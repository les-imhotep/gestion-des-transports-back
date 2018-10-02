package dev.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.domain.Vehicule;

/**
 * Repository des véhicule pour utilisation de JPA
 * 
 * @author diginamic09
 *
 */
public interface VehiculeRepo extends JpaRepository<Vehicule, Long> {
	
	/**
	 * Recherche d'un véhicule par son immatriculation
	 * 
	 * @param immatriculation
	 * @return
	 */
	Optional<Vehicule> findByImmatriculation (String immatriculation);

}
