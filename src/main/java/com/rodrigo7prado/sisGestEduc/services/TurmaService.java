package com.rodrigo7prado.sisGestEduc.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodrigo7prado.sisGestEduc.entities.Turma;
import com.rodrigo7prado.sisGestEduc.repositories.TurmaRepository;

@Service
public class TurmaService {

	@Autowired
	private TurmaRepository repository;
	
	public List<Turma> findAll() throws InterruptedException {
		return repository.findAll();
	}
	
	public Turma findById(Long id) {
		Optional<Turma> obj = repository.findById(id);
		return obj.get();
	}
	
	public Turma insert(Turma obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public Turma update(Long id, Turma obj) {
		Turma entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(Turma entity, Turma obj) {
		entity.setNome(obj.getNome());
	}

	public List<Turma> findBy() {
		// TODO Auto-generated method stub
//		List<Turma> list = ArrayList;
		List<Turma> list = new ArrayList<>();
		list.add(new Turma(1L,"3001"));
		list.add(new Turma(2L,"3002"));
		list.add(new Turma(3L,"3003"));
		return list;
	}
}
