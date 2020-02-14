package com.rodrigo7prado.sisGestEduc.dto;

import com.rodrigo7prado.sisGestEduc.entities.external.AlunoExternal;
import com.rodrigo7prado.sisGestEduc.entities.external.ResultadoFinalExternal;

public class ResultadoFinalExternalDTO2 {

	private Long id;
	
	private String anoLetivo;
	
	private String modalidade;
	
	private String curso;
	
	private String serie;
	
	private String turno;
	
	private String turma;
	
	private AlunoExternal aluno;
	
	private String matricula;
	
	private String nomeCompl;
	
	private String freq;
	
	private String situacaoFinal;
	
	ResultadoFinalExternalDTO2() {
	}
	
	public ResultadoFinalExternalDTO2(ResultadoFinalExternal obj) {
		id = obj.getId();
		anoLetivo = obj.getAnoLetivo();
		modalidade = obj.getModalidade();
		curso = obj.getCurso();
		serie = obj.getSerie();
		turno = obj.getTurno();
		turma = obj.getTurma();
		nomeCompl = obj.getNomeCompl();
		aluno = obj.getAluno();
		matricula = obj.getMatricula();
		freq = obj.getFreq();
		situacaoFinal = obj.getSituacaoFinal();

	}

	public ResultadoFinalExternalDTO2(String anoLetivo, String modalidade, String curso, String serie, String turno,
			String turma, String nomeCompl, AlunoExternal aluno, String freq, String situacaoFinal) {
		super();
		this.anoLetivo = anoLetivo;
		this.modalidade = modalidade;
		this.curso = curso;
		this.serie = serie;
		this.turno = turno;
		this.turma = turma;
		this.aluno = aluno;
		this.nomeCompl = nomeCompl;
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
		return matricula;
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
	
	
}
