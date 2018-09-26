package dev.controller;

import org.springframework.security.core.context.SecurityContextHolder;

public class AbstractController {
	
	public String getUserDetails() {
		return (String)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}

}
