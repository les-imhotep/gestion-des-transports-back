package dev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.domain.ReservationVehicule;

public interface ReservationVehiculeRepo extends JpaRepository<ReservationVehicule, Long> {

	List<ReservationVehicule> findByCollegueEmail(String username);

}
