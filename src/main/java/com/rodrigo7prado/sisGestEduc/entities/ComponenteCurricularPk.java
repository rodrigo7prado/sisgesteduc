package com.rodrigo7prado.sisGestEduc.entities;

import java.io.Serializable;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class ComponenteCurricularPk implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "disciplina_id")
	private Disciplina disciplina;
	
	@ManyToOne
	@JoinColumn(name = "periodoCurricular_id")
	private PeriodoCurricular periodoCurricular;

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public PeriodoCurricular getPeriodoCurricular() {
		return periodoCurricular;
	}

	public void setPeriodoCurricular(PeriodoCurricular periodoCurricular) {
		this.periodoCurricular = periodoCurricular;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((disciplina == null) ? 0 : disciplina.hashCode());
		result = prime * result + ((periodoCurricular == null) ? 0 : periodoCurricular.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ComponenteCurricularPk other = (ComponenteCurricularPk) obj;
		if (disciplina == null) {
			if (other.disciplina != null)
				return false;
		} else if (!disciplina.equals(other.disciplina))
			return false;
		if (periodoCurricular == null) {
			if (other.periodoCurricular != null)
				return false;
		} else if (!periodoCurricular.equals(other.periodoCurricular))
			return false;
		return true;
	}
}
