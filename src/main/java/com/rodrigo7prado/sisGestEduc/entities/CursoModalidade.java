package com.rodrigo7prado.sisGestEduc.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rodrigo7prado.sisGestEduc.entities.external.CursoModalidadePk;

@Entity
@Table(name = "tb_cursoModalidade")
public class CursoModalidade implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CursoModalidadePk id = new CursoModalidadePk();
	// outros atributos
	
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
	
	@JsonIgnore
	public Set<Aluno> getAlunos() {
		Set<Aluno> set = new HashSet<>();
		for (AlunoCursoModalidade x : alunosCursosModalidades) {
			set.add(x.getAluno());
		}
		return set;
	}
}
