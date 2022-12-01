package com.example.ClinicaOdontologicaV2.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name ="Patients")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String lastname;
    private String dni;
    private LocalDate dateOfAdmission;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "shift_id")
    private Shift shift;

    public Patient(String name, String lastname, String dni, LocalDate dateOfAdmission, Address address /*Shift shift*/) {
        this.name = name;
        this.lastname = lastname;
        this.dni = dni;
        this.dateOfAdmission = dateOfAdmission;
        this.address = address;
        //this.shift = shift;
    }
}
