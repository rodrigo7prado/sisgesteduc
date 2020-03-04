package com.rodrigo7prado.sisGestEduc.entities.external;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class VwAlunoPeriodoCurricularPk implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String ano;
	
	private String turma;
	
	private String aluno;

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
}
