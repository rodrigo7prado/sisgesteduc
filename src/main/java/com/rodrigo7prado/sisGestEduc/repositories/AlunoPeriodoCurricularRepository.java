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
//			+ "c.anoLetivo"
//			+ ", c.id.periodoCurricular.id.cursoModalidade.id.curso.nome"
//			+ ", c.id.periodoCurricular.id.cursoModalidade.id.modalidade.nome"
//			+ ", c.turma"
//			+ ", c.id.aluno.nomeCompleto"
////			+ ", c.id.aluno.matricula"
//			+ ", e.id"
//			+ ") "
//			+ "FROM AlunoPeriodoCurricular c "
//			+ "RIGHT JOIN AlunoExternal e "
//			+ "ON e.id = c.id.aluno.id"
////			+ "WHERE "
////			+ "c.anoLetivo LIKE 'Ano Letivo: 2018%' "
////			+ "AND c.situacaoFinal = 'Aprovado' "
////			+ "ORDER BY c.turma, c.id.aluno.nomeCompleto"
//			)
	@Query("SELECT DISTINCT new com.rodrigo7prado.sisGestEduc.dto.AlunoPeriodoCurricularDto("
			+ "c.anoLetivo"
			+ ", c.id.periodoCurricular.id.cursoModalidade.id.curso.nome"
			+ ", c.id.periodoCurricular.id.cursoModalidade.id.modalidade.nome"
			+ ", e.ultimaTurma"
			+ ", c.id.aluno.nomeCompleto"
//			+ ", c.id.aluno.matricula"
			+ ", e.id"
			+ ") "
			+ "FROM AlunoExternal e "
			+ "LEFT JOIN AlunoPeriodoCurricular c "
			+ "ON c.id.aluno.id = e.id "
//			+ "WHERE "
//			+ "c.anoLetivo LIKE 'Ano Letivo: 2018%' "
//			+ "AND c.situacaoFinal = 'Aprovado' "
			+ "ORDER BY e.ultimaTurma"
			)
//	@Query("SELECT DISTINCT new com.rodrigo7prado.sisGestEduc.dto.AlunoPeriodoCurricularDto("
//			+ "c.anoLetivo, c.modalidade, c.curso, c.serie, c.turno, c.turma, "
//			+ "c.nomeCompl, c.aluno, c.freq, c.situacaoFinal"
//			+ ") FROM AlunoPeriodoCurricular c "
//			+ "WHERE c.anoLetivo LIKE 'Ano Letivo: 2018%' "
//			+ "AND c.situacaoFinal = 'Aprovado' "
//			+ "ORDER BY c.turma, c.nomeCompl")
//	@Query("SELECT DISTINCT new com.rodrigo7prado.sisGestEduc.dto.AlunoPeriodoCurricularDTO("
//			+ "c.anoLetivo, c.modalidade, c.curso, c.serie, c.turno, c.turma, "
//			+ " c.nomeCompl, a.matricula, c.freq, c.situacaoFinal"
//			+ ") FROM AlunoPeriodoCurricular c "
//			+ "INNER JOIN AlunoExternal a "
//			+ "ON c.matricula = a.matricula "
//			+ "WHERE c.anoLetivo LIKE 'Ano Letivo: 2018%' "
//			+ "AND c.situacaoFinal = 'Aprovado' "
//			+ "ORDER BY c.turma, c.nomeCompl")
//	@Query("SELECT DISTINCT c.aluno, c.anoLetivo, c.modalidade, c.curso, c.serie, c.turno, c.turma, "
//			+ " c.nomeCompl, a.matricula, c.freq, c.situacaoFinal"
//			+ " FROM AlunoPeriodoCurricular c "
//			+ "INNER JOIN AlunoExternal a "
//			+ "ON c.aluno = a.matricula "
//			+ "WHERE c.anoLetivo LIKE 'Ano Letivo: 2018%' "
//			+ "AND c.situacaoFinal = 'Aprovado' "
//			+ "ORDER BY c.turma, c.nomeCompl")
//	@Query("SELECT DISTINCT c.turma "
//			+ "c.id.aluno.nomeCompleto, c.id.aluno.matricula "
//			+ "FROM AlunoPeriodoCurricular c "
//			+ "WHERE "
//			+ "WHERE c.turma = '3001' "
//			+ "c.anoLetivo LIKE 'Ano Letivo: 2018%' "
//			+ "AND c.situacaoFinal = 'Aprovado' "
//			+ "ORDER BY c.turma, c.id.aluno.nomeCompleto"
//)
	List<AlunoPeriodoCurricularDto> findFilterConcluintes();
}
