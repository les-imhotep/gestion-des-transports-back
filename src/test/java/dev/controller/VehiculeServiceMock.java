package dev.controller;

import java.util.Optional;

import dev.domain.Collegue;
import dev.domain.Vehicule;
import dev.service.CollegueService;
import dev.service.VehiculeService;

public class VehiculeServiceMock implements VehiculeService {

	@Override
	public void send(Vehicule vehicule) {
		// TODO Auto-generated method stub

	}

	@Override
	public Optional<Vehicule> findByImmatriculation(String immatriculation) {
		return Optional.empty();
	}

}
