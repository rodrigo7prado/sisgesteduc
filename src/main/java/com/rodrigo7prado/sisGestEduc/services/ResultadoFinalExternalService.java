package com.rodrigo7prado.sisGestEduc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodrigo7prado.sisGestEduc.dto.ResultadoFinalExternalDTO;
import com.rodrigo7prado.sisGestEduc.entities.external.ResultadoFinalExternal;
import com.rodrigo7prado.sisGestEduc.repositories.ResultadoFinalExternalRepository;

@Service
public class ResultadoFinalExternalService {
	@Autowired
	private ResultadoFinalExternalRepository repository;
	
	public List<ResultadoFinalExternal> findAll() {
		return repository.findAll();
	}
	
	public ResultadoFinalExternal findById(Long id) {
		Optional<ResultadoFinalExternal> obj = repository.findById(id);
		return obj.get();
	}
	
	public List<ResultadoFinalExternalDTO> findFilterConcluintes() {
		List<ResultadoFinalExternalDTO> listDto = repository.findFilterConcluintes();
		
		return listDto;
	}
}
