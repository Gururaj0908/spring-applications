package com.example.coworkspace.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.coworkspace.Entity.Reservation;


@Repository
public interface ReservationRepository extends JpaRepository<Reservation , Long> {

}
