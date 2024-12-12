package com.fortuneteller.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fortuneteller.helper.Message;
import com.fortuneteller.models.User;
import com.fortuneteller.repository.UserRepository;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class HomeController {
	@Autowired
	UserRepository userRepository;
	
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
		model.addAttribute("user", new User());
		return "signup";
	}
	
	//Handler for signuppage for registration
	@RequestMapping(value = "/do_register", method = RequestMethod.POST)
	public String do_Register(@Valid @ModelAttribute("user") User user,BindingResult result, @RequestParam(value = "agreement",defaultValue = "false") 
	boolean agreement, Model model) {
		System.out.println("Agreement" + agreement);
		System.out.println("USER" + user.toString());
		
		try {
			if (!agreement) {
				System.out.println("Please accept term and condition");
				throw new Exception("Please accept term and condition");
			}
			
			if (result.hasErrors()) {
				System.out.println(result.toString());
				model.addAttribute("user",user);
				return "signup";
			}
			user.setUserRole("Normal_User");
			user.setIs_user_active(true);
			userRepository.save(user);
			model.addAttribute("user",new User());
			model.addAttribute("message", new Message("Successfully registered !!","alert-success"));
			return "signup";
			
		}catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("user",user);
			model.addAttribute("message",new Message("Something went wrong!!!" + e.getMessage(),"alert-danger"));
			return "signup";
		}
	}
}
