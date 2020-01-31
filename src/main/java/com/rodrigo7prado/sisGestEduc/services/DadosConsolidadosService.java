package com.rodrigo7prado.sisGestEduc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodrigo7prado.sisGestEduc.dto.DadosConsolidadosAlunosDTO;
import com.rodrigo7prado.sisGestEduc.entities.external.DadosConsolidados;
import com.rodrigo7prado.sisGestEduc.repositories.DadosConsolidadosRepository;

@Service
public class DadosConsolidadosService {
	@Autowired
	private DadosConsolidadosRepository repository;
	
	public List<DadosConsolidados> findAll() {
		return repository.findAll();
	}
	
	public DadosConsolidados findById(Long id) {
		Optional<DadosConsolidados> obj = repository.findById(id);
		return obj.get();
	}
	
//	@Query(value = "SELECT DISTINCT * " +
//	        "FROM consolidado" +
//	        "WHERE Ano = 'Ano Letivo: 2018' " +
//	        "ORDER BY TURMA, NOME_COMPL", nativeQuery = true)
	public List<DadosConsolidadosAlunosDTO> findFilterConcluintes() {
		
//		List<DadosConsolidados> list = findAll();
//		List<DadosConsolidadosAlunosDTO> listDto = list.stream().map(obj -> new DadosConsolidadosAlunosDTO(obj)).collect(Collectors.toList());
		
		List<DadosConsolidadosAlunosDTO> listDto = repository.findFilterConcluintes();
		
		return listDto;
	}
	
//	public List<DadosConsolidados>
}
