package dev.controller.vm;

import java.time.LocalDateTime;

import dev.domain.Annonce;

public class AnnonceVM {
	
	private LocalDateTime horaireDeDepart;
	private String lieuDeDepart;
	private String lieuDeDestination;
	private Integer nombreDeVoyageurs;
	
	
	public AnnonceVM() {
		
	}

	public AnnonceVM(Annonce annonce) {
		this.horaireDeDepart = annonce.getHoraireDeDepart();
		this.lieuDeDepart = annonce.getLieuDeDepart();
		this.lieuDeDestination = annonce.getLieuDeDestination();
		this.nombreDeVoyageurs = annonce.getNombreDeVoyageurs();
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
	
	
	
	

}
