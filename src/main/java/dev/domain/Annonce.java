package dev.domain;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;

@Entity
public class Annonce {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@ManyToOne
	@JoinColumn(name="collegue_id")
	private Collegue collegue;
	@ManyToOne
	@JoinColumn(name="vehicule_id")
	private Vehicule vehicule;
	private LocalDateTime horaireDeDepart;
	private String lieuDeDepart;
	private String lieuDeDestination;
	private Integer nombreDeVoyageurs;
	private Integer nombreDePlacesDisponibles;
	@OneToMany(mappedBy= "annonce", cascade = CascadeType.ALL)
	private List<ReservationCovoiturage> listeCovoit;
	
	public Annonce() {
	}

	public Annonce(Collegue collegue, Vehicule vehicule, LocalDateTime horaireDeDepart, String lieuDeDepart,
			String lieuDeDestination, Integer nombreDeVoyageurs) {
		this.collegue = collegue;
		this.vehicule = vehicule;
		this.horaireDeDepart = horaireDeDepart;
		this.lieuDeDepart = lieuDeDepart;
		this.lieuDeDestination = lieuDeDestination;
		this.nombreDeVoyageurs = nombreDeVoyageurs;
		this.nombreDePlacesDisponibles = vehicule.getNombreDePlace()-1;
	}
	
	

	@Override
	public String toString() {
		return "Annonce [id=" + id + ", collegue=" + collegue + ", vehicule=" + vehicule + ", horaireDeDepart="
				+ horaireDeDepart + ", lieuDeDepart=" + lieuDeDepart + ", lieuDeDestination=" + lieuDeDestination
				+ ", nombreDeVoyageurs=" + nombreDeVoyageurs + ", nombreDePlacesDisponibles="
				+ nombreDePlacesDisponibles + ", listeCovoit=" + listeCovoit + "]";
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

	public Vehicule getVehicule() {
		return vehicule;
	}

	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}

	public LocalDateTime getHoraireDeDepart() {
		return horaireDeDepart;
	}

	public void setHoraireDeDepart(LocalDateTime horaireDeDepart) {
		this.horaireDeDepart = horaireDeDepart;
	}

	public String getLieuDeDepart() {
		return lieuDeDepart;
	}

	public void setLieuDeDepart(String lieuDeDepart) {
		this.lieuDeDepart = lieuDeDepart;
	}

	public String getLieuDeDestination() {
		return lieuDeDestination;
	}

	public void setLieuDeDestination(String lieuDeDestination) {
		this.lieuDeDestination = lieuDeDestination;
	}

	public Integer getNombreDeVoyageurs() {
		return nombreDeVoyageurs;
	}

	public void setNombreDeVoyageurs(Integer nombreDeVoyageurs) {
		this.nombreDeVoyageurs = nombreDeVoyageurs;
	}

	public Integer getNombreDePlacesDisponibles() {
		return nombreDePlacesDisponibles;
	}

	public void setNombreDePlacesDisponibles(Integer nombreDePlacesDisponibles) {
		this.nombreDePlacesDisponibles = nombreDePlacesDisponibles;
	}

	public List<ReservationCovoiturage> getListeCovoit() {
		return listeCovoit;
	}

	public void setListeCovoit(List<ReservationCovoiturage> listeCovoit) {
		this.listeCovoit = listeCovoit;
	}
	
	
	
	
	
	
	
	
	

}
