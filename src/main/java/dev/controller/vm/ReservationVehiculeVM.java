package dev.controller.vm;

import java.time.LocalDateTime;

import dev.domain.ReservationVehicule;

public class ReservationVehiculeVM {

	private long id;

	private CollegueVM collegueVM;

	private VehiculeDeSocieteVM vehiculeSocVM;
	private Boolean chauffeur;

	private LocalDateTime depart;

	private LocalDateTime arrive;

	public ReservationVehiculeVM() {
	}

	public ReservationVehiculeVM(ReservationVehicule resVehicule) {
		super();
		this.id = resVehicule.getId();
		this.collegueVM = new CollegueVM(resVehicule.getCollegue());
		this.vehiculeSocVM = new VehiculeDeSocieteVM(resVehicule.getVehiculeSoc());
		this.chauffeur = resVehicule.getChauffeur();
		this.depart = resVehicule.getDepart();
		this.arrive = resVehicule.getArrive();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public CollegueVM getCollegue() {
		return collegueVM;
	}

	public void setCollegue(CollegueVM collegue) {
		this.collegueVM = collegue;
	}

	public VehiculeDeSocieteVM getVehiculeSoc() {
		return vehiculeSocVM;
	}

	public void setVehiculeSoc(VehiculeDeSocieteVM vehiculeSoc) {
		this.vehiculeSocVM = vehiculeSoc;
	}

	public Boolean getChauffeur() {
		return chauffeur;
	}

	public void setChauffeur(Boolean chauffeur) {
		this.chauffeur = chauffeur;
	}

	public LocalDateTime getDepart() {
		return depart;
	}

	public void setDepart(LocalDateTime depart) {
		this.depart = depart;
	}

	public LocalDateTime getArrive() {
		return arrive;
	}

	public void setArrive(LocalDateTime arrive) {
		this.arrive = arrive;
	}

}
