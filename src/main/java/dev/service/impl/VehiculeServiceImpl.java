package dev.service.impl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import dev.domain.Vehicule;
import dev.repository.VehiculeRepo;
import dev.service.VehiculeService;

/**
 * @author diginamic09
 * 
 * Couche de service faisant le lien entre la base de données et la couche de contrôle pour les véhicules
 */
@Service
@Transactional
public class VehiculeServiceImpl implements VehiculeService {

	private VehiculeRepo vehiculeRepo;

	/**
	 * Injection des dépendances
	 * 
	 * @param vehiculeRepo
	 */
	public VehiculeServiceImpl(VehiculeRepo vehiculeRepo) {

		this.vehiculeRepo = vehiculeRepo;
	}

	/**
	 * Envoie du véhicule au repository pour création
	 * 
	 * @param vehicule
	 */
	public void send(Vehicule vehicule) {

		this.vehiculeRepo.save(vehicule);
		
	}
	
	/**
	 * Recherche d'un véhicule grâce à son immatriculation
	 *  
	 * @param immatriculation
	 * @return
	 */
	public Optional<Vehicule> findByImmatriculation(String immatriculation) {

		return this.vehiculeRepo.findByImmatriculation(immatriculation);
	}






}
