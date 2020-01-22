package com.rodrigo7prado.sisGestEduc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodrigo7prado.sisGestEduc.entities.PeriodoCurricular;
import com.rodrigo7prado.sisGestEduc.repositories.PeriodoCurricularRepository;

@Service
public class PeriodoCurricularService {

	@Autowired
	private PeriodoCurricularRepository repository;
	
	public List<PeriodoCurricular> findAll() {
		return repository.findAll();
	}
	
	public PeriodoCurricular findById(Long id) {
		Optional<PeriodoCurricular> obj = repository.findById(id);
		return obj.get();
	}
	
	public PeriodoCurricular insert(PeriodoCurricular obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public PeriodoCurricular update(Long id, PeriodoCurricular obj) {
		PeriodoCurricular entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(PeriodoCurricular entity, PeriodoCurricular obj) {
		entity.setNome(obj.getNome());
	}
}
