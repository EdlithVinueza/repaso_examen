package com.uce.edu.repository;

import com.uce.edu.repository.modelo.Doctor;

public interface IDoctorRepository {
	
	public Doctor seleccionar(Integer id);
	public void insertar(Doctor doctor);
	public void actualizar (Doctor doctor);
	public void eliminar(Integer id);
	public Doctor seleccionarPorCedula(String cedula);

}
