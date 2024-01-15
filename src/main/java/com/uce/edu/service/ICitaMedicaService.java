package com.uce.edu.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.repository.modelo.CitaMedica;

public interface ICitaMedicaService {
	
	public CitaMedica buscar(Integer id);
	public void guardar(CitaMedica citaMedica);
	public void actualizar (CitaMedica citaMedica);
	public void borrar(Integer id);
	
	public void agendarCitaMedica(String turno, LocalDateTime fechaCita, BigDecimal costoCita, String lugarCita, String ceduDoctor, String ceduPaciente );
	
	public CitaMedica buscarrPorNumero(String numero);
	
	public void actualizarCitaMedica(String diagnostico, LocalDateTime fechaControl, String receta, String numero);

	public List<CitaMedica> buscarPorFechaCosto(LocalDateTime fecha, BigDecimal costo);
	
	public void imprimirReporte(LocalDateTime fecha, BigDecimal costo); 
	
}
