package dev.controller.vm;

import dev.domain.Vehicule;

public class VehiculeVM {
	
	private String marque;
	private String modele;
	private String immatriculation;
	private String nombreDePlace;
	
	
	public VehiculeVM() {
	}

	public VehiculeVM(Vehicule vehicule) {
		this.marque = vehicule.getMarque();
		this.modele = vehicule.getModele();
		this.immatriculation = vehicule.getImmatriculation();
		this.nombreDePlace = vehicule.getNombreDePlace();
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

	public String getNombreDePlace() {
		return nombreDePlace;
	}

	public void setNombreDePlace(String nombreDePlace) {
		this.nombreDePlace = nombreDePlace;
	}
	
	
	
	

}
