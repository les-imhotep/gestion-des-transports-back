package dev.controller.vm;

import java.time.LocalDateTime;

import dev.domain.Annonce;
import dev.utils.Converters;

/**
 * @author diginamic09
 * 
 * Annonce View Model
 *
 */
public class AnnonceVM {
	
	private LocalDateTime horaireDeDepart;
	private String jourDeDepart;	// string coté front
	private String heureDeDepart; // string coté front
	private String lieuDeDepart;
	private String lieuDeDestination;
	private Integer nombreDeVoyageurs;
	private Integer nombreDePlacesDisponibles;
	private Long id;
	private VehiculeVM vehicule;
	private CollegueVM collegue;
	
	
	public AnnonceVM() {
		
	}

	/**
	 * Constructeur d'un AnnonceVM à partir d'une Annonce
	 * 
	 * @param annonce
	 */
	public AnnonceVM(Annonce annonce) {
		this.id = annonce.getId();
		this.horaireDeDepart = annonce.getHoraireDeDepart();
		this.heureDeDepart = Converters.LOCALDATETIME_TO_STRING_TIME.convert(annonce.getHoraireDeDepart());
		this.jourDeDepart = Converters.LOCALDATETIME_TO_STRING_DATE.convert(annonce.getHoraireDeDepart());
		this.lieuDeDepart = annonce.getLieuDeDepart();
		this.lieuDeDestination = annonce.getLieuDeDestination();
		this.nombreDeVoyageurs = annonce.getNombreDeVoyageurs();
		this.vehicule = new VehiculeVM(annonce.getVehicule());
		this.collegue = new CollegueVM(annonce.getCollegue());
		this.nombreDePlacesDisponibles = annonce.getNombreDePlacesDisponibles();
	}

	
	/* GETTER - SETTER */

	public String getJourDeDepart() {
		return jourDeDepart;
	}

	public void setJourDeDepart(String jourDeDepart) {
		this.jourDeDepart = jourDeDepart;
	}

	public String getHeureDeDepart() {
		return heureDeDepart;
	}

	public void setHeureDeDepart(String heureDeDepart) {
		this.heureDeDepart = heureDeDepart;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getHoraireDeDepart() {
		return horaireDeDepart;
	}

	public void setHoraireDeDepart(LocalDateTime horaireDeDepart) {
		this.horaireDeDepart = horaireDeDepart;
	}

	public String getLieuDeDepart() {
		return lieuDeDepart;
	}

	public void setLieuDeDepart(String lieuDeDepart) {
		this.lieuDeDepart = lieuDeDepart;
	}

	public String getLieuDeDestination() {
		return lieuDeDestination;
	}

	public void setLieuDeDestination(String lieuDeDestination) {
		this.lieuDeDestination = lieuDeDestination;
	}

	public Integer getNombreDeVoyageurs() {
		return nombreDeVoyageurs;
	}

	public void setNombreDeVoyageurs(Integer nombreDeVoyageurs) {
		this.nombreDeVoyageurs = nombreDeVoyageurs;
	}

	public VehiculeVM getVehicule() {
		return vehicule;
	}

	public void setVehicule(VehiculeVM vehicule) {
		this.vehicule = vehicule;
	}

	public CollegueVM getCollegue() {
		return collegue;
	}

	public void setCollegue(CollegueVM collegue) {
		this.collegue = collegue;
	}

	public Integer getNombreDePlacesDisponibles() {
		return nombreDePlacesDisponibles;
	}

	public void setNombreDePlacesDisponibles(Integer nombreDePlacesDisponibles) {
		this.nombreDePlacesDisponibles = nombreDePlacesDisponibles;
	}
	
	
	
	
	
	

}
