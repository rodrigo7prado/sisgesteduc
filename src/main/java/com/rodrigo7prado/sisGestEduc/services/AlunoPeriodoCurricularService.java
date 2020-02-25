package com.rodrigo7prado.sisGestEduc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodrigo7prado.sisGestEduc.dto.AlunoPeriodoCurricularDto;
import com.rodrigo7prado.sisGestEduc.entities.AlunoPeriodoCurricular;
import com.rodrigo7prado.sisGestEduc.repositories.AlunoPeriodoCurricularRepository;

@Service
public class AlunoPeriodoCurricularService {
	@Autowired
	private AlunoPeriodoCurricularRepository repository;
	
	public List<AlunoPeriodoCurricular> findAll() {
		return repository.findAll();
	}
	
	public AlunoPeriodoCurricular findById(Long id) {
		Optional<AlunoPeriodoCurricular> obj = repository.findById(id);
		return obj.get();
	}
	
	public List<AlunoPeriodoCurricularDto> findFilterConcluintes() {
		List<AlunoPeriodoCurricularDto> listDto = repository.findFilterConcluintes();
		
		return listDto;
	}
}
