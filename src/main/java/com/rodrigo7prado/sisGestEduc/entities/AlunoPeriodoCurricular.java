package com.rodrigo7prado.sisGestEduc.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	private String situacaoFinal;
	
//	private String anoLetivo_2;
//	private String turma_2;
//	private String situacaoFinal_2;
	
	private String anoLetivo2;
	private String turma2;
	private String situacaoFinal2;
	
//	private String anoLetivoExternal;
//	private String turmaExternal;
//	private String situacaoFinalExternal;
	
	// Parte muitos
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name = "aluno_id",insertable=false, updatable=false),
		@JoinColumn(name = "curso_id",insertable=false, updatable=false),
		@JoinColumn(name = "modalidade_id",insertable=false, updatable=false)
	})
	private AlunoCursoModalidade alunoCursoModalidade;
	
	@JsonIgnore
	@OneToMany(mappedBy = "alunoPeriodoCurricular")
	private List<AlunoComponenteCurricular> alunosCompoentnesCurriculares = new ArrayList<>();

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

	public String getSituacaoFinal() {
		return situacaoFinal;
	}

	public void setSituacaoFinal(String situacaoFinal) {
		this.situacaoFinal = situacaoFinal;
	}

	public String getAnoLetivo2() {
		return anoLetivo2;
	}

	public void setAnoLetivo2(String anoLetivo2) {
		this.anoLetivo2 = anoLetivo2;
	}

	public String getTurma2() {
		return turma2;
	}

	public void setTurma2(String turma2) {
		this.turma2 = turma2;
	}

	public String getSituacaoFinal2() {
		return situacaoFinal2;
	}

	public void setSituacaoFinal2(String situacaoFinal2) {
		this.situacaoFinal2 = situacaoFinal2;
	}

	
//	public Double getTotal() {
//		double sum = 0.0;
//		for (AlunoComponenteCurricular x : alunosCompoentnesCurriculares) {
//			if (!x.getTotalPontos().equals("-") || !x.getTotalPontos().equals(null)) {
//				sum = sum + 1;
//			}
//		}
//		return sum;
//	}
}
