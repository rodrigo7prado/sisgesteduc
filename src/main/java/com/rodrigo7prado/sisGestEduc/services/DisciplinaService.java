package com.rodrigo7prado.sisGestEduc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodrigo7prado.sisGestEduc.entities.Disciplina;
import com.rodrigo7prado.sisGestEduc.repositories.DisciplinaRepository;

@Service
public class DisciplinaService {

	@Autowired
	private DisciplinaRepository repository;
	
	public List<Disciplina> findAll() {
		return repository.findAll();
	}
	
	public Disciplina findById(Long id) {
		Optional<Disciplina> obj = repository.findById(id);
		return obj.get();
	}
	
	public Disciplina insert(Disciplina obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public Disciplina update(Long id, Disciplina obj) {
		Disciplina entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(Disciplina entity, Disciplina obj) {
		entity.setNome(obj.getNome());
	}
}
