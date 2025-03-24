package com.example.Assessment.Tracking.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;


import jakarta.validation.Valid;

@Controller
public class AdminController {
    
    @Autowired
    private AdminRepository adminRepository;

    @GetMapping("/admin")
    public ModelAndView admin() {
        ModelAndView modelAndView = new ModelAndView("admin.html");
        modelAndView.addObject("admin", new Admin());
        return modelAndView;
    }

    @GetMapping("/admin/register")
    public ModelAndView adminRegister(){
        ModelAndView modelAndView = new ModelAndView("register.html");
        modelAndView.addObject("admin", new Admin());
        return modelAndView;
    }

    @PostMapping("/admin/register")
    public ModelAndView addUser(@Valid @ModelAttribute("admin") Admin admin,
                                   BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("admin", model.asMap());
            System.out.println("Errors");
            return modelAndView;
        }
        System.out.println(admin);
        adminRepository.addUsers(admin);
        ModelAndView modelAndView = new ModelAndView("redirect:/thankYou");
        return modelAndView;
    }

    @GetMapping("/admin/assessment-tracking")
    public ModelAndView assessmentTracker() {
        ModelAndView modelAndView = new ModelAndView("assessmentTracker.html");
        List<AssessmentStatus> assessmentStatuses = adminRepository.getAssessmentStatuses();
        modelAndView.addObject("assessmentStatuses", assessmentStatuses);
        return modelAndView;
    }
}
