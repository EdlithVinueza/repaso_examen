package com.uce.edu.repository;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Doctor;
import com.uce.edu.repository.modelo.Paciente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
@Repository
@Transactional
public class PacienteRepositoryImpl implements IPacienteRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Paciente seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Paciente.class, id);
	}

	@Override
	public void insertar(Paciente paciente) {
		// TODO Auto-generated method stub
		this.entityManager.persist(paciente);

	}

	@Override
	public void actualizar(Paciente paciente) {
		// TODO Auto-generated method stub
		this.entityManager.merge(paciente);

	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Paciente paciente = this.seleccionar(id);
		this.entityManager.remove(paciente);

	}

	
	@Override
	public Paciente seleccionarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		//JPQL : SELECT p FROM Paciente p WHERE p.cedula = :cedula 
		TypedQuery<Paciente> myQuery = this.entityManager.createQuery("SELECT p FROM Paciente p WHERE p.cedula = :cedula", Paciente.class);
		myQuery.setParameter("cedula", cedula);
		return myQuery.getSingleResult();
	}

}
