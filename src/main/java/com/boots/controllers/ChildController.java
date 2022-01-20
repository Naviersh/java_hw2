package com.boots.controllers;

import com.boots.entity.Child;
import com.boots.requests.ChildRequests;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ChildController {
    private final ChildRequests childRequests;

    public ChildController(ChildRequests childRequests) {
        this.childRequests= childRequests;
    }

    @GetMapping("/children")
    public String getAllChildren(Model model) {
        model.addAttribute("children", childRequests.getAllChildren());
        return "children/children";
    }

    @GetMapping("/children/add/{parentsId}")
    public String postAddChild(@PathVariable(value = "parentsId") String parentsId, Model model) {
        model.addAttribute("parentsId", parentsId);
        return "children/addChild";
    }

    @PostMapping("/children/add/{parentsId}")
    public String addChild(Child child, @PathVariable(value = "parentsId") int parentsId, Model model) {
        Child result = childRequests.addChild(child, parentsId);
        if (result == null) {
            model.addAttribute("isError", true);
            model.addAttribute("errorMessage", "Не удалось добавить ребенка");
            return "children/addChild";
        }
        return "redirect:/parents";
    }

    @GetMapping("/children/{id}")
    public String child(@PathVariable(value = "id") int id, Model model) {
        Child child = childRequests.getById(id);
        if (child == null) {
            return "redirect:/parents";
        }
        model.addAttribute("child", child);
        model.addAttribute("school", childRequests.getSchools(child));
        return "children/child";
    }

    @PostMapping("/children/{id}")
    public String saveSchool(int schoolId, @PathVariable(value = "id") int id, Model model) {
        Child child = childRequests.getById(id);
        if (child == null) {
            model.addAttribute("isError", true);
            model.addAttribute("errorMessage", "Не удалось найти ребенка");
            return "children/child";
        }
        if (!childRequests.setSchools(id, schoolId)) {
            model.addAttribute("isError", true);
            model.addAttribute("errorMessage", "Не удалось записать в школу");
            return "children/child";
        }
        return "redirect:/parents";
    }
}
