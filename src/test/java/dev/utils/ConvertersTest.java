package dev.utils;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import org.junit.Test;

import dev.controller.vm.AnnonceVM;
import dev.controller.vm.VehiculeVM;
import dev.domain.Annonce;
import dev.domain.Collegue;
import dev.domain.Vehicule;

/**
 * @author diginamic09
 *
 */
public class ConvertersTest {
	
	@Test
	public void	ANNONCE_VM_TO_ANNONCE() {
				
		AnnonceVM annonceVM = new AnnonceVM();
		annonceVM.setLieuDeDepart("Caen");
		annonceVM.setLieuDeDestination("Brest");
		annonceVM.setNombreDeVoyageurs(4);
		annonceVM.setNombreDePlacesDisponibles(5);
		
		Annonce annonce = Converters.ANNONCE_VM_TO_ANNONCE.convert(annonceVM);
		
		assertThat(annonce.getLieuDeDepart()).isEqualTo("Caen");
		assertThat(annonce.getLieuDeDestination()).isEqualTo("Brest");
		assertThat(annonce.getNombreDeVoyageurs()).isEqualTo(4);
		assertThat(annonce.getNombreDePlacesDisponibles()).isEqualTo(5);
		
		
	}
	
	@Test
	public void VEHICULE_VM_TO_VEHICULE() {
		
		VehiculeVM vehiculeVM = new VehiculeVM();
		vehiculeVM.setImmatriculation("AA-123-AA");
		vehiculeVM.setMarque("Peugeot");
		vehiculeVM.setModele("404");
		vehiculeVM.setNombreDePlace(5);
		
		Vehicule vehicule = Converters.VEHICULE_VM_TO_VEHICULE.convert(vehiculeVM);
		
		assertThat(vehicule.getImmatriculation()).isEqualTo("AA-123-AA");
		assertThat(vehicule.getMarque()).isEqualTo("Peugeot");
		assertThat(vehicule.getModele()).isEqualTo("404");
		assertThat(vehicule.getNombreDePlace()).isEqualTo(5);
		
	}

	@Test
	public void LOCALDATETIME_TO_STRING_TIME() {
		
		LocalDateTime dateTime = LocalDateTime.of(2018, 10, 2, 9, 41);
		
		
		String heure = Converters.LOCALDATETIME_TO_STRING_TIME.convert(dateTime);
		
		
		assertThat(heure).isEqualTo("09:41");
		
	}
	
	@Test
	public void LOCALDATETIME_TO_STRING_DATE() {
		
		LocalDateTime dateTime = LocalDateTime.of(2018, 10, 2, 9, 41);
		
		
		String date = Converters.LOCALDATETIME_TO_STRING_DATE.convert(dateTime);
		
		
		assertThat(date).isEqualTo("2018-10-02");
		
	}

	
	
	
	
	
	
	

}
