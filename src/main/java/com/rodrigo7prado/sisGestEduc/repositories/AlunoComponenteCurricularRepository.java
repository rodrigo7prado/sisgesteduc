package com.rodrigo7prado.sisGestEduc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rodrigo7prado.sisGestEduc.dto.AlunoComponenteCurricularDto;
import com.rodrigo7prado.sisGestEduc.dto.AlunoPeriodoCurricularDto;
import com.rodrigo7prado.sisGestEduc.entities.AlunoComponenteCurricular;

@Repository
public interface AlunoComponenteCurricularRepository extends JpaRepository<AlunoComponenteCurricular, Long> {
	@Query("SELECT DISTINCT new com.rodrigo7prado.sisGestEduc.dto.AlunoComponenteCurricularDto(" + "v.anoLetivo"
			
//			+ ", v.cursoId" + 
//			", v.modalidadeId" 
//			+ ", v.periodoCurricularId" + 
//			", v.aluno.id" 
//			+ ", v.nomeCompl" 
//			+ ", v.disciplina1"
			
			+ ", v.curso" + 
			", v.modalidade" 
			+ ", v.serie" + 
			", v.aluno.id" 
			+ ", v.nomeCompl" 
			+ ", v.disciplina1"
			+ ", v.total_pontos" + ", v.faltas" + ", v.freq" + ") " + "FROM ResultadoFinalExternal v " + "WHERE "
			+ "v.aluno.id = ?1 " + "ORDER BY v.disciplina1")
	List<AlunoComponenteCurricularDto> findFilterConcluintes(String matricula);

	@Query("SELECT DISTINCT new com.rodrigo7prado.sisGestEduc.dto.AlunoComponenteCurricularDto(" + "v.anoLetivo"
			+ ", v.curso" + ", v.modalidade" + ", v.serie" + ", v.aluno.id" + ", v.nomeCompl" + ", v.disciplina1"
			+ ", v.total_pontos" + ", v.faltas" + ", v.freq" + ") " + "FROM ResultadoFinalExternal v " + "WHERE "
			+ "v.aluno.id = ?1 " 
			+ "AND v.curso.id = ?2 " 
			+ "AND v.modalidade.id = ?2 " 
			+ "AND v.serie = ?3 "
			+ "AND v.disciplina1 = ?4 "
			)
	AlunoComponenteCurricularDto findByIndex(String alunoId, Integer cursoId, Integer cursoModalidadeId,
			Integer periodoCurricularId, Integer disciplinaId);

	@Query("SELECT DISTINCT new com.rodrigo7prado.sisGestEduc.dto.AlunoComponenteCurricularDto(" + " v.curso"
			+ ", v.modalidade" + ", v.aluno.id" + ", v.nomeCompl" + ", v.disciplina1" + ") "
			+ "FROM ResultadoFinalExternal v " + "WHERE " + "v.aluno = '201601911023339' ")
	List<AlunoComponenteCurricularDto> findFilterConcluintes2();

	@Query(AlunoPeriodoCurricularRepository.part + "WHERE " + "v.id.ano LIKE 'Ano Letivo: 2018%' "
			+ "AND v.id.situacaoFinal = 'Aprovado' " + "ORDER BY v.id.turma, v.nomeCompl")
	List<AlunoPeriodoCurricularDto> findFilterQuaisquerPendencias();

	AlunoComponenteCurricularDto save(AlunoComponenteCurricularDto entity);
}
