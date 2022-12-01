package com.example.ClinicaOdontologicaV2.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name ="Shift")
public class Shift {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private LocalDate date;
    private String hour;

    @OneToOne(mappedBy = "shift", fetch = FetchType.LAZY)
    private Patient patient;

    public Shift(LocalDate date, String hour) {
        this.date = date;
        this.hour = hour;
    }
}
