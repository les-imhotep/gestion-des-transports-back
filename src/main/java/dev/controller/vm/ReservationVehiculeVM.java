package dev.controller.vm;

import dev.domain.Collegue;
import dev.domain.ReservationVehicule;
import dev.domain.VehiculeDeSociete;

public class ReservationVehiculeVM {

	private Collegue collegue;
	private VehiculeDeSociete vehiculeSoc;
	private Boolean chauffeur;
	private Long id;

	public ReservationVehiculeVM() {
	}

	public ReservationVehiculeVM(ReservationVehicule resVehicule) {
		
		this.id = resVehicule.getId();
		this.collegue = resVehicule.getCollegue();
		this.vehiculeSoc = resVehicule.getVehiculeSoc();
		this.chauffeur = resVehicule.getChauffeur();
	}
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Collegue getCollegue() {
		return collegue;
	}

	public void setCollegue(Collegue collegue) {
		this.collegue = collegue;
	}

	public VehiculeDeSociete getVehiculeSoc() {
		return vehiculeSoc;
	}

	public void setVehiculeSoc(VehiculeDeSociete vehiculeSoc) {
		this.vehiculeSoc = vehiculeSoc;
	}

	public Boolean getChauffeur() {
		return chauffeur;
	}

	public void setChauffeur(Boolean chauffeur) {
		this.chauffeur = chauffeur;
	}

}
