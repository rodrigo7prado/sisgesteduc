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
	
	public List<AlunoPeriodoCurricularDto> findFilterNull() {
		List<AlunoPeriodoCurricularDto> listDto = repository.findFilterNull();
		
		return listDto;
	}
	
	public List<AlunoPeriodoCurricularDto> findFilterTodos() {
		List<AlunoPeriodoCurricularDto> listDto = repository.findFilterTodos();
		
		return listDto;
	}
	
	public List<AlunoPeriodoCurricularDto> findFilterUltimosPeriodosLetivos() {
		List<AlunoPeriodoCurricularDto> listDto = repository.findFilterUltimosPeriodosLetivos();
		
		return listDto;
	}
	
	public List<AlunoPeriodoCurricularDto> findFilterConcluintes() {
		List<AlunoPeriodoCurricularDto> listDto = repository.findFilterConcluintes();
		
		return listDto;
	}
	
	public List<AlunoPeriodoCurricularDto> findFilterPendDadosPessoais() {
		List<AlunoPeriodoCurricularDto> listDto = repository.findFilterPendDadosPessoais();
		
		return listDto;
	}
	
	public List<AlunoPeriodoCurricularDto> findFilterPendDataNasc() {
		List<AlunoPeriodoCurricularDto> listDto = repository.findFilterPendDataNasc();
		
		return listDto;
	}
	
	public List<AlunoPeriodoCurricularDto> findFilterPendNaturalidade() {
		List<AlunoPeriodoCurricularDto> listDto = repository.findFilterPendNaturalidade();
		
		return listDto;
	}
	
	public List<AlunoPeriodoCurricularDto> findFilterPendNacionalidade() {
		List<AlunoPeriodoCurricularDto> listDto = repository.findFilterPendNacionalidade();
		
		return listDto;
	}
	
	public List<AlunoPeriodoCurricularDto> findFilterPendRg() {
		List<AlunoPeriodoCurricularDto> listDto = repository.findFilterPendRg();
		
		return listDto;
	}
	
	public List<AlunoPeriodoCurricularDto> findFilterPendNomePai() {
		List<AlunoPeriodoCurricularDto> listDto = repository.findFilterPendNomePai();
		
		return listDto;
	}
	
	public List<AlunoPeriodoCurricularDto> findFilterPendNomeMae() {
		List<AlunoPeriodoCurricularDto> listDto = repository.findFilterPendNomeMae();
		
		return listDto;
	}
}
