package com.rodrigo7prado.sisGestEduc.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_aluno_curso")
public class AlunoCurso implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AlunoCursoPk id = new AlunoCursoPk();
	// outros atributos

	public AlunoCurso() {
	}

	public AlunoCurso(Aluno aluno, Curso curso) {
		super();
		id.setAluno(aluno);
		id.setCurso(curso);
		// outros atributos
	}
		
	@JsonIgnore
	public Aluno getAluno() {
		return id.getAluno();
	}
		
	public void setAluno(Aluno aluno) {
		id.setAluno(aluno);
	}
		
	public Curso getCurso() {
		return id.getCurso();
	}
		
	public void setCurso(Curso curso) {
		id.setCurso(curso);
	}
}
