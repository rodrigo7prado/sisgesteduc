package com.rodrigo7prado.sisGestEduc.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_periodoCurricular")
public class PeriodoCurricular implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	
//	@ManyToOne
//	@JoinColumn(name = "modalidadeId")
//	private Modalidade modalidade;
	
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name = "curso_id"),
		@JoinColumn(name = "modalidade_id")
	})
	private CursoModalidade cursoModalidade;
	
	@OneToMany(mappedBy = "id.periodoCurricular")
	Set<ComponenteCurricular> componentesCurriculares = new HashSet<>();
	@OneToMany(mappedBy = "id.periodoCurricular")
	Set<AlunoPeriodoLetivo> alunosPeriodosLetivos = new HashSet<>();

	public PeriodoCurricular() {
	}

	public PeriodoCurricular(Long id, String nome, CursoModalidade cursoModalidade) {
		super();
		this.id = id;
		this.nome = nome;
		this.cursoModalidade = cursoModalidade;
//		this.modalidade = modalidade;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public CursoModalidade getModalidade() {
		return cursoModalidade;
	}

	public void setModalidade(CursoModalidade cursoModalidade) {
		this.cursoModalidade = cursoModalidade;
	}
	
	@JsonIgnore
	public Set<Aluno> getAlunos() {
		Set<Aluno> set = new HashSet<>();
		for (AlunoPeriodoLetivo x : alunosPeriodosLetivos) {
			set.add(x.getAluno());
		}
		return set;
	}

	@Override
	public String toString() {
		return "PeriodoCurricular [id=" + id + ", nome=" + nome + ", cursoModalidade=" + cursoModalidade
				+ ", componentesCurriculares=" + componentesCurriculares + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		PeriodoCurricular other = (PeriodoCurricular) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
