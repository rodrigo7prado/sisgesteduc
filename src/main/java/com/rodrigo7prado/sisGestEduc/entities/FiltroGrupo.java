package com.rodrigo7prado.sisGestEduc.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_filtro_grupo")
public class FiltroGrupo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nomeFiltroGrupo;
	
	public FiltroGrupo() {
	}
	public FiltroGrupo(Long id, String nomeFiltroGrupo) {
		this.id = id;
		this.nomeFiltroGrupo = nomeFiltroGrupo;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomeFiltroGrupo() {
		return nomeFiltroGrupo;
	}
	public void setNomeFiltroGrupo(String nomeFiltroGrupo) {
		this.nomeFiltroGrupo = nomeFiltroGrupo;
	}
}
