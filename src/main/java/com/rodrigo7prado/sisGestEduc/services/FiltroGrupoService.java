package com.rodrigo7prado.sisGestEduc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodrigo7prado.sisGestEduc.entities.FiltroGrupo;
import com.rodrigo7prado.sisGestEduc.repositories.FiltroGrupoRepository;

@Service
public class FiltroGrupoService {

	@Autowired
	private FiltroGrupoRepository repository;
	
	public List<FiltroGrupo> findAll() {
		return repository.findAll();
	}
	
	public FiltroGrupo findById(Long id) {
		Optional<FiltroGrupo> obj = repository.findById(id);
		return obj.get();
	}
	
	public FiltroGrupo insert(FiltroGrupo obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public FiltroGrupo update(Long id, FiltroGrupo obj) {
		FiltroGrupo entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(FiltroGrupo entity, FiltroGrupo obj) {
//		entity.setNomeCompleto(obj.getNomeCompleto());
	}

	public List<FiltroGrupo> findBy() {
		// TODO Auto-generated method stub
		return null;
	}
}
