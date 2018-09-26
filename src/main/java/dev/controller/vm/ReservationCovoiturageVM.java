package dev.controller.vm;


import dev.domain.ReservationCovoiturage;

public class ReservationCovoiturageVM {
	
	
	private CollegueVM collegueVM;
	private AnnonceVM annonceVM;
	private Long id;
	
	public ReservationCovoiturageVM() {
		
	}

	public ReservationCovoiturageVM(ReservationCovoiturage reservationCovoiturage) {

		this.id = reservationCovoiturage.getId();
		this.collegueVM = new CollegueVM(reservationCovoiturage.getCollegue());
		this.annonceVM = new AnnonceVM(reservationCovoiturage.getAnnonce());
	}
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CollegueVM getCollegueVM() {
		return collegueVM;
	}

	public void setCollegueVM(CollegueVM collegueVM) {
		this.collegueVM = collegueVM;
	}

	public AnnonceVM getAnnonceVM() {
		return annonceVM;
	}

	public void setAnnonceVM(AnnonceVM annonceVM) {
		this.annonceVM = annonceVM;
	}

	
	
	
	
	
	

}
