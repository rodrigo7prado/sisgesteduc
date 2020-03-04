package com.rodrigo7prado.sisGestEduc.dto;

import com.rodrigo7prado.sisGestEduc.entities.Aluno;
import com.rodrigo7prado.sisGestEduc.entities.AlunoPeriodoCurricular;
import com.rodrigo7prado.sisGestEduc.entities.PeriodoCurricular;
import com.rodrigo7prado.sisGestEduc.entities.external.AlunoExternal;
import com.rodrigo7prado.sisGestEduc.enums.StatusDocAluno;

public class AlunoPeriodoCurricularDto4 {

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
	
	private String freq;
	
	private String situacaoFinal;
	
	private StatusDocAluno validDadosPessoais;
	
	private StatusDocAluno validDadosIdentif;
	
	private StatusDocAluno validDadosHeFund;
	
	private StatusDocAluno validDadosHeMedio;
	
	AlunoPeriodoCurricularDto4() {
	}
	
	public AlunoPeriodoCurricularDto4(AlunoPeriodoCurricular obj) {
//		id = obj.getId();
//		anoLetivo = obj.getAnoLetivo();
//		modalidade = obj.getModalidade();
//		curso = obj.getCurso();
//		serie = obj.getSerie();
//		turno = obj.getTurno();
//		turma = obj.getTurma();
//		nomeCompl = obj.getNomeCompl();
//		aluno = obj.getAluno();
//		matricula = obj.getMatricula();
//		freq = obj.getFreq();
//		situacaoFinal = obj.getSituacaoFinal();

	}
	
	public AlunoPeriodoCurricularDto4(AlunoPeriodoCurricular alunoPeriodoCurricular,AlunoExternal alunoExternal,String anoLetivo, String curso, String modalidade,String turma, String nomeCompleto, String matricula) {
		super();
		if (alunoExternal != null) {
//			System.out.println("aa: " + alunoExternal.getNomeCompleto() + ", " + matricula);
			System.out.println("e: " + alunoExternal + ", c: " + alunoPeriodoCurricular);
			
			if ( alunoPeriodoCurricular != null ) {
//				System.out.println("aa: " + alunoPeriodoCurricular.getAluno().getNomeCompleto());
				if (!alunoPeriodoCurricular.getAnoLetivo().equals(null)) {
					this.anoLetivo = alunoPeriodoCurricular.getAnoLetivo();
				}
				
				if (!alunoPeriodoCurricular.getPeriodoCurricular().getCursoModalidade().getCurso().getNome().equals(null)) {
					this.curso = alunoPeriodoCurricular.getPeriodoCurricular().getCursoModalidade().getCurso().getNome();
				} else {
					this.curso = null;
				}
				
				if (!alunoPeriodoCurricular.getPeriodoCurricular().getCursoModalidade().getModalidade().getNome().equals(null)) {
					this.modalidade = alunoPeriodoCurricular.getPeriodoCurricular().getCursoModalidade().getModalidade().getNome();
				}
				
				if (!alunoPeriodoCurricular.getTurma().equals(null)) {
//					this.turma = alunoPeriodoCurricular.getTurma();
				} else {
//					this.turma = alunoExternal.getUltimaTurma();
				}
			}
			
		} else {
//			System.out.println("e: " + alunoExternal + ", c: " + alunoPeriodoCurricular);
		}
		
//		this.anoLetivo = anoLetivo;
//		this.curso = curso;
//		this.modalidade = modalidade;
		this.turma = turma;
		this.nomeCompleto = nomeCompleto;
		this.matricula = matricula;
	}

	
//	public AlunoPeriodoCurricularDto(String anoLetivo,String curso, String modalidade, String serie, String turno,
//			String turma, String nomeCompl, Aluno aluno, String freq, String situacaoFinal) {
//		super();
//		this.anoLetivo = anoLetivo;
//		this.aluno = aluno;
//		this.curso = curso;
//		this.modalidade = modalidade;
//		this.serie = serie;
//		this.turno = turno;
//		this.turma = turma;
//		this.nomeCompleto = nomeCompl;
//		if(aluno != null) {
//			this.matricula = aluno.getMatricula();
////			this.validDadosPessoais = aluno.getValidDadosPessoais();
////			this.validDadosIdentif = aluno.getValidDadosIdentif();
////			this.validDadosHeFund = aluno.getValidDadosHeFund();
////			this.validDadosHeMedio = aluno.getValidDadosHeMedio();
//		} else {
//			this.matricula = null;
//			this.validDadosPessoais = null;
//			this.validDadosIdentif = null;
//			this.validDadosHeFund = null;
//			this.validDadosHeMedio = null;
//		}
////		this.matricula = null;
////		this.validDadosPessoais = null;
//		this.freq = freq;
//		this.situacaoFinal = situacaoFinal;
//	}

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

	public void setFreq(String freq) {
		this.freq = freq;
	}

	public void setSituacaoFinal(String situacaoFinal) {
		this.situacaoFinal = situacaoFinal;
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
