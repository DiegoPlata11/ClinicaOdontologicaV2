package com.example.ClinicaOdontologicaV2.service;

import com.example.ClinicaOdontologicaV2.model.Patient;

import java.util.List;
import java.util.Optional;

public interface PatientService {

    Patient create(Patient patient);

    Optional<Patient> findById(Integer id);

    List<Patient> findAll();

    Patient update(Patient patient);

    void deleteById(Integer id);

    void deleteById();

    boolean findId(Integer id);

}
