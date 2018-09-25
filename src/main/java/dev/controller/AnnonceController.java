package dev.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.controller.vm.AnnonceVM;
import dev.service.AnnonceService;

@CrossOrigin
@RestController() // @Controller + @ResponseBody
@RequestMapping("/collaborateur")
public class AnnonceController {
	
	private AnnonceService annonceService;

	public AnnonceController(AnnonceService annonceService) {

		this.annonceService = annonceService;
	}
	
	@GetMapping("/annonces")
	public ResponseEntity<List<AnnonceVM>> listerAnnonces() {

		return ResponseEntity.ok(this.annonceService.findAllAnnonces()
				.stream()
				.map(annonce -> new AnnonceVM(annonce)).collect(Collectors.toList()));

	}
	
	

}
