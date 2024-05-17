package com.example.colive.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.colive.Entity.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation , Long> {

}
