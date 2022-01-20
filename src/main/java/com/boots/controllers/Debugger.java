package com.boots.controllers;

import com.boots.requests.UsersRequests;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Debugger {
    private final UsersRequests usersRequests;

    public Debugger(UsersRequests usersRequests) {
        this.usersRequests = usersRequests;
    }

    @GetMapping("/debug")
    public String userList(Model model) {
        model.addAttribute("allUsers", usersRequests.getAllUsers());
        return "admin";
    }

    @PostMapping("/debug")
    public String deleteUser(@RequestParam(required = true, defaultValue = "") Integer userId,
                             @RequestParam(required = true, defaultValue = "") String action,
                             Model model) {
        if (action.equals("delete")) {
            usersRequests.deleteUser(userId);
        }
        return "redirect:/admin";
    }
}
