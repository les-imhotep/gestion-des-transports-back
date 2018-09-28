package dev.controller.vm;

import java.time.LocalDateTime;

import dev.domain.Annonce;

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

	public AnnonceVM(Annonce annonce) {
		this.id = annonce.getId();
		this.horaireDeDepart = annonce.getHoraireDeDepart();
		this.lieuDeDepart = annonce.getLieuDeDepart();
		this.lieuDeDestination = annonce.getLieuDeDestination();
		this.nombreDeVoyageurs = annonce.getNombreDeVoyageurs();
		this.vehicule = new VehiculeVM(annonce.getVehicule());
		this.collegue = new CollegueVM(annonce.getCollegue());
		this.nombreDePlacesDisponibles = annonce.getNombreDePlacesDisponibles();
	}

	

	@Override
	public String toString() {
		return "AnnonceVM [horaireDeDepart=" + horaireDeDepart + ", jourDeDepart=" + jourDeDepart + ", heureDeDepart="
				+ heureDeDepart + ", lieuDeDepart=" + lieuDeDepart + ", lieuDeDestination=" + lieuDeDestination
				+ ", nombreDeVoyageurs=" + nombreDeVoyageurs + ", nombreDePlacesDisponibles="
				+ nombreDePlacesDisponibles + ", id=" + id + ", vehicule=" + vehicule + ", collegue=" + collegue + "]";
	}

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
