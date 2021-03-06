package com.rodrigo7prado.sisGestEduc.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rodrigo7prado.sisGestEduc.entities.pk.CursoModalidadePk;

@Entity
@Table(name = "tb_cursoModalidade")
public class CursoModalidade implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CursoModalidadePk id = new CursoModalidadePk();
	// outros atributos
	private String nomeExternal; 
	
	@OneToMany(mappedBy = "id.cursoModalidade")
	Set<PeriodoCurricular> periodosCurriculares = new HashSet<>();
	@OneToMany(mappedBy = "id.cursoModalidade")
	Set<AlunoCursoModalidade> alunosCursosModalidades = new HashSet<>();
	

	public CursoModalidade() {
	}

	public CursoModalidade(Curso curso, Modalidade modalidade) {
		super();
		id.setCurso(curso);
		id.setModalidade(modalidade);
		// outros atributos
	}
	
	@JsonIgnore
	public Curso getCurso() {
		return id.getCurso();
	}
	
	public void setCurso(Curso curso) {
		id.setCurso(curso);
	}
	
	public Modalidade getModalidade() {
		return id.getModalidade();
	}
	
	public void setModalidade(Modalidade modalidade) {
		id.setModalidade(modalidade);
	}
	
	public Set<PeriodoCurricular> getPeriodosCurriculares() {
		return periodosCurriculares;
	}

	public String getNomeExternal() {
		return nomeExternal;
	}

	public void setNomeExternal(String nomeExternal) {
		this.nomeExternal = nomeExternal;
	}

	@JsonIgnore
	public Set<Aluno> getAlunos() {
		Set<Aluno> set = new HashSet<>();
		for (AlunoCursoModalidade x : alunosCursosModalidades) {
			set.add(x.getAluno());
		}
		return set;
	}
}
