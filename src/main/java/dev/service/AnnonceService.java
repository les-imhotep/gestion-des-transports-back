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
	
	
	
	public List<Annonce> findAllAnnonces() {

		return this.annonceRepo.findAll();
	}
	
	

}
