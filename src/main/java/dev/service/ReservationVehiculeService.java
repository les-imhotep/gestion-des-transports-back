package dev.service;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.domain.ReservationVehicule;
import dev.repository.ReservationVehiculeRepo;

@Service
public class ReservationVehiculeService {

	private ReservationVehiculeRepo reservationVehiculeRepo;

	public ReservationVehiculeService(ReservationVehiculeRepo reservationVehiculeRepo) {
		super();
		this.reservationVehiculeRepo = reservationVehiculeRepo;
	}

	public List<ReservationVehicule> listerReservation() {
		return this.reservationVehiculeRepo.findAll();
	}

	public List<ReservationVehicule> listerReservationCollegue(String username) {
		return this.reservationVehiculeRepo.findByCollegueEmail(username);
	}

	public void supprimerReservationVehic(Long id) {
		this.reservationVehiculeRepo.deleteById(id);
	}
}
