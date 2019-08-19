package ru.skwardlow.example.springdata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.skwardlow.example.springdata.interfaces.UserRepository;

@Controller
public class MyController {
    @Autowired
    UserRepository crudRepository;

    @RequestMapping("/")
    public String index(@RequestParam(name = "name",required = false,defaultValue = "world") String name, Model model){
        model.addAttribute("name",name);
        return  "index";
    }

    @RequestMapping("/get_users")
    public String getUsers(Model model){
        return "/get_users";
    }
}
