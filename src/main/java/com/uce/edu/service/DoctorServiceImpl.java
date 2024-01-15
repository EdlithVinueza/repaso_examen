package com.uce.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.IDoctorRepository;
import com.uce.edu.repository.modelo.Doctor;
@Service
public class DoctorServiceImpl implements IDoctorService {
	@Autowired
	private IDoctorRepository iDoctorRepository;

	@Override
	public Doctor buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.iDoctorRepository.seleccionar(id);
	}

	@Override
	public void guardar(Doctor doctor) {
		// TODO Auto-generated method stub
		this.iDoctorRepository.insertar(doctor);

	}

	@Override
	public void actualizar(Doctor doctor) {
		// TODO Auto-generated method stub
		this.iDoctorRepository.actualizar(doctor);

	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.iDoctorRepository.eliminar(id);

	}

	@Override
	public Doctor buscarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		return this.iDoctorRepository.seleccionarPorCedula(cedula);
	}

}
