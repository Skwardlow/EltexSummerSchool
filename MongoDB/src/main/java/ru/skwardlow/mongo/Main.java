package ru.skwardlow.mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.skwardlow.mongo.entities.User;
import ru.skwardlow.mongo.services.UserService;
@Controller
public class Main {
    @Autowired UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView showAll() {
        ModelAndView modelAndView = new ModelAndView("all");

        modelAndView.addObject("contacts", userService.getAll());

        return modelAndView;
    }


}
