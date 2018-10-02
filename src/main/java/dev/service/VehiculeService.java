package dev.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import dev.domain.Collegue;
import dev.domain.Vehicule;
import dev.repository.VehiculeRepo;

@Service
@Transactional
public class VehiculeService {

	private VehiculeRepo vehiculeRepo;

	public VehiculeService(VehiculeRepo vehiculeRepo) {

		this.vehiculeRepo = vehiculeRepo;
	}

	public void send(Vehicule vehicule) {

		this.vehiculeRepo.save(vehicule);
		
	}
	
	public Optional<Vehicule> findByImmatriculation(String immatriculation) {

		return this.vehiculeRepo.findByImmatriculation(immatriculation);
	}






}
