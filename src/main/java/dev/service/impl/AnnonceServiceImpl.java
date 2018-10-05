package dev.service.impl;

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
import dev.service.AnnonceService;

/**
 * @author diginamic09
 *
 *         Couche de service faisant le lien entre la base de données et la
 *         couche de contrôle pour les Annonces
 */
@Service
@Transactional
public class AnnonceServiceImpl implements AnnonceService {

	private AnnonceRepo annonceRepo;

	/**
	 * Injection des dépendances
	 * 
	 * @param annonceRepo
	 */
	public AnnonceServiceImpl(AnnonceRepo annonceRepo) {

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
	 * Runtime exception générée dans deux cas
	 * 
	 * @param annonce
	 */
	public void send(Annonce annonce) {
		
		if (annonce.getNombreDePlacesDisponibles() >= annonce.getVehicule().getNombreDePlace()) {
			
			throw new NbDePlaceException();
		}
		else if (annonce.getHoraireDeDepart().isBefore(LocalDateTime.now())) {
			
			throw new HoraireException();
			
		}
		else {
			this.annonceRepo.save(annonce);
		}
	
	}

	/**
	 * Envoie de l'id de l'annonce pour suppression
	 * 
	 * @param id
	 */
	public void supprimerAnnonce(Long id) {

		this.annonceRepo.deleteById(id);
	}

	/**
	 * Récupére toutes les annonces
	 * 
	 * @return
	 */
	public List<Annonce> listerAllCovoiturages() {

		return this.annonceRepo.findAll();
	}

	/**
	 * Récupére l'annonce en fonction du paramètre
	 * 
	 * @param id
	 * @return
	 */
	public Optional<Annonce> findAnnonce(Long id) {
		return this.annonceRepo.findById(id);
	}
	
	
	
	
	
}