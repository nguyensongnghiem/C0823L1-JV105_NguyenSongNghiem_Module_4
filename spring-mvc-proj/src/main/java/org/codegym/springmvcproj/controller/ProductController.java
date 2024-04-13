package org.codegym.springmvcproj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {
    @GetMapping("/")
    public String showList() {
        return "list";
    }
    @GetMapping("/add")
    public String showAddForm() {
        return "add";
    }
}
