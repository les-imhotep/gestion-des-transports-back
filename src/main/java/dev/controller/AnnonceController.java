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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.controller.vm.AnnonceVM;
import dev.service.AnnonceService;

@CrossOrigin
@RestController() // @Controller + @ResponseBody
@RequestMapping("/collaborateur")
public class AnnonceController extends AbstractController {

	private AnnonceService annonceService;

	public AnnonceController(AnnonceService annonceService) {

		this.annonceService = annonceService;
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
	public ResponseEntity<String> creerCollegue(@RequestBody AnnonceVM annonceVM) {


		//this.service.send(this.service.findCollegueByMatriculeFromWebApi(collegueFormulaireView));

		return ResponseEntity.status(HttpStatus.CREATED).build();
}
	

	@PostMapping("/annonces/{id}")
	public ResponseEntity<String> supprimerAnnonce(
			@PathVariable("id") Long id/* @RequestBody AnnonceVM annonceVM */) {

		this.annonceService.supprimerAnnonce(id);

		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

}
