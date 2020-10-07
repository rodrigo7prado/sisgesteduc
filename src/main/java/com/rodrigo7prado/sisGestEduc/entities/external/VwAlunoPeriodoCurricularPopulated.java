package com.rodrigo7prado.sisGestEduc.entities.external;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import org.hibernate.annotations.Immutable;

import com.rodrigo7prado.sisGestEduc.entities.Aluno;
import com.rodrigo7prado.sisGestEduc.entities.PeriodoCurricular;
//import com.rodrigo7prado.sisGestEduc.entities.external.VwAlunoPeriodoCurricularPopulatedPk;

@Entity
@Immutable
public class VwAlunoPeriodoCurricularPopulated {

	@EmbeddedId
	private VwAlunoPeriodoCurricularPopulatedPk id;
	
	private String nomeCompl;
	private String situacaoFinal;
	
	private String chSubst;
	private String ensMedioEstabEns;
	private String ensMedioCidadeEstadoEstabEns;
	private Double freqSubst;
	private Double frqg;
	private String resSerie;
	private String resSerieSubst;	
	
	public VwAlunoPeriodoCurricularPopulated() {
	}
	
	public VwAlunoPeriodoCurricularPopulated(Aluno aluno, PeriodoCurricular periodoCurricular) {
		super();
//		id.setAluno(aluno);
//		id.setPeriodoCurricular(periodoCurricular);
		// outros atributos
	}
	
	public VwAlunoPeriodoCurricularPopulated(
			VwAlunoPeriodoCurricularPopulatedPk id,
			String ano,
			String curso,
			String modalidade,
			String periodoCurricular,
			String turma,
			String aluno,
			String nomeCompl,
			String situacaoFinal,
			String chSubst,
			String ensMedioEstabEns,
			String ensMedioCidadeEstadoEstabEns,
			Double freqSubst,
			Double frqg,
			String resSerie,
			String resSerieSubst
			) {
//		super();
//		this.id.setAno(ano);
//		this.id.setCurso(curso);
//		this.id.setModalidade(modalidade);
//		this.id.setPeriodoCurricular(periodoCurricular);
//		this.id.setTurma(turma);
//		this.id.setAluno(aluno);
		this.id = id;
		this.nomeCompl = nomeCompl;
		this.situacaoFinal = situacaoFinal;
		this.chSubst = chSubst;
		this.ensMedioEstabEns = ensMedioEstabEns;
		this.ensMedioCidadeEstadoEstabEns = ensMedioCidadeEstadoEstabEns;
		this.freqSubst = freqSubst;
		this.frqg = frqg;
		this.resSerie = resSerie;
		this.resSerieSubst = resSerieSubst;
	}

	public VwAlunoPeriodoCurricularPopulatedPk getId() {
		return id;
	}

	public void setId(VwAlunoPeriodoCurricularPopulatedPk id) {
		this.id = id;
	}

	public String getNomeCompl() {
		return nomeCompl;
	}

	public void setNomeCompl(String nomeCompl) {
		this.nomeCompl = nomeCompl;
	}

	public String getSituacaoFinal() {
		return situacaoFinal;
	}

	public void setSituacaoFinal(String situacaoFinal) {
		this.situacaoFinal = situacaoFinal;
	}

	public String getChSubst() {
		return chSubst;
	}

	public void setChSubst(String chSubst) {
		this.chSubst = chSubst;
	}

	public String getEnsMedioEstabEns() {
		return ensMedioEstabEns;
	}

	public void setEnsMedioEstabEns(String ensMedioEstabEns) {
		this.ensMedioEstabEns = ensMedioEstabEns;
	}

	public String getEnsMedioCidadeEstadoEstabEns() {
		return ensMedioCidadeEstadoEstabEns;
	}

	public void setEnsMedioCidadeEstadoEstabEns(String ensMedioCidadeEstadoEstabEns) {
		this.ensMedioCidadeEstadoEstabEns = ensMedioCidadeEstadoEstabEns;
	}

	public Double getFreqSubst() {
		return freqSubst;
	}

	public void setFreqSubst(Double freqSubst) {
		this.freqSubst = freqSubst;
	}

	public Double getFrqg() {
		return frqg;
	}

	public void setFrqg(Double frqg) {
		this.frqg = frqg;
	}

	public String getResSerie() {
		return resSerie;
	}

	public void setResSerie(String resSerie) {
		this.resSerie = resSerie;
	}

	public String getResSerieSubst() {
		return resSerieSubst;
	}

	public void setResSerieSubst(String resSerieSubst) {
		this.resSerieSubst = resSerieSubst;
	}

	@Override
	public String toString() {
		return "VwAlunoPeriodoCurricularPopulated [id=" + id + ", nomeCompl=" + nomeCompl + ", situacaoFinal="
				+ situacaoFinal + ", chSubst=" + chSubst + ", ensMedioEstabEns=" + ensMedioEstabEns
				+ ", ensMedioCidadeEstadoEstabEns=" + ensMedioCidadeEstadoEstabEns + ", freqSubst=" + freqSubst
				+ ", frqg=" + frqg + ", resSerie=" + resSerie + ", resSerieSubst=" + resSerieSubst + "]";
	} 
}
