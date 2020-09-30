package com.rodrigo7prado.sisGestEduc.dto;

import java.util.Date;

import com.rodrigo7prado.sisGestEduc.entities.Aluno;
import com.rodrigo7prado.sisGestEduc.entities.AlunoPeriodoCurricular;
import com.rodrigo7prado.sisGestEduc.entities.PeriodoCurricular;
import com.rodrigo7prado.sisGestEduc.enums.StatusDocAluno;

public class AlunoPeriodoCurricularCondensedDto {

	private Long id;

	private PeriodoCurricular periodoCurricular;

	private String anoLetivo;

	private String modalidade;

	private String curso;

	private String serie;

	private String turno;

	private String turma;

	private Aluno aluno;

	private String matricula;

	private String nomeCompleto;
	private String sexo;
//	private String dataNasc;
	private Date dataNasc;
	private String nomePai;
	private String nomeMae;
	private String nacionalidade;
	private String naturalidade;
	private String naturalidadeUF;
	private String rg;
	private String rgEmissor;
	private String rgEmissorUf;
	
	private String nomeCompleto2;
	private String sexo2;
//	private String dataNasc2;
	private Date dataNasc2;
	private String nomePai2;
	private String nomeMae2;
	private String nacionalidade2;
	private String naturalidade2;
	private String naturalidadeUF2;
	private String rg2;
	private String rgEmissor2;
	private String rgEmissorUf2;

	private String freq;
	private String situacaoFinal;
	
	private String chSubst;
	private String ensMedioEstabEns;		
	private String ensMedioCidadeEstadoEstabEns;
	private Double freqSubst;
	private Double frqG;
	private String resSerie;
	private String resSerieSubst;
	
	private Integer nflCertidao;
	private Integer nflCertificado;

	private StatusDocAluno validDadosPessoais;

	private StatusDocAluno validDadosIdentif;

	private StatusDocAluno validDadosHeFund;

	private StatusDocAluno validDadosHeMedio;

	public AlunoPeriodoCurricularCondensedDto() {
//		System.out.println("CONSTRUTOR: " + this.nomeCompleto);
	}

	public AlunoPeriodoCurricularCondensedDto(AlunoPeriodoCurricular obj) {

	}

	public AlunoPeriodoCurricularCondensedDto(
//			Aluno aluno,
//			VwAlunoPeriodoCurricular vwAlunoPeriodoCurricular,
//			AlunoExternal alunoExternal,
			String anoLetivo, String curso, String modalidade, String serie, String turma,
			String matricula,
			String nomeCompleto, String sexo,
			Date dataNasc, String nomePai, String nomeMae, String nacionalidade, String naturalidade,
			String naturalidadeUF, String rg, String rgEmissor, String rgEmissorUf,
			String nomeCompleto2, String sexo2,
			Date dataNasc2, String nomePai2, String nomeMae2, String nacionalidade2, String naturalidade2,
			String naturalidadeUF2, String rg2, String rgEmissor2, String rgEmissorUf2,
			String situacaoFinal,
			String chSubst,
			String ensMedioEstabEns,
			String ensMedioCidadeEstadoEstabEns,
			Double freqSubst,
			Double frqG,
			String resSerie,
			String resSerieSubst,
			Integer nflCertidao, Integer nflCertificado) {
		super();

//		System.out.println("USO 1");

//		if (alunoExternal != null) {
//			this.validDadosPessoais = alunoExternal.getValidDadosPessoais();
//			this.validDadosIdentif = alunoExternal.getValidDadosIdentif();
//			this.validDadosHeFund = alunoExternal.getValidDadosHeFund();
//			this.validDadosHeMedio = alunoExternal.getValidDadosHeMedio();
//		}
		
		if (aluno == null) {
			this.nomeCompleto = nomeCompleto;
			this.nomeCompleto2 = nomeCompleto2;
		} else {
			this.nomeCompleto = aluno.getNomeCompleto();
		}

		this.anoLetivo = anoLetivo;
		this.curso = curso;
		this.modalidade = modalidade;
		this.serie = serie;
		this.turma = turma;
		this.matricula = matricula;
		
		this.sexo = sexo;
		this.dataNasc = dataNasc;
		this.nomePai = nomePai;
		this.nomeMae = nomeMae;
		this.nacionalidade = nacionalidade;
		this.naturalidade = naturalidade;
		this.naturalidadeUF = naturalidadeUF;
		this.rg = rg;
		this.rgEmissor = rgEmissor;
		this.rgEmissorUf = rgEmissorUf;
		this.situacaoFinal = situacaoFinal;
		
		this.sexo2 = sexo2;
		this.dataNasc2 = dataNasc2;
		this.nomePai2 = nomePai2;
		this.nomeMae2 = nomeMae2;
		this.nacionalidade2 = nacionalidade2;
		this.naturalidade2 = naturalidade2;
		this.naturalidadeUF2 = naturalidadeUF2;
		this.rg2 = rg2;
		this.rgEmissor2 = rgEmissor2;
		this.rgEmissorUf2 = rgEmissorUf2;
		
		this.chSubst = chSubst;
		this.ensMedioEstabEns = ensMedioEstabEns;		
//		System.out.println("Lugar: " + situacaoFinal);
		this.ensMedioCidadeEstadoEstabEns = ensMedioCidadeEstadoEstabEns;
		this.freqSubst = freqSubst;
		this.frqG = frqG;
		this.resSerie = resSerie;
		this.resSerieSubst = resSerieSubst;
		
		this.nflCertidao = nflCertidao;
		this.nflCertificado = nflCertificado;

	}
	
