package utils;

import org.springframework.core.convert.converter.Converter;

import dev.controller.vm.AnnonceVM;
import dev.controller.vm.VehiculeVM;
import dev.domain.Annonce;
import dev.domain.Vehicule;

public interface Converters {
	
	Converter <VehiculeVM, Vehicule> VEHICULE_VM_TO_VEHICULE = source -> {
		
		Vehicule vehicule = new Vehicule();

		vehicule.setImmatriculation(source.getImmatriculation());
		vehicule.setMarque(source.getMarque());
		vehicule.setModele(source.getModele());
		vehicule.setNombreDePlace(source.getNombreDePlace());
		
		return vehicule;
		
	};
	
	
	Converter <AnnonceVM, Annonce> ANNONCE_VM_TO_ANNONCE = source -> {
		
		Annonce annonce = new Annonce();
				
		
		annonce.setLieuDeDepart(source.getLieuDeDepart());
		annonce.setLieuDeDestination(source.getLieuDeDestination());
		annonce.setNombreDeVoyageurs(source.getNombreDeVoyageurs());
		annonce.setNombreDePlacesDisponibles(source.getNombreDePlacesDisponibles());
		
		return annonce;
		
	};

}
