package com.example.ClinicaOdontologicaV2.model;

import org.apache.log4j.Logger;
import javax.persistence.*;

@Entity
@Table(name ="Dentists")
public class Dentist {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String lastname;
    private String registrationNumber;

    public Dentist() {
    }

    public Dentist(Integer id, String name, String lastname, String registrationNumber) {
        this.id = id;
        this.lastname = lastname;
        this.name = name;
        this.registrationNumber = registrationNumber;
    }
    public Dentist(String name, String lastname, String registrationNumber) {
        this.lastname = lastname;
        this.name = name;
        this.registrationNumber = registrationNumber;
    }

    private static final Logger LOGGER = Logger.getLogger(Dentist.class);

    public Dentist(int id, String name, String lastname, int registrationNumber) {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    @Override
    public String toString() {
        return "Dentist{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", registrationNumber='" + registrationNumber + '\'' +
                '}';
    }
}
