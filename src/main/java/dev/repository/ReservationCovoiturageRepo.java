package dev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.domain.ReservationCovoiturage;

public interface ReservationCovoiturageRepo extends JpaRepository<ReservationCovoiturage, Long> {
	
	List<ReservationCovoiturage> findAllByCollegueEmail(String username);

}
