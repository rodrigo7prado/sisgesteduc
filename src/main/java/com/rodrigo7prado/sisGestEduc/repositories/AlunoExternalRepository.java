package com.rodrigo7prado.sisGestEduc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rodrigo7prado.sisGestEduc.dto.AlunoExternalDTO;
import com.rodrigo7prado.sisGestEduc.entities.external.AlunoExternal;

@Repository
public interface AlunoExternalRepository extends JpaRepository<AlunoExternal, String> {
	@Query("SELECT DISTINCT new com.rodrigo7prado.sisGestEduc.dto.AlunoExternalDTO("
			+ "r.anoLetivo, r.modalidade, r.curso, r.serie, r.turno, r.turma, "
			+ "a.nomeCompleto, a.matricula, r.freq, r.situacaoFinal"
			+ ") FROM AlunoExternal a "
			+ "JOIN ResultadoFinalExternal r "
			+ "ON a.matricula = r.aluno "
			+ "WHERE  r.anoLetivo LIKE 'Ano Letivo: 2018%' AND r.situacaoFinal = 'Aprovado' "
			+ "ORDER BY  r.turma, a.nomeCompleto")
//	@Query("SELECT DISTINCT "
//			+ "r.anoLetivo, r.modalidade, r.curso, r.serie, r.turno, r.turma, "
//			+ "a.nomeCompleto, a.matricula, r.freq, r.situacaoFinal"
//			+ " FROM AlunoExternal a "
//			+ "JOIN ResultadoFinalExternal r "
//			+ "ON a.matricula = r.aluno "
//			+ "WHERE  r.anoLetivo LIKE 'Ano Letivo: 2018%' AND r.situacaoFinal = 'Aprovado' "
//			+ "ORDER BY  r.turma, a.nomeCompleto")
//	"SELECT DISTINCT new com.rodrigo7prado.sisGestEduc.dto.ResultadoFinalExternalDTO("
//	+ "c.anoLetivo, c.modalidade, c.curso, c.serie, c.turno, c.turma, "
//	+ "c.aluno, c.nomeCompl, c.freq, c.situacaoFinal"
//	+ ") FROM ResultadoFinalExternal c "
//	+ "WHERE c.anoLetivo LIKE 'Ano Letivo: 2018%' "
//	+ "AND c.situacaoFinal = 'Aprovado' "
//	+ "ORDER BY c.turma, c.nomeCompl"
	List<AlunoExternalDTO> findFilterConcluintes();
}
