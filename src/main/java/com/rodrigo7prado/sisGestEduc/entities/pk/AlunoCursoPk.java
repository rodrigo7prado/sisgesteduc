package com.rodrigo7prado.sisGestEduc.entities.pk;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.rodrigo7prado.sisGestEduc.entities.Aluno;
import com.rodrigo7prado.sisGestEduc.entities.Curso;

@Embeddable
public class AlunoCursoPk  implements Serializable {
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "aluno_id")
	private Aluno aluno;
		
	@ManyToOne
	@JoinColumn(name = "curso_id")
	private Curso curso;

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}
}
