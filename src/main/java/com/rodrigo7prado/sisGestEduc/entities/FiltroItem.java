package com.rodrigo7prado.sisGestEduc.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_filtro_item")
public class FiltroItem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nomeFiltroItem;
	
	@ManyToOne
	@JoinColumn(name = "filtroGrupoId")
	private FiltroGrupo filtroGrupo;
	
	public FiltroItem() {
	}
	public FiltroItem(Long id, FiltroGrupo filtroGrupo, String nomeFiltroItem) {
		this.id = id;
		this.filtroGrupo = filtroGrupo;
		this.nomeFiltroItem = nomeFiltroItem;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomeFiltroItem() {
		return nomeFiltroItem;
	}
	public void setNomeFiltroItem(String nomeFiltroItem) {
		this.nomeFiltroItem = nomeFiltroItem;
	}
}
