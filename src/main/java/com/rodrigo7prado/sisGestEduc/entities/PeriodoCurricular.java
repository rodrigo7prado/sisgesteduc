package com.rodrigo7prado.sisGestEduc.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rodrigo7prado.sisGestEduc.entities.pk.PeriodoCurricularPk;

@Entity
@Table(name = "tb_periodo_curricular")
public class PeriodoCurricular implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PeriodoCurricularPk id = new PeriodoCurricularPk();
	// outros atributos
	
	@OneToMany(mappedBy = "id.periodoCurricular")
	Set<ComponenteCurricular> componentesCurriculares = new HashSet<>();

	public PeriodoCurricular() {
	}

	public PeriodoCurricular(CursoModalidade cursoModalidade, String nome) {
		super();
		id.setCursoModalidade(cursoModalidade);
		id.setNome(nome);
		// outros atributos
	}
	
	@JsonIgnore
	public CursoModalidade getCursoModalidade() {
		return id.getCursoModalidade();
	}
	
	public void setCursoModalidade(CursoModalidade cursoModalidade) {
		id.setCursoModalidade(cursoModalidade);
	}
	
	public String getNome() {
		return id.getNome();
	}
	
	public void setNome(String nome) {
		id.setNome(nome);
	}
	
	public Set<ComponenteCurricular> getComponentesCurriculares() {
		return componentesCurriculares;
	}
}