package com.rodrigo7prado.sisGestEduc.entities.external;

import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import org.hibernate.annotations.Immutable;

import com.rodrigo7prado.sisGestEduc.entities.Aluno;
import com.rodrigo7prado.sisGestEduc.entities.PeriodoCurricular;

@Entity
@Immutable
public class VwAlunoPeriodoCurricularCondensed {

	@EmbeddedId
	private VwAlunoPeriodoCurricularCondensedPk id;
	
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
	
	private String nomeCompl2;
	private String sexo2;
	private Date dataNasc2;
	private String nomePai2;
	private String nomeMae2;
	private String nacionalidade2;
	private String naturalidade2;
	private String naturalidadeUF2;
	private String rg2;
	private String rgEmissor2;
	private String rgEmissorUf2;
	private String situacaoFinal2;
	
	private String chSubst;
	private String ensMedioEstabEns;
	private String ensMedioCidadeEstadoEstabEns;
	private Double freqSubst;
	private Double frqg;
	private String resSerie;
	private String resSerieSubst;
	private Integer cdNfl;
	private Integer cfNfl;	
	
	public VwAlunoPeriodoCurricularCondensed() {
	}
	
	public VwAlunoPeriodoCurricularCondensed(Aluno aluno, PeriodoCurricular periodoCurricular) {
		super();
//		id.setAluno(aluno);
//		id.setPeriodoCurricular(periodoCurricular);
		// outros atributos
	}

	public VwAlunoPeriodoCurricularCondensedPk getId() {
		return id;
	}

	public void setId(VwAlunoPeriodoCurricularCondensedPk id) {
		this.id = id;
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
	
	public String getNomeCompl2() {
		return nomeCompl2;
	}

	public void setNomeCompl2(String nomeCompl2) {
		this.nomeCompl2 = nomeCompl2;
	}

	public String getSexo2() {
		return sexo2;
	}

	public void setSexo2(String sexo2) {
		this.sexo2 = sexo2;
	}

	public Date getDataNasc2() {
		return dataNasc2;
	}

	public void setDataNasc2(Date dataNasc2) {
		this.dataNasc2 = dataNasc2;
	}

	public String getNomePai2() {
		return nomePai2;
	}

	public void setNomePai2(String nomePai2) {
		this.nomePai2 = nomePai2;
	}

	public String getNomeMae2() {
		return nomeMae2;
	}

	public void setNomeMae2(String nomeMae2) {
		this.nomeMae2 = nomeMae2;
	}

	public String getNacionalidade2() {
		return nacionalidade2;
	}

	public void setNacionalidade2(String nacionalidade2) {
		this.nacionalidade2 = nacionalidade2;
	}

	public String getNaturalidade2() {
		return naturalidade2;
	}

	public void setNaturalidade2(String naturalidade2) {
		this.naturalidade2 = naturalidade2;
	}

	public String getNaturalidadeUF2() {
		return naturalidadeUF2;
	}

	public void setNaturalidadeUF2(String naturalidadeUF2) {
		this.naturalidadeUF2 = naturalidadeUF2;
	}

	public String getRg2() {
		return rg2;
	}

	public void setRg2(String rg2) {
		this.rg2 = rg2;
	}

	public String getRgEmissor2() {
		return rgEmissor2;
	}

	public void setRgEmissor2(String rgEmissor2) {
		this.rgEmissor2 = rgEmissor2;
	}

	public String getRgEmissorUf2() {
		return rgEmissorUf2;
	}

	public void setRgEmissorUf2(String rgEmissorUf2) {
		this.rgEmissorUf2 = rgEmissorUf2;
	}

	public String getSituacaoFinal2() {
		return situacaoFinal2;
	}

	public void setSituacaoFinal2(String situacaoFinal2) {
		this.situacaoFinal2 = situacaoFinal2;
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
