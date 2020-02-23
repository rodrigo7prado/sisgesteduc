package com.rodrigo7prado.sisGestEduc.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rodrigo7prado.sisGestEduc.entities.pk.AlunoPeriodoLetivoPk;

@Entity
@Table(name = "tb_aluno_periodo_letivo")
public class AlunoPeriodoLetivo implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AlunoPeriodoLetivoPk id = new AlunoPeriodoLetivoPk();
	// outros atributos

	public AlunoPeriodoLetivo() {
	}

	public AlunoPeriodoLetivo(Aluno aluno, PeriodoCurricular periodoCurricular) {
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
}