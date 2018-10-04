package dev.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.domain.ReservationCovoiturage;
import dev.repository.ReservationCovoiturageRepo;

/**
 * @author diginamic09
 * 
 *         Couche de service faisant le lien entre la base de données et la
 *         couche de contrôle pour les réservations de covoiturages
 *
 */
@Service
@Transactional
public class ReservationCovoiturageService {

	private ReservationCovoiturageRepo reservationCovoiturageRepo;

	/**
	 * Injection des dépendances
	 * 
	 * @param reservationCovoiturageRepo
	 */
	public ReservationCovoiturageService(ReservationCovoiturageRepo reservationCovoiturageRepo) {

		this.reservationCovoiturageRepo = reservationCovoiturageRepo;
	}

	/**
	 * Lister toutes les réservations de covoiturages de l'utilisateur connecté
	 * 
	 * @param username
	 * @return
	 */
	public List<ReservationCovoiturage> listerCovoiturages(String username) {

		return this.reservationCovoiturageRepo.findAllByCollegueEmail(username);
	}

	/**
	 * Envoie de l'id de la réservation du covoiturage pour suppression
	 * 
	 * @param id
	 */
	public void supprimerCovoiturage(Long id) {

		this.reservationCovoiturageRepo.deleteById(id);
	}

	/**
	 * envoie d'une reservation de covoiturage dans la base de données
	 * 
	 * @param resCovoiturage
	 */
	public void send(ReservationCovoiturage resCovoiturage) {
		this.reservationCovoiturageRepo.save(resCovoiturage);
	}

	/**
	 * Récupére la réservation de covoiturage en fonction du paramètre
	 * 
	 * @param id
	 * @return
	 */
	public Optional<ReservationCovoiturage> findAnnonce(Long id) {
		return this.reservationCovoiturageRepo.findById(id);
	}
}
