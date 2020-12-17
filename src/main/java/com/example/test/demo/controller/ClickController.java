package com.example.test.demo.controller;

import com.example.test.demo.service.ClickService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClickController {

    private final ClickService clickService;

    @Autowired
    public ClickController(ClickService clickService) {
        this.clickService = clickService;
    }

    @GetMapping("/click")
    public long click() {
        return clickService.clickAndGetCount();
    }

}
