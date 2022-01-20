package com.boots.controllers;


import com.boots.entity.User;
import com.boots.requests.UsersRequests;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;

@Controller
public class RegistryController {
    private final UsersRequests usersRequests;

    public RegistryController(UsersRequests usersRequests) {
        this.usersRequests = usersRequests;
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String registerNewUser(User user, Model model) {
        if (usersRequests.saveUser(user)) {
            return "redirect:/login";
        } else {
            model.addAttribute("message", "User exists");
            return "register";
        }
    }
}
