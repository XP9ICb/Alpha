package com.alpha.mvc;

import com.alpha.mvc.persistence.domain.Role;
import com.alpha.mvc.persistence.domain.User;
import com.alpha.mvc.persistence.dto.UserDto;
import com.alpha.mvc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class UserManageController {

    @Autowired
    private UserService userService;

    @RequestMapping("/admin.htm")
    public ModelAndView adminIndex(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/admin");
        mav.addObject("delete", "Удалить пользователя");
        mav.addObject("change", "Сменить пароль");
        mav.addObject("password", "Введите текущий пароль");
        mav.addObject("password1", "Пароль");
        mav.addObject("password2", "Пароль еще раз");
        mav.addObject("close", "Закрыть");
        mav.addObject("users", userService.getUsersList(0,100));
        return mav;
    }

    @RequestMapping("/delete_user.htm")
    @ResponseBody
    public void deleteUser(@RequestParam String login) {
        userService.deleteUserByLogin(login);
    }

    @RequestMapping("/change_password.htm")
    @ResponseBody
    public String changePassword(@RequestParam Map<String, String> passwordParametrs) {
        String result = null;
        String currentPassword = userService.encodePassword(passwordParametrs.get("currentPassword"));
        String newPassword = userService.encodePassword(passwordParametrs.get("newPassword"));
        User user = userService.getUser(passwordParametrs.get("login"));
        if(user.getPassword().equals(currentPassword)){
            user.setPassword(newPassword);
            userService.updateUser(user);
            result = "true";
        }
        return result;
    }

    @RequestMapping("/change_role.htm")
    @ResponseBody
    public void changeRole(@RequestBody UserDto userDto) {
        User user = userService.getUser(userDto.getLogin());
        Role newRole = userService.getRoleByName(userDto.getRole());
        user.setRole(newRole);
        userService.updateUser(user);
    }
}
