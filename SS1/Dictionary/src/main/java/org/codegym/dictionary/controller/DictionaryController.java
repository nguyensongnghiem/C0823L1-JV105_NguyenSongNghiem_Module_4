package org.codegym.dictionary.controller;

import org.codegym.dictionary.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DictionaryController {
    @Autowired
    private DictionaryService dictionaryService;
    @GetMapping("/")
    public String home(Model model) {
        return "home";
    }
    @GetMapping("/find")
    public  String find(String word, Model model) {
        String meaning = dictionaryService.find(word);
        model.addAttribute("meaning", meaning);
        model.addAttribute("word", word);
        return "home";
    }
}
