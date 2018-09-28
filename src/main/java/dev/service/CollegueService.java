package dev.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import dev.domain.Collegue;
import dev.repository.CollegueRepo;

@Service
@Transactional
public class CollegueService {
	
	private CollegueRepo collegueRepo;
	
	public CollegueService(CollegueRepo collegueRepo) {

		this.collegueRepo = collegueRepo;
	}



	public Optional<Collegue> findCollegue(String username) {

		return this.collegueRepo.findByEmail(username);
	}

}
