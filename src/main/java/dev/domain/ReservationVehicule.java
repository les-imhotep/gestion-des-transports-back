package dev.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ReservationVehicule {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "collegue_id")
	private Collegue collegue;

	@ManyToOne
	@JoinColumn(name = "vehiculeSoc_id")
	private VehiculeDeSociete vehiculeSoc;

	private Boolean chauffeur;

	private LocalDateTime depart;
	private LocalDateTime arrive;

	public ReservationVehicule() {
		super();
	}

	public ReservationVehicule(Collegue collegue, VehiculeDeSociete vehiculeSoc, Boolean chauffeur,
			LocalDateTime depart, LocalDateTime arrive) {
		super();
		this.collegue = collegue;
		this.vehiculeSoc = vehiculeSoc;
		this.chauffeur = chauffeur;
		this.depart = depart;
		this.arrive = arrive;
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
