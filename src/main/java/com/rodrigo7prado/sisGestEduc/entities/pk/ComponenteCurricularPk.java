package com.rodrigo7prado.sisGestEduc.entities.pk;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import com.rodrigo7prado.sisGestEduc.entities.Disciplina;
import com.rodrigo7prado.sisGestEduc.entities.PeriodoCurricular;

@Embeddable
public class ComponenteCurricularPk  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name = "curso_id"),
		@JoinColumn(name = "modalidade_id"),
		@JoinColumn(name = "periodo_curricular_id")
	})
	private PeriodoCurricular periodoCurricular;
		
	@ManyToOne
	@JoinColumn(name = "disciplina_id")
	private Disciplina disciplina;
	
	public PeriodoCurricular getPeriodoCurricular() {
		return periodoCurricular;
	}
	
	public void setPeriodoCurricular(PeriodoCurricular periodoCurricular) {
		this.periodoCurricular = periodoCurricular;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	
	// hashcode e equals omitidos
}