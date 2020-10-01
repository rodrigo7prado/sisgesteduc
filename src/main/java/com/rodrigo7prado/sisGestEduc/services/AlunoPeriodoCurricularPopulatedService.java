package com.rodrigo7prado.sisGestEduc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodrigo7prado.sisGestEduc.entities.external.VwAlunoPeriodoCurricularPopulated;
import com.rodrigo7prado.sisGestEduc.repositories.AlunoPeriodoCurricularPopulatedRepository;

@Service
public class AlunoPeriodoCurricularPopulatedService {
	@Autowired
	private AlunoPeriodoCurricularPopulatedRepository repository;

	public List<VwAlunoPeriodoCurricularPopulated> findAll() {
		return repository.findAll();
	}

	public VwAlunoPeriodoCurricularPopulated findById(Long id) {
		Optional<VwAlunoPeriodoCurricularPopulated> obj = repository.findById(id);
		return obj.get();
	}

	public List<VwAlunoPeriodoCurricularPopulated> findFilterTodos() {
		System.out.println("Chamando sql?");
		List<VwAlunoPeriodoCurricularPopulated> listDto = repository.findFilterTodos();

		return listDto;
	}
	
	public void saveAll(VwAlunoPeriodoCurricularPopulated entity) {
		repository.save(entity);
	}

}
