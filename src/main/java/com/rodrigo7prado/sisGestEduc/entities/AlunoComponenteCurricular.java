package com.rodrigo7prado.sisGestEduc.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
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
	
	private String totalPontos;
	private String freqGlobal;
	
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name = "aluno_id",insertable=false, updatable=false),
		@JoinColumn(name = "curso_id",insertable=false, updatable=false),
		@JoinColumn(name = "modalidade_id",insertable=false, updatable=false),
		@JoinColumn(name = "periodo_curricular_id",insertable=false, updatable=false)
	})
	private AlunoPeriodoCurricular alunoPeriodoCurricular;

	public AlunoComponenteCurricular() {
	}

	public AlunoComponenteCurricular(Aluno aluno, ComponenteCurricular componenteCurricular) {
		super();
		id.setAluno(aluno);
		id.setComponenteCurricular(componenteCurricular);
//		 outros atributos
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

	public String getTotalPontos() {
		return totalPontos;
	}

	public void setTotalPontos(String totalPontos) {
		this.totalPontos = totalPontos;
	}

	public String getFreqGlobal() {
		return freqGlobal;
	}

	public void setFreqGlobal(String freqGlobal) {
		this.freqGlobal = freqGlobal;
	}
}