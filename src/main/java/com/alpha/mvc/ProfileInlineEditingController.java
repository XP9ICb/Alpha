package com.alpha.mvc;

import com.alpha.mvc.persistence.domain.Profile;
import com.alpha.mvc.persistence.dto.InlineEditingDto;
import com.alpha.mvc.services.UserService;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.security.Principal;

@Controller
public class ProfileInlineEditingController {

    @Autowired
    private UserService userService;

    @RequestMapping("/profile-inline-editing.htm")
    @ResponseBody
    public String InlineEditingController(@RequestBody InlineEditingDto inlineEditingDto, Principal principal) throws InvocationTargetException, IllegalAccessException, IOException {
        Profile profile = userService.getUser(principal.getName()).getProfile();
        BeanUtils.setProperty(profile, inlineEditingDto.getName(), inlineEditingDto.getValue());
        userService.updateProfile(profile);
        return "{\"success\":\"true\"}";
    }
}
