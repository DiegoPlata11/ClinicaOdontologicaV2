package com.example.ClinicaOdontologicaV2.repository;

import com.example.ClinicaOdontologicaV2.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository <Patient, Integer> {

}
