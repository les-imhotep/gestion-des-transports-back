package dev.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.controller.vm.ReservationCovoiturageVM;
import dev.service.ReservationCovoiturageService;

@CrossOrigin
@RestController()
@RequestMapping("/collaborateur")
public class ReservationCovoiturageController extends AbstractController {

	private ReservationCovoiturageService reservationCovoiturageService;

	public ReservationCovoiturageController(ReservationCovoiturageService reservationCovoiturageService) {

		this.reservationCovoiturageService = reservationCovoiturageService;
	}

	// @GetMapping("/reservationsCovoiturage")
	// public ResponseEntity<List<ReservationCovoiturageVM>>
	// listerCovoiturages() {
	// return
	// ResponseEntity.ok(this.reservationCovoiturageService.listerAllCovoiturages().stream()
	// .filter(reservationCovoiturage ->
	// reservationCovoiturage.getAnnonce().getHoraireDeDepart()
	// .isAfter(LocalDateTime.now()))
	// .map(reservationCovoiturage -> new
	// ReservationCovoiturageVM(reservationCovoiturage))
	// .collect(Collectors.toList()));
	//
	// }

	@GetMapping("/reservationsCovoiturage/encours")
	public ResponseEntity<List<ReservationCovoiturageVM>> listerCovoiturageEncours() {
		return ResponseEntity.ok(this.reservationCovoiturageService.listerCovoiturages(getUserDetails()).stream()
				.filter(reservationCovoiturage -> reservationCovoiturage.getAnnonce().getHoraireDeDepart()
						.isAfter(LocalDateTime.now()))
				.map(reservationCovoiturage -> new ReservationCovoiturageVM(reservationCovoiturage))
				.collect(Collectors.toList()));

	}

	@GetMapping("/reservationsCovoiturage/historique")
	public ResponseEntity<List<ReservationCovoiturageVM>> listerCovoiturageHistorique() {
		return ResponseEntity.ok(this.reservationCovoiturageService.listerCovoiturages(getUserDetails()).stream()
				.filter(reservationCovoiturage -> reservationCovoiturage.getAnnonce().getHoraireDeDepart()
						.isBefore(LocalDateTime.now()))
				.map(reservationCovoiturage -> new ReservationCovoiturageVM(reservationCovoiturage))
				.collect(Collectors.toList()));

	}

	@PostMapping("/reservationsCovoiturage/{id}")
	public ResponseEntity<String> supprimerAnnonce(
			@PathVariable("id") Long id/* @RequestBody AnnonceVM annonceVM */) {

		this.reservationCovoiturageService.supprimerCovoiturage(id);

		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

}
