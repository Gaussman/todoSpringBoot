package com.addison.springboot.web.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WelcomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showWelcomePage(ModelMap model) {
		model.put("username", getLoggedinUserName());
		return "welcome";

	}

	private String getLoggedinUserName() {
		Object principalObject = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principalObject instanceof UserDetails) {
			return ((UserDetails) principalObject).getUsername();
		}
		return principalObject.toString();
	}
}

//	@RequestMapping(value = "/login", method = RequestMethod.POST)
//	public String showWelcomePage(ModelMap model, @RequestParam String username, @RequestParam String password) {
//
//		boolean isValidUser = service.validate(username, password);
//
//		if (!isValidUser) {
//			model.put("invalidMsg", "Invalid credentials");
//			return "login";
//		}
//		model.put("username", username);
//		model.put("password", password);
//		return "welcome";
