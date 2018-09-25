package dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.domain.ReservationCovoiturage;

public interface ReservationCovoiturageRepo extends JpaRepository<ReservationCovoiturage, Long> {

}
