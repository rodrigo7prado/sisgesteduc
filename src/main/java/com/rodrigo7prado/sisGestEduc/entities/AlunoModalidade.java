package com.rodrigo7prado.sisGestEduc.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_aluno_modalidade")
public class AlunoModalidade implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AlunoModalidadePk id = new AlunoModalidadePk();
	// outros atributos
	
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name = "aluno_id", insertable=false, updatable=false),
		@JoinColumn(name = "curso_id", insertable=false, updatable=false)	
	})
	private AlunoCurso alunoCurso;

	public AlunoModalidade() {
	}

	public AlunoModalidade(Aluno aluno, Modalidade modalidade) {
		super();
		id.setAluno(aluno);
		id.setModalidade(modalidade);
		// outros atributos
	}
	
	@JsonIgnore
	public Aluno getAluno() {
		return id.getAluno();
	}
	
	public void setAluno(Aluno aluno) {
		id.setAluno(aluno);
	}
	
	public Modalidade getModalidade() {
		return id.getModalidade();
	}
	
	public void setModalidade(Modalidade modalidade) {
		id.setModalidade(modalidade);
	}
}
