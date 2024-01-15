package com.uce.edu.repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;
import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.CitaMedica;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
@Repository
@Transactional
public class CitaMedicaRepositoryImpl implements ICitaMedicaRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public CitaMedica seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(CitaMedica.class, id);
	}

	@Override
	public void insertar(CitaMedica citaMedica) {
		// TODO Auto-generated method stub
		this.entityManager.persist(citaMedica);

	}

	@Override
	public void actualizar(CitaMedica citaMedica) {
		// TODO Auto-generated method stub
		this.entityManager.merge(citaMedica);

	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		CitaMedica citaMedica = this.seleccionar(id);
		this.entityManager.remove(citaMedica);

	}

	@Override
	public CitaMedica selecciarPorNumero(String numero) {
		// TODO Auto-generated method stub
		TypedQuery<CitaMedica> myQuery = this.entityManager.createNamedQuery("CitaMedica.queryBuscarPorNumero", CitaMedica.class);
		myQuery.setParameter("numero", numero);
		return myQuery.getSingleResult();
	}

	@Override
	public List<CitaMedica> selecionarPorFechaCosto(LocalDateTime fecha, BigDecimal costo) {
		// TODO Auto-generated method stub
		TypedQuery<CitaMedica> mYQuery = 
				this.entityManager.createQuery("SELECT c FROM CitaMedica c WHERE c.fechaCita>=:fecha AND c.costoCita >=:costo", CitaMedica.class);
		mYQuery.setParameter("fecha", fecha);
		mYQuery.setParameter("costo", costo);
		return mYQuery.getResultList();
	}

}
