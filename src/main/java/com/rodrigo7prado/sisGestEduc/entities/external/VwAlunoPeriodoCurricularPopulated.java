package com.rodrigo7prado.sisGestEduc.entities.external;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import org.hibernate.annotations.Immutable;

import com.rodrigo7prado.sisGestEduc.entities.Aluno;
import com.rodrigo7prado.sisGestEduc.entities.PeriodoCurricular;

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
}
