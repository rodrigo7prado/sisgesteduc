package com.rodrigo7prado.sisGestEduc.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rodrigo7prado.sisGestEduc.entities.external.AlunoCursoModalidadePk;

@Entity
@Table(name = "tb_alunoCursoModalidade")
public class AlunoCursoModalidade implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AlunoCursoModalidadePk id = new AlunoCursoModalidadePk();
	// outros atributos
	
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name = "aluno_id",insertable=false, updatable=false),
		@JoinColumn(name = "curso_id",insertable=false, updatable=false)
	})
	private AlunoCurso alunoCurso;

	public AlunoCursoModalidade() {
	}

	public AlunoCursoModalidade(Aluno aluno, CursoModalidade cursoModalidade) {
		super();
		id.setAluno(aluno);
		id.setCursoModalidade(cursoModalidade);
		// outros atributos
	}
	
	@JsonIgnore
	public Aluno getAluno() {
		return id.getAluno();
	}
	
	public void setAluno(Aluno aluno) {
		id.setAluno(aluno);
	}
	
	public CursoModalidade getCursoModalidade() {
		return id.getCursoModalidade();
	}
	
	public void setCursoModalidade(CursoModalidade cursoModalidade) {
		id.setCursoModalidade(cursoModalidade);
	}
}
