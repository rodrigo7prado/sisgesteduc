package com.rodrigo7prado.sisGestEduc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodrigo7prado.sisGestEduc.dto.AlunoComponenteCurricularDto;
import com.rodrigo7prado.sisGestEduc.entities.Aluno;
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

	public AlunoComponenteCurricularDto findByIndex(String alunoId, Integer cursoId, Integer cursoModalidadeId,
			Integer periodoCurricularId, Integer disciplinaId) {
		AlunoComponenteCurricularDto obj = repository.findByIndex(alunoId, cursoId, cursoModalidadeId,
				periodoCurricularId, disciplinaId);
		return obj;
	}

	public List<AlunoComponenteCurricularDto> findFilterConcluintes(String matricula) {
		List<AlunoComponenteCurricularDto> listDto = repository.findFilterConcluintes(matricula);

		return listDto;
	}

	public List<AlunoComponenteCurricularDto> findFilterConcluintes2(String matricula) {
		List<AlunoComponenteCurricularDto> listDto = repository.findFilterConcluintes(matricula);

		return listDto;
	}

	public AlunoComponenteCurricularDto update(String alunoId, Integer cursoId, Integer cursoModalidadeId,
			Integer periodoCurricularId, Integer disciplinaId, AlunoComponenteCurricularDto obj) {
		AlunoComponenteCurricularDto entity = repository.findByIndex(alunoId, cursoId, cursoModalidadeId,
				periodoCurricularId, disciplinaId);
		updateData(entity, obj);
		return repository.save(entity);
	}
	
	private void updateData(AlunoComponenteCurricularDto entity, AlunoComponenteCurricularDto obj) {
		entity.setTotalPontos(obj.getTotalPontos());
	}
}
