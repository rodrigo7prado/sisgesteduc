package com.rodrigo7prado.sisGestEduc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rodrigo7prado.sisGestEduc.entities.Curso;


public interface CursoRepository extends JpaRepository<Curso, Long> {

}
