package com.example.ClinicaOdontologicaV2;

import com.example.ClinicaOdontologicaV2.model.Address;
import com.example.ClinicaOdontologicaV2.model.Dentist;
import com.example.ClinicaOdontologicaV2.model.Patient;
import com.example.ClinicaOdontologicaV2.model.Shift;
import com.example.ClinicaOdontologicaV2.repository.DentistRepository;
import com.example.ClinicaOdontologicaV2.repository.PatientRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;

@SpringBootApplication
public class ClinicaOdontologicaV2Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ClinicaOdontologicaV2Application.class, args);
		DentistRepository repository = context.getBean(DentistRepository.class);
		PatientRepository repository2 = context.getBean(PatientRepository.class);

		Dentist dentist1 = new Dentist("Diego","Plata","123456");
		Dentist dentist2 = new Dentist("Andres","Ulloa","234567");
		Address address1 = new Address("25a","14b","Poblado","Medellin");
		//Shift shift1 = new Shift(LocalDate.of(2022,11,30),"12:00");
		Patient patient1 = new Patient("Andres","Ulloa","123456", LocalDate.of(2022,06,11), address1/*,shift1*/);


		repository.save(dentist1);
		repository.save(dentist2);
		repository2.save(patient1);


		System.out.println("Cantidad de doctores en BD " + repository.findAll().size());
		System.out.println("Cantidad de pacientes en BD " + repository2.findAll().size());

	}




}
