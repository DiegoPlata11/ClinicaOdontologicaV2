package com.example.ClinicaOdontologicaV2;

import com.example.ClinicaOdontologicaV2.model.Odontologo;
import com.example.ClinicaOdontologicaV2.repository.OdontologoRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ClinicaOdontologicaV2Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ClinicaOdontologicaV2Application.class, args);
		OdontologoRepository repository = context.getBean(OdontologoRepository.class);

		Odontologo odontologo1 = new Odontologo("Diego","Plata","123456");
		Odontologo odontologo2 = new Odontologo("Andres","Ulloa","234567");

		repository.save(odontologo1);
		repository.save(odontologo2);

		System.out.println("Cantidad de doctores en BD " + repository.findAll().size());
	}




}
