package dev.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Vehicule {
	
	@Id
    @GeneratedValue
    private Long id;
	
	private String marque;
	private String modele;
	private String immatriculation;
	private Integer nombreDePlace;
	
	public Vehicule() {
	}

	public Vehicule(String marque, String modele, String immatriculation, Integer nombreDePlace) {
		this.marque = marque;
		this.modele = modele;
		this.immatriculation = immatriculation;
		this.nombreDePlace = nombreDePlace;
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getModele() {
		return modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}

	public String getImmatriculation() {
		return immatriculation;
	}

	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}

	public Integer getNombreDePlace() {
		return nombreDePlace;
	}

	public void setNombreDePlace(Integer nombreDePlace) {
		this.nombreDePlace = nombreDePlace;
	}
	
	
	
	
	

}
