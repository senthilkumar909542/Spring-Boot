package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.demo.service.patternservice;

@Controller
public class logincontroller {

	@Autowired
	public patternservice service;

	@GetMapping("/login")
	public String login(
			@RequestParam(name = "username", required = false, defaultValue = "World") String username,
			ModelMap model
			) {
		model.addAttribute("name", username);
		return "index";
	}

	@PostMapping("/pattern-page")
	public String pattern_page() {
		return "Pattern_home";
	}

	@PostMapping("/Pattern-Result")
	public String welcome(@RequestParam("input") int number, @RequestParam("Pattern") String value,

			Model m) {
		
		System.out.println("You Entered Input : "+number);
		System.out.println("You Selected the pattern : "+value);
		m.addAttribute("value2", service.pattern(number, value));
		return "Pattern-Result";
	}

	@PostMapping("/Pattern_Name")
	public String pattern_name() {
		return "Pattern_Name";
	}

	@PostMapping("/namepattern")
	public String namepattern(@RequestParam("username") String n, Model m) {
		m.addAttribute("name", n);
		m.addAttribute("value1", service.namepattern(n));
		return "name";
	}

}
