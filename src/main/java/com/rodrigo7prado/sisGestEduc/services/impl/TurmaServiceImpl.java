package com.rodrigo7prado.sisGestEduc.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodrigo7prado.sisGestEduc.entities.Turma;
import com.rodrigo7prado.sisGestEduc.repositories.TurmaRepository;
import com.rodrigo7prado.sisGestEduc.services.TurmaService;

@Service
public class TurmaServiceImpl implements TurmaService {

	@Autowired
	private TurmaRepository repository;

	@Override
	public Turma insert(Turma entity) {
		return repository.save(entity);
	}

	@Override
	public Turma update(Long id, Turma entity) {
//		Turma turma = repository.getOne(id);
//		updateData(entity, entity);
		return repository.save(entity);
	}

	@Override
	public void delete(Turma entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Turma find(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Turma> findAll() {
		return repository.findAll();	}
}
