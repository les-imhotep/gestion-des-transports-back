package dev.controller.vm;


import dev.domain.Annonce;
import dev.domain.Collegue;
import dev.domain.ReservationCovoiturage;

public class ReservationCovoiturageVM {
	
	
	private Collegue collegue;
	private Annonce annonce;
	private Long id;
	
	public ReservationCovoiturageVM() {
		
	}

	public ReservationCovoiturageVM(ReservationCovoiturage reservationCovoiturage) {

		this.id = reservationCovoiturage.getId();
		this.collegue = reservationCovoiturage.getCollegue();
		this.annonce = reservationCovoiturage.getAnnonce();
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

	public Annonce getAnnonce() {
		return annonce;
	}

	public void setAnnonce(Annonce annonce) {
		this.annonce = annonce;
	}
	
	
	
	
	

}
