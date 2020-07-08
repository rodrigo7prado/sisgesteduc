package com.rodrigo7prado.sisGestEduc.entities.external;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import org.hibernate.annotations.Immutable;

@Entity
@Immutable
public class VwAlunoPeriodoCurricular {

	@EmbeddedId
	private VwAlunoPeriodoCurricularPk id;
	
	private String ano2;
	
	private String nomeCompl;
	
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
}
