package dev.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import dev.domain.Annonce;
import dev.repository.AnnonceRepo;

/**
 * @author diginamic09
 *
 */
@Service
@Transactional
public class AnnonceService {

	private AnnonceRepo annonceRepo;

	/**
	 * Injection de bean
	 * 
	 * @param annonceRepo
	 */
	public AnnonceService(AnnonceRepo annonceRepo) {

		this.annonceRepo = annonceRepo;
	}

	/**
	 * Lister toutes les annonces de l'utilisateur connecté
	 * 
	 * @param username
	 * @return
	 */
	public List<Annonce> listerAnnonces(String username) {

		return this.annonceRepo.findAllByCollegueEmail(username);
	}

	/**
	 * Envoie de l'Annonce au repository pour création
	 * 
	 * @param annonce
	 */
	public void send(Annonce annonce) {

		this.annonceRepo.save(annonce);
	}

	/**
	 * Envoie de l'id de l'annonce pour suppression
	 * 
	 * @param id
	 */
	public void supprimerAnnonce(Long id) {

		this.annonceRepo.deleteById(id);
	}

	public List<Annonce> listerAllCovoiturages() {

		return this.annonceRepo.findAll();
	}

}