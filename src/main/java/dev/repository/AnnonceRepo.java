package dev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.domain.Annonce;

public interface AnnonceRepo extends JpaRepository<Annonce, Long> {
	
	List<Annonce> findAllByCollegueEmail(String username);

}
