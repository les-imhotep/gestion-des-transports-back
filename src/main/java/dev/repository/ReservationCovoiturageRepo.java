package dev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.domain.ReservationCovoiturage;

/**
 * Repository des réservation de covoiturage pour utilisation de JPA
 * 
 * @author diginamic09
 *
 */
public interface ReservationCovoiturageRepo extends JpaRepository<ReservationCovoiturage, Long> {
	
	/**
	 * Liste des réservation de covoiturage pour un utilisateur donné
	 * 
	 * @param username
	 * @return
	 */
	List<ReservationCovoiturage> findAllByCollegueEmail(String username);

}
