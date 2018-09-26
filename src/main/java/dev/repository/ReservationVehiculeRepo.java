package dev.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.domain.ReservationVehicule;

public interface ReservationVehiculeRepo extends JpaRepository<ReservationVehicule, Long> {

	Optional<ReservationVehicule> findById(Long id);

}
