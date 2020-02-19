package com.rodrigo7prado.sisGestEduc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodrigo7prado.sisGestEduc.entities.Aluno;
import com.rodrigo7prado.sisGestEduc.repositories.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository repository;
	
	public List<Aluno> findAll() {
		return repository.findAll();
	}
	
	public Aluno findById(Long id) {
		Optional<Aluno> obj = repository.findById(id);
		return obj.get();
	}
	
	public Aluno insert(Aluno obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public Aluno update(Long id, Aluno obj) {
		Aluno entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(Aluno entity, Aluno obj) {
		entity.setNomeCompleto(obj.getNomeCompleto());
	}

	public List<Aluno> findBy() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Aluno> findFilterConcluintes() {
		List<Aluno> listDto = repository.findFilterConcluintes();
		
		return listDto;
	}
}
