package com.example.ClinicaOdontologicaV2.controller;

import com.example.ClinicaOdontologicaV2.model.Odontologo;
import com.example.ClinicaOdontologicaV2.repository.OdontologoRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {

    private OdontologoRepository odontologoRepository;

    public OdontologoController(OdontologoRepository odontologoRepository) {
        this.odontologoRepository = odontologoRepository;
    }

    @PostMapping("/api/new")
    public Odontologo registrarOdontologo(@RequestBody Odontologo odontologo){
        return odontologoRepository.save(odontologo);
    }

    @GetMapping("/api/odontologos")
    //Buscar todos los odontologos
    public List<Odontologo> findAll(){
        return odontologoRepository.findAll();
    }

    @GetMapping("/api/odontologos/{id}")
    public Odontologo BuscarPorId(@PathVariable Integer id){
        Optional<Odontologo> odontologoOpt = odontologoRepository.findById(id);
        return odontologoOpt.orElse(null);
    }


}
