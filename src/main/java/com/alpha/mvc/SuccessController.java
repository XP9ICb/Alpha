package com.alpha.mvc;

import com.alpha.mvc.services.ExpertiseService;
import com.alpha.mvc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
public class SuccessController {

    @Autowired
    private UserService userService;

    @Autowired
    private ExpertiseService expertiseService;

    @RequestMapping("/success.htm")
    public ModelAndView logged(Principal principal) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("authenticated_user", principal.getName());
        mav.addObject("modalProfileHeader", "Профиль пользователя " + principal.getName() + " .");
        mav.addObject("modalExpertiseHeader", "Новая экспертиза");
        mav.addObject("userProfile", userService.getUser(principal.getName()).getProfile());
        mav.addObject("userName", "Имя");
        mav.addObject("userSecondName", "Фамилия");
        mav.addObject("userMidleName", "Отчество");
        mav.addObject("userCertificateNumber", "Номер удостоверения");
        mav.addObject("profile", "ПРОФИЛЬ");
        mav.addObject("admin", "ПОЛЬЗОВАТЕЛИ");
        mav.addObject("moderator", "НОВАЯ ЭКСПЕРТИЗА");
        mav.addObject("logOut", "ВЫЙТИ");
        mav.addObject("number", "Номер");
        mav.addObject("startDate", "Дата начала");
        mav.addObject("endDate", "Дата окончания");
        mav.addObject("organization", "Организация");
        mav.addObject("crimeNumber", "Номер уголовного производства");
        mav.addObject("save", "Сохранить");
        mav.addObject("close", "Закрыть");
        mav.addObject("users", userService.getUsersList(0,100));
        mav.addObject("allExpertises", expertiseService.getAllExpertises());
        mav.addObject("userExpertises", userService.getUser(principal.getName()).getExpertiseList());
        mav.setViewName("/success");
        return mav;
    }
}
