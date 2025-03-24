package com.example.Assessment.Tracking.forms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


import jakarta.validation.Valid;

@Controller
public class ResponseController {

    @Autowired
    private LeaderResponseRepository leaderResponseRepository;

    @GetMapping("/leaderResponse")
    public ModelAndView responseForm(){
        ModelAndView modelAndView = new ModelAndView("leaderResponseForm.html");
        modelAndView.addObject("leaderResponse", new LeaderResponse());
        return modelAndView;
    }

    @PostMapping("/leaderResponse")
    public ModelAndView submitResponseForm(@Valid @ModelAttribute("leaderResponse") LeaderResponse leaderResponse, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("leaderResponseForm", model.asMap());
            return modelAndView;
        }

        leaderResponseRepository.addLeaderResponseForm(leaderResponse);
        System.out.println(leaderResponse);
        return new ModelAndView("redirect:/thankYou");
    }
    
}