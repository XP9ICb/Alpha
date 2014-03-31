package com.alpha.mvc;

import com.alpha.mvc.services.ExpertiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @Autowired
    private ExpertiseService expertiseService;

    @RequestMapping("/user-search.htm")
    public ModelAndView userSearch(@RequestParam String searchString){
        ModelAndView mav = new ModelAndView();
        mav.addObject("profile", "ПРОФИЛЬ");
        mav.addObject("logOut", "ВЫЙТИ");
        mav.addObject("number", "Номер");
        mav.addObject("startDate", "Дата начала");
        mav.addObject("endDate", "Дата окончания");
        mav.addObject("organization", "Организация");
        mav.addObject("crimeNumber", "Номер уголовного производства");
        mav.addObject("userExpertises", expertiseService.getExpertiseByLikeParametr(searchString));
        mav.setViewName("user-search");
        return mav;
    }
}
