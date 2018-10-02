package dev.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
import dev.domain.Annonce;
import dev.domain.Vehicule;
import dev.service.AnnonceService;
import dev.service.CollegueService;
import dev.service.VehiculeService;
import dev.utils.Converters;

@CrossOrigin
@RestController() // @Controller + @ResponseBody
@RequestMapping("/collaborateur")
public class AnnonceController extends AbstractController {

	private AnnonceService annonceService;
	private CollegueService collegueService;
	private VehiculeService vehiculeService;

	public AnnonceController(AnnonceService annonceService, CollegueService collegueService,
			VehiculeService vehiculeService) {

		this.annonceService = annonceService;
		this.collegueService = collegueService;
		this.vehiculeService = vehiculeService;
	}

	@GetMapping("/annonces/encours")
	public ResponseEntity<List<AnnonceVM>> listerAnnoncesEnCours() {

		return ResponseEntity.ok(this.annonceService.listerAnnonces(getUserDetails()).stream()
				.filter(annonce -> annonce.getHoraireDeDepart().isAfter(LocalDateTime.now()))
				.map(annonce -> new AnnonceVM(annonce)).collect(Collectors.toList()));

	}

	@GetMapping("/annonces/historique")
	public ResponseEntity<List<AnnonceVM>> listerAnnoncesHistorique() {

		return ResponseEntity.ok(this.annonceService.listerAnnonces(getUserDetails()).stream()
				.filter(annonce -> annonce.getHoraireDeDepart().isBefore(LocalDateTime.now()))
				.map(annonce -> new AnnonceVM(annonce)).collect(Collectors.toList()));

	}

	@PostMapping("/annonces/creer")
	public ResponseEntity<String> creerAnnonce(@RequestBody AnnonceVM annonceVM) {

		Annonce annonce = Converters.ANNONCE_VM_TO_ANNONCE.convert(annonceVM);

		String dateEtHeure = annonceVM.getJourDeDepart() + " " + annonceVM.getHeureDeDepart();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime dateTime = LocalDateTime.parse(dateEtHeure, formatter);
		annonce.setHoraireDeDepart(dateTime);

		this.collegueService.findCollegue(getUserDetails()).ifPresent(collegue -> annonce.setCollegue(collegue));

		Optional<Vehicule> optVehicule = this.vehiculeService
				.findByImmatriculation(annonceVM.getVehicule().getImmatriculation());
		if (optVehicule.isPresent()) {

			annonce.setVehicule(optVehicule.get());
		} else {

			annonce.setVehicule(Converters.VEHICULE_VM_TO_VEHICULE.convert(annonceVM.getVehicule()));
			this.vehiculeService.send(annonce.getVehicule());

		}

		System.out.println(annonce);

		this.annonceService.send(annonce);

		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@PostMapping("/annonces/{id}")
	public ResponseEntity<String> supprimerAnnonce(
			@PathVariable("id") Long id/* @RequestBody AnnonceVM annonceVM */) {

		this.annonceService.supprimerAnnonce(id);

		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@GetMapping("/annonces")
	public ResponseEntity<List<AnnonceVM>> listerCovoiturages() {
		return ResponseEntity.ok(this.annonceService.listerAllCovoiturages().stream()
				.filter(annonce -> annonce.getHoraireDeDepart().isAfter(LocalDateTime.now()))
				.map(annonce -> new AnnonceVM(annonce)).collect(Collectors.toList()));
	}
}
