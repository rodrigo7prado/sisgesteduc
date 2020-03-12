package com.rodrigo7prado.sisGestEduc.dto;

public class AlunoComponenteCurricularDto {
	private String ano;
	private String curso;
	private String modalidade;
	private String periodoCurricular;
	private String componenteCurricular;
	private String matricula;
	private String nomeCompleto;
	private String totalPontos;
	private String faltas;
	private String freqGlobal;

	public AlunoComponenteCurricularDto() {
	}

	public AlunoComponenteCurricularDto(String curso, String modalidade, String matricula, String nomeCompleto,
			String componenteCurricular) {
		this.curso = curso;
		this.modalidade = modalidade;
		this.matricula = matricula;
		this.nomeCompleto = nomeCompleto;
		this.componenteCurricular = componenteCurricular;
	}

	public AlunoComponenteCurricularDto(String ano, String curso, String modalidade, String periodoCurricular,
			String matricula, String nomeCompleto, String componenteCurricular, String totalPontos, String faltas,
			String freqGlobal) {
		this.ano = ano;
		this.curso = curso;
		this.modalidade = modalidade;
		this.periodoCurricular = periodoCurricular;
		this.matricula = matricula;
		this.nomeCompleto = nomeCompleto;
		this.componenteCurricular = componenteCurricular;
		this.totalPontos = totalPontos;
		this.faltas = faltas;
		this.freqGlobal = freqGlobal;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
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

	public String getComponenteCurricular() {
		return componenteCurricular;
	}

	public void setComponenteCurricular(String componenteCurricular) {
		this.componenteCurricular = componenteCurricular;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getTotalPontos() {
		return totalPontos;
	}

	public void setTotalPontos(String totalPontos) {
		this.totalPontos = totalPontos;
	}

	public String getFaltas() {
		return faltas;
	}

	public void setFaltas(String faltas) {
		this.faltas = faltas;
	}

	public String getFreqGlobal() {
		return freqGlobal;
	}

	public void setFreqGlobal(String freqGlobal) {
		this.freqGlobal = freqGlobal;
	}
}
