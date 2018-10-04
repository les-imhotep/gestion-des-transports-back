package dev.controller;

import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author diginamic09
 * 
 * Controler permettant de récupérer les données de l'utilisateur connecté
 *
 */
public class AbstractController {

	/**
	 * Retourn l'adresse email en format String de l'utilisateur connecté
	 * 
	 * @return
	 */
	public String getUserDetails() {
		if (SecurityContextHolder.getContext().getAuthentication()!=null){
			return (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		}
		return null;
	}

}
