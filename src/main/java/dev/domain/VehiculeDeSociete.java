package dev.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class VehiculeDeSociete extends Vehicule {

	private String photo;
	@Enumerated(EnumType.STRING)
	private Categorie categorie;
	@Enumerated(EnumType.STRING)
	private Statut statut;

	public VehiculeDeSociete(String photo, Categorie categorie, Statut statut) {
		this.photo = photo;
		this.categorie = categorie;
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

	public Statut getStatut() {
		return statut;
	}

	public void setStatut(Statut statut) {
		this.statut = statut;
	}

}
