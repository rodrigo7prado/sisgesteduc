package com.rodrigo7prado.sisGestEduc.entities.external;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "consolidado")
public class DadosConsolidados implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "Ano")
	private String anoLetivo;
	
	private String modalidade;
	
	private String curso;
	
	private String serie;
	
	private String turno;
	
	private String turma;
	
	private String aluno;
	
	private String nomeCompl;
	
	private String disciplina1;
	
	private String total_pontos;
	
	private String faltas;
	
	@Column(name = "Textbox148")
	private String freq;
	
	private String situacaoFinal;
	
	public DadosConsolidados() {
	}

	public DadosConsolidados(Long id, String anoLetivo, String modalidade, String curso, String serie, String turno,
			String turma, String aluno, String nomeCompl, String disciplina1, String total_pontos, String faltas,
			String freq, String situacaoFinal) {
		super();
		this.id = id;
		this.anoLetivo = anoLetivo;
		this.modalidade = modalidade;
		this.curso = curso;
		this.serie = serie;
		this.turno = turno;
		this.turma = turma;
		this.aluno = aluno;
		this.nomeCompl = nomeCompl;
		this.disciplina1 = disciplina1;
		this.total_pontos = total_pontos;
		this.faltas = faltas;
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

	public String getAluno() {
		return aluno;
	}

	public String getNomeCompl() {
		return nomeCompl;
	}

	public String getDisciplina1() {
		return disciplina1;
	}

	public String getTotal_pontos() {
		return total_pontos;
	}

	public String getFaltas() {
		return faltas;
	}

	public String getFreq() {
		return freq;
	}

	public String getSituacaoFinal() {
		return situacaoFinal;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DadosConsolidados other = (DadosConsolidados) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DadosConsolidados [id=" + id + "anoLetivo=" + anoLetivo + ", modalidade=" + modalidade + ", curso=" + curso
				+ ", serie=" + serie + ", turno=" + turno + ", turma=" + turma + ", aluno=" + aluno + ", nomeCompl="
				+ nomeCompl + ", disciplina1=" + disciplina1 + ", total_pontos=" + total_pontos + ", faltas=" + faltas
				+ ", freq=" + freq + ", situacaoFinal=" + situacaoFinal + "]";
	}
}
