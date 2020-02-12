package com.rodrigo7prado.sisGestEduc.entities.external;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.rodrigo7prado.sisGestEduc.enums.StatusDocumentacaoAluno;

@Entity
@Table(name = "consolidado_manual_alunos")
public class AlunosExternal {

	@Id
	@Column(name = "ALUNO")
	private String matricula;
	
	@Column(name = "NOME_COMPL")
	private String nomeCompleto;
	
	@Column(name = "Status_Matricula_Conex")
	private String statusMatriculaConexao;
	
	private Boolean certificacao;
	
	@Column(name = "data_conclusao_em")
	private Date dataConclusaoEM;
	
	private String dataNasc;
	
	@Column(name = "Pai")
	private String nomePai;
	
	@Column(name = "Mae")
	private String nomeMae;
	
	private String sexo;
	
	private String nacionalidade;
	
	private String naturalidade;
	
	private String naturalidadeUF;
	
	private String rg;
	
	private String rgEmissor;
	
	private String rgEmissorUF;
	
	@Column(name = "rg_emissao")
	private String rgDataEmissao;
	
	private String cnCartorio;
	
	private String cnMunicipio;
	
	private String cnUF;
	
	private String cnNTermo;
	
	private String cnLivro;
	
	private String cnFolha;
	
	@Column(name = "CN_EMISSAO")
	private String cnDataEmissao;
	
	private String obsHist;
	
	@Column(name = "Falta_HE_Fundamental")
	private Boolean faltaEntregaHEFundamental;
	
	@Column(name = "Falta_HE_Medio")
	private Boolean faltaEntregaHEMedio;
	
	@Column(name = "Falta_Rg")
	private Boolean faltaEntregaRG;
	
	@Column(name = "Falta_CN")
	private Boolean faltaEntregaCN;
	
	private Boolean dadosConferidos;
	
	@Column(name = "EF_Escola_conc")
	private String ensFundEscolaConclusao;
	
	@Column(name = "EF_Escola_concl_Local")
	private String ensFundMunicipioEscolaConclusao;
	
	@Column(name = "EF_Ano_Conc")
	private String ensFundAnoEscolaConclusao;
	
	@Column(name = "EF_Conc_Emissao")
	private String ensFundDataEmissaoConclusao;
	
	@Column(name = "EF_Num_Pag")
	private String ensFundNumPaginasConclusao;
	
	private StatusDocumentacaoAluno statusDocumentacaoAluno;
	
