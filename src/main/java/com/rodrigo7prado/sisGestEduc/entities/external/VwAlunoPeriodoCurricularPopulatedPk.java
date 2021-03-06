package com.rodrigo7prado.sisGestEduc.entities.external;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class VwAlunoPeriodoCurricularPopulatedPk implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String curso;
	
	private String modalidade;
	
	private String periodoCurricular;
	
	private String aluno;

	public VwAlunoPeriodoCurricularPopulatedPk() {
		super();
	}
	
	public VwAlunoPeriodoCurricularPopulatedPk(String curso, String modalidade, String periodoCurricular, String ano,
			String turma, String aluno) {
		super();
		this.curso = curso;
		this.modalidade = modalidade;
		this.periodoCurricular = periodoCurricular;
		this.aluno = aluno;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getModalidade() {
		return modalidade;
	}

	public void setModalidade(String modalidade) {
		this.modalidade = modalidade;
	}

	public String getPeriodoCurricular() {
		return periodoCurricular;
	}

	public void setPeriodoCurricular(String periodoCurricular) {
		this.periodoCurricular = periodoCurricular;
	}

	public String getAluno() {
		return aluno;
	}

	public void setAluno(String aluno) {
		this.aluno = aluno;
	}

	@Override
	public String toString() {
		return "VwAlunoPeriodoCurricularPopulatedPk [curso=" + curso + ", modalidade=" + modalidade
				+ ", periodoCurricular=" + periodoCurricular + ", aluno=" + aluno
				+ "]";
	}
	
}
