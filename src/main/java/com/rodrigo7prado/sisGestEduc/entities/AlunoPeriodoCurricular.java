package com.rodrigo7prado.sisGestEduc.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rodrigo7prado.sisGestEduc.entities.pk.AlunoPeriodoCurricularPk;

@Entity
@Table(name = "tb_aluno_periodo_curricular")
public class AlunoPeriodoCurricular implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AlunoPeriodoCurricularPk id = new AlunoPeriodoCurricularPk();
	// outros atributos
	
	private String anoLetivo;
	private String turma;
	
	// Parte muitos
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name = "aluno_id",insertable=false, updatable=false),
		@JoinColumn(name = "curso_id",insertable=false, updatable=false),
		@JoinColumn(name = "modalidade_id",insertable=false, updatable=false)
	})
	private AlunoCursoModalidade alunoCursoModalidade;

	public AlunoPeriodoCurricular() {
	}

	public AlunoPeriodoCurricular(Aluno aluno, PeriodoCurricular periodoCurricular) {
		super();
		id.setAluno(aluno);
		id.setPeriodoCurricular(periodoCurricular);
		// outros atributos
	}
	
	@JsonIgnore
	public Aluno getAluno() {
		return id.getAluno();
	}
	
	public void setAluno(Aluno aluno) {
		id.setAluno(aluno);
	}
	
	public PeriodoCurricular getPeriodoCurricular() {
		return id.getPeriodoCurricular();
	}
	
	public void setPeriodoCurricular(PeriodoCurricular periodoCurricular) {
		id.setPeriodoCurricular(periodoCurricular);
	}

	public String getAnoLetivo() {
		return anoLetivo;
	}

	public void setAnoLetivo(String anoLetivo) {
		this.anoLetivo = anoLetivo;
	}

	public String getTurma() {
		return turma;
	}

	public void setTurma(String turma) {
		this.turma = turma;
	}
}
