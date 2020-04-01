package com.rodrigo7prado.sisGestEduc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rodrigo7prado.sisGestEduc.entities.FiltroItem;

@Repository
public interface FiltroItemRepository extends JpaRepository<FiltroItem, Long> {

}
