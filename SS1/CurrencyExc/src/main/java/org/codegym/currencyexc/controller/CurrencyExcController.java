package org.codegym.currencyexc.controller;

import org.codegym.currencyexc.service.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CurrencyExcController {
    @Autowired
    private ExchangeService exchangeService;
    @GetMapping("/")
    public String showForm(Model model) {
       return "exc-form";
    }
    @GetMapping("/calculate")
    public ModelAndView exchange(@RequestParam float usd) {
        float vnd = exchangeService.exchange(usd);
        ModelAndView modelAndView = new ModelAndView("result","result",vnd);
        return modelAndView;
    }
}
