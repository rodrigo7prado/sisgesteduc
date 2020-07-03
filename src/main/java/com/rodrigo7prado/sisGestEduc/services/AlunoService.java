package com.rodrigo7prado.sisGestEduc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodrigo7prado.sisGestEduc.entities.Aluno;
import com.rodrigo7prado.sisGestEduc.repositories.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository repository;
	
	public List<Aluno> findAll() {
		return repository.findAll();
	}
	
//	public Aluno findById(String id) {
//		Optional<Aluno> obj = repository.findById(id);
//		return obj.get();
//	}
	
	public Aluno findOneByMatricula(String matricula) {
//		Optional<Aluno> obj = repository.findByMatricula(matricula);
//		
//		System.out.println("Obj: " + obj);
		
		
		System.out.println("repository: " + repository.findOneByMatricula(matricula));
		
		
		return new Aluno();
//		return obj.get();
	}
	
	public Aluno findByMatricula(String matricula) {
//		Optional<Aluno> obj = repository.findByMatricula(matricula);
//		
//		System.out.println("Obj: " + obj);
		
		
//		System.out.println("repository: " + repository.findByMatricula(matricula));
		
		Aluno obj = repository.findByMatricula(matricula);
		
		return obj;
		
//		return new Aluno();
//		return obj.get();
	}
	
	public Aluno insert(Aluno obj) {
		return repository.save(obj); 
//		return new Aluno();
	}
	
	public void insert2(Aluno obj) {
		System.out.println("alou");
	}
	
//	public void insert3() {
//		System.out.println("alou");
//	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
//	public Aluno update(Long id, Aluno obj) {
//		Aluno entity = repository.getOne(id);
//		updateData(entity, obj);
//		return repository.save(entity);
//	}
	
	public Aluno update(String matricula, Aluno obj) {
		Aluno entity = repository.findByMatricula(matricula);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(Aluno entity, Aluno obj) {
		entity.setNomeCompleto(obj.getNomeCompleto());
	}

	public List<Aluno> findBy() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Aluno> findFilterConcluintes() {
		List<Aluno> listDto = repository.findFilterConcluintes();
		
		return listDto;
	}
}
