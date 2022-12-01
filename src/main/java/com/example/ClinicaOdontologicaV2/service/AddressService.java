package com.example.ClinicaOdontologicaV2.service;

import com.example.ClinicaOdontologicaV2.model.Address;

import java.util.List;
import java.util.Optional;

public interface AddressService {

    Address create(Address address);

    Optional<Address> find(Integer id);

    List<Address> findAll();

    Address update(Address address);

    void delete(Integer id);

    void deleteAll();

    boolean searchId(Integer id);
}
