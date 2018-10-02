package dev.repository;

import dev.domain.Collegue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author diginamic09
 * 
 * Repository des Collegues pour utilisation de JPA
 *
 */
public interface CollegueRepo extends JpaRepository<Collegue, Long> {

    /**
     * Recherche d'un collegue par son adresse email
     * 
     * @param email
     * @return
     */
    Optional<Collegue> findByEmail(String email);
}
