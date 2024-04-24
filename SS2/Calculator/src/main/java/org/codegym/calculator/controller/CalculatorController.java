package org.codegym.calculator.controller;

import org.codegym.calculator.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @Autowired
    private CalculatorService calculatorService;
    @GetMapping("/")
    public String home(Model model) {
        return "home";
    }
    @PostMapping("/calculator")
    public String calculator(Model model, @RequestParam float input1,@RequestParam float input2, @RequestParam String operator ) {
        Float result = null;
        model.addAttribute("input1",input1);
        model.addAttribute("input2",input2);
        switch (operator) {
            case "add":
                result = calculatorService.add(input1,input2);
                break;
            case "sub":
                result = calculatorService.sub(input1,input2);
                break;
            case "mul":
                result = calculatorService.mul(input1,input2);
                break;
            case "div":
                result = calculatorService.div(input1,input2);
                break;
        }
        model.addAttribute("result", result);
        return "home";
    }
}
