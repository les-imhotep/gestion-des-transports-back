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

import dev.controller.vm.ReservationVehiculeVM;
import dev.service.ReservationVehiculeService;

/**
 * @author diginamic09
 * 
 * Couche de cntrôle faisant le lien entre le front et la couche service pour les réservations de véhicule
 *
 */
@CrossOrigin
@RestController()
@RequestMapping("/collaborateur")
public class ReservationVehiculeController extends AbstractController {

	private ReservationVehiculeService reservationVehiculeService;

	/**
	 * Injection des dépendances
	 * 
	 * @param reservationService
	 */
	public ReservationVehiculeController(ReservationVehiculeService reservationService) {
		this.reservationVehiculeService = reservationService;
	}

	/**
	 * GET: toutes les réservation de véhicule dont la date est postérieure à la date du jour
	 * 
	 * @return
	 */
	@GetMapping("/reservationsVehicule/encours")
	public ResponseEntity<List<ReservationVehiculeVM>> listerReservationVehiculeEncours() {
		String username = getUserDetails();
		return ResponseEntity.ok(this.reservationVehiculeService.listerReservationCollegue(username).stream()
				.filter(reservationVehicule -> reservationVehicule.getDepart().isAfter(LocalDateTime.now()))
				.map(reservationVehicule -> new ReservationVehiculeVM(reservationVehicule))
				.collect(Collectors.toList()));
	}

	/**
	 * GET: toutes les réservation de véhicule dont la date est antérieur à la date du jour
	 * 
	 * @return
	 */
	@GetMapping("/reservationsVehicule/historique")
	public ResponseEntity<List<ReservationVehiculeVM>> listerReservationVehiculeHistorique() {
		String username = getUserDetails();
		return ResponseEntity.ok(this.reservationVehiculeService.listerReservationCollegue(username).stream()
				.filter(reservationVehicule -> reservationVehicule.getDepart().isBefore(LocalDateTime.now()))
				.map(reservationVehicule -> new ReservationVehiculeVM(reservationVehicule))
				.collect(Collectors.toList()));
	}

	/**
	 * POST : suppression d'une réservation de véhicule en base de données
	 * 
	 * @param id
	 * @return
	 */
	@PostMapping("/reservationsVehicule/{id}")
	public ResponseEntity<String> supprimerReservationVehicule(@PathVariable("id") Long id) {
		this.reservationVehiculeService.supprimerReservationVehicule(id);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
}
