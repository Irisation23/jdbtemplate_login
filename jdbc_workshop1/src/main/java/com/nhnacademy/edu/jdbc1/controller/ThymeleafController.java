package com.nhnacademy.edu.jdbc1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class ThymeleafController {
    @GetMapping("/thymeleaf")
    public String thymeleaf(Model model) {
//        model.addAttribute("html", "this is <b>HTML</b>.");
//
//        List<String> list = Arrays.asList("nhn", "academy", "dooray");
//        model.addAttribute("list", list);
//
//        model.addAttribute("choice", 2);

        return "thymeleaf/logForm";
    }


}
