package main.web.controller;

import main.web.model.User;
import main.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HelloController {


    @Autowired
    UserService userService;

    @GetMapping(value = "/")
    public String page(Model model) {
        System.out.println("In page method");
        return "main";
    }

    @GetMapping(value = "/users")
    public String h(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "main";
    }
}
