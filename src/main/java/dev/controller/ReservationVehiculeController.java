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

@CrossOrigin
@RestController()
@RequestMapping("/collaborateur")
public class ReservationVehiculeController extends AbstractController {

	private ReservationVehiculeService reservationVehiculeService;

	public ReservationVehiculeController(ReservationVehiculeService reservationService) {
		this.reservationVehiculeService = reservationService;
	}

	@GetMapping("/reservationsVehicule/encours")
	public ResponseEntity<List<ReservationVehiculeVM>> listerReservationVehiculeEncours() {
		String username = getUserDetails();
		return ResponseEntity.ok(this.reservationVehiculeService.listerReservationCollegue(username).stream()
				.filter(reservationVehicule -> reservationVehicule.getDepart().isAfter(LocalDateTime.now()))
				.map(reservationVehicule -> new ReservationVehiculeVM(reservationVehicule))
				.collect(Collectors.toList()));
	}

	@GetMapping("/reservationsVehicule/historique")
	public ResponseEntity<List<ReservationVehiculeVM>> listerReservationVehiculeHistorique() {
		String username = getUserDetails();
		return ResponseEntity.ok(this.reservationVehiculeService.listerReservationCollegue(username).stream()
				.filter(reservationVehicule -> reservationVehicule.getDepart().isBefore(LocalDateTime.now()))
				.map(reservationVehicule -> new ReservationVehiculeVM(reservationVehicule))
				.collect(Collectors.toList()));
	}

	@PostMapping("/reservationsVehicule/{id}")
	public ResponseEntity<String> supprimerAnnonce(@PathVariable("id") Long id) {
		this.reservationVehiculeService.supprimerReservationVehic(id);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
}
