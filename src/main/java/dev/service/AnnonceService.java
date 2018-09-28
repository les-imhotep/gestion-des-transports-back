package dev.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import dev.domain.Annonce;
import dev.repository.AnnonceRepo;

@Service
@Transactional
public class AnnonceService {

	private AnnonceRepo annonceRepo;

	public AnnonceService(AnnonceRepo annonceRepo) {

		this.annonceRepo = annonceRepo;
	}

	public List<Annonce> listerAnnonces(String username) {

		return this.annonceRepo.findAllByCollegueEmail(username);
	}
	
	public void send(Annonce annonce) {
		
		this.annonceRepo.save(annonce);
	}

	public void supprimerAnnonce(Long id) {

		this.annonceRepo.deleteById(id);
	}

}