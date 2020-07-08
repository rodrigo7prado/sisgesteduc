package com.rodrigo7prado.sisGestEduc.entities.external;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Immutable;

@Entity
@Immutable
public class VwUnionAnosSeries {
	@Id
	private String aluno;
	private String serie;
	private String anoSerie;
	private String chSubst;
	private String ensMedioEstabEns;
	private String ensMedioCidadeEstadoEstabEns;
	private Double freqSubst;
	private Double frqG;
	private String resSerie;
	private String resSerieSubst;
	
	
	
	public VwUnionAnosSeries() {
	}
	
	public VwUnionAnosSeries(String aluno, String serie, String anoSerie, String chSubst, String ensMedioCidadeEstadoEstabEns,
			String ensMedioEstabEns, Double freqSubst, Double frqG, String resSerie, String resSerieSubst) {
		super();
		this.aluno = aluno;
		this.serie = serie;
		this.anoSerie = anoSerie;
		this.chSubst = chSubst;
		this.ensMedioEstabEns = ensMedioEstabEns;
		this.ensMedioCidadeEstadoEstabEns = ensMedioCidadeEstadoEstabEns;
		this.freqSubst = freqSubst;
		this.frqG = frqG;
		this.resSerie = resSerie;
		this.resSerieSubst = resSerieSubst;
	}
	
	public String getAluno() {
		return aluno;
	}

	public void setAluno(String aluno) {
		this.aluno = aluno;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public String getAnoSerie() {
		return anoSerie;
	}

	public void setAnoSerie(String anoSerie) {
		this.anoSerie = anoSerie;
	}

	public String getChSubst() {
		return chSubst;
	}

	public void setChSubst(String chSubst) {
		this.chSubst = chSubst;
	}

	public String getEnsMedioCidadeEstadoEstabEns() {
		return ensMedioCidadeEstadoEstabEns;
	}

	public void setEnsMedioCidadeEstadoEstabEns(String ensMedioCidadeEstadoEstabEns) {
		this.ensMedioCidadeEstadoEstabEns = ensMedioCidadeEstadoEstabEns;
	}

	public String getEnsMedioEstabEns() {
		return ensMedioEstabEns;
	}

	public void setEnsMedioEstabEns(String ensMedioEstabEnsino) {
		this.ensMedioEstabEns = ensMedioEstabEnsino;
	}

	public Double getFreqSubst() {
		return freqSubst;
	}

	public void setFreqSubst(Double freqSubst) {
		this.freqSubst = freqSubst;
	}

	public Double getFrqG() {
		return frqG;
	}

	public void setFrqG(Double frqG) {
		this.frqG = frqG;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aluno == null) ? 0 : aluno.hashCode());
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
		VwUnionAnosSeries other = (VwUnionAnosSeries) obj;
		if (aluno == null) {
			if (other.aluno != null)
				return false;
		} else if (!aluno.equals(other.aluno))
			return false;
		return true;
	}
	
	
}
