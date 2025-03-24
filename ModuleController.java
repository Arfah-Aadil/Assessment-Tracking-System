package com.example.Assessment.Tracking.modules;

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
public class ModuleController {
   @Autowired
   private ModuleRepository moduleRepository;

   @GetMapping("/moduleForm")
   public ModelAndView moduleForm(){
       ModelAndView modelAndView = new ModelAndView("moduleForm.html");
       modelAndView.addObject("moduleForm", new Module());
       return modelAndView;
   }

    @PostMapping("/moduleForm")
    public ModelAndView submitModuleForm(@Valid @ModelAttribute("moduleForm") Module moduleForm, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("moduleForm", model.asMap());
            return modelAndView;
        }
        moduleRepository.submitModuleForm(moduleForm);
        return new ModelAndView("redirect:/thankYou");
    }
}
