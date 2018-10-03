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

import dev.controller.vm.AnnonceVM;
import dev.controller.vm.ReservationCovoiturageVM;
import dev.domain.Annonce;
import dev.domain.Collegue;
import dev.domain.ReservationCovoiturage;
import dev.service.AnnonceService;
import dev.service.CollegueService;
import dev.service.ReservationCovoiturageService;

/**
 * @author diginamic09
 * 
 *         Couche de cntrôle faisant le lien entre le front et la couche service
 *         pour les réservations de covoiturage
 *
 */
@CrossOrigin
@RestController()
@RequestMapping("/collaborateur")
public class ReservationCovoiturageController extends AbstractController {

	private ReservationCovoiturageService reservationCovoiturageService;
	private CollegueService collegueService;
	private AnnonceService annonceService;

	/**
	 * Injection des dépendances
	 * 
	 * @param reservationCovoiturageService
	 */
	public ReservationCovoiturageController(ReservationCovoiturageService reservationCovoiturageService,
			CollegueService collegueService, AnnonceService annonceService) {

		this.annonceService = annonceService;
		this.collegueService = collegueService;
		this.reservationCovoiturageService = reservationCovoiturageService;
	}

	/**
	 * GET: toutes les réservation de covoiturage dont la date est postérieure à
	 * la date du jour
	 * 
	 * @return
	 */
	@GetMapping("/reservationsCovoiturage/encours")
	public ResponseEntity<List<ReservationCovoiturageVM>> listerCovoiturageEncours() {
		return ResponseEntity.ok(this.reservationCovoiturageService.listerCovoiturages(getUserDetails()).stream()
				.filter(reservationCovoiturage -> reservationCovoiturage.getAnnonce().getHoraireDeDepart()
						.isAfter(LocalDateTime.now()))
				.map(reservationCovoiturage -> new ReservationCovoiturageVM(reservationCovoiturage))
				.collect(Collectors.toList()));

	}

	/**
	 * GET: toutes les réservation de covoiturage dont la date est antérieur à
	 * la date du jour
	 * 
	 * @return
	 */
	@GetMapping("/reservationsCovoiturage/historique")
	public ResponseEntity<List<ReservationCovoiturageVM>> listerCovoiturageHistorique() {
		return ResponseEntity.ok(this.reservationCovoiturageService.listerCovoiturages(getUserDetails()).stream()
				.filter(reservationCovoiturage -> reservationCovoiturage.getAnnonce().getHoraireDeDepart()
						.isBefore(LocalDateTime.now()))
				.map(reservationCovoiturage -> new ReservationCovoiturageVM(reservationCovoiturage))
				.collect(Collectors.toList()));

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

	@PostMapping("/reservationsCovoiturage/creer")
	public ResponseEntity<String> creerCovoiturage(@RequestBody AnnonceVM annonceVM) {

		HttpStatus status;
		ReservationCovoiturage resCovoiturage = new ReservationCovoiturage();

		/*
		 * Récupération des données de l'utilisateur connecté dans la base de
		 * données et vérification de la présence de l'annonce dans la bdd
		 */

		Optional<Collegue> optCollegue = this.collegueService.findCollegue(getUserDetails());
		Optional<Annonce> optAnnonce = this.annonceService.findAnnonce(annonceVM.getId());

		if (optCollegue.isPresent()) {
			if (optAnnonce.isPresent()) {
				if (optAnnonce.get().getNombreDePlacesDisponibles() > 0) {

					optAnnonce.get().setNombreDePlacesDisponibles(optAnnonce.get().getNombreDePlacesDisponibles() - 1);
					optAnnonce.get().setNombreDeVoyageurs(optAnnonce.get().getNombreDeVoyageurs() + 1);

					resCovoiturage.setAnnonce(optAnnonce.get());
					resCovoiturage.setCollegue(optCollegue.get());

					/*
					 * Appel de la méthode send() du service pour écrire en base
					 */

					this.reservationCovoiturageService.send(resCovoiturage);
					status = HttpStatus.CREATED;
				} else {
					status = HttpStatus.BAD_REQUEST;
				}
			} else {
				status = HttpStatus.BAD_REQUEST;
			}
		} else {
			status = HttpStatus.BAD_REQUEST;
		}

		return ResponseEntity.status(status).build();
	}

}
