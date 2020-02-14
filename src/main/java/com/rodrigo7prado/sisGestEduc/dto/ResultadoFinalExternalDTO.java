package com.rodrigo7prado.sisGestEduc.dto;

import com.rodrigo7prado.sisGestEduc.entities.external.AlunoExternal;
import com.rodrigo7prado.sisGestEduc.entities.external.ResultadoFinalExternal;

public class ResultadoFinalExternalDTO {

	private Long id;
	
	private String anoLetivo;
	
	private String modalidade;
	
	private String curso;
	
	private String serie;
	
	private String turno;
	
	private String turma;
	
	private AlunoExternal aluno;
	
	private String matricula2;
	
	private String nomeCompl;
	
	private String freq;
	
	private String situacaoFinal;
	
	ResultadoFinalExternalDTO() {
	}
	
	public ResultadoFinalExternalDTO(ResultadoFinalExternal obj) {
		id = obj.getId();
		anoLetivo = obj.getAnoLetivo();
		modalidade = obj.getModalidade();
		curso = obj.getCurso();
		serie = obj.getSerie();
		turno = obj.getTurno();
		turma = obj.getTurma();
		nomeCompl = obj.getNomeCompl();
		aluno = obj.getAluno();
//		matricula = obj.getMatricula();
		freq = obj.getFreq();
		situacaoFinal = obj.getSituacaoFinal();

	}

	public ResultadoFinalExternalDTO(String anoLetivo, String modalidade, String curso, String serie, String turno,
			String turma, String nomeCompl, AlunoExternal aluno, String freq, String situacaoFinal) {
		super();
		this.aluno = aluno;
		this.anoLetivo = anoLetivo;
		this.modalidade = modalidade;
		this.curso = curso;
		this.serie = serie;
		this.turno = turno;
		this.turma = turma;
		this.nomeCompl = nomeCompl;
		if(aluno != null) {
			this.matricula2 = aluno.getMatricula();
		} else {
			this.matricula2 = null;
		}
		this.freq = freq;
		this.situacaoFinal = situacaoFinal;
	}

	public Long getId() {
		return id;
	}

	public String getAnoLetivo() {
		return anoLetivo;
	}

	public String getModalidade() {
		return modalidade;
	}

	public String getCurso() {
		return curso;
	}

	public String getSerie() {
		return serie;
	}

	public String getTurno() {
		return turno;
	}

	public String getTurma() {
		return turma;
	}
	
	public AlunoExternal getAluno() {
		return aluno;
	}
	
	public String getMatricula() {
		return matricula2;
	}

	public String getNomeCompl() {
		return nomeCompl;
	}

	public String getFreq() {
		return freq;
	}

	public String getSituacaoFinal() {
		return situacaoFinal;
	}

	public String getMatricula2() {
		return matricula2;
	}

	public void setMatricula2(String matricula2) {
		this.matricula2 = matricula2;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setAnoLetivo(String anoLetivo) {
		this.anoLetivo = anoLetivo;
	}

	public void setModalidade(String modalidade) {
		this.modalidade = modalidade;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public void setTurma(String turma) {
		this.turma = turma;
	}

	public void setAluno(AlunoExternal aluno) {
		this.aluno = aluno;
	}

	public void setNomeCompl(String nomeCompl) {
		this.nomeCompl = nomeCompl;
	}

	public void setFreq(String freq) {
		this.freq = freq;
	}

	public void setSituacaoFinal(String situacaoFinal) {
		this.situacaoFinal = situacaoFinal;
	}
	
}