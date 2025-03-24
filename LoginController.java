package com.example.Assessment.Tracking.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
class LoginController {
	@GetMapping("/login")
	String login(HttpSession session) {
		session.setAttribute("name", "Prem");
		return "login";
	}
}
