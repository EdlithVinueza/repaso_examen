package com.uce.edu.repository;

import com.uce.edu.repository.modelo.Paciente;

public interface IPacienteRepository {

	public Paciente seleccionar(Integer id);
	public void insertar(Paciente paciente);
	public void actualizar (Paciente paciente);
	public void eliminar(Integer id);
	public Paciente seleccionarPorCedula(String cedula);

}
