package com.rodrigo7prado.sisGestEduc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rodrigo7prado.sisGestEduc.dto.AlunoPeriodoCurricularCondensedDto;
import com.rodrigo7prado.sisGestEduc.entities.external.VwAlunoPeriodoCurricularCondensed;

@Repository
public interface AlunoPeriodoCurricularCondensedRepository extends JpaRepository<VwAlunoPeriodoCurricularCondensed, Long> {
	String part = "SELECT DISTINCT new com.rodrigo7prado.sisGestEduc.dto.AlunoPeriodoCurricularCondensedDto("
			+ "c.id.ano"
			+ ", c.id.curso"
			+ ", c.id.modalidade"
			+ ", c.id.periodoCurricular"
			+ ", c.id.turma"
			+ ", c.nomeCompl"
			+ ", c.sexo"
			+ ", c.dataNasc"
			+ ", c.nomePai"
			+ ", c.nomeMae"
			+ ", c.nacionalidade"
			+ ", c.naturalidade"
			+ ", c.naturalidadeUF"
			+ ", c.rg"
			+ ", c.rgEmissor"
			+ ", c.rgEmissorUf"
			+ ", c.id.aluno"
			+ ", c.situacaoFinal"
			+ ", c.chSubst"
			+ ", c.ensMedioEstabEns"
			+ ", c.ensMedioCidadeEstadoEstabEns"
			+ ", c.freqSubst"
			+ ", c.frqg"
			+ ", c.resSerie"
			+ ", c.resSerieSubst"
			+ ", c.cdNfl"
			+ ", c.cfNfl"
			+ ") " + "FROM VwAlunoPeriodoCurricularCondensed c "
			;
	@Query(part
			)
	List<AlunoPeriodoCurricularCondensedDto> findFilterTodos();
	
	}
