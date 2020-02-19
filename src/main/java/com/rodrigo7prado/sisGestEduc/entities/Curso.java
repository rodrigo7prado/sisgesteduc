package com.rodrigo7prado.sisGestEduc.entities;

import java.io.Serializable;
import java.util.HashSet;
<<<<<<< HEAD
import java.util.List;
=======
>>>>>>> 94f0aa07d501f57f566704b1603dc63e477439d9
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

//import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_curso")
public class Curso implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	
<<<<<<< HEAD
//	@JsonIgnore
	@OneToMany(mappedBy = "curso")
	private List<Modalidade> modalidades;
=======
	@OneToMany(mappedBy = "id.curso")
	Set<CursoModalidade> cursosModalidades = new HashSet<>();
>>>>>>> 94f0aa07d501f57f566704b1603dc63e477439d9
	
	@OneToMany(mappedBy = "id.curso")
	Set<AlunoCurso> alunosCursos = new HashSet<>();

	public Curso() {
	}

	public Curso(Long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
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
	
	public Set<CursoModalidade> getCursosModalidades() {
		return cursosModalidades;
	}
	
	@JsonIgnore
	public Set<Aluno> getAlunos() {
		Set<Aluno> set = new HashSet<>();
		for (AlunoCurso x : alunosCursos) {
			set.add(x.getAluno());
		}
		return set;
	}
	
	@JsonIgnore
	public Set<Aluno> getAlunos() {
		Set<Aluno> set = new HashSet<>();
		for (AlunoCurso x : alunosCursos) {
			set.add(x.getAluno());
		}
		return set;
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
		Curso other = (Curso) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
