package com.rodrigo7prado.sisGestEduc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rodrigo7prado.sisGestEduc.dto.FiltroItemDto;
import com.rodrigo7prado.sisGestEduc.entities.FiltroItem;

@Repository
public interface FiltroItemRepository extends JpaRepository<FiltroItem, Long> {

	@Query("SELECT DISTINCT new com.rodrigo7prado.sisGestEduc.dto.FiltroItemDto("
			+ "f.id, f.filtroGrupo.id,f.nomeFiltroItem"
			+ ") FROM FiltroItem f "
			+ "ORDER BY  f.filtroGrupo.id, f.id")
	List<FiltroItemDto> findAllDto();

}
