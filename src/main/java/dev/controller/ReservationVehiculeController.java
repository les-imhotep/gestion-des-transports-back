package dev.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.controller.vm.ReservationVehiculeVM;
import dev.domain.Collegue;
import dev.domain.ReservationVehicule;
import dev.domain.VehiculeDeSociete;
import dev.service.CollegueService;
import dev.service.ReservationVehiculeService;
import dev.service.VehiculeDeSocieteService;

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
	private CollegueService collegueService;
	private VehiculeDeSocieteService vehiculeDeSocieteService;

	/**
	 * Injection des dépendances
	 * 
	 * @param reservationService
	 */
	public ReservationVehiculeController(ReservationVehiculeService reservationService, CollegueService collegueService, VehiculeDeSocieteService vehiculeDeSocieteService) {
		this.reservationVehiculeService = reservationService;
		this.collegueService = collegueService;
		this.vehiculeDeSocieteService = vehiculeDeSocieteService;
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
	
	/**
	 * POST : Ajout d'une réservation de véhicule de société en base de données
	 * 
	 * @param reservationVehiculeVM
	 * @return
	 */
	@PostMapping("/reservationsVehicule/creer")
	public ResponseEntity<String> creerReservationVehicule(@RequestBody ReservationVehiculeVM reservationVehiculeVM){
		
		ReservationVehicule resVehicule = new ReservationVehicule();
		
		Optional<Collegue> optCollegue = this.collegueService.findCollegue(getUserDetails());
		//System.out.println("hgjgh "+reservationVehiculeVM.getDepart());
		Optional<VehiculeDeSociete> optVehicule = this.vehiculeDeSocieteService
				.findByImmatriculation(reservationVehiculeVM.getVehiculeSoc().getImmatriculation());
		
		resVehicule.setVehiculeSoc(optVehicule.get());
		resVehicule.setCollegue(optCollegue.get());
		resVehicule.setDepart(reservationVehiculeVM.getDepart());
		resVehicule.setArrive(reservationVehiculeVM.getArrive());
		resVehicule.setChauffeur(false);
		
		this.reservationVehiculeService.send(resVehicule);
		
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
}
