package com.rodrigo7prado.sisGestEduc.entities.pk;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.rodrigo7prado.sisGestEduc.entities.Curso;
import com.rodrigo7prado.sisGestEduc.entities.Modalidade;

@Embeddable
public class CursoModalidadePk  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "curso_id")
	private Curso curso;
		
	@ManyToOne
	@JoinColumn(name = "modalidade_id")
	private Modalidade modalidade;
	
	public Curso getCurso() {
		return curso;
	}
	
	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Modalidade getModalidade() {
		return modalidade;
	}

	public void setModalidade(Modalidade modalidade) {
		this.modalidade = modalidade;
	}
	// hashcode e equals omitidos

	@Override
	public String toString() {
		return "CursoModalidadePk [curso=" + curso + ", modalidade=" + modalidade + "]";
	}
}
