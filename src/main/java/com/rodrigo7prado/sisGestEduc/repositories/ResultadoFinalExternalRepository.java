package com.rodrigo7prado.sisGestEduc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rodrigo7prado.sisGestEduc.dto.ResultadoFinalExternalDTO;
import com.rodrigo7prado.sisGestEduc.entities.external.ResultadoFinalExternal;

@Repository
public interface ResultadoFinalExternalRepository extends JpaRepository<ResultadoFinalExternal, Long> {
	@Query("SELECT DISTINCT new com.rodrigo7prado.sisGestEduc.dto.ResultadoFinalExternalDTO("
			+ "c.anoLetivo, c.modalidade, c.curso, c.serie, c.turno, c.turma, "
			+ "c.nomeCompl, c.aluno, c.freq, c.situacaoFinal"
			+ ") FROM ResultadoFinalExternal c "
			+ "WHERE c.anoLetivo LIKE 'Ano Letivo: 2018%' "
			+ "AND c.situacaoFinal = 'Aprovado' "
			+ "ORDER BY c.turma, c.nomeCompl")
//	@Query("SELECT DISTINCT new com.rodrigo7prado.sisGestEduc.dto.ResultadoFinalExternalDTO("
//			+ "c.anoLetivo, c.modalidade, c.curso, c.serie, c.turno, c.turma, "
//			+ " c.nomeCompl, a.matricula, c.freq, c.situacaoFinal"
//			+ ") FROM ResultadoFinalExternal c "
//			+ "INNER JOIN AlunoExternal a "
//			+ "ON c.matricula = a.matricula "
//			+ "WHERE c.anoLetivo LIKE 'Ano Letivo: 2018%' "
//			+ "AND c.situacaoFinal = 'Aprovado' "
//			+ "ORDER BY c.turma, c.nomeCompl")
//	@Query("SELECT DISTINCT c.aluno, c.anoLetivo, c.modalidade, c.curso, c.serie, c.turno, c.turma, "
//			+ " c.nomeCompl, a.matricula, c.freq, c.situacaoFinal"
//			+ " FROM ResultadoFinalExternal c "
//			+ "INNER JOIN AlunoExternal a "
//			+ "ON c.aluno = a.matricula "
//			+ "WHERE c.anoLetivo LIKE 'Ano Letivo: 2018%' "
//			+ "AND c.situacaoFinal = 'Aprovado' "
//			+ "ORDER BY c.turma, c.nomeCompl")
	List<ResultadoFinalExternalDTO> findFilterConcluintes();
}
