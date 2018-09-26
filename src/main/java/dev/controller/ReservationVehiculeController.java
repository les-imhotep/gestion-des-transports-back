package dev.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.controller.vm.ReservationVehiculeVM;
import dev.service.ReservationVehiculeService;

@CrossOrigin
@RestController()
@RequestMapping("/collaborateur")
public class ReservationVehiculeController extends AbstractController {

	private ReservationVehiculeService reservationService;

	public ReservationVehiculeController(ReservationVehiculeService reservationService) {
		this.reservationService = reservationService;
	}

	@GetMapping("/reservationsVehicule")
	public ResponseEntity<List<ReservationVehiculeVM>> findReservationById() {
		String username = getUserDetails();
		return ResponseEntity.ok(this.reservationService.listerReservationCollegue(username).stream()
				.map(reservationVehicule -> new ReservationVehiculeVM(reservationVehicule)));
	}
}
