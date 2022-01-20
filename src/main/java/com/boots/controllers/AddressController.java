package com.boots.controllers;

import com.boots.requests.AddressRequests;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AddressController {
    private final AddressRequests addressRequests;

    public AddressController(AddressRequests addressRequests) {
        this.addressRequests = addressRequests;
    }

    @GetMapping("/addresses")
    public String getAllAddresses(Model model) {
        model.addAttribute("addresses", addressRequests.getAllAddresses());
        return "addresses";
    }
}
