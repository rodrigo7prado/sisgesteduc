package com.rodrigo7prado.sisGestEduc.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rodrigo7prado.sisGestEduc.entities.pk.ComponenteCurricularPk;

@Entity
@Table(name = "tb_componente_curricular")
public class ComponenteCurricular implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ComponenteCurricularPk id = new ComponenteCurricularPk();
	// outros atributos
	
	@OneToMany(mappedBy = "id.componenteCurricular")
	Set<AlunoComponenteCurricular> componentesCurriculares = new HashSet<>();

	public ComponenteCurricular() {
	}

	public ComponenteCurricular(PeriodoCurricular periodoCurricular, Disciplina disciplina) {
		super();
		id.setPeriodoCurricular(periodoCurricular);
		id.setDisciplina(disciplina);
		// outros atributos
	}
	
	@JsonIgnore
	public PeriodoCurricular getPeriodoCurricular() {
		return id.getPeriodoCurricular();
	}
	
	public void setPeriodoCurricular(PeriodoCurricular periodoCurricular) {
		id.setPeriodoCurricular(periodoCurricular);
	}
	
	public Disciplina getDisciplina() {
		return id.getDisciplina();
	}
	
	public void setDisciplina(Disciplina disciplina) {
		id.setDisciplina(disciplina);
	}
	
	@JsonIgnore
	public Set<Aluno> getAlunos() {
		Set<Aluno> set = new HashSet<>();
		for (AlunoComponenteCurricular x : componentesCurriculares) {
			set.add(x.getAluno());
		}
		return set;
	}
}
