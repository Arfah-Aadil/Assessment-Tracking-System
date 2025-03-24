package com.example.Assessment.Tracking.forms;

import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import jakarta.validation.Valid;

// Controller class for internal form
@Controller
public class FormsController {

    @Autowired
    private FormRepository formRepository; // Repository for internal form
    private FormSubmissionEmail formSubmissionEmail; // Service for handling form submission emails

    // Constructor for dependencies
    public FormsController(FormRepository formRepository, FormSubmissionEmail formSubmissionEmail) {
        this.formRepository = formRepository;
        this.formSubmissionEmail = formSubmissionEmail;
    }

    // Handler for displaying the internal form
    @GetMapping("/internal")
    public ModelAndView trackingForm(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView("form.html");
        TrackingForm trackingForm = (TrackingForm) session.getAttribute("trackingForm");
        if (trackingForm == null) {
            trackingForm = new TrackingForm();
        }
        modelAndView.addObject("trackingForm", trackingForm);
        return modelAndView;
    }

    // Handler for showing the internal form for editing
    @GetMapping("/internal/edit/{moduleCode}")
    public ModelAndView showEditInternalForm(@PathVariable String moduleCode) {
        ModelAndView modelAndView = new ModelAndView("editInternal");
        TrackingForm trackingForm = formRepository.findInternal(moduleCode);
        modelAndView.addObject("trackingForm", trackingForm);
        return modelAndView;
    }

    // Handler for submitting the internal form
    @PostMapping("/internal")
    public ModelAndView submitTrackingForm(@Valid TrackingForm trackingForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("form");
        }
        formRepository.addForm(trackingForm);
        formSubmissionEmail.processFormSubmission(trackingForm);
        return new ModelAndView("redirect:/thankYou");
    }

    // Handler for updating the internal form
    @PostMapping("/internal/edit")
    public ModelAndView updateInternalForm(@Valid TrackingForm trackingForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("editInternal", "trackingForm", trackingForm);
        }
        formRepository.updateForm(trackingForm);
        formSubmissionEmail.processFormSubmission(trackingForm);
        return new ModelAndView("redirect:/thankYou");
    }

    @PostMapping("/internal/save")
    public ResponseEntity<?> saveFormDataTemporarily(@ModelAttribute TrackingForm trackingForm, HttpSession session) {
        // Logic to temporarily save form data in the session
        session.setAttribute("trackingForm", trackingForm);
        return ResponseEntity.ok("Form data saved temporarily");
    }

    // Handler for the thank-you page after form submission
    @GetMapping("thankYou")
    public String thankYou() {
        return "response";
    }
}