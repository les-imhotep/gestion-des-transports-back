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

/** 
 * @author diginamic09
 * 
 * Couche de cntrôle faisant le lien entre le front et la couche service pour les réservations de covoiturage
 *
 */
@CrossOrigin
@RestController()
@RequestMapping("/collaborateur")
public class ReservationCovoiturageController extends AbstractController {
	
	private ReservationCovoiturageService reservationCovoiturageService;

	/**
	 * Injection des dépendances
	 * 
	 * @param reservationCovoiturageService
	 */
	public ReservationCovoiturageController(ReservationCovoiturageService reservationCovoiturageService) {
		
		this.reservationCovoiturageService = reservationCovoiturageService;
	}
	
	
	/**
	 * GET: toutes les réservation de covoiturage dont la date est postérieure à la date du jour
	 * 
	 * @return
	 */
	@GetMapping("/reservationsCovoiturage/encours")
	public ResponseEntity<List<ReservationCovoiturageVM>> listerCovoiturageEncours() {


		return ResponseEntity.ok(this.reservationCovoiturageService.listerCovoiturages(getUserDetails())
				.stream()
				.filter(reservationCovoiturage -> reservationCovoiturage.getAnnonce().getHoraireDeDepart().isAfter(LocalDateTime.now()))
				.map(reservationCovoiturage -> new ReservationCovoiturageVM(reservationCovoiturage)).collect(Collectors.toList()));

	}
	
	/**
	 * GET: toutes les réservation de covoiturage dont la date est antérieur à la date du jour
	 * 
	 * @return
	 */
	@GetMapping("/reservationsCovoiturage/historique")
	public ResponseEntity<List<ReservationCovoiturageVM>> listerCovoiturageHistorique() {


		return ResponseEntity.ok(this.reservationCovoiturageService.listerCovoiturages(getUserDetails())
				.stream()
				.filter(reservationCovoiturage -> reservationCovoiturage.getAnnonce().getHoraireDeDepart().isBefore(LocalDateTime.now()))
				.map(reservationCovoiturage -> new ReservationCovoiturageVM(reservationCovoiturage)).collect(Collectors.toList()));

	}
	
	/**
	 * POST : suppression d'un covoiturage en base de données
	 * 
	 * @param id
	 * @return
	 */
	@PostMapping("/reservationsCovoiturage/{id}")
	public ResponseEntity<String> supprimerCovoiturage(@PathVariable("id") Long id) {
		
		
		this.reservationCovoiturageService.supprimerCovoiturage(id);
		
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	

}
