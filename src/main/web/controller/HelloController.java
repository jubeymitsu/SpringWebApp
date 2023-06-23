package main.web.controller;

import main.web.model.User;
import main.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class HelloController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/",
            method = RequestMethod.GET)
    public String page(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "main";
    }

    @RequestMapping(value = "/addNewUser"
            , method = RequestMethod.GET)
    public String addNewUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "user-info";
    }

    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @RequestMapping(value = "/updateInfo/{id}")
    public String updateUser(@PathVariable int id, Model model) {
        User user = userService.getUser(id);
        model.addAttribute("user", user);
        return "user-info";
    }

    @RequestMapping(value = "/deleteUser/{id}")
    public String deleteUser(@PathVariable int id) {
        userService.deleteById(id);
        return "redirect:/";
    }
}
