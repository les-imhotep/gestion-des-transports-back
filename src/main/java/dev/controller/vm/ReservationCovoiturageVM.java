package dev.controller.vm;

import dev.domain.ReservationCovoiturage;
import dev.utils.Converters;

/**
 * @author diginamic09
 * 
 *         Structure modèlisant une réservation de covoiturage servant à
 *         communiquer avec l'extérieur (WEB API).
 *
 */
public class ReservationCovoiturageVM {

	private CollegueVM collegue;
	private AnnonceVM annonce;
	private Long id;

	public ReservationCovoiturageVM() {
		super();
	}

	/**
	 * Constructeur d'une ReservationCovoiturageVM à partir d'une
	 * ReservationCovoiturage
	 * 
	 * @param reservationCovoiturage
	 */
	public ReservationCovoiturageVM(ReservationCovoiturage reservationCovoiturage) {

		this.id = reservationCovoiturage.getId();
		this.collegue = new CollegueVM(reservationCovoiturage.getCollegue());
		this.annonce = new AnnonceVM(reservationCovoiturage.getAnnonce());
		this.annonce
				.setHeureDeDepart(Converters.LOCALDATETIME_TO_STRING_TIME.convert(this.annonce.getHoraireDeDepart()));
		this.annonce
				.setJourDeDepart(Converters.LOCALDATETIME_TO_STRING_DATE.convert(this.annonce.getHoraireDeDepart()));
	}

	/* GETTER - SETTER */

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
