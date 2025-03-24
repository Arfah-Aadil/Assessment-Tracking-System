package com.example.Assessment.Tracking.home;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.Assessment.Tracking.modules.ModuleRepository;

import ch.qos.logback.core.model.Model;
import jakarta.servlet.http.HttpSession;

import com.example.Assessment.Tracking.ModuleLead.ModuleLead;
import com.example.Assessment.Tracking.ModuleLead.ModuleLeadRepository;
import com.example.Assessment.Tracking.modules.Module;
import java.security.Principal;

@Controller
public class HomeController {
    
    @Autowired
    private ModuleRepository moduleRepository;
    @Autowired
    private ModuleLeadRepository moduleLeadRepository;
    @Autowired
    private HomeRepository homeRepository;

    @GetMapping("/")
    public ModelAndView home(Principal principal){
        ModelAndView modelAndView = new ModelAndView("home.html");
        List<Module> Modules = moduleRepository.getAllModules();
        List<RoleData> rolesData = homeRepository.getRole(principal);
        modelAndView.addObject("authority",rolesData);
        modelAndView.addObject("Modules", Modules);
        return modelAndView;
    }

    @GetMapping("/assessment")
    public ModelAndView assessment(@RequestParam("assessmentTitleH") String assessmentTitleH, Model model,HttpSession session,Principal principal){
        ModelAndView modelAndView = new ModelAndView("assessment1.html");
        List<ModuleLead> assessmentDetails = moduleLeadRepository.getAssessmentDetails();
        List<RoleData> rolesData = homeRepository.getRole(principal);
        modelAndView.addObject("authority",rolesData);
        modelAndView.addObject("assessmentTitleH", assessmentTitleH);
        modelAndView.addObject("assessmentDetails", assessmentDetails);
        System.out.println(moduleLeadRepository.getAssessmentDetails());
        return modelAndView;
    }
}