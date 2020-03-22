package com.rodrigo7prado.sisGestEduc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rodrigo7prado.sisGestEduc.entities.FiltroGrupo;

@Repository
public interface FiltroGrupoRepository extends JpaRepository<FiltroGrupo, Long> {

}
