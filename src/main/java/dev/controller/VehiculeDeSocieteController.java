package dev.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.controller.vm.VehiculeDeSocieteVM;
import dev.service.VehiculeDeSocieteService;

@CrossOrigin
@RestController()
@RequestMapping("/collaborateur")
public class VehiculeDeSocieteController extends AbstractController {
	
	private VehiculeDeSocieteService vehiculeDeSocieteService;
	

	public VehiculeDeSocieteController(VehiculeDeSocieteService vehiculeDeSocieteService) {
		super();
		this.vehiculeDeSocieteService = vehiculeDeSocieteService;
	}



	@GetMapping("/reservations/creer")
	public ResponseEntity<List<VehiculeDeSocieteVM>> listerLesVehiculeDeSociete() {

		return ResponseEntity.ok(this.vehiculeDeSocieteService.listerVehiculeDeSociete().stream()
				.map(vehicule -> new VehiculeDeSocieteVM(vehicule)).collect(Collectors.toList()));

	}

}