package com.example.ClinicaOdontologicaV2.controller;


import com.example.ClinicaOdontologicaV2.model.Patient;
import com.example.ClinicaOdontologicaV2.service.impl.PatientServiceImpl;
import lombok.AllArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/patients")
@AllArgsConstructor
public class PatientController {

    private final Logger LOGGER = Logger.getLogger(PatientController.class);

    private final PatientServiceImpl patientServiceImpl;

    @PostMapping("/api/new")
    public Patient createPatient(@RequestBody Patient patient){
        return patientServiceImpl.create(patient);
    }
    @GetMapping("/api/patients")
    //Find all patients
    public List<Patient> findAll(){
        return patientServiceImpl.findAll();
    }

    @GetMapping("/api/patients/{id}")
    public ResponseEntity<Patient> findById(@PathVariable Integer id){
        Optional<Patient> patientOpt = patientServiceImpl.findById(id);

        //if(patientOpt.isPresent())
            return ResponseEntity.ok(patientOpt.get());
        //else
            //return ResponseEntity.notFound().build();
    }
    @PutMapping("/api/patients")
    public ResponseEntity<Patient> update(@RequestBody Patient patient){
        if(patient.getId() == null){
            LOGGER.warn("Intentando actualizar un paciente  no existente");
            return ResponseEntity.badRequest().build();
        }

        if(!patientServiceImpl.findId(patient.getId())){
            LOGGER.warn("Intentando actualizar un paciente no existente");
            return ResponseEntity.notFound().build();
        }

        Patient result = patientServiceImpl.update(patient);
        LOGGER.debug("Paciente actualizado en base de Datos");
        return ResponseEntity.ok(result);
    }
    @DeleteMapping("/api/patients/{id}")
    public ResponseEntity<Patient> eliminar(@PathVariable Integer id){
        if(!patientServiceImpl.findId(id)){
            LOGGER.warn("Intentando eliminar un paciente  no existente");
            return ResponseEntity.notFound().build();
        }
        patientServiceImpl.deleteById(id);
        LOGGER.debug("Paciente eliminado en base de Datos");
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/api/patients")
    public ResponseEntity<Patient> eliminarTodo(){
        patientServiceImpl.deleteById();
        LOGGER.debug("Todos los pacientes eliminados en base de Datos");
        return ResponseEntity.noContent().build();
    }


}
