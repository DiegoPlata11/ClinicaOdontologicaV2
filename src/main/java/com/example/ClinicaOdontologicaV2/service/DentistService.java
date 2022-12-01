package com.example.ClinicaOdontologicaV2.service;

import com.example.ClinicaOdontologicaV2.dto.DentistDto;
import com.example.ClinicaOdontologicaV2.model.Dentist;

import java.util.List;
import java.util.Optional;

public interface DentistService {

    Dentist create(Dentist dentist);

    Optional<DentistDto> find(Integer id);

    List<Dentist> findAll();

    Dentist update(Dentist dentist);

    void delete(Integer id);

    void deleteAll();

    boolean searchId(Integer id);


}
