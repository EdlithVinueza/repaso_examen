package com.uce.edu.repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.repository.modelo.CitaMedica;


public interface ICitaMedicaRepository {
	
	public CitaMedica seleccionar(Integer id);
	public void insertar(CitaMedica citaMedica);
	public void actualizar (CitaMedica citaMedica);
	public void eliminar(Integer id);
	public CitaMedica selecciarPorNumero(String numero);
	public List<CitaMedica> selecionarPorFechaCosto(LocalDateTime fecha, BigDecimal costo);


}
