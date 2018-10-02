package dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.domain.VehiculeDeSociete;

public interface VehiculeDeSocieteRepo extends JpaRepository<VehiculeDeSociete, Long> {
	
	//List<Vehicule> findByImmatriculation (String immatriculation);

}
