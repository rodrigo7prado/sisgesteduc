package com.rodrigo7prado.sisGestEduc.entities.pk;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import com.rodrigo7prado.sisGestEduc.entities.Aluno;
import com.rodrigo7prado.sisGestEduc.entities.ComponenteCurricular;

@Embeddable
public class AlunoComponenteCurricularPk  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "aluno_id")
	private Aluno aluno;
		
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name = "curso_id"),
		@JoinColumn(name = "modalidade_id"),
		@JoinColumn(name = "periodo_curricular_id"),
		@JoinColumn(name = "componente_curricular_id")
	})
	private ComponenteCurricular componenteCurricular;
	
	public Aluno getAluno() {
		return aluno;
	}
	
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public ComponenteCurricular getComponenteCurricular() {
		return componenteCurricular;
	}

	public void setComponenteCurricular(ComponenteCurricular componenteCurricular) {
		this.componenteCurricular = componenteCurricular;
	}
	// hashcode e equals omitidos
}