package com.example.Assessment.Tracking.ModuleLead;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

// import com.example.Assessment.Tracking.forms.TrackingForm;

import jakarta.validation.Valid;

@Controller
public class ModuleLeadController {
    @Autowired
    private ModuleLeadRepository moduleLeadRepository;
    
    @GetMapping("/moduleLead")
    public ModelAndView moduleLeadForm(){
        ModelAndView modelAndView = new ModelAndView("moduleLeader.html");
        modelAndView.addObject("moduleLead", new ModuleLead());
        return modelAndView;
    }

    @PostMapping("/moduleLead")
    public ModelAndView addModuleLead(@Valid @ModelAttribute("moduleLead") ModuleLead moduleLead, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("moduleLeader", model.asMap());
            return modelAndView;
        }
        moduleLeadRepository.addModuleLeaderForm(moduleLead);
        System.out.println(moduleLead);
        return new ModelAndView("redirect:/thankYou");
    }
}