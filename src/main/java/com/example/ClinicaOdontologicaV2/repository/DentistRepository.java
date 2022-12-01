package com.example.ClinicaOdontologicaV2.repository;

import com.example.ClinicaOdontologicaV2.model.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DentistRepository extends JpaRepository<Dentist,Integer> {
}
