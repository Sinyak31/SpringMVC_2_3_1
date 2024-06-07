package org.example.controller;

import org.example.entity.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping(value = "/users")
@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/save")
    public String saveUser(@RequestParam(value = "name") String name, @RequestParam(value = "surname") String surname
            , @RequestParam(value = "age") int age) {
        userService.saveUser(new User(name, surname, age));
        return "redirect:index";
    }

    @GetMapping("/addUser")
    public String addUser() {
        return "AddUser";
    }

    @GetMapping("/index")
    public String getUsers(Model model) {
        List<User> users;
        users = userService.getUserList();
        model.addAttribute("usersList", users);
        return "Users";
    }

    @GetMapping(value = "/remove")
    public String removeUser(@RequestParam(value = "id") long id) {
        userService.removeUser(id);
        return "redirect:index";
    }

    @GetMapping("/edit")
    public String showEditUser(@RequestParam(value = "id") long id, Model model) {
        User user = userService.getUserFindById(id);
        model.addAttribute("user", user);
        return "EditUser";
    }

    @PostMapping("/editUser")
    public String editUser(@RequestParam(value = "id") long id, @RequestParam(value = "name") String name,
                           @RequestParam(value = "surname") String surname, @RequestParam(value = "age") int age) {
        userService.updateUser(id, new User(name, surname, age));
        return "redirect:index";
    }
}
