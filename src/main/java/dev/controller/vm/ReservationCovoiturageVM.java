package dev.controller.vm;


import dev.domain.ReservationCovoiturage;

public class ReservationCovoiturageVM {
	
	
	private CollegueVM collegue;
	private AnnonceVM annonce;
	private Long id;
	
	public ReservationCovoiturageVM() {
		
	}

	public ReservationCovoiturageVM(ReservationCovoiturage reservationCovoiturage) {

		this.id = reservationCovoiturage.getId();
		this.collegue = new CollegueVM(reservationCovoiturage.getCollegue());
		this.annonce = new AnnonceVM(reservationCovoiturage.getAnnonce());
	}
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CollegueVM getCollegue() {
		return collegue;
	}

	public void setCollegue(CollegueVM collegue) {
		this.collegue = collegue;
	}

	public AnnonceVM getAnnonce() {
		return annonce;
	}

	public void setAnnonce(AnnonceVM annonce) {
		this.annonce = annonce;
	}



	
	
	
	
	
	

}
