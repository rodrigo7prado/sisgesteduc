package com.rodrigo7prado.sisGestEduc.dto;

public class FiltroItemDto {
	private Integer id;
	private Long filtroGrupoId;
	private String filtroItemNome;
	
	public FiltroItemDto() {
	}
	
	public FiltroItemDto(Integer id,Long filtroGrupoId,String filtroItemNome) {
		this.id = id;
		this.filtroGrupoId = filtroGrupoId;
		this.filtroItemNome = filtroItemNome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Long getFiltroGrupoId() {
		return filtroGrupoId;
	}

	public void setFiltroGrupoId(Long filtroGrupoId) {
		this.filtroGrupoId = filtroGrupoId;
	}

	public String getFiltroItemNome() {
		return filtroItemNome;
	}

	public void setFiltroItemNome(String filtroItemNome) {
		this.filtroItemNome = filtroItemNome;
	}

	@Override
	public String toString() {
		return "FiltroItemDto [id=" + id + ", filtroGrupoId=" + filtroGrupoId + ", filtroItemNome=" + filtroItemNome
				+ "]";
	}
}
