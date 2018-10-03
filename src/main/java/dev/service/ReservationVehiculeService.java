package dev.service;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.domain.ReservationVehicule;
import dev.repository.ReservationVehiculeRepo;

/**
 * @author diginamic09
 *
 * Couche de service faisant le lien entre la base de données et la couche de contrôle pour les réservations de véhicules de service
 */
@Service
public class ReservationVehiculeService {

	private ReservationVehiculeRepo reservationVehiculeRepo;

	/**
	 * Injection des dépendances
	 * 
	 * @param reservationVehiculeRepo
	 */
	public ReservationVehiculeService(ReservationVehiculeRepo reservationVehiculeRepo) {
		super();
		this.reservationVehiculeRepo = reservationVehiculeRepo;
	}

	/**
	 * Lister toutes les réservations de véhicule de service
	 * 
	 * @return
	 */
	public List<ReservationVehicule> listerReservation() {
		return this.reservationVehiculeRepo.findAll();
	}

	/**
	 * Lister toutes les réservations de véhicule de service de l'utilisateur connecté
	 * 
	 * @param username
	 * @return
	 */
	public List<ReservationVehicule> listerReservationCollegue(String username) {
		return this.reservationVehiculeRepo.findByCollegueEmail(username);
	}

	/**
	 * Envoie de l'id de la réservation pour suppression
	 * 
	 * @param id
	 */
	public void supprimerReservationVehicule(Long id) {
		this.reservationVehiculeRepo.deleteById(id);
	}
	
	/**
	 * envoie d'une reservation de vehicule dans la base de données
	 * 
	 * @param resVehicule
	 */
	public void send(ReservationVehicule resVehicule) {
		this.reservationVehiculeRepo.save(resVehicule);
	}
}
