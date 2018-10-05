package dev.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import dev.domain.Vehicule;
import dev.repository.VehiculeRepo;

/**
 * @author diginamic09
 * 
 * Couche de service faisant le lien entre la base de données et la couche de contrôle pour les véhicules
 */
public interface VehiculeService {


	/**
	 * Envoie du véhicule au repository pour création
	 * 
	 * @param vehicule
	 */
	void send(Vehicule vehicule);
	
	/**
	 * Recherche d'un véhicule grâce à son immatriculation
	 *  
	 * @param immatriculation
	 * @return
	 */
	Optional<Vehicule> findByImmatriculation(String immatriculation);

}
