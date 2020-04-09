package com.rodrigo7prado.sisGestEduc.entities.external;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "certificados_external")
public class CertificadosCsv  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String nfl; 
	private String livro;
	private String censo;
	private String instituicao;
	private String instAtoDeCriacao;
	private String dataInstAtoDeCriacao;
	private String curso;
	private String consolidadoModalidade;
	@Column(name = "DOC_CONCL_MODALIDADES_Modalidade")
	private String docConclMmodalidadesModalidade;
	private String leiModalidade;
	private String decretoModalidade;
	@Column(name = "Carga_Horaria_Modalidade")
	private String cargaHorariaModalidade;
	private String ano;
	private String turma;
	private String nomeCompl;
	@Id
	private String aluno;
	private String tipoDoc;
	private String sexo;
	private String nacionalidade;
	private String naturalidadeUf;
	private String naturalidade;
	private String rg;
	private String rgEmissor;
	private String rgEmissorUf; 
	private Date rgEmissao; 
	private String pai;
	private String mae;
	private Date dataNasc; 
	private String situacaoFinal; 
	private Date dataConclusao;
	private Date dataEmissaoCertificado; 
	private String cnCartorio;
	private String cnMunicipio;
	private String cnUf;
	private String cnTermo; 
	private String cnLivro; 
	private String cnFolha;
	private Date cnEmisao;
	private Boolean aCorrigir;
	private String descrErro;
	private Boolean corrigido;
	private Boolean impresso;
	private Boolean reimpresso;
	private Boolean imprimirAgora;
	
	public CertificadosCsv() {
		
	}

	public String getNfl() {
		return nfl;
	}

	public void setNfl(String nfl) {
		this.nfl = nfl;
	}

	public String getLivro() {
		return livro;
	}

	public void setLivro(String livro) {
		this.livro = livro;
	}

	public String getCenso() {
		return censo;
	}

	public void setCenso(String censo) {
		this.censo = censo;
	}

	public String getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}

	public String getInstAtoDeCriacao() {
		return instAtoDeCriacao;
	}

	public void setInstAtoDeCriacao(String instAtoDeCriacao) {
		this.instAtoDeCriacao = instAtoDeCriacao;
	}

	public String getDataInstAtoDeCriacao() {
		return dataInstAtoDeCriacao;
	}

	public void setDataInstAtoDeCriacao(String dataInstAtoDeCriacao) {
		this.dataInstAtoDeCriacao = dataInstAtoDeCriacao;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getConsolidadoModalidade() {
		return consolidadoModalidade;
	}

	public void setConsolidadoModalidade(String consolidadoModalidade) {
		this.consolidadoModalidade = consolidadoModalidade;
	}

	public String getDocConclMmodalidadesModalidade() {
		return docConclMmodalidadesModalidade;
	}

	public void setDocConclMmodalidadesModalidade(String docConclMmodalidadesModalidade) {
		this.docConclMmodalidadesModalidade = docConclMmodalidadesModalidade;
	}

	public String getLeiModalidade() {
		return leiModalidade;
	}

	public void setLeiModalidade(String leiModalidade) {
		this.leiModalidade = leiModalidade;
	}

	public String getDecretoModalidade() {
		return decretoModalidade;
	}

	public void setDecretoModalidade(String decretoModalidade) {
		this.decretoModalidade = decretoModalidade;
	}

	public String getCargaHorariaModalidade() {
		return cargaHorariaModalidade;
	}

	public void setCargaHorariaModalidade(String cargaHorariaModalidade) {
		this.cargaHorariaModalidade = cargaHorariaModalidade;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getTurma() {
		return turma;
	}

	public void setTurma(String turma) {
		this.turma = turma;
	}

	public String getNomeCompl() {
		return nomeCompl;
	}

	public void setNomeCompl(String nomeCompl) {
		this.nomeCompl = nomeCompl;
	}

	public String getAluno() {
		return aluno;
	}

	public void setAluno(String aluno) {
		this.aluno = aluno;
	}

	public String getTipoDoc() {
		return tipoDoc;
	}

	public void setTipoDoc(String tipoDoc) {
		this.tipoDoc = tipoDoc;
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

	public String getNaturalidadeUf() {
		return naturalidadeUf;
	}

	public void setNaturalidadeUf(String naturalidadeUf) {
		this.naturalidadeUf = naturalidadeUf;
	}

	public String getNaturalidade() {
		return naturalidade;
	}

	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
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

	public Date getRgEmissao() {
		return rgEmissao;
	}

	public void setRgEmissao(Date rgEmissao) {
		this.rgEmissao = rgEmissao;
	}

	public String getPai() {
		return pai;
	}

	public void setPai(String pai) {
		this.pai = pai;
	}

	public String getMae() {
		return mae;
	}

	public void setMae(String mae) {
		this.mae = mae;
	}

	public Date getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

	public String getSituacaoFinal() {
		return situacaoFinal;
	}

	public void setSituacaoFinal(String situacaoFinal) {
		this.situacaoFinal = situacaoFinal;
	}

	public Date getDataConclusao() {
		return dataConclusao;
	}

	public void setDataConclusao(Date dataConclusao) {
		this.dataConclusao = dataConclusao;
	}

	public Date getDataEmissaoCertificado() {
		return dataEmissaoCertificado;
	}

	public void setDataEmissaoCertificado(Date dataEmissaoCertificado) {
		this.dataEmissaoCertificado = dataEmissaoCertificado;
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

	public String getCnUf() {
		return cnUf;
	}

	public void setCnUf(String cnUf) {
		this.cnUf = cnUf;
	}

	public String getCnTermo() {
		return cnTermo;
	}

	public void setCnTermo(String cnTermo) {
		this.cnTermo = cnTermo;
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

	public Date getCnEmisao() {
		return cnEmisao;
	}

	public void setCnEmisao(Date cnEmisao) {
		this.cnEmisao = cnEmisao;
	}

	public Boolean getaCorrigir() {
		return aCorrigir;
	}

	public void setaCorrigir(Boolean aCorrigir) {
		this.aCorrigir = aCorrigir;
	}

	public String getDescrErro() {
		return descrErro;
	}

	public void setDescrErro(String descrErro) {
		this.descrErro = descrErro;
	}

	public Boolean getCorrigido() {
		return corrigido;
	}

	public void setCorrigido(Boolean corrigido) {
		this.corrigido = corrigido;
	}

	public Boolean getImpresso() {
		return impresso;
	}

	public void setImpresso(Boolean impresso) {
		this.impresso = impresso;
	}

	public Boolean getReimpresso() {
		return reimpresso;
	}

	public void setReimpresso(Boolean reimpresso) {
		this.reimpresso = reimpresso;
	}

	public Boolean getImprimirAgora() {
		return imprimirAgora;
	}

	public void setImprimirAgora(Boolean imprimirAgora) {
		this.imprimirAgora = imprimirAgora;
	}
	
}
