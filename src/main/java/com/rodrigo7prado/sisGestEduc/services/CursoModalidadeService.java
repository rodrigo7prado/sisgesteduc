package com.rodrigo7prado.sisGestEduc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodrigo7prado.sisGestEduc.entities.CursoModalidade;
import com.rodrigo7prado.sisGestEduc.repositories.CursoModalidadeRepository;

@Service
public class CursoModalidadeService {

	@Autowired
	private CursoModalidadeRepository repository;
	
	public List<CursoModalidade> findAll() {
		return repository.findAll();
	}
	
	public CursoModalidade findById(Long id) {
		Optional<CursoModalidade> obj = repository.findById(id);
		return obj.get();
	}
	
	public CursoModalidade insert(CursoModalidade obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public CursoModalidade update(Long id, CursoModalidade obj) {
		CursoModalidade entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(CursoModalidade entity, CursoModalidade obj) {
//		entity.setNome(obj.getNome());
		entity.setCurso(obj.getCurso());
		entity.setModalidade(obj.getModalidade());
	}
}
