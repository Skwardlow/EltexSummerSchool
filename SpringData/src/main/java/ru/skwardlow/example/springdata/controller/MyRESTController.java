package ru.skwardlow.example.springdata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.skwardlow.example.springdata.entities.User;
import ru.skwardlow.example.springdata.interfaces.UserRepository;

@RestController
public class MyRESTController {
    @Autowired
    UserRepository crudRepository;

    @GetMapping("/employees/{id}")
    Resource<User> one(@PathVariable Long id) {

        User user = crudRepository.findById(id);

        return (Resource<User>) user;
    }
}
