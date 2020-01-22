package com.rodrigo7prado.sisGestEduc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodrigo7prado.sisGestEduc.entities.Modalidade;
import com.rodrigo7prado.sisGestEduc.repositories.ModalidadeRepository;

@Service
public class ModalidadeService {

	@Autowired
	private ModalidadeRepository repository;
	
	public List<Modalidade> findAll() {
		return repository.findAll();
	}
	
	public Modalidade findById(Long id) {
		Optional<Modalidade> obj = repository.findById(id);
		return obj.get();
	}
	
	public Modalidade insert(Modalidade obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public Modalidade update(Long id, Modalidade obj) {
		Modalidade entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(Modalidade entity, Modalidade obj) {
		entity.setNome(obj.getNome());
	}
}
