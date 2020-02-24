package com.rodrigo7prado.sisGestEduc.entities.pk;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import com.rodrigo7prado.sisGestEduc.entities.CursoModalidade;

@Embeddable
public class PeriodoCurricularPk  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name = "curso_id"),
		@JoinColumn(name = "modalidade_id")
	})
	private CursoModalidade cursoModalidade;
		
	private Integer periodoCurricular;
	
	public CursoModalidade getCursoModalidade() {
		return cursoModalidade;
	}
	
	public void setCursoModalidade(CursoModalidade cursoModalidade) {
		this.cursoModalidade = cursoModalidade;
	}

	public Integer getPeriodoCurricular() {
		return periodoCurricular;
	}

	public void setPeriodoCurricular(Integer periodoCurricular) {
		this.periodoCurricular = periodoCurricular;
	}
	// hashcode e equals omitidos
}