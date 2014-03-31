package com.alpha.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @RequestMapping("/")
    public ModelAndView indexPage() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/index");
        mav.addObject("signin", "Аутентифицируйтесь");
        mav.addObject("rememberme", "Запомнить меня");
        mav.addObject("enter", "Войти");
        mav.addObject("login", "Логин");
        mav.addObject("registration", "Зарегистрироваться");
        mav.addObject("close", "Закрый");
        mav.addObject("save", "Сохранить");
        mav.addObject("modalheader", "Форма регистрации нового пользователя");
        mav.addObject("password1", "Пароль");
        mav.addObject("password2", "Пароль еще раз");
        mav.addObject("password", "Пароль");
        mav.addObject("name", "Имя");
        mav.addObject("secondName", "Фамилия");
        mav.addObject("midleName", "Отчество");
        mav.addObject("certificateNumber", "Номер удостоверения");
        return mav;
    }

    @RequestMapping("/access-denied.htm")
    public ModelAndView no(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("access-denied");
        return mav;
    }

}