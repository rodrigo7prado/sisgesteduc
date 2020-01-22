package com.rodrigo7prado.sisGestEduc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodrigo7prado.sisGestEduc.entities.PeriodoLetivo;
import com.rodrigo7prado.sisGestEduc.repositories.PeriodoLetivoRepository;

@Service
public class PeriodoLetivoService {

	@Autowired
	private PeriodoLetivoRepository repository;
	
	public List<PeriodoLetivo> findAll() {
		return repository.findAll();
	}
	
	public PeriodoLetivo findById(Long id) {
		Optional<PeriodoLetivo> obj = repository.findById(id);
		return obj.get();
	}
	
	public PeriodoLetivo insert(PeriodoLetivo obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public PeriodoLetivo update(Long id, PeriodoLetivo obj) {
		PeriodoLetivo entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(PeriodoLetivo entity, PeriodoLetivo obj) {
		entity.setNome(obj.getNome());
	}
}
