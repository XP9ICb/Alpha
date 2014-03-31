package com.alpha.mvc;

import com.alpha.mvc.persistence.dto.NewUserDto;
import com.alpha.mvc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @RequestMapping("/registration.htm")
    @ResponseBody
    public String registrationIndex(@RequestBody NewUserDto newUserDto) {
        String result = null;
        if (userService.getUser(newUserDto.getLogin()) == null) {
            result = "true";
            userService.saveNewUser(newUserDto);
        }
        return result;
    }
}
