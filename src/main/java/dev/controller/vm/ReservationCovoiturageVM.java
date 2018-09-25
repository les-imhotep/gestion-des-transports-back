package dev.controller.vm;


import dev.domain.Annonce;
import dev.domain.Collegue;
import dev.domain.ReservationCovoiturage;

public class ReservationCovoiturageVM {
	
	
	private Collegue collegue;
	private Annonce annonce;
	
	public ReservationCovoiturageVM() {
		
	}

	public ReservationCovoiturageVM(ReservationCovoiturage reservationCovoiturage) {

		this.collegue = reservationCovoiturage.getCollegue();
		this.annonce = reservationCovoiturage.getAnnonce();
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
