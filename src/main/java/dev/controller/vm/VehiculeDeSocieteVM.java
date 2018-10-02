package dev.controller.vm;

import dev.domain.Categorie;
import dev.domain.Statut;
import dev.domain.VehiculeDeSociete;

/**
 * @author diginamic09
 * 
 * Structure modèlisant un véhicule de société servant à communiquer avec l'extérieur (WEB API).
 *
 */
public class VehiculeDeSocieteVM extends VehiculeVM {

	private String photo;
	private Categorie categorie;
	private Statut statut;
	private Long id;

	public VehiculeDeSocieteVM() {
		super();
	}

	/**
	 * Constructeur d'un VehiculeDeSocieteVM à partir d'un VehiculeDeSociete
	 * 
	 * @param vehiculeDeSociete
	 */
	public VehiculeDeSocieteVM(VehiculeDeSociete vehiculeDeSociete) {
		
		super(vehiculeDeSociete);
		this.id = vehiculeDeSociete.getId();
		this.photo = vehiculeDeSociete.getPhoto();
		this.categorie = vehiculeDeSociete.getCategorie();
		this.statut = vehiculeDeSociete.getStatut();
	}
	
	/* GETTER - SETTER */

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
