package org.example.controller;

import org.example.entity.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
@PostMapping("/save")
    public void  saveUser(){
    User user = new User("Андрей","Синдяев",31);
    userService.svaUser(user);
    System.out.println("Сохранился");
    }
}
