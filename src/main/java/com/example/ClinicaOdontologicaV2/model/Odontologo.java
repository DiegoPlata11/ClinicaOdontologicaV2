package com.example.ClinicaOdontologicaV2.model;

import org.apache.log4j.Logger;
import javax.persistence.*;

@Entity
@Table(name ="odontologos")
public class Odontologo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nombre;
    private String apellido;
    private String matricula;

    public Odontologo() {
    }

    public Odontologo(Integer id, String nombre, String apellido, String matricula) {
        this.id = id;
        this.apellido = apellido;
        this.nombre = nombre;
        this.matricula = matricula;
    }
    public Odontologo(String nombre, String apellido, String matricula) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.matricula = matricula;
    }

    private static final Logger LOGGER = Logger.getLogger(Odontologo.class);

    public Odontologo(int id, String nombre, String apellido, int matricula) {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return "Odontologo{" +
                "apellido='" + apellido + '\'' +
                ", nombre='" + nombre + '\'' +
                ", Matricula='" + matricula + '\'' +
                '}';
    }
}
