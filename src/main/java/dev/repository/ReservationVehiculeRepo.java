package dev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.domain.ReservationVehicule;

/**
 * Repository des réservation de véhicule pour utilisation de JPA
 * 
 * @author diginamic09
 *
 */
public interface ReservationVehiculeRepo extends JpaRepository<ReservationVehicule, Long> {

	/**
	 * Liste des réservation de véhicule pour un utilisateur donné
	 * 
	 * @param username
	 * @return
	 */
	List<ReservationVehicule> findByCollegueEmail(String username);

}
