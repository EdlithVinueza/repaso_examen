package com.uce.edu.service;

import com.uce.edu.repository.modelo.Paciente;

public interface IPacienteService {
	
	public Paciente buscar(Integer id);
	public void guardar(Paciente paciente);
	public void actualizar (Paciente paciente);
	public void borrar(Integer id);
	public Paciente buscarPorCedula(String cedula);

}
