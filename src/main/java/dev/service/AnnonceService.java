package dev.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import dev.domain.Annonce;
import dev.exceptions.HoraireException;
import dev.exceptions.NbDePlaceException;
import dev.exceptions.ServiceException;
import dev.repository.AnnonceRepo;

/**
 * @author diginamic09
 *
 *         Couche de service faisant le lien entre la base de données et la
 *         couche de contrôle pour les Annonces
 */
public interface AnnonceService {

	/**
	 * Lister toutes les annonces de l'utilisateur connecté
	 * 
	 * @param username
	 * @return
	 */
	List<Annonce> listerAnnonces(String username);

	/**
	 * Envoie de l'Annonce au repository pour création
	 * 
	 * Runtime exception générée dans deux cas
	 * 
	 * @param annonce
	 */
	void send(Annonce annonce);

	/**
	 * Envoie de l'id de l'annonce pour suppression
	 * 
	 * @param id
	 */
	void supprimerAnnonce(Long id);

	/**
	 * Récupére toutes les annonces
	 * 
	 * @return
	 */
	List<Annonce> listerAllCovoiturages();

	/**
	 * Récupére l'annonce en fonction du paramètre
	 * 
	 * @param id
	 * @return
	 */
	Optional<Annonce> findAnnonce(Long id);
	
	
}