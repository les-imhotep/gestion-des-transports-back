package dev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.domain.Annonce;

/**
 * @author diginamic09
 *
 */
public interface AnnonceRepo extends JpaRepository<Annonce, Long> {
	
	/**
	 * Liste des annonces pour un utilisateur
	 * 
	 * @param username
	 * @return
	 */
	List<Annonce> findAllByCollegueEmail(String username);

}
