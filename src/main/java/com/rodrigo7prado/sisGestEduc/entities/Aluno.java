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
	@Column(length = 25,name = "aluno_external_aluno")
//	@Column(length = 25)
	private String matricula;
	private String nomeCompleto;
	@Column(name = "Status_Matricula_Conex")
	private String statusMatriculaConexao;
	private Boolean certificacao;
	@Column(name = "data_conclusao_em")
	private Date dataConclusaoEM;
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
	private String obsHist1;
	private String obsHist2;
	private Boolean faltaEntregaHeFundamental;
	private Boolean faltaEntregaHeMedio;
	private Boolean faltaEntregaRg;
	private Boolean faltaEntregaCn;
	private Boolean dadosConferidos;
	private Boolean maisDeUmCurso;
	@Column(length = 60)
	private String ensFundEscolaConclusao;
	@Column(length = 30)
	private String ensFundMunicipioEscolaConclusao;
	@Column(length = 20)
	private String ensFundAnoEscolaConclusao;
	@Column(length = 20)
	private String ensFundDataEmissaoConclusao;
	@Column(length = 30)
	private String ensFundNumPaginasConclusao;
	@Column(length = 30)
	private String cidadeEstadoEscola;
	@Column(length = 50)
	private String ultimaModalidade;
	@Column(length = 20)
	private String ultimoAno;
	@Column(length = 30)
	private String ultimaTurma;
	@Column(length = 30)
	private String ultimoResultadoFinal;
	@Column(length = 30)
	private String resSerie1;
	@Column(length = 30)
	private String resSerie2;
	@Column(length = 30)
	private String resSerie3;
	@Column(length = 30)
	private String resSerie4;
	@Column(length = 30)
	private String resSerie1Subst;
	@Column(length = 30)
	private String resSerie2Subst;
	@Column(length = 30)
	private String resSerie3Subst;
	@Column(length = 30)
	private String resSerie4Subst;
	@Column(length = 30)
	private String anoSerie1;
	@Column(length = 20)
	private String anoSerie2;
	@Column(length = 20)
	private String anoSerie3;
	@Column(length = 20)
	private String anoSerie4;
	@Column(length = 20)
	private String turmaSerie1;
	@Column(length = 20)
	private String turmaSerie2;
	@Column(length = 20)
	private String turmaSerie3;
	@Column(length = 20)
	private String turmaSerie4;
	@Column(length = 10)
	private String frqG1;
	@Column(length = 10)
	private String frqG2;
	@Column(length = 10)
	private String frqG3;
	@Column(length = 10)
	private String frqG4;
	@Column(length = 10)
	private String chSubst1;
	@Column(length = 10)
	private String chSubst2;
	@Column(length = 10)
	private String chSubst3;
	@Column(length = 10)
	private String chSubst4;
	@Column(length = 10)
	private String freqSubst1;
	@Column(length = 10)
	private String freqSubst2;
	@Column(length = 10)
	private String freqSubst3;
	@Column(length = 10)
	private String freqSubst4;
	@Column(length = 60)
	private String ensMedioEstabEnsAno1;
	@Column(length = 60)
	private String ensMedioEstabEnsAno2;
	@Column(length = 60)
	private String ensMedioEstabEnsAno3;
	@Column(length = 60)
	private String ensMedioEstabEnsAno4;
	@Column(length = 60)
	private String ensMedioCidadeEstadoEstabEnsAno1;
	@Column(length = 60)
	private String ensMedioCidadeEstadoEstabEnsAno2;
	@Column(length = 60)
	private String ensMedioCidadeEstadoEstabEnsAno3;
	@Column(length = 60)
	private String ensMedioCidadeEstadoEstabEnsAno4;
	
	private StatusDocAluno statusDocumentacaoAluno;
	
	@JsonIgnore
	@OneToOne
	@MapsId
	private AlunoExternal alunoExternal;
	@OneToMany(mappedBy = "id.aluno")
	Set<AlunoCurso> alunosCursos = new HashSet<>();
	@OneToMany(mappedBy = "id.aluno")
	Set<AlunoCursoModalidade> alunosCursosModalidades = new HashSet<>();
	@OneToMany(mappedBy = "id.aluno")
	Set<AlunoPeriodoCurricular> alunosPeriodosCurriculares = new HashSet<>();
	@OneToMany(mappedBy = "id.aluno")
	Set<AlunoComponenteCurricular> componentesCurriculares = new HashSet<>();

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
		return obsHist1;
	}

	public void setObsHist1(String obsHist1) {
		this.obsHist1 = obsHist1;
	}

	public String getObsHist2() {
		return obsHist2;
	}

	public void setObsHist2(String obsHist2) {
		this.obsHist2 = obsHist2;
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

	public String getCidadeEstadoEscola() {
		return cidadeEstadoEscola;
	}

	public void setCidadeEstadoEscola(String cidadeEstadoEscola) {
		this.cidadeEstadoEscola = cidadeEstadoEscola;
	}

	public String getUltimaModalidade() {
		return ultimaModalidade;
	}

	public void setUltimaModalidade(String ultimaModalidade) {
		this.ultimaModalidade = ultimaModalidade;
	}

	public String getUltimoAno() {
		return ultimoAno;
	}

	public void setUltimoAno(String ultimoAno) {
		this.ultimoAno = ultimoAno;
	}

	public String getUltimaTurma() {
		return ultimaTurma;
	}

	public void setUltimaTurma(String ultimaTurma) {
		this.ultimaTurma = ultimaTurma;
	}

	public String getUltimoResultadoFinal() {
		return ultimoResultadoFinal;
	}

	public void setUltimoResultadoFinal(String ultimoResultadoFinal) {
		this.ultimoResultadoFinal = ultimoResultadoFinal;
	}

	public String getResSerie1() {
		return resSerie1;
	}

	public void setResSerie1(String resSerie1) {
		this.resSerie1 = resSerie1;
	}

	public String getResSerie2() {
		return resSerie2;
	}

	public void setResSerie2(String resSerie2) {
		this.resSerie2 = resSerie2;
	}

	public String getResSerie3() {
		return resSerie3;
	}

	public void setResSerie3(String resSerie3) {
		this.resSerie3 = resSerie3;
	}

	public String getResSerie4() {
		return resSerie4;
	}

	public void setResSerie4(String resSerie4) {
		this.resSerie4 = resSerie4;
	}

	public String getResSerie1Subst() {
		return resSerie1Subst;
	}

	public void setResSerie1Subst(String resSerie1Subst) {
		this.resSerie1Subst = resSerie1Subst;
	}

	public String getResSerie2Subst() {
		return resSerie2Subst;
	}

	public void setResSerie2Subst(String resSerie2Subst) {
		this.resSerie2Subst = resSerie2Subst;
	}

	public String getResSerie3Subst() {
		return resSerie3Subst;
	}

	public void setResSerie3Subst(String resSerie3Subst) {
		this.resSerie3Subst = resSerie3Subst;
	}

	public String getResSerie4Subst() {
		return resSerie4Subst;
	}

	public void setResSerie4Subst(String resSerie4Subst) {
		this.resSerie4Subst = resSerie4Subst;
	}

	public String getAnoSerie1() {
		return anoSerie1;
	}

	public void setAnoSerie1(String anoSerie1) {
		this.anoSerie1 = anoSerie1;
	}

	public String getAnoSerie2() {
		return anoSerie2;
	}

	public void setAnoSerie2(String anoSerie2) {
		this.anoSerie2 = anoSerie2;
	}

	public String getAnoSerie3() {
		return anoSerie3;
	}

	public void setAnoSerie3(String anoSerie3) {
		this.anoSerie3 = anoSerie3;
	}

	public String getAnoSerie4() {
		return anoSerie4;
	}

	public void setAnoSerie4(String anoSerie4) {
		this.anoSerie4 = anoSerie4;
	}

	public String getTurmaSerie1() {
		return turmaSerie1;
	}

	public void setTurmaSerie1(String turmaSerie1) {
		this.turmaSerie1 = turmaSerie1;
	}

	public String getTurmaSerie2() {
		return turmaSerie2;
	}

	public void setTurmaSerie2(String turmaSerie2) {
		this.turmaSerie2 = turmaSerie2;
	}

	public String getTurmaSerie3() {
		return turmaSerie3;
	}

	public void setTurmaSerie3(String turmaSerie3) {
		this.turmaSerie3 = turmaSerie3;
	}

	public String getTurmaSerie4() {
		return turmaSerie4;
	}

	public void setTurmaSerie4(String turmaSerie4) {
		this.turmaSerie4 = turmaSerie4;
	}

	public String getFrqG1() {
		return frqG1;
	}

	public void setFrqG1(String frqG1) {
		this.frqG1 = frqG1;
	}

	public String getFrqG2() {
		return frqG2;
	}

	public void setFrqG2(String frqG2) {
		this.frqG2 = frqG2;
	}

	public String getFrqG3() {
		return frqG3;
	}

	public void setFrqG3(String frqG3) {
		this.frqG3 = frqG3;
	}

	public String getFrqG4() {
		return frqG4;
	}

	public void setFrqG4(String frqG4) {
		this.frqG4 = frqG4;
	}

	public String getChSubst1() {
		return chSubst1;
	}

	public void setChSubst1(String chSubst1) {
		this.chSubst1 = chSubst1;
	}

	public String getChSubst2() {
		return chSubst2;
	}

	public void setChSubst2(String chSubst2) {
		this.chSubst2 = chSubst2;
	}

	public String getChSubst3() {
		return chSubst3;
	}

	public void setChSubst3(String chSubst3) {
		this.chSubst3 = chSubst3;
	}

	public String getChSubst4() {
		return chSubst4;
	}

	public void setChSubst4(String chSubst4) {
		this.chSubst4 = chSubst4;
	}

	public String getFreqSubst1() {
		return freqSubst1;
	}

	public void setFreqSubst1(String freqSubst1) {
		this.freqSubst1 = freqSubst1;
	}

	public String getFreqSubst2() {
		return freqSubst2;
	}

	public void setFreqSubst2(String freqSubst2) {
		this.freqSubst2 = freqSubst2;
	}

	public String getFreqSubst3() {
		return freqSubst3;
	}

	public void setFreqSubst3(String freqSubst3) {
		this.freqSubst3 = freqSubst3;
	}

	public String getFreqSubst4() {
		return freqSubst4;
	}

	public void setFreqSubst4(String freqSubst4) {
		this.freqSubst4 = freqSubst4;
	}

	public String getEnsMedioEstabEnsAno1() {
		return ensMedioEstabEnsAno1;
	}

	public void setEnsMedioEstabEnsAno1(String ensMedioEstabEnsAno1) {
		this.ensMedioEstabEnsAno1 = ensMedioEstabEnsAno1;
	}

	public String getEnsMedioEstabEnsAno2() {
		return ensMedioEstabEnsAno2;
	}

	public void setEnsMedioEstabEnsAno2(String ensMedioEstabEnsAno2) {
		this.ensMedioEstabEnsAno2 = ensMedioEstabEnsAno2;
	}

	public String getEnsMedioEstabEnsAno3() {
		return ensMedioEstabEnsAno3;
	}

	public void setEnsMedioEstabEnsAno3(String ensMedioEstabEnsAno3) {
		this.ensMedioEstabEnsAno3 = ensMedioEstabEnsAno3;
	}

	public String getEnsMedioEstabEnsAno4() {
		return ensMedioEstabEnsAno4;
	}

	public void setEnsMedioEstabEnsAno4(String ensMedioEstabEnsAno4) {
		this.ensMedioEstabEnsAno4 = ensMedioEstabEnsAno4;
	}

	public String getEnsMedioCidadeEstadoEstabEnsAno1() {
		return ensMedioCidadeEstadoEstabEnsAno1;
	}

	public void setEnsMedioCidadeEstadoEstabEnsAno1(String ensMedioCidadeEstadoEstabEnsAno1) {
		this.ensMedioCidadeEstadoEstabEnsAno1 = ensMedioCidadeEstadoEstabEnsAno1;
	}

	public String getEnsMedioCidadeEstadoEstabEnsAno2() {
		return ensMedioCidadeEstadoEstabEnsAno2;
	}

	public void setEnsMedioCidadeEstadoEstabEnsAno2(String ensMedioCidadeEstadoEstabEnsAno2) {
		this.ensMedioCidadeEstadoEstabEnsAno2 = ensMedioCidadeEstadoEstabEnsAno2;
	}

	public String getEnsMedioCidadeEstadoEstabEnsAno3() {
		return ensMedioCidadeEstadoEstabEnsAno3;
	}

	public void setEnsMedioCidadeEstadoEstabEnsAno3(String ensMedioCidadeEstadoEstabEnsAno3) {
		this.ensMedioCidadeEstadoEstabEnsAno3 = ensMedioCidadeEstadoEstabEnsAno3;
	}

	public String getEnsMedioCidadeEstadoEstabEnsAno4() {
		return ensMedioCidadeEstadoEstabEnsAno4;
	}

	public void setEnsMedioCidadeEstadoEstabEnsAno4(String ensMedioCidadeEstadoEstabEnsAno4) {
		this.ensMedioCidadeEstadoEstabEnsAno4 = ensMedioCidadeEstadoEstabEnsAno4;
	}

	public StatusDocAluno getStatusDocumentacaoAluno() {
		return statusDocumentacaoAluno;
	}

	public void setStatusDocumentacaoAluno(StatusDocAluno statusDocumentacaoAluno) {
		this.statusDocumentacaoAluno = statusDocumentacaoAluno;
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
	
	public Set<AlunoComponenteCurricular> getComponentesCurriculares() {
		return componentesCurriculares;
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
		return "Aluno [matricula=" + matricula + ", nomeCompleto=" + nomeCompleto + ", statusMatriculaConexao="
				+ statusMatriculaConexao + ", certificacao=" + certificacao + ", dataConclusaoEM=" + dataConclusaoEM
				+ ", dataNasc=" + dataNasc + ", nomePai=" + nomePai + ", nomeMae=" + nomeMae + ", sexo=" + sexo
				+ ", nacionalidade=" + nacionalidade + ", naturalidade=" + naturalidade + ", naturalidadeUF="
				+ naturalidadeUF + ", rg=" + rg + ", rgEmissor=" + rgEmissor + ", rgEmissorUf=" + rgEmissorUf
				+ ", rgDataEmissao=" + rgDataEmissao + ", cnCartorio=" + cnCartorio + ", cnMunicipio=" + cnMunicipio
				+ ", cnUF=" + cnUF + ", cnTermo=" + cnTermo + ", cnLivro=" + cnLivro + ", cnFolha=" + cnFolha
				+ ", cnDataEmissao=" + cnDataEmissao + ", dyn_mais_de_um_curso=" + dyn_mais_de_um_curso + ", obsHist="
				+ obsHist + ", obsHist1=" + obsHist1 + ", obsHist2=" + obsHist2 + ", faltaEntregaHeFundamental="
				+ faltaEntregaHeFundamental + ", faltaEntregaHeMedio=" + faltaEntregaHeMedio + ", faltaEntregaRg="
				+ faltaEntregaRg + ", faltaEntregaCn=" + faltaEntregaCn + ", dadosConferidos=" + dadosConferidos
				+ ", maisDeUmCurso=" + maisDeUmCurso + ", ensFundEscolaConclusao=" + ensFundEscolaConclusao
				+ ", ensFundMunicipioEscolaConclusao=" + ensFundMunicipioEscolaConclusao
				+ ", ensFundAnoEscolaConclusao=" + ensFundAnoEscolaConclusao + ", ensFundDataEmissaoConclusao="
				+ ensFundDataEmissaoConclusao + ", ensFundNumPaginasConclusao=" + ensFundNumPaginasConclusao
				+ ", cidadeEstadoEscola=" + cidadeEstadoEscola + ", ultimaModalidade=" + ultimaModalidade
				+ ", ultimoAno=" + ultimoAno + ", ultimaTurma=" + ultimaTurma + ", ultimoResultadoFinal="
				+ ultimoResultadoFinal + ", resSerie1=" + resSerie1 + ", resSerie2=" + resSerie2 + ", resSerie3="
				+ resSerie3 + ", resSerie4=" + resSerie4 + ", resSerie1Subst=" + resSerie1Subst + ", resSerie2Subst="
				+ resSerie2Subst + ", resSerie3Subst=" + resSerie3Subst + ", resSerie4Subst=" + resSerie4Subst
				+ ", anoSerie1=" + anoSerie1 + ", anoSerie2=" + anoSerie2 + ", anoSerie3=" + anoSerie3 + ", anoSerie4="
				+ anoSerie4 + ", turmaSerie1=" + turmaSerie1 + ", turmaSerie2=" + turmaSerie2 + ", turmaSerie3="
				+ turmaSerie3 + ", turmaSerie4=" + turmaSerie4 + ", frqG1=" + frqG1 + ", frqG2=" + frqG2 + ", frqG3="
				+ frqG3 + ", frqG4=" + frqG4 + ", chSubst1=" + chSubst1 + ", chSubst2=" + chSubst2 + ", chSubst3="
				+ chSubst3 + ", chSubst4=" + chSubst4 + ", freqSubst1=" + freqSubst1 + ", freqSubst2=" + freqSubst2
				+ ", freqSubst3=" + freqSubst3 + ", freqSubst4=" + freqSubst4 + ", ensMedioEstabEnsAno1="
				+ ensMedioEstabEnsAno1 + ", ensMedioEstabEnsAno2=" + ensMedioEstabEnsAno2 + ", ensMedioEstabEnsAno3="
				+ ensMedioEstabEnsAno3 + ", ensMedioEstabEnsAno4=" + ensMedioEstabEnsAno4
				+ ", ensMedioCidadeEstadoEstabEnsAno1=" + ensMedioCidadeEstadoEstabEnsAno1
				+ ", ensMedioCidadeEstadoEstabEnsAno2=" + ensMedioCidadeEstadoEstabEnsAno2
				+ ", ensMedioCidadeEstadoEstabEnsAno3=" + ensMedioCidadeEstadoEstabEnsAno3
				+ ", ensMedioCidadeEstadoEstabEnsAno4=" + ensMedioCidadeEstadoEstabEnsAno4
				+ ", statusDocumentacaoAluno=" + statusDocumentacaoAluno + ", alunoExternal=" + alunoExternal
				+ ", alunosCursos=" + alunosCursos + ", alunosCursosModalidades=" + alunosCursosModalidades
				+ ", alunosPeriodosCurriculares=" + alunosPeriodosCurriculares + ", componentesCurriculares="
				+ componentesCurriculares + "]";
	}
	
	
}
