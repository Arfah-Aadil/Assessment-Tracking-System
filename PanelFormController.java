package com.example.Assessment.Tracking.forms;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

// Controller class for panel form
@Controller
public class PanelFormController {

    @Autowired
    private PanelRepository panelRepository; // Repository for internal form
    private FormSubmissionEmail formSubmissionEmail; // Service for handling form submission emails

    // Constructor for dependencies
    public PanelFormController(FormSubmissionEmail formSubmissionEmail) {
        this.formSubmissionEmail = formSubmissionEmail;
    }

    // Handler for displaying the panel form
    @GetMapping("/panel")
    public ModelAndView panelForm() {
        ModelAndView modelAndView = new ModelAndView("panel.html");
        modelAndView.addObject("panelForm", new PanelForm());
        return modelAndView;
    }

    // Handler for showing the panel form for editing
    @GetMapping("/panel/edit/{moduleCode}")
    public ModelAndView showEditPanelForm(@PathVariable String moduleCode) {
        ModelAndView modelAndView = new ModelAndView("editPanel");
        PanelForm panelForm = panelRepository.findPanel(moduleCode);
        modelAndView.addObject("panelForm", panelForm);
        return modelAndView;
    }

    // Handler for submitting the panel form
    @PostMapping("/panel")
    public ModelAndView submitPanelForm(@Valid PanelForm panelForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("panel");
            modelAndView.addObject("panelForm", panelForm);
            return modelAndView;
        }
        formSubmissionEmail.processFormSubmission(panelForm);
        panelRepository.addPanel(panelForm);
        return new ModelAndView("redirect:/thank-you");
    }

    // Handler for updating the panel form
    @PostMapping("/panel/edit")
    public ModelAndView updatePanelForm(@Valid PanelForm panelForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("editPanel", "panelForm", panelForm);
        }
        formSubmissionEmail.processFormSubmission(panelForm);
        panelRepository.updatePanel(panelForm);
        return new ModelAndView("redirect:/thankYou");
    }
}