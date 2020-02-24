package com.rodrigo7prado.sisGestEduc.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rodrigo7prado.sisGestEduc.entities.pk.ComponenteCurricularPk;

//import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_componenteCurricular")
public class ComponenteCurricular implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private ComponenteCurricularPk id = new ComponenteCurricularPk();

	public ComponenteCurricular() {
	}

	public ComponenteCurricular(PeriodoCurricular periodoCurricular, Disciplina disciplina) {
		super();
		id.setDisciplina(disciplina);
		id.setPeriodoCurricular(periodoCurricular);
	}

	public void setPeriodoCurricular(PeriodoCurricular periodoCurricular) {
		id.setPeriodoCurricular(periodoCurricular);
	}

	public Disciplina getDisciplina() {
		return id.getDisciplina();
	}

	public void setDisciplina(Disciplina disciplina) {
		id.setDisciplina(disciplina);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		ComponenteCurricular other = (ComponenteCurricular) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
