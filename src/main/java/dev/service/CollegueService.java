package dev.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import dev.domain.Collegue;
import dev.repository.CollegueRepo;

/**
 * @author diginamic09
 * 
 * Couche de service faisant le lien entre la base de données et la couche de contrôle pour les Collegue
 */
public interface CollegueService {

	/**
	 * Chercher un collegue gràace à son adresse email
	 * 
	 * @param username
	 * @return
	 */
	Optional<Collegue> findCollegue(String username);

}
