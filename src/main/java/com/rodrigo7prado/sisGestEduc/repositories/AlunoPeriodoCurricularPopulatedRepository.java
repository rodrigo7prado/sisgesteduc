package com.rodrigo7prado.sisGestEduc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rodrigo7prado.sisGestEduc.entities.external.VwAlunoPeriodoCurricularPopulated;

@Repository
public interface AlunoPeriodoCurricularPopulatedRepository extends JpaRepository<VwAlunoPeriodoCurricularPopulated, Long> {
	String part = "SELECT DISTINCT new com.rodrigo7prado.sisGestEduc.entities.external.VwAlunoPeriodoCurricularPopulated("
			+ "c.id.ano"
			+ ", c.id.curso"
			+ ", c.id.modalidade"
			+ ", c.id.periodoCurricular"
			+ ", c.id.turma"
			+ ", c.id.aluno"
			+ ", c.nomeCompl"
			+ ", c.situacaoFinal"
			+ ", c.chSubst"
			+ ", c.ensMedioEstabEns"
			+ ", c.ensMedioCidadeEstadoEstabEns"
			+ ", c.freqSubst"
			+ ", c.frqg"
			+ ", c.resSerie"
			+ ", c.resSerieSubst"
			+ ") " + "FROM VwAlunoPeriodoCurricularPopulated c "
			;
		
	String selectCount = "SELECT COUNT(*) "
			+ "FROM VwAlunoPeriodoCurricularPopulated c "
			;
	
	String order = "ORDER BY c.id.turma, c.nomeCompl";
	String whereInterno = " AND " + "c.id.turma IS NOT NULL ";
	
	@Query(part
//			+ where1
//			+ findFilterTodosWhere
//			+ order
			)
	List<VwAlunoPeriodoCurricularPopulated> findFilterTodos();
	
	}
