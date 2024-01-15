package com.uce.edu;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Doctor;
import com.uce.edu.repository.modelo.Paciente;
import com.uce.edu.service.ICitaMedicaService;
import com.uce.edu.service.IDoctorService;
import com.uce.edu.service.IPacienteService;

@SpringBootApplication
public class RepesoExamen1Application implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(RepesoExamen1Application.class, args);
	}

		@Autowired
		private ICitaMedicaService iCitaMedicaService;
		@Autowired
		private IDoctorService iDoctorService;
		@Autowired
		private IPacienteService iPacienteService;

		@Override
		public void run(String... args) throws Exception {
			// TODO Auto-generated method stub
			
			Doctor d1 = new Doctor();
			d1.setApellido("V1");
			d1.setCedula("1236");
			d1.setFechaNacimiento(LocalDateTime.now());
			d1.setNombre("dE");
			d1.setNumeroConsultorio("1287");
			d1.setSalario(new BigDecimal(1000));
			d1.setTitulo("Doctor1");
			
			d1.setCitasMedicas(null);
			
			this.iDoctorService.guardar(d1);
			
			Doctor d2 = new Doctor();
			d2.setApellido("Zdf");
			d2.setCedula("125774");
			d2.setFechaNacimiento(LocalDateTime.now());
			d2.setNombre("Agdfg");
			d2.setNumeroConsultorio("1287sd");
			d2.setSalario(new BigDecimal(10000));
			d2.setTitulo("Doctor2");
			
			d2.setCitasMedicas(null);
			
			this.iDoctorService.guardar(d2);
			
			Paciente p1 = new Paciente();
			
			p1.setApellido("V");
			p1.setCedula("1594");
			p1.setCodigoIess("5653232");
			p1.setEstatura("1.75");
			p1.setFechaNacimiento(LocalDateTime.now());
			p1.setGenero("f");
			p1.setNombre("A");
			p1.setPeso("55");
			
			this.iPacienteService.guardar(p1);
		
			Paciente p2 = new Paciente();
			
			p2.setApellido("A");
			p2.setCedula("5454");
			p2.setCodigoIess("5653232");
			p2.setEstatura("1.75");
			p2.setFechaNacimiento(LocalDateTime.now());
			p2.setGenero("f");
			p2.setNombre("V");
			p2.setPeso("55");
			
			this.iPacienteService.guardar(p2);
			
			this.iCitaMedicaService.agendarCitaMedica("3", LocalDateTime.now(), new BigDecimal(10), "Consultorio1", "1236", "5454");
			
			this.iCitaMedicaService.actualizarCitaMedica("Gripe", LocalDateTime.now(), "paracetamol", "3");
			
			this.iCitaMedicaService.imprimirReporte(LocalDateTime.of(2023, 1, 1, 1, 1), new BigDecimal(5));
			
		
	}

}
