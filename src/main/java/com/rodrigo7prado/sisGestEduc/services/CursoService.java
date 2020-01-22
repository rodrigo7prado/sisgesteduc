package com.rodrigo7prado.sisGestEduc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodrigo7prado.sisGestEduc.entities.Curso;
import com.rodrigo7prado.sisGestEduc.repositories.CursoRepository;

@Service
public class CursoService {

	@Autowired
	private CursoRepository repository;
	
	public List<Curso> findAll() {
		return repository.findAll();
	}
	
	public Curso findById(Long id) {
		Optional<Curso> obj = repository.findById(id);
		return obj.get();
	}
	
	public Curso insert(Curso obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public Curso update(Long id, Curso obj) {
		Curso entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(Curso entity, Curso obj) {
		entity.setNome(obj.getNome());
	}
}
