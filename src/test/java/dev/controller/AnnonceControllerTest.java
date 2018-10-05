package dev.controller;

import static org.junit.Assert.*;

import org.junit.Test;

import dev.controller.vm.AnnonceVM;
import dev.controller.vm.VehiculeVM;

public class AnnonceControllerTest {

	@Test
	public void testCreerAnnonce() {
		
		AnnonceServiceMock annonceServ = new AnnonceServiceMock();
		AnnonceController annonceController = new AnnonceController(annonceServ, new CollegueServiceMock(), new VehiculeServiceMock());
		
		AnnonceVM annonceVM = new AnnonceVM();
		annonceVM.setJourDeDepart("2018-12-10");
		annonceVM.setHeureDeDepart("12:12");
		
		annonceVM.setVehicule(new VehiculeVM());
		annonceVM.getVehicule().setImmatriculation("12");
		
		
		annonceController.creerAnnonce(annonceVM);
		
		assertNull(annonceServ.getAnnonce().getCollegue());
		
		
	}

}
