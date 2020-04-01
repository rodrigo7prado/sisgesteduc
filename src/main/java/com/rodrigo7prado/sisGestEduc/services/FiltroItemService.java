package com.rodrigo7prado.sisGestEduc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodrigo7prado.sisGestEduc.entities.FiltroItem;
import com.rodrigo7prado.sisGestEduc.repositories.FiltroItemRepository;

@Service
public class FiltroItemService {

	@Autowired
	private FiltroItemRepository repository;
	
	public List<FiltroItem> findAll() {
		return repository.findAll();
	}
	
	public FiltroItem findById(Long id) {
		Optional<FiltroItem> obj = repository.findById(id);
		return obj.get();
	}
	
	public FiltroItem insert(FiltroItem obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public FiltroItem update(Long id, FiltroItem obj) {
		FiltroItem entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(FiltroItem entity, FiltroItem obj) {
//		entity.setNomeCompleto(obj.getNomeCompleto());
	}

	public List<FiltroItem> findBy() {
		// TODO Auto-generated method stub
		return null;
	}
}
