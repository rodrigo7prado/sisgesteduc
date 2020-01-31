package com.rodrigo7prado.sisGestEduc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rodrigo7prado.sisGestEduc.entities.Turma;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Long> {

}
