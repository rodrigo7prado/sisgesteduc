package com.rodrigo7prado.sisGestEduc.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

import com.rodrigo7prado.sisGestEduc.entities.pk.AlunoPeriodoCurricularCondensedPk;

@Entity
@Immutable
@Table(name = "vw_aluno_periodo_curricular_condensed")
public class AlunoPeriodoCurricularCondensed implements Serializable {
	private static final long serialVersionUID = 1L;
//	+ "al, v,a"

	@EmbeddedId
	private AlunoPeriodoCurricularCondensedPk id;

	private String nomeCompl;

	private String sexo;
	private Date dataNasc;
	private String nomePai;
	private String nomeMae;
	private String nacionalidade;
	private String naturalidade;
	private String naturalidadeUF;
	private String rg;
	private String rgEmissor;
	private String rgEmissorUf;
	private String situacaoFinal;
	private String chSubst;
	private String ensMedioEstabEns;
	private String ensMedioCidadeEstadoEstabEns;
	private Double freqSubst;
	private Double frqG;
	private String resSerie;
	private String resSerieSubst;
	private Integer cdNfl;
	private Integer cfNfl;

	public AlunoPeriodoCurricularCondensed() {
	}

	public String getNomeCompl() {
		return nomeCompl;
	}

	public void setNomeCompl(String nomeCompl) {
		this.nomeCompl = nomeCompl;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Date getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

	public String getNomePai() {
		return nomePai;
	}

	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}

	public String getNomeMae() {
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public String getNaturalidade() {
		return naturalidade;
	}

	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}

	public String getNaturalidadeUF() {
		return naturalidadeUF;
	}

	public void setNaturalidadeUF(String naturalidadeUF) {
		this.naturalidadeUF = naturalidadeUF;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getRgEmissor() {
		return rgEmissor;
	}

	public void setRgEmissor(String rgEmissor) {
		this.rgEmissor = rgEmissor;
	}

	public String getRgEmissorUf() {
		return rgEmissorUf;
	}

	public void setRgEmissorUf(String rgEmissorUf) {
		this.rgEmissorUf = rgEmissorUf;
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

	public Integer getCdNfl() {
		return cdNfl;
	}

	public void setCdNfl(Integer cdNfl) {
		this.cdNfl = cdNfl;
	}

	public Integer getCfNfl() {
		return cfNfl;
	}

	public void setCfNfl(Integer cfNfl) {
		this.cfNfl = cfNfl;
	}

}
