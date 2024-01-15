package com.uce.edu.service;

import com.uce.edu.repository.modelo.Doctor;

public interface IDoctorService {
	
	public Doctor buscar(Integer id);
	public void guardar(Doctor doctor);
	public void actualizar (Doctor doctor);
	public void borrar(Integer id);
	public Doctor buscarPorCedula(String cedula);

}
