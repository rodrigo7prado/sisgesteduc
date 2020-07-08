package com.rodrigo7prado.sisGestEduc.entities.external;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class VwAlunoPeriodoCurricularPk implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String curso;
	
	private String modalidade;
	
	private String periodoCurricular;
	
	private String ano;
	
	private String turma;
	
	private String aluno;
	
	private String situacaoFinal;
	
	

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

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getTurma() {
		return turma;
	}

	public void setTurma(String turma) {
		this.turma = turma;
	}

	public String getAluno() {
		return aluno;
	}

	public void setAluno(String aluno) {
		this.aluno = aluno;
	}

	public String getSituacaoFinal() {
		return situacaoFinal;
	}

	public void setSituacaoFinal(String situacaoFinal) {
		this.situacaoFinal = situacaoFinal;
	}
}
