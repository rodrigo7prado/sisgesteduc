package com.rodrigo7prado.sisGestEduc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rodrigo7prado.sisGestEduc.dto.AlunoPeriodoCurricularDto;
import com.rodrigo7prado.sisGestEduc.entities.AlunoPeriodoCurricular;

@Repository
public interface AlunoPeriodoCurricularRepository extends JpaRepository<AlunoPeriodoCurricular, Long> {
//	@Query("SELECT DISTINCT new com.rodrigo7prado.sisGestEduc.dto.AlunoPeriodoCurricularDto("
//			+ "c,e"
//			+ ", c.anoLetivo"
////			+ "e.ultimaTurma"
//
////			+ ", c.id.periodoCurricular.id.cursoModalidade.id.curso.nome"
//			+ ", e.ultimaTurma"
//
////			+ ", c.id.periodoCurricular.id.cursoModalidade.id.modalidade.nome"
//			+ ", e.ultimaTurma"
//
////			+ ", c.ultimaTurma"
//			+ ", e.ultimaTurma"
//
////			+ ", c.id.aluno.nomeCompleto"
//			+ ", e.nomeCompleto"
//
////			+ ", c.id.aluno.matricula"
//			+ ", e.id"
//
//			+ ") "
//			+ "FROM AlunoPeriodoCurricular c "
//			+ "RIGHT JOIN AlunoExternal e "
//			+ "ON c.id.aluno.id = e.id "
////			+ "WHERE "
////			+ "c.anoLetivo LIKE 'Ano Letivo: 2018%' "
////			+ "AND c.situacaoFinal = 'Aprovado' "
//			+ "ORDER BY e.ultimaTurma"
//			)
//	@Query("SELECT DISTINCT new com.rodrigo7prado.sisGestEduc.dto.AlunoPeriodoCurricularDto("
//			+ "c,e"
//			+ ", c.anoLetivo"
////			+ "e.ultimaTurma"
//
////			+ ", c.id.periodoCurricular.id.cursoModalidade.id.curso.nome"
//			+ ", e.ultimaTurma"
//
////			+ ", c.id.periodoCurricular.id.cursoModalidade.id.modalidade.nome"
//			+ ", e.ultimaTurma"
//
////			+ ", c.ultimaTurma"
//			+ ", e.ultimaTurma"
//
////			+ ", c.id.aluno.nomeCompleto"
//			+ ", e.nomeCompleto"
//
////			+ ", c.id.aluno.matricula"
//			+ ", e.id"
//
//			+ ") "
//			+ "FROM AlunoExternal e "
//			+ "LEFT JOIN AlunoPeriodoCurricular c "
//			+ "ON c.id.aluno.id = e.id "
////			+ "WHERE "
////			+ "c.anoLetivo LIKE 'Ano Letivo: 2018%' "
////			+ "AND c.situacaoFinal = 'Aprovado' "
//			+ "ORDER BY e.ultimaTurma"
//			)
	@Query("SELECT DISTINCT new com.rodrigo7prado.sisGestEduc.dto.AlunoPeriodoCurricularDto("
			+ "e"
			+ ", e.id.turma"
//			+ "e.ultimaTurma"

//			+ ", c.id.periodoCurricular.id.cursoModalidade.id.curso.nome"
			+ ", e.id.turma"

//			+ ", c.id.periodoCurricular.id.cursoModalidade.id.modalidade.nome"
			+ ", e.id.turma"

//			+ ", c.ultimaTurma"
			+ ", e.id.turma"

//			+ ", c.id.aluno.nomeCompleto"
			+ ", e.nomeCompl"

//			+ ", c.id.aluno.matricula"
			+ ", e.id.aluno"

			+ ") "
			+ "FROM VwAlunoPeriodoCurricular e "
//			+ "LEFT JOIN AlunoPeriodoCurricular c "
//			+ "ON c.id.aluno.id = e.id "
//			+ "WHERE "
//			+ "c.anoLetivo LIKE 'Ano Letivo: 2018%' "
//			+ "AND c.situacaoFinal = 'Aprovado' "
//			+ "ORDER BY e.ultimaTurma"
			)
	List<AlunoPeriodoCurricularDto> findFilterConcluintes();
}
