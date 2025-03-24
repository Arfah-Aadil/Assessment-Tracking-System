package com.example.Assessment.Tracking.forms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.validation.Valid;

// Controller class for external form
@Controller
public class ExternalFormController {

    @Autowired
    private ExternalFormRepository externalFormRepository; // Repository for external form
    private FormSubmissionEmail formSubmissionEmail; // Handling form submission emails

    // Constructor for dependencies
    public ExternalFormController(FormSubmissionEmail formSubmissionEmail) {
        this.formSubmissionEmail = formSubmissionEmail;
    }

    // Handler for displaying the external form
    @GetMapping("/external")
    public ModelAndView externalFormTH() {
        ModelAndView modelAndView = new ModelAndView("external1.html");
        modelAndView.addObject("externalForm", new ExternalForm());
        return modelAndView;
    }


    // Handler for submitting the external form
    @PostMapping("/external")
    public ModelAndView submitExternalForm(@Valid @ModelAttribute("externalForm") ExternalForm externalForm, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("external1", model.asMap());
            return modelAndView;
        }
        externalFormRepository.addExternalForm(externalForm);
        System.out.println(externalForm);
        formSubmissionEmail.processFormSubmission(externalForm);
        return new ModelAndView("redirect:/thankYou");
    }
}
// @GetMapping("/external/edit/{moduleCode}")
    // public ModelAndView showEditExternalForm(@PathVariable String moduleCode) {
    //     ModelAndView modelAndView = new ModelAndView("editExternal");
    //     ExternalForm externalForm = externalFormRepository.findExternal(moduleCode);
    //     modelAndView.addObject("externalForm", externalForm);
    //     return modelAndView;
    // }
    // @PostMapping("/external/edit")
    // public ModelAndView updateExternalForm(@Valid ExternalForm externalForm, BindingResult bindingResult) {
    //     if (bindingResult.hasErrors()) {
    //         return new ModelAndView("editExternal", "externalForm", externalForm);
    //     }
    //     externalFormRepository.updateExternalForm(externalForm);
    //     System.out.println(externalForm);
    //     formSubmissionEmail.processFormSubmission(externalForm);
    //     return new ModelAndView("redirect:/thankYou");
    // }