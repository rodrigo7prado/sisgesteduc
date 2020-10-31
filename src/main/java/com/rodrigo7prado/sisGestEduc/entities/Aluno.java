package com.rodrigo7prado.sisGestEduc.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rodrigo7prado.sisGestEduc.entities.external.AlunoExternal;
import com.rodrigo7prado.sisGestEduc.enums.StatusDocAluno;

@Entity
@Table(name = "tb_aluno")
public class Aluno implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(length = 25)
	private String matricula;	
	private String nomeCompleto;
	private Date dataNasc;
	private String nomePai;
	private String nomeMae;
	@Column(length = 10)
	private String sexo;
	@Column(length = 20)
	private String nacionalidade;
	@Column(length = 30)
	private String naturalidade;
	@Column(length = 20)
	private String naturalidadeUF;
	@Column(length = 20)
	private String rg;
	@Column(length = 20)
	private String rgEmissor;
	@Column(length = 20)
	private String rgEmissorUf;
	@Column(length = 20)
	private String rgDataEmissao;
	@Column(length = 120)
	private String cnCartorio;
	@Column(length = 30)
	private String cnMunicipio;
	@Column(length = 2)
	private String cnUF;
	@Column(length = 20)
	private String cnTermo;
	@Column(length = 10)
	private String cnLivro;
	@Column(length = 10)
	private String cnFolha;
	@Column(length = 20)
	private String cnDataEmissao;
	private Boolean dyn_mais_de_um_curso;
	private String obsHist;
	private String obsHist1o;
	private String obsHist2o;
	private Boolean faltaEntregaHeFundamental;
	private Boolean faltaEntregaHeMedio;
	private Boolean faltaEntregaRg;
	private Boolean faltaEntregaCn;
	private Boolean dadosConferidos;
	private Boolean maisDeUmCurso;
	@Column(length = 60)
	private StatusDocAluno statusDocumentacaoAluno;
	
	private String nomeCompleto2;
	private Date dataNasc2;
	private String nomePai2;
	private String nomeMae2;
	@Column(length = 10)
	private String sexo2;
	@Column(length = 20)
	private String nacionalidade2;
	@Column(length = 30)
	private String naturalidade2;
	@Column(length = 20)
	private String naturalidadeUF2;
	@Column(length = 20)
	private String rg2;
	@Column(length = 20)
	private String rgEmissor2;
	@Column(length = 20)
	private String rgEmissorUf2;
	@Column(length = 20)
	private String rgDataEmissao2;
	@Column(length = 120)
	private String cnCartorio2;
	@Column(length = 30)
	private String cnMunicipio2;
	@Column(length = 2)
	private String cnUF2;
	@Column(length = 20)
	private String cnTermo2;
	@Column(length = 10)
	private String cnLivro2;
	@Column(length = 10)
	private String cnFolha2;
	@Column(length = 20)
	private String cnDataEmissao2;
	
	
	
	
	@JsonIgnore
	@OneToOne
