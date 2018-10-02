package dev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.domain.Annonce;

/**
 * @author diginamic09
 * 
 * Repository des Annonces pour utilisation de JPA
 *
 */
public interface AnnonceRepo extends JpaRepository<Annonce, Long> {
	
	/**
	 * Liste des annonces pour un utilisateur donné
	 * 
	 * @param username
	 * @return
	 */
	List<Annonce> findAllByCollegueEmail(String username);

}
