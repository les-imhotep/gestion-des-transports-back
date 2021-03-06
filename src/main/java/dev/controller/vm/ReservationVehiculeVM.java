package dev.controller.vm;

import java.time.LocalDateTime;

import dev.domain.ReservationVehicule;

/**
 * @author diginamic09
 * 
 * Structure modèlisant une réservation de véhicule servant à communiquer avec l'extérieur (WEB API).
 *
 */
public class ReservationVehiculeVM {

	private long id;
	private CollegueVM collegue;
	private VehiculeDeSocieteVM vehiculeSoc;
	private Boolean chauffeur;
	private LocalDateTime depart;
	private LocalDateTime arrive;

	public ReservationVehiculeVM() {
		super();
	}

	/**
	 * Constructeur d'une ReservationVehiculeVM à partir d'une ReservationVehicule
	 * 
	 * @param resVehicule
	 */
	public ReservationVehiculeVM(ReservationVehicule resVehicule) {
		
		this.id = resVehicule.getId();
		this.collegue = new CollegueVM(resVehicule.getCollegue());
		this.vehiculeSoc = new VehiculeDeSocieteVM(resVehicule.getVehiculeSoc());
		this.chauffeur = resVehicule.getChauffeur();
		this.depart = resVehicule.getDepart();
		this.arrive = resVehicule.getArrive();
	}
	
	/* GETTER - SETTER */

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}



	public CollegueVM getCollegue() {
		return collegue;
	}

	public void setCollegue(CollegueVM collegue) {
		this.collegue = collegue;
	}

	public VehiculeDeSocieteVM getVehiculeSoc() {
		return vehiculeSoc;
	}

	public void setVehiculeSoc(VehiculeDeSocieteVM vehiculeSoc) {
		this.vehiculeSoc = vehiculeSoc;
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