	public AlunoPeriodoCurricularCondensedDto(
//			Aluno aluno,
//			VwAlunoPeriodoCurricular vwAlunoPeriodoCurricular,
//			AlunoExternal alunoExternal,
			String anoLetivo, String curso, String modalidade, String serie, String turma,
			String matricula,
			String nomeCompleto, String sexo, Date dataNasc, String nomePai, String nomeMae, String nacionalidade, String naturalidade,
			String naturalidadeUF, String rg, String rgEmissor, String rgEmissorUf, 
			String nomeCompleto2, String sexo2, Date dataNasc2, String nomePai2, String nomeMae2, String nacionalidade2, String naturalidade2,
			String naturalidadeUF2, String rg2, String rgEmissor2, String rgEmissorUf2,
			String situacaoFinal
//			, Integer nflCertidao, Integer nflCertificado
			) {
		super();

//		if (alunoExternal != null) {
//			this.validDadosPessoais = alunoExternal.getValidDadosPessoais();
//			this.validDadosIdentif = alunoExternal.getValidDadosIdentif();
//			this.validDadosHeFund = alunoExternal.getValidDadosHeFund();
//			this.validDadosHeMedio = alunoExternal.getValidDadosHeMedio();
//		}
		
		if (aluno == null) {
			this.nomeCompleto = nomeCompleto;
		} else {
			this.nomeCompleto = aluno.getNomeCompleto();
		}

		this.anoLetivo = anoLetivo;
		this.curso = curso;
		this.modalidade = modalidade;
		this.serie = serie;
		this.turma = turma;
		this.matricula = matricula;
		
		this.sexo = sexo;
		this.dataNasc = dataNasc;
		this.nomePai = nomePai;
		this.nomeMae = nomeMae;
		this.nacionalidade = nacionalidade;
		this.naturalidade = naturalidade;
		this.naturalidadeUF = naturalidadeUF;
		this.rg = rg;
		this.rgEmissor = rgEmissor;
		this.rgEmissorUf = rgEmissorUf;
		this.situacaoFinal = situacaoFinal;
		
//		this.nflCertidao = nflCertidao;
//		this.nflCertificado = nflCertificado;

	}

