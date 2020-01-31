package com.rodrigo7prado.sisGestEduc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rodrigo7prado.sisGestEduc.dto.DadosConsolidadosAlunosDTO;
import com.rodrigo7prado.sisGestEduc.entities.external.DadosConsolidados;

@Repository
public interface DadosConsolidadosRepository extends JpaRepository<DadosConsolidados, Long> {
//	@Query("SELECT new com.rodrigo7prado.sisGestEduc.dto.DadosConsolidadosAlunosDTO * "
//			+ "FROM DadosConsolidados As c "
//			+ "WHERE c.periodoLetivo = :periodoLetivo"
//			+ "AND  c.serie = :serie")
//	List<DadosConsolidadosAlunosDTO> findFilterConcluintes(@Param("periodoLetivo") String periodoLetivo, @Param("serie") String serie);
//	, nativeQuery = true
	@Query("SELECT DISTINCT new com.rodrigo7prado.sisGestEduc.dto.DadosConsolidadosAlunosDTO("
			+ "c.anoLetivo, c.modalidade, c.curso, c.serie, c.turno, c.turma, "
			+ "c.aluno, c.nomeCompl, c.freq, c.situacaoFinal"
			+ ") FROM DadosConsolidados c "
			+ "WHERE c.anoLetivo LIKE 'Ano Letivo: 2018%' "
			+ "AND c.situacaoFinal = 'Aprovado' "
			+ "ORDER BY c.turma, c.nomeCompl")
//	@Query("select c from DadosConsolidadosAlunosDTO c")
	List<DadosConsolidadosAlunosDTO> findFilterConcluintes();
}
