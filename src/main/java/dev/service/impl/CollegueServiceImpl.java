package dev.service.impl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import dev.domain.Collegue;
import dev.repository.CollegueRepo;
import dev.service.CollegueService;

/**
 * @author diginamic09
 * 
 * Couche de service faisant le lien entre la base de données et la couche de contrôle pour les Collegue
 */
@Service
@Transactional
public class CollegueServiceImpl implements CollegueService {
	
	private CollegueRepo collegueRepo;
	
	/**
	 * Injection des dépendances
	 * 
	 * @param collegueRepo
	 */
	public CollegueServiceImpl(CollegueRepo collegueRepo) {

		this.collegueRepo = collegueRepo;
	}



	/**
	 * Chercher un collegue gràace à son adresse email
	 * 
	 * @param username
	 * @return
	 */
	public Optional<Collegue> findCollegue(String username) {

		return this.collegueRepo.findByEmail(username);
	}

}
