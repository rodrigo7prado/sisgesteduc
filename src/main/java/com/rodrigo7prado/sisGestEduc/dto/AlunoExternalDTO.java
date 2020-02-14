package com.rodrigo7prado.sisGestEduc.dto;

import com.rodrigo7prado.sisGestEduc.entities.external.AlunoExternal;

public class AlunoExternalDTO {

	private String anoLetivo;
	private String modalidade;
	private String curso;
	private String serie;
	private String turno;
	private String turma;
	private String nomeCompleto;
	private String matricula;
	private String situacaoFinal;

	AlunoExternalDTO() {
	}

	public AlunoExternalDTO(AlunoExternal obj) {
		anoLetivo = obj.getResultadosFinaisExternal().iterator().next().getSituacaoFinal();
		matricula = obj.getMatricula();
		nomeCompleto = obj.getNomeCompleto();
		turma = obj.getResultadosFinaisExternal().iterator().next().getTurma();
		situacaoFinal = obj.getResultadosFinaisExternal().iterator().next().getSituacaoFinal();
	}

	public AlunoExternalDTO(String anoLetivo, String modalidade, String curso, String serie, String turno, String turma,
			String nomeCompleto, String matricula, String freq, String situacaoFinal) {
		super();
		
		
		this.anoLetivo = anoLetivo;
		this.modalidade = modalidade;
		this.curso = curso;
		this.serie = serie;
		this.turno = turno;
		this.turma = turma;
		this.nomeCompleto = nomeCompleto;
		this.matricula = matricula;
		this.situacaoFinal = situacaoFinal;
		
		
	}

	public String getAnoLetivo() {
		return anoLetivo;
	}

	public void setAnoLetivo(String anoLetivo) {
		this.anoLetivo = anoLetivo;
	}

	public String getModalidade() {
		return modalidade;
	}

	public void setModalidade(String modalidade) {
		this.modalidade = modalidade;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public String getTurma() {
		return turma;
	}

	public void setTurma(String turma) {
		this.turma = turma;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getSituacaoFinal() {
		return situacaoFinal;
	}

	public void setSituacaoFinal(String situacaoFinal) {
		this.situacaoFinal = situacaoFinal;
	}
}
