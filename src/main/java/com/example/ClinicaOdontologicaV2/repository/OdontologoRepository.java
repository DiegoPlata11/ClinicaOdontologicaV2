package com.example.ClinicaOdontologicaV2.repository;

import com.example.ClinicaOdontologicaV2.model.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OdontologoRepository extends JpaRepository<Odontologo,Integer> {
}
