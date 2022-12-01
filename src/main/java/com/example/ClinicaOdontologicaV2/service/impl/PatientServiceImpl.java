package com.example.ClinicaOdontologicaV2.service.impl;

import com.example.ClinicaOdontologicaV2.model.Patient;
import com.example.ClinicaOdontologicaV2.repository.AddressRepository;
import com.example.ClinicaOdontologicaV2.repository.PatientRepository;
import com.example.ClinicaOdontologicaV2.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;
    @Autowired
    private AddressRepository addressRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public Patient create(Patient patient) {
        addressRepository.save(patient.getAddress());
        return patientRepository.save(patient);
    }

    @Override
    public Optional<Patient> findById(Integer id) {
        return patientRepository.findById(id);
    }
    @Override
    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    @Override
    public Patient update(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public void deleteById(Integer id) {
        patientRepository.deleteById(id);
    }

    @Override
    public void deleteById() {
        patientRepository.deleteAll();
    }

    @Override
    public boolean findId(Integer id) {
        return patientRepository.existsById(id);
    }
}
