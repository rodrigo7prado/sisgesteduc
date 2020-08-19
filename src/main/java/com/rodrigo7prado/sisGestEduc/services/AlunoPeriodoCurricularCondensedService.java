package com.rodrigo7prado.sisGestEduc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodrigo7prado.sisGestEduc.dto.AlunoPeriodoCurricularCondensedDto;
import com.rodrigo7prado.sisGestEduc.entities.external.VwAlunoPeriodoCurricularCondensed;
import com.rodrigo7prado.sisGestEduc.repositories.AlunoPeriodoCurricularCondensedRepository;

@Service
public class AlunoPeriodoCurricularCondensedService {
	@Autowired
	private AlunoPeriodoCurricularCondensedRepository repository;

	public List<VwAlunoPeriodoCurricularCondensed> findAll() {
		return repository.findAll();
	}

	public List<AlunoPeriodoCurricularCondensedDto> findFilterTodos() {
		System.out.println("Chamando sql?");
		List<AlunoPeriodoCurricularCondensedDto> listDto = repository.findFilterTodos();

		return listDto;
	}
}