	public AlunoPeriodoCurricularCondensedDto(String anoLetivo, String curso, String modalidade, String serie, String turma, String matricula,
			String nomeCompleto, String sexo, Date dataNasc, String nomePai, String nomeMae, String nacionalidade,
			String naturalidade, String naturalidadeUF, String rg, String rgEmissor, String rgEmissorUf,
			String nomeCompleto2, String sexo2, Date dataNasc2, String nomePai2, String nomeMae2, String nacionalidade2,
			String naturalidade2, String naturalidadeUF2, String rg2, String rgEmissor2, String rgEmissorUf2,
			StatusDocAluno validDadosPessoais, StatusDocAluno validDadosIdentif, StatusDocAluno validDadosHeFund,
			StatusDocAluno validDadosHeMedio, String situacaoFinal,
			String ensMedioEstabEns,
			Integer nflCertidao, Integer nflCertificado
			) {
		this.anoLetivo = anoLetivo;
		this.curso = curso;
		this.modalidade = modalidade;
		this.serie = serie;
		this.turma = turma;
		this.matricula = matricula;
		
		this.nomeCompleto = nomeCompleto;
		this.sexo = sexo;
		this.dataNasc = dataNasc;
		this.nomePai = nomePai;
		this.nomeMae = nomeMae;
		this.nacionalidade = nacionalidade;
		this.naturalidade = naturalidade;
		this.naturalidadeUF = naturalidadeUF;
		this.rg = rg;
		this.rgEmissor = rgEmissor;
		this.rgEmissorUf = rgEmissorUf;
		
		this.nomeCompleto2 = nomeCompleto2;
		this.sexo2 = sexo2;
		this.dataNasc2 = dataNasc2;
		this.nomePai2 = nomePai2;
		this.nomeMae2 = nomeMae2;
		this.nacionalidade2 = nacionalidade2;
		this.naturalidade2 = naturalidade2;
		this.naturalidadeUF2 = naturalidadeUF2;
		this.rg2 = rg2;
		this.rgEmissor2 = rgEmissor2;
		this.rgEmissorUf2 = rgEmissorUf2;
		
		this.validDadosPessoais = validDadosPessoais;
		this.validDadosIdentif = validDadosIdentif;
		this.validDadosHeFund = validDadosHeFund;
		this.validDadosHeMedio = validDadosHeMedio;
		this.situacaoFinal = situacaoFinal;
		
		this.ensMedioEstabEns = ensMedioEstabEns;
		
		this.nflCertidao = nflCertidao;
		this.nflCertificado = nflCertificado;
	}

	public Long getId() {
		return id;
	}

	public PeriodoCurricular getPeriodoCurricular() {
		return periodoCurricular;
	}

	public void setPeriodoCurricular(PeriodoCurricular periodoCurricular) {
		this.periodoCurricular = periodoCurricular;
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

	public Aluno getAluno() {
		return aluno;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
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

	public String getFreq() {
		return freq;
	}

	public String getSituacaoFinal() {
		return situacaoFinal;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
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

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
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

	public void setRg(String rg) {
		this.rg = rg;
	}
	
	public String getNomeCompleto2() {
		return nomeCompleto2;
	}

	public void setNomeCompleto2(String nomeCompleto2) {
		this.nomeCompleto2 = nomeCompleto2;
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

	public void setFreq(String freq) {
		this.freq = freq;
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

	public Integer getNflCertidao() {
		return nflCertidao;
	}

	public void setNflCertidao(Integer nflCertidao) {
		this.nflCertidao = nflCertidao;
	}

	public Integer getNflCertificado() {
		return nflCertificado;
	}

	public void setNflCertificado(Integer nflCertificado) {
		this.nflCertificado = nflCertificado;
	}

	public StatusDocAluno getValidDadosPessoais() {
		return validDadosPessoais;
	}

	public void setValidDadosPessoais(StatusDocAluno validDadosPessoais) {
		this.validDadosPessoais = validDadosPessoais;
	}

	public StatusDocAluno getValidDadosIdentif() {
		return validDadosIdentif;
	}

	public void setValidDadosIdentif(StatusDocAluno validDadosIdentif) {
		this.validDadosIdentif = validDadosIdentif;
	}

	public StatusDocAluno getValidDadosHeFund() {
		return validDadosHeFund;
	}

	public void setValidDadosHeFund(StatusDocAluno validDadosHeFund) {
		this.validDadosHeFund = validDadosHeFund;
	}

	public StatusDocAluno getValidDadosHeMedio() {
		return validDadosHeMedio;
	}

	public void setValidDadosHeMedio(StatusDocAluno validDadosHeMedio) {
		this.validDadosHeMedio = validDadosHeMedio;
	}

	@Override
	public String toString() {
		return "AlunoPeriodoCurricularDto [anoLetivo=" + anoLetivo + ", modalidade=" + modalidade + ", curso=" + curso
				+ ", matricula=" + matricula + ", nomeCompleto=" + nomeCompleto + "]";
	}
}
