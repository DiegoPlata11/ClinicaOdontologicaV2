package com.example.ClinicaOdontologicaV2.service.impl;

import com.example.ClinicaOdontologicaV2.model.Address;
import com.example.ClinicaOdontologicaV2.model.Shift;
import com.example.ClinicaOdontologicaV2.repository.AddressRepository;
import com.example.ClinicaOdontologicaV2.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;


    @Override
    public Address create(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Optional<Address> find(Integer id) {
        return addressRepository.findById(id);
    }

    @Override
    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    @Override
    public Address update(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public void delete(Integer id) {
        addressRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        addressRepository.deleteAll();
    }

    @Override
    public boolean searchId(Integer id) {
        return false;
    }
}
