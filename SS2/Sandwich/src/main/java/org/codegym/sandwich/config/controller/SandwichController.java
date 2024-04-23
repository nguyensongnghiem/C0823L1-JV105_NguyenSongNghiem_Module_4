package org.codegym.sandwich.config.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class SandwichController {
    @GetMapping("/")
    public  String home() {
        return "sandwich";
    }
    @GetMapping("/save")
    public String save(Model model, @RequestParam(defaultValue = "No things!"
    ) String[] compliments ) {

        System.out.println(compliments);
        model.addAttribute("compliments",compliments);

        return "order";
    }
}
