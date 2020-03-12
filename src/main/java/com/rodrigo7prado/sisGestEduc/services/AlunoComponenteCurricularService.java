package com.rodrigo7prado.sisGestEduc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodrigo7prado.sisGestEduc.dto.AlunoComponenteCurricularDto;
import com.rodrigo7prado.sisGestEduc.entities.AlunoComponenteCurricular;
import com.rodrigo7prado.sisGestEduc.repositories.AlunoComponenteCurricularRepository;

@Service
public class AlunoComponenteCurricularService {
	@Autowired
	private AlunoComponenteCurricularRepository repository;
	
	public List<AlunoComponenteCurricular> findAll() {
		return repository.findAll();
	}
	
	public AlunoComponenteCurricular findById(Long id) {
		Optional<AlunoComponenteCurricular> obj = repository.findById(id);
		return obj.get();
	}
	
	public List<AlunoComponenteCurricularDto> findFilterConcluintes(String matricula) {
		List<AlunoComponenteCurricularDto> listDto = repository.findFilterConcluintes(matricula);
		
		return listDto;
	}
	
	public List<AlunoComponenteCurricularDto> findFilterConcluintes2(String matricula) {
		List<AlunoComponenteCurricularDto> listDto = repository.findFilterConcluintes(matricula);
		
		return listDto;
	}
}
