package com.rodrigo7prado.sisGestEduc.entities.pk;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import com.rodrigo7prado.sisGestEduc.entities.CursoModalidade;

@Embeddable
public class PeriodoCurricularPk  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name = "curso_id"),
		@JoinColumn(name = "modalidade_id")
	})
	private CursoModalidade cursoModalidade;
		
	private String nome;
	
	public CursoModalidade getCursoModalidade() {
		return cursoModalidade;
	}
	
	public void setCursoModalidade(CursoModalidade cursoModalidade) {
		this.cursoModalidade = cursoModalidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	// hashcode e equals omitidos
}