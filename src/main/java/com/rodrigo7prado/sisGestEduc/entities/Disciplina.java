package com.rodrigo7prado.sisGestEduc.entities;

import java.io.Serializable;
import java.util.HashSet;
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
@Table(name = "tb_disciplina")
public class Disciplina implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String nomeExternal;

	@OneToMany(mappedBy = "id.disciplina")
	Set<ComponenteCurricular> componentesCurriculares = new HashSet<>();
	
	public Disciplina() {
	}

	public Disciplina(Long id, String nome, String nomeExternal) {
		super();
		this.id = id;
		this.nome = nome;
		this.nomeExternal = nomeExternal;
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
	
	public Set<ComponenteCurricular> getComponentesCurriculares() {
		return componentesCurriculares;
	}

	public void setComponentesCurriculares(Set<ComponenteCurricular> componentesCurriculares) {
		this.componentesCurriculares = componentesCurriculares;
	}

	public String getNomeExternal() {
		return nomeExternal;
	}

	public void setNomeExternal(String nomeExternal) {
		this.nomeExternal = nomeExternal;
	}

	@JsonIgnore
	public Set<PeriodoCurricular> getPeriodoCurriculars() {
		Set<PeriodoCurricular> set = new HashSet<>();
		for (ComponenteCurricular x : componentesCurriculares) {
			set.add(x.getPeriodoCurricular());
		}
		return set;
	}
}
