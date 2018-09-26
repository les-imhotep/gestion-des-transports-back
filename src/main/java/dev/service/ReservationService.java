package dev.service;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.domain.ReservationVehicule;
import dev.repository.ReservationVehiculeRepo;

@Service
public class ReservationService {

	private ReservationVehiculeRepo reservationVehiculeRepo;

	public ReservationService(ReservationVehiculeRepo reservationVehiculeRepo) {
		super();
		this.reservationVehiculeRepo = reservationVehiculeRepo;
	}

	public List<ReservationVehicule> listerReservation() {
		return this.reservationVehiculeRepo.findAll();
	}

	public List<ReservationVehicule> listerReservationCollegue(String username) {
		return this.reservationVehiculeRepo.findByCollegueEmail(username);
	}
}
