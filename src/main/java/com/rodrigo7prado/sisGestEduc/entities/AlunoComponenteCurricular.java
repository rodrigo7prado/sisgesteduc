package com.rodrigo7prado.sisGestEduc.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rodrigo7prado.sisGestEduc.entities.pk.AlunoComponenteCurricularPk;

@Entity
@Table(name = "tb_aluno_componente_curricular")
public class AlunoComponenteCurricular implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AlunoComponenteCurricularPk id = new AlunoComponenteCurricularPk();
	// outros atributos

	public AlunoComponenteCurricular() {
	}

	public AlunoComponenteCurricular(Aluno aluno, ComponenteCurricular componenteCurricular) {
		super();
		id.setAluno(aluno);
		id.setComponenteCurricular(componenteCurricular);
		// outros atributos
	}
	
	@JsonIgnore
	public Aluno getAluno() {
		return id.getAluno();
	}
	
	public void setAluno(Aluno aluno) {
		id.setAluno(aluno);
	}
	
	public ComponenteCurricular getComponenteCurricular() {
		return id.getComponenteCurricular();
	}
	
	public void setComponenteCurricular(ComponenteCurricular componenteCurricular) {
		id.setComponenteCurricular(componenteCurricular);
	}
}