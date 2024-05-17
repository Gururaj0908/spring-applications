package com.example.coworkspace.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.coworkspace.Entity.RentalAgreement;

@Repository
public interface RentalAgreementRepository extends JpaRepository<RentalAgreement, Long>{

}
