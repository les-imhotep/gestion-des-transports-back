package dev.domain;

import javax.persistence.Entity;

@Entity
public class VehiculeDeSociete extends Vehicule {
	
	private String photo;
	private Categorie categorie;
	private Boolean disponibilite;
	private Statut statut;
	
	public VehiculeDeSociete(String photo, Categorie categorie, Boolean disponibilite, Statut statut) {
		this.photo = photo;
		this.categorie = categorie;
		this.disponibilite = disponibilite;
		this.statut = statut;
	}

	public VehiculeDeSociete() {
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
