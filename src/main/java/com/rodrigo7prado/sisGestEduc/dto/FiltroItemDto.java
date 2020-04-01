package com.rodrigo7prado.sisGestEduc.dto;

public class FiltroItemDto {
	private Long id;
	private Long filtroGrupoId;
	private String filtroItemNome;
	
	public FiltroItemDto() {
	}
	
	public FiltroItemDto(Long id,Long filtroGrupoId,String filtroItemNome) {
		this.id = id;
		this.filtroGrupoId = filtroGrupoId;
		this.filtroItemNome = filtroItemNome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
}
