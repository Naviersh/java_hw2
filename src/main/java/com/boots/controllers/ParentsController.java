package com.boots.controllers;
import com.boots.entity.Parents;
import com.boots.requests.AddressRequests;
import com.boots.requests.ParentsRequests;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Objects;

@Controller
public class ParentsController {
    private final ParentsRequests parentsRequests;
    private final AddressRequests addressRequests;

    public ParentsController(ParentsRequests parentsRequests, AddressRequests addressRequests) {
        this.parentsRequests = parentsRequests;
        this.addressRequests = addressRequests;
    }

    @GetMapping("/parents")
    public String getParents(Model model) {
        model.addAttribute("parents", parentsRequests.GetAllParents());
        return "parents/parents";
    }

    @GetMapping("/parents/add")
    public String getAddParents(Model model) {
        model.addAttribute("addresses", addressRequests.getAllAddresses());
        return "parents/addParents";
    }

    @GetMapping("/parents/edit/{id}")
    public String getEditParents(@PathVariable(value = "id") int id, Model model) {
        model.addAttribute("addresses", addressRequests.getAllAddresses());
        model.addAttribute("parents", parentsRequests.GetById(id));
        return "parents/editParents";
    }

    @PostMapping("/parents/add")
    public String postAddParents(Parents parents, int addressId, Model model) {
        if (Objects.equals(parents.getMotherFullName(), null) && Objects.equals(parents.getFatherFullname(), null)) {
            model.addAttribute("isError", true);
            model.addAttribute("errorMessage", "Нужно записать хотя бы одного родителя");
            model.addAttribute("addresses", addressRequests.getAllAddresses());
            return "parents/addParents";
        }
        parentsRequests.addOrUpdateParents(parents, addressId);
        return "redirect:/parents";
    }

    @PostMapping("/parents/edit/{id}")
    public String postEditParents(Parents parents, int addressId, Model model) {
        if (Objects.equals(parents.getMotherFullName(), null) && Objects.equals(parents.getFatherFullname(), null)) {
            model.addAttribute("isError", true);
            model.addAttribute("errorMessage", "Нужно записать хотя бы одного родителя");
            model.addAttribute("addresses", addressRequests.getAllAddresses());
            return "parents/editParents";
        }
        parentsRequests.addOrUpdateParents(parents, addressId);
        return "redirect:/parents";
    }
}
