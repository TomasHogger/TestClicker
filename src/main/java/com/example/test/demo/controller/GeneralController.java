package com.example.test.demo.controller;

import com.example.test.demo.service.ClickService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GeneralController {

    private final ClickService clickService;

    @Autowired
    public GeneralController(ClickService clickService) {
        this.clickService = clickService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("value", clickService.getCount());
        return "index";
    }
}
