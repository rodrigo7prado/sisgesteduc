package com.rodrigo7prado.sisGestEduc.entities.pk;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import com.rodrigo7prado.sisGestEduc.entities.Aluno;
import com.rodrigo7prado.sisGestEduc.entities.CursoModalidade;

@Embeddable
public class AlunoCursoModalidadePk  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "aluno_id")
	private Aluno aluno;
		
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name = "curso_id",insertable=false, updatable=false),
		@JoinColumn(name = "modalidade_id",insertable=false, updatable=false)
	})
	
	private CursoModalidade cursoModalidade;
	
	public Aluno getAluno() {
		return aluno;
	}
	
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public CursoModalidade getCursoModalidade() {
		return cursoModalidade;
	}

	public void setCursoModalidade(CursoModalidade cursoModalidade) {
		this.cursoModalidade = cursoModalidade;
	}
	// hashcode e equals omitidos
}