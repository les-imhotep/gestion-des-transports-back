package dev.controller;

import java.util.List;
import java.util.Optional;

import dev.domain.Annonce;
import dev.service.AnnonceService;

public class AnnonceServiceMock implements AnnonceService {

	private Annonce annonce;
	
	public Annonce getAnnonce() {
		return annonce;
	}

	public void setAnnonce(Annonce annonce) {
		this.annonce = annonce;
	}

	@Override
	public List<Annonce> listerAnnonces(String username) {
		
		return null;
	}

	@Override
	public void send(Annonce annonce) {
		this.annonce = annonce;
	}

	@Override
	public void supprimerAnnonce(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Annonce> listerAllCovoiturages() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Annonce> findAnnonce(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
