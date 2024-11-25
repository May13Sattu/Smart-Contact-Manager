package com.fortuneteller.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	// Home Handler
	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("tittle", "Home - Smart Contact Manager");
		return "home";
	}

	// About page handler
	@RequestMapping("/about")
	public String about(Model model) {
		model.addAttribute("tittle", "About - Smart Contact Manager");
		return "about";
	}

	// Login page handler
	@RequestMapping("/login")
	public String login(Model model) {
		model.addAttribute("tittle", "Login - Smart Contact Manager");
		return "login";
	}

	// Signup Page handler
	@RequestMapping("/signup")
	public String signup(Model model) {
		model.addAttribute("tittle", "Signup - Smart Contact Manager");
		return "signup";
	}
}
