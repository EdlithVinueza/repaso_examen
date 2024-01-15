package com.uce.edu.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.ICitaMedicaRepository;
import com.uce.edu.repository.IDoctorRepository;
import com.uce.edu.repository.IPacienteRepository;
import com.uce.edu.repository.modelo.CitaMedica;
import com.uce.edu.repository.modelo.Doctor;
import com.uce.edu.repository.modelo.Paciente;
@Service
public class CitaMedicaServiceImpl implements ICitaMedicaService {
	@Autowired
	private ICitaMedicaRepository iCitaMedicaRepository;
	@Autowired
	private IDoctorRepository iDoctorRepository;
	@Autowired
	private IPacienteRepository iPacienteRepository;

	@Override
	public CitaMedica buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.iCitaMedicaRepository.seleccionar(id);
	}

	@Override
	public void guardar(CitaMedica citaMedica) {
		// TODO Auto-generated method stub
		this.iCitaMedicaRepository.insertar(citaMedica);

	}

	@Override
	public void actualizar(CitaMedica citaMedica) {
		// TODO Auto-generated method stub
		this.iCitaMedicaRepository.actualizar(citaMedica);

	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.iCitaMedicaRepository.eliminar(id);

	}

	@Override
	public void agendarCitaMedica(String turno, LocalDateTime fechaCita, BigDecimal costoCita, String lugarCita,
		String ceduDoctor, String ceduPaciente) {
		
		CitaMedica citaMedica = new CitaMedica();
		
		citaMedica.setCostoCita(costoCita);
		citaMedica.setFechaCita(fechaCita);
		citaMedica.setNumeroTuerno(turno);
		citaMedica.setLugarCita(lugarCita);
		
		Doctor doctor = this.iDoctorRepository.seleccionarPorCedula(ceduDoctor);
		citaMedica.setDoctor(doctor);
		
		Paciente paciente = this.iPacienteRepository.seleccionarPorCedula(ceduPaciente);
		citaMedica.setPaciente(paciente);
		
		this.guardar(citaMedica);
		
	}

	@Override
	public CitaMedica buscarrPorNumero(String numero) {
		// TODO Auto-generated method stub
		return this.iCitaMedicaRepository.selecciarPorNumero(numero);
	}

	@Override
	public void actualizarCitaMedica(String diagnostico, LocalDateTime fechaControl, String receta, String numero) {
		// TODO Auto-generated method stub
		CitaMedica c = this.buscarrPorNumero(numero);
		c.setDiagnostico(diagnostico);
		c.setFechaControl(fechaControl);
		c.setReceta(receta);
		this.actualizar(c);
	}

	@Override
	public List<CitaMedica> buscarPorFechaCosto(LocalDateTime fecha, BigDecimal costo) {
		// TODO Auto-generated method stub
		return this.iCitaMedicaRepository.selecionarPorFechaCosto(fecha, costo);
	}

	@Override
	public void imprimirReporte(LocalDateTime fecha, BigDecimal costo) {
		List<CitaMedica> citas = this.buscarPorFechaCosto(fecha, costo);
		// TODO Auto-generated method stub
		System.out.println("Lista de Citas Medicas");
		for(CitaMedica cita: citas) {
			System.out.println(cita.toString());
		}
		
	}

}
