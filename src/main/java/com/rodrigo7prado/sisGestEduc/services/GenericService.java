package com.rodrigo7prado.sisGestEduc.services;

import java.util.List;

public interface GenericService<T extends Object> {

	T insert(T entity);
    
    T update(Long id, T obj);
  
    void delete(T entity);
  
    void delete(Long id);
  
    T find(Long id);
  
    List<T> findAll();
}
