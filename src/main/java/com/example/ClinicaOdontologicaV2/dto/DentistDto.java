package com.example.ClinicaOdontologicaV2.dto;

import com.example.ClinicaOdontologicaV2.model.Dentist;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.apache.log4j.Logger;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DentistDto {

    private Integer id;
    private String name;
    private String lastname;


    public DentistDto() {
    }

}

