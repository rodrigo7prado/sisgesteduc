package com.rodrigo7prado.sisGestEduc.entities.external;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import org.hibernate.annotations.Immutable;

@Entity
@Immutable
public class VwAlunoPeriodoCurricular {

	@EmbeddedId
	private VwAlunoPeriodoCurricularPk id;
	
	private String nomeCompl;
	
	public VwAlunoPeriodoCurricular() {
	}

	public VwAlunoPeriodoCurricularPk getId() {
		return id;
	}

	public void setId(VwAlunoPeriodoCurricularPk id) {
		this.id = id;
	}

	public String getNomeCompl() {
		return nomeCompl;
	}

	public void setNomeCompl(String nomeCompl) {
		this.nomeCompl = nomeCompl;
	}
}