//	@MapsId
	private AlunoExternal alunoExternal;
	@OneToMany(mappedBy = "id.aluno")
	Set<AlunoCurso> alunosCursos = new HashSet<>();
	@OneToMany(mappedBy = "id.aluno")
	Set<AlunoCursoModalidade> alunosCursosModalidades = new HashSet<>();
	@OneToMany(mappedBy = "id.aluno")
	Set<AlunoPeriodoCurricular> alunosPeriodosCurriculares = new HashSet<>();
	@OneToMany(mappedBy = "id.aluno")
	Set<AlunoComponenteCurricular> alunosComponentesCurriculares = new HashSet<>();

	public Aluno() {
	}

	public Aluno(String matricula, String nomeCompleto, String turma) {
		super();
		this.matricula = matricula;
		this.nomeCompleto = nomeCompleto;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
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

	public String getRgEmissorUf() {
		return rgEmissorUf;
	}

	public void setRgEmissorUf(String rgEmissorUf) {
		this.rgEmissorUf = rgEmissorUf;
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

	public String getCnDataEmissao() {
		return cnDataEmissao;
	}

	public void setCnDataEmissao(String cnDataEmissao) {
		this.cnDataEmissao = cnDataEmissao;
	}

	public Boolean getDyn_mais_de_um_curso() {
		return dyn_mais_de_um_curso;
	}

	public void setDyn_mais_de_um_curso(Boolean dyn_mais_de_um_curso) {
		this.dyn_mais_de_um_curso = dyn_mais_de_um_curso;
	}

	public String getObsHist() {
		return obsHist;
	}

	public void setObsHist(String obsHist) {
		this.obsHist = obsHist;
	}

	public String getObsHist1() {
		return obsHist1o;
	}

	public void setObsHist1(String obsHist1o) {
		this.obsHist1o = obsHist1o;
	}

	public String getObsHist2() {
		return obsHist2o;
	}

	public void setObsHist2(String obsHist2o) {
		this.obsHist2o = obsHist2o;
	}

	public Boolean getFaltaEntregaHeFundamental() {
		return faltaEntregaHeFundamental;
	}

	public void setFaltaEntregaHeFundamental(Boolean faltaEntregaHeFundamental) {
		this.faltaEntregaHeFundamental = faltaEntregaHeFundamental;
	}

	public Boolean getFaltaEntregaHeMedio() {
		return faltaEntregaHeMedio;
	}

	public void setFaltaEntregaHeMedio(Boolean faltaEntregaHeMedio) {
		this.faltaEntregaHeMedio = faltaEntregaHeMedio;
	}

	public Boolean getFaltaEntregaRg() {
		return faltaEntregaRg;
	}

	public void setFaltaEntregaRg(Boolean faltaEntregaRg) {
		this.faltaEntregaRg = faltaEntregaRg;
	}

	public Boolean getFaltaEntregaCn() {
		return faltaEntregaCn;
	}

	public void setFaltaEntregaCn(Boolean faltaEntregaCn) {
		this.faltaEntregaCn = faltaEntregaCn;
	}

	public Boolean getDadosConferidos() {
		return dadosConferidos;
	}

	public void setDadosConferidos(Boolean dadosConferidos) {
		this.dadosConferidos = dadosConferidos;
	}

	public Boolean getMaisDeUmCurso() {
		return maisDeUmCurso;
	}

	public void setMaisDeUmCurso(Boolean maisDeUmCurso) {
		this.maisDeUmCurso = maisDeUmCurso;
	}

	public StatusDocAluno getStatusDocumentacaoAluno() {
		return statusDocumentacaoAluno;
	}

	public void setStatusDocumentacaoAluno(StatusDocAluno statusDocumentacaoAluno) {
		this.statusDocumentacaoAluno = statusDocumentacaoAluno;
	}
	
	public String getObsHist1o() {
		return obsHist1o;
	}

	public void setObsHist1o(String obsHist1o) {
		this.obsHist1o = obsHist1o;
	}

	public String getObsHist2o() {
		return obsHist2o;
	}

	public void setObsHist2o(String obsHist2o) {
		this.obsHist2o = obsHist2o;
	}

	public String getNomeCompleto2() {
		return nomeCompleto2;
	}

	public void setNomeCompleto2(String nomeCompleto2) {
		this.nomeCompleto2 = nomeCompleto2;
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

	public String getSexo2() {
		return sexo2;
	}

	public void setSexo2(String sexo2) {
		this.sexo2 = sexo2;
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

	public String getRgDataEmissao2() {
		return rgDataEmissao2;
	}

	public void setRgDataEmissao2(String rgDataEmissao2) {
		this.rgDataEmissao2 = rgDataEmissao2;
	}

	public String getCnCartorio2() {
		return cnCartorio2;
	}

	public void setCnCartorio2(String cnCartorio2) {
		this.cnCartorio2 = cnCartorio2;
	}

	public String getCnMunicipio2() {
		return cnMunicipio2;
	}

	public void setCnMunicipio2(String cnMunicipio2) {
		this.cnMunicipio2 = cnMunicipio2;
	}

	public String getCnUF2() {
		return cnUF2;
	}

	public void setCnUF2(String cnUF2) {
		this.cnUF2 = cnUF2;
	}

	public String getCnTermo2() {
		return cnTermo2;
	}

	public void setCnTermo2(String cnTermo2) {
		this.cnTermo2 = cnTermo2;
	}

	public String getCnLivro2() {
		return cnLivro2;
	}

	public void setCnLivro2(String cnLivro2) {
		this.cnLivro2 = cnLivro2;
	}

	public String getCnFolha2() {
		return cnFolha2;
	}

	public void setCnFolha2(String cnFolha2) {
		this.cnFolha2 = cnFolha2;
	}

	public String getCnDataEmissao2() {
		return cnDataEmissao2;
	}

	public void setCnDataEmissao2(String cnDataEmissao2) {
		this.cnDataEmissao2 = cnDataEmissao2;
	}

	public AlunoExternal getAlunoExternal() {
		return alunoExternal;
	}

	public void setAlunoExternal(AlunoExternal alunoExternal) {
		this.alunoExternal = alunoExternal;
	}

	public Set<AlunoCurso> getAlunosCursos() {
		return alunosCursos;
	}
	
	public Set<AlunoCursoModalidade> getAlunosCursosModalidades() {
		return alunosCursosModalidades;
	}
	
	public Set<AlunoPeriodoCurricular> getAlunosPeriodosCurriculares() {
		return alunosPeriodosCurriculares;
	}
	
	public Set<AlunoComponenteCurricular> getAlunosComponentesCurriculares() {
		return alunosComponentesCurriculares;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
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
		Aluno other = (Aluno) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Aluno [matricula=" + matricula + ", nomeCompleto=" + nomeCompleto + ", dataNasc=" + dataNasc + ", nomePai=" + nomePai + ", nomeMae=" + nomeMae + ", sexo=" + sexo
				+ ", nacionalidade=" + nacionalidade + ", naturalidade=" + naturalidade + ", naturalidadeUF="
				+ naturalidadeUF + ", rg=" + rg + ", rgEmissor=" + rgEmissor + ", rgEmissorUf=" + rgEmissorUf
				+ ", rgDataEmissao=" + rgDataEmissao + ", cnCartorio=" + cnCartorio + ", cnMunicipio=" + cnMunicipio
				+ ", cnUF=" + cnUF + ", cnTermo=" + cnTermo + ", cnLivro=" + cnLivro + ", cnFolha=" + cnFolha
				+ ", cnDataEmissao=" + cnDataEmissao + ", dyn_mais_de_um_curso=" + dyn_mais_de_um_curso + ", obsHist="
				+ obsHist + ", obsHist1o=" + obsHist1o + ", obsHist2o=" + obsHist2o + ", faltaEntregaHeFundamental="
				+ faltaEntregaHeFundamental + ", faltaEntregaHeMedio=" + faltaEntregaHeMedio + ", faltaEntregaRg="
				+ faltaEntregaRg + ", faltaEntregaCn=" + faltaEntregaCn + ", dadosConferidos=" + dadosConferidos
				+ ", maisDeUmCurso=" + maisDeUmCurso + ", statusDocumentacaoAluno=" + statusDocumentacaoAluno + ", alunoExternal=" + alunoExternal
				+ ", alunosCursos=" + alunosCursos + ", alunosCursosModalidades=" + alunosCursosModalidades
				+ ", alunosPeriodosCurriculares=" + alunosPeriodosCurriculares + ", componentesCurriculares="
				+ alunosComponentesCurriculares + "]";
	}

}
