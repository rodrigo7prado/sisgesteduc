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
	@OneToMany(mappedBy = "id.periodoCurricular")
	Set<AlunoPeriodoCurricular> alunosPeriodosCurriculares = new HashSet<>();

	public PeriodoCurricular() {
	}

	public PeriodoCurricular(CursoModalidade cursoModalidade, Integer periodoCurricular) {
		super();
		id.setCursoModalidade(cursoModalidade);
		id.setPeriodoCurricular(periodoCurricular);
		// outros atributos
	}
	
	@JsonIgnore
	public CursoModalidade getCursoModalidade() {
		return id.getCursoModalidade();
	}
	
	public void setCursoModalidade(CursoModalidade cursoModalidade) {
		id.setCursoModalidade(cursoModalidade);
	}
	
	public Integer getPeriodoCurricular() {
		return id.getPeriodoCurricular();
	}
	
	public void setPeriodoCurricular(Integer periodoCurricular) {
		id.setPeriodoCurricular(periodoCurricular);
	}
	
	public Set<ComponenteCurricular> getComponentesCurriculares() {
		return componentesCurriculares;
	}
	
	@JsonIgnore
	public Set<Aluno> getAlunos() {
		Set<Aluno> set = new HashSet<>();
		for (AlunoPeriodoCurricular x : alunosPeriodosCurriculares) {
			set.add(x.getAluno());
		}
		return set;
	}
}