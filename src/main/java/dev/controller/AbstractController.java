package dev.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class AbstractController {
	
	public String getUserDetails() {
		return (String)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}

}
