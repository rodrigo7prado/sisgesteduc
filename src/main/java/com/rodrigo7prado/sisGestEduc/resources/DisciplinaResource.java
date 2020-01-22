package com.rodrigo7prado.sisGestEduc.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rodrigo7prado.sisGestEduc.entities.Disciplina;
import com.rodrigo7prado.sisGestEduc.services.DisciplinaService;

@RestController
@RequestMapping(value = "/disciplinas")
public class DisciplinaResource {

	@Autowired
	private DisciplinaService service;
	
	@GetMapping
	public ResponseEntity<List<Disciplina>> findAll() {
		List<Disciplina> list = service.findAll();

		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Disciplina> findById(@PathVariable Long id) {
		Disciplina obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping
	public ResponseEntity<Disciplina> insert(@RequestBody Disciplina obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Disciplina> update(@PathVariable Long id, @RequestBody Disciplina obj) {
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}	
}