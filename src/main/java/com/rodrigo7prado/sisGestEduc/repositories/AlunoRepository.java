package com.rodrigo7prado.sisGestEduc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rodrigo7prado.sisGestEduc.entities.Aluno;


public interface AlunoRepository extends JpaRepository<Aluno, Long> {

}
