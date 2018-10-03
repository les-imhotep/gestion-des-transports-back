package dev.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.domain.VehiculeDeSociete;

public interface VehiculeDeSocieteRepo extends JpaRepository<VehiculeDeSociete, Long> {
	
	Optional<VehiculeDeSociete> findByImmatriculation (String immatriculation);

}