	public AlunosExternal() {	
	}

//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getStatusMatriculaConexao() {
		return statusMatriculaConexao;
	}

	public void setStatusMatriculaConexao(String statusMatriculaConexao) {
		this.statusMatriculaConexao = statusMatriculaConexao;
	}

	public Boolean getCertificacao() {
		return certificacao;
	}

	public void setCertificacao(Boolean certificacao) {
		this.certificacao = certificacao;
	}

	public Date getDataConclusaoEM() {
		return dataConclusaoEM;
	}

	public void setDataConclusaoEM(Date dataConclusaoEM) {
		this.dataConclusaoEM = dataConclusaoEM;
	}

	public String getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(String dataNasc) {
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

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
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

	public String getRgEmissorUF() {
		return rgEmissorUF;
	}

	public void setRgEmissorUF(String rgEmissorUF) {
		this.rgEmissorUF = rgEmissorUF;
	}

	public String getRgDataEmissao() {
		return rgDataEmissao;
	}

	public void setRgDataEmissao(String rgDataEmissao) {
		this.rgDataEmissao = rgDataEmissao;
	}

	public String getCnCartorio() {
		return cnCartorio;
	}

	public void setCnCartorio(String cnCartorio) {
		this.cnCartorio = cnCartorio;
	}

	public String getCnMunicipio() {
		return cnMunicipio;
	}

	public void setCnMunicipio(String cnMunicipio) {
		this.cnMunicipio = cnMunicipio;
	}

	public String getCnUF() {
		return cnUF;
	}

	public void setCnUF(String cnUF) {
		this.cnUF = cnUF;
	}

	public String getCnNTermo() {
		return cnNTermo;
	}

	public void setCnNTermo(String cnNTermo) {
		this.cnNTermo = cnNTermo;
	}

	public String getCnLivro() {
		return cnLivro;
	}

	public void setCnLivro(String cnLivro) {
		this.cnLivro = cnLivro;
	}

	public String getCnFolha() {
		return cnFolha;
	}

	public void setCnFolha(String cnFolha) {
		this.cnFolha = cnFolha;
	}

	public String getCnDataEmissao() {
		return cnDataEmissao;
	}

	public void setCnDataEmissao(String cnDataEmissao) {
		this.cnDataEmissao = cnDataEmissao;
	}

	public String getObsHist() {
		return obsHist;
	}

	public void setObsHist(String obsHist) {
		this.obsHist = obsHist;
	}

	public Boolean getFaltaEntregaHEFundamental() {
		return faltaEntregaHEFundamental;
	}

	public void setFaltaEntregaHEFundamental(Boolean faltaEntregaHEFundamental) {
		this.faltaEntregaHEFundamental = faltaEntregaHEFundamental;
	}

	public Boolean getFaltaEntregaHEMedio() {
		return faltaEntregaHEMedio;
	}

	public void setFaltaEntregaHEMedio(Boolean faltaEntregaHEMedio) {
		this.faltaEntregaHEMedio = faltaEntregaHEMedio;
	}

	public Boolean getFaltaEntregaRG() {
		return faltaEntregaRG;
	}

	public void setFaltaEntregaRG(Boolean faltaEntregaRG) {
		this.faltaEntregaRG = faltaEntregaRG;
	}

	public Boolean getFaltaEntregaCN() {
		return faltaEntregaCN;
	}

	public void setFaltaEntregaCN(Boolean faltaEntregaCN) {
		this.faltaEntregaCN = faltaEntregaCN;
	}

	public Boolean getDadosConferidos() {
		return dadosConferidos;
	}

	public void setDadosConferidos(Boolean dadosConferidos) {
		this.dadosConferidos = dadosConferidos;
	}

	public String getEnsFundEscolaConclusao() {
		return ensFundEscolaConclusao;
	}

	public void setEnsFundEscolaConclusao(String ensFundEscolaConclusao) {
		this.ensFundEscolaConclusao = ensFundEscolaConclusao;
	}

	public String getEnsFundMunicipioEscolaConclusao() {
		return ensFundMunicipioEscolaConclusao;
	}

	public void setEnsFundMunicipioEscolaConclusao(String ensFundMunicipioEscolaConclusao) {
		this.ensFundMunicipioEscolaConclusao = ensFundMunicipioEscolaConclusao;
	}

	public String getEnsFundAnoEscolaConclusao() {
		return ensFundAnoEscolaConclusao;
	}

	public void setEnsFundAnoEscolaConclusao(String ensFundAnoEscolaConclusao) {
		this.ensFundAnoEscolaConclusao = ensFundAnoEscolaConclusao;
	}

	public String getEnsFundDataEmissaoConclusao() {
		return ensFundDataEmissaoConclusao;
	}

	public void setEnsFundDataEmissaoConclusao(String ensFundDataEmissaoConclusao) {
		this.ensFundDataEmissaoConclusao = ensFundDataEmissaoConclusao;
	}

	public String getEnsFundNumPaginasConclusao() {
		return ensFundNumPaginasConclusao;
	}

	public void setEnsFundNumPaginasConclusao(String ensFundNumPaginasConclusao) {
		this.ensFundNumPaginasConclusao = ensFundNumPaginasConclusao;
	}

	@SuppressWarnings("static-access")
	public StatusDocumentacaoAluno statusDocumentacaoAluno() {
		return statusDocumentacaoAluno.DOCUMENTACAO_OK;
	}
}
