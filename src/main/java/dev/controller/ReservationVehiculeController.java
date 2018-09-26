package dev.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.controller.vm.ReservationVehiculeVM;
import dev.service.ReservationService;

@CrossOrigin
@RestController()
@RequestMapping("/collaborateur")
public class ReservationVehiculeController {

	private ReservationService reservationService;

	public ReservationVehiculeController(ReservationService reservationService) {
		this.reservationService = reservationService;
	}

	@GetMapping("/reservations")
	public ResponseEntity<List<ReservationVehiculeVM>> findAll() {
		return ResponseEntity.ok(this.reservationService.listerReservation().stream()
				.map(reservationVehicule -> new ReservationVehiculeVM(reservationVehicule))
				.collect(Collectors.toList()));
	}

	@GetMapping("/reservations/{id}")
	public ResponseEntity<List<ReservationVehiculeVM>> findReservationById(@PathVariable Long id) {
		return ResponseEntity.ok(this.reservationService.listerReservationCollegue(id)
				.map(reservationVehicule -> new ReservationVehiculeVM(reservationVehicule)));
	}
}
