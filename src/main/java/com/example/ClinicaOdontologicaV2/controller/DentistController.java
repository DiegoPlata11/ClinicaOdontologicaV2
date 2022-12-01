package com.example.ClinicaOdontologicaV2.controller;

import com.example.ClinicaOdontologicaV2.dto.DentistDto;
import com.example.ClinicaOdontologicaV2.model.Dentist;
import com.example.ClinicaOdontologicaV2.service.impl.DentistServiceImpl;
import lombok.AllArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/dentist")
@AllArgsConstructor
public class DentistController {

    private final Logger LOGGER = Logger.getLogger(DentistController.class);

    private final DentistServiceImpl dentistServiceImpl;
    //Create new dentist
    @PostMapping("/api/new")
    public Dentist createDentist(@RequestBody Dentist dentist){
        return dentistServiceImpl.create(dentist);
    }

    @GetMapping("/api/dentist")
    //Search all dentist
    public List<Dentist> findAll(){
        return dentistServiceImpl.findAll();
    }
    //Search dentist by id
    @GetMapping("/api/dentist/{id}")
    public ResponseEntity<DentistDto> FindById(@PathVariable Integer id){
        Optional<DentistDto> dentistOpt = dentistServiceImpl.find(id);

        if(dentistOpt.isPresent())
            return ResponseEntity.ok(dentistOpt.get());
        else
            return ResponseEntity.notFound().build();
    }
    //Update dentist
    @PutMapping("/api/dentist")
    public ResponseEntity<Dentist> update(@RequestBody Dentist dentist){
        if(dentist.getId() == null){
            LOGGER.warn("Trying to update a non-existent dentist");
            return ResponseEntity.badRequest().build();
        }

        if(!dentistServiceImpl.searchId(dentist.getId())){
            LOGGER.warn("Trying to update a non-existent dentist");
            return ResponseEntity.notFound().build();
        }

        Dentist result = dentistServiceImpl.update(dentist);
            LOGGER.debug("Dentist updated in database");
            return ResponseEntity.ok(result);
    }
    //Delete dentist
    @DeleteMapping("/api/dentist/{id}")
    public ResponseEntity<Dentist> delete(@PathVariable Integer id){
        if(!dentistServiceImpl.searchId(id)){
            LOGGER.warn("Trying to delete a non-existent dentist");
            return ResponseEntity.notFound().build();
        }
        dentistServiceImpl.delete(id);
        LOGGER.debug("Trying to delete a non-existent dentist");
        return ResponseEntity.noContent().build();
    }

    //Delete all dentists
    @DeleteMapping("/api/dentist")
    public ResponseEntity<Dentist> deleteAll(){
        dentistServiceImpl.deleteAll();
        LOGGER.debug("All dentist eliminated in database");
        return ResponseEntity.noContent().build();
    }


}
