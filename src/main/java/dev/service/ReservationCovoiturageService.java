package dev.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.domain.ReservationCovoiturage;
import dev.repository.ReservationCovoiturageRepo;

@Service
@Transactional
public class ReservationCovoiturageService {

	private ReservationCovoiturageRepo reservationCovoiturageRepo;

	public ReservationCovoiturageService(ReservationCovoiturageRepo reservationCovoiturageRepo) {

		this.reservationCovoiturageRepo = reservationCovoiturageRepo;
	}

	// public List<ReservationCovoiturage> listerAllCovoiturages() {
	//
	// return this.reservationCovoiturageRepo.findAll();
	// }

	public List<ReservationCovoiturage> listerCovoiturages(String username) {

		return this.reservationCovoiturageRepo.findAllByCollegueEmail(username);
	}

	public void supprimerCovoiturage(Long id) {

		this.reservationCovoiturageRepo.deleteById(id);
	}

}
