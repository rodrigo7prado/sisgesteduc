package com.rodrigo7prado.sisGestEduc.entities.external;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name = "ts_aluno_periodo_curricular_external")
public class VwAlunoPeriodoCurricular {

	@EmbeddedId
	private VwAlunoPeriodoCurricularPk id;
	
	private String ano2;
	
	private String nomeCompl;
	
	private Long cursoId;
	
//	@ManyToOne
//	@JoinColumn(name = "alunoExternalId")
//	private AlunoExternal alunoExternal;
	
	public VwAlunoPeriodoCurricular() {
	}

	public VwAlunoPeriodoCurricularPk getId() {
		return id;
	}

	public void setId(VwAlunoPeriodoCurricularPk id) {
		this.id = id;
	} 

	public String getAno2() {
		return ano2;
	}

	public void setAno2(String ano2) {
		this.ano2 = ano2;
	}

	public String getNomeCompl() {
		return nomeCompl;
	}

	public void setNomeCompl(String nomeCompl) {
		this.nomeCompl = nomeCompl;
	}

	public Long getCursoId() {
		return cursoId;
	}

	public void setCursoId(Long cursoId) {
		this.cursoId = cursoId;
	}
}
