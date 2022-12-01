package com.example.ClinicaOdontologicaV2.controller;

import com.example.ClinicaOdontologicaV2.model.Address;
import com.example.ClinicaOdontologicaV2.model.Dentist;
import com.example.ClinicaOdontologicaV2.repository.AddressRepository;
import com.example.ClinicaOdontologicaV2.service.impl.AddressServiceImpl;
import lombok.AllArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
@AllArgsConstructor
public class AddressController {

    private final Logger LOGGER = Logger.getLogger(DentistController.class);

    private final AddressServiceImpl addressServiceImpl;

    @PostMapping("/api/new")
    public Address createDentist(@RequestBody Address address){
        return addressServiceImpl.create(address);
    }

    //Search all address
    @GetMapping("/api/address")
    public List<Address> findAll(){
        return addressServiceImpl.findAll();
    }
}
