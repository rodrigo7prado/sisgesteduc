package com.rodrigo7prado.sisGestEduc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodrigo7prado.sisGestEduc.dto.AlunoExternalDTO;
import com.rodrigo7prado.sisGestEduc.entities.external.AlunoExternal;
import com.rodrigo7prado.sisGestEduc.repositories.AlunoExternalRepository;

@Service
public class AlunoExternalService {
	@Autowired
	private AlunoExternalRepository repository;
	
	public List<AlunoExternal> findAll() {
		return repository.findAll();
	}
	
	public AlunoExternal findById(String id) {
		Optional<AlunoExternal> obj = repository.findById(id);
		return obj.get();
	}
	
	public List<AlunoExternalDTO> findFilterConcluintes() {
		List<AlunoExternalDTO> listDto = repository.findFilterConcluintes();
		
		return listDto;
	}
}
