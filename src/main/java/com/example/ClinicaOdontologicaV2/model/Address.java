package com.example.ClinicaOdontologicaV2.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name ="Address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String street;
    private String number;
    private String department;
    private String city;
    public Address(String street, String number, String department, String city) {
        this.street = street;
        this.number = number;
        this.department = department;
        this.city = city;
    }
}
