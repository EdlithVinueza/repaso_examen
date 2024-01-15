package com.uce.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.IPacienteRepository;
import com.uce.edu.repository.modelo.Paciente;
@Service
public class PacienteServiceImpl implements IPacienteService {
	@Autowired
	private IPacienteRepository iPacienteRepository;

	@Override
	public Paciente buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.iPacienteRepository.seleccionar(id);
	}

	@Override
	public void guardar(Paciente paciente) {
		// TODO Auto-generated method stub
		this.iPacienteRepository.insertar(paciente);

	}

	@Override
	public void actualizar(Paciente paciente) {
		// TODO Auto-generated method stub
		this.iPacienteRepository.actualizar(paciente);

	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.iPacienteRepository.eliminar(id);
	}

	@Override
	public Paciente buscarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		return this.iPacienteRepository.seleccionarPorCedula(cedula);
	}

}
