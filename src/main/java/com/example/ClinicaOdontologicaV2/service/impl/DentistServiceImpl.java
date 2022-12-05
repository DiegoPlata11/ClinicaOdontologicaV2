package com.example.ClinicaOdontologicaV2.service.impl;

import com.example.ClinicaOdontologicaV2.dto.DentistDto;
import com.example.ClinicaOdontologicaV2.model.Dentist;
import com.example.ClinicaOdontologicaV2.repository.DentistRepository;
import com.example.ClinicaOdontologicaV2.service.DentistService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DentistServiceImpl implements DentistService {

    private final DentistRepository dentistRepository;

    public DentistServiceImpl(DentistRepository dentistRepository) {
        this.dentistRepository = dentistRepository;
    }
    @Override
    public Dentist create(Dentist dentist) {
        return dentistRepository.save(dentist);
    }
    @Override
    public Optional<DentistDto> find(Integer id) {
        ObjectMapper mapper = new ObjectMapper();
        DentistDto dentistDto;
        Dentist dentist = null;
        Optional<Dentist> optionalDentist = dentistRepository.findById(id);

        if (optionalDentist.isPresent()){
            dentist = optionalDentist.get();
        }
        dentistDto = mapper.convertValue(dentist, DentistDto.class);
        return Optional.of(dentistDto);
    }

    @Override
    public List<Dentist> findAll() {
        return dentistRepository.findAll();
    }
    @Override
    public Dentist update(Dentist dentist) {
        return dentistRepository.save(dentist);
    }
    @Override
    public void delete(Integer id){
        dentistRepository.deleteById(id);
    }
    @Override
    public void deleteAll(){
        dentistRepository.deleteAll();
    }
    @Override
    public boolean searchId(Integer id) {
        return dentistRepository.existsById(id);
    }
}
