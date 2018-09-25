package dev.controller.vm;

import dev.domain.Categorie;
import dev.domain.Statut;
import dev.domain.VehiculeDeSociete;

public class VehiculeDeSocieteVM extends VehiculeVM{
	
	private String photo;
	private Categorie categorie;
	private Boolean disponibilite;
	private Statut statut;
	
	public VehiculeDeSocieteVM() {
		
	}

	public VehiculeDeSocieteVM(VehiculeDeSociete vehiculeDeSociete) {
		this.photo = vehiculeDeSociete.getPhoto();
		this.categorie = vehiculeDeSociete.getCategorie();
		this.disponibilite = vehiculeDeSociete.getDisponibilite();
		this.statut = vehiculeDeSociete.getStatut();
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public Boolean getDisponibilite() {
		return disponibilite;
	}

	public void setDisponibilite(Boolean disponibilite) {
		this.disponibilite = disponibilite;
	}

	public Statut getStatut() {
		return statut;
	}

	public void setStatut(Statut statut) {
		this.statut = statut;
	}
	
	
	
	

}
