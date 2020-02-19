package com.rodrigo7prado.sisGestEduc.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "curso_modalidade")
public class CursoModalidade implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CursoModalidadePk id = new CursoModalidadePk();
	// outros atributos

	public CursoModalidade() {
	}

	public CursoModalidade(Curso curso, Modalidade modalidade) {
		super();
		id.setCurso(curso);
		id.setModalidade(modalidade);
		// outros atributos
	}
	
	@JsonIgnore
	public Curso getCurso() {
		return id.getCurso();
	}
	
	public void setCurso(Curso curso) {
		id.setCurso(curso);
	}
	
	public Modalidade getModalidade() {
		return id.getModalidade();
	}
	
	public void setModalidade(Modalidade modalidade) {
		id.setModalidade(modalidade);
	}
}
