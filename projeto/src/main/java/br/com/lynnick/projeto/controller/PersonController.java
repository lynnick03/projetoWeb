package br.com.lynnick.projeto.controller;

import java.util.*;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import br.com.lynnick.projeto.model.Person;
import br.com.lynnick.projeto.service.PersonServices;


@RestController
@RequestMapping("/api")
public class PersonController {

	
	@Autowired
	private PersonServices personServices;
	
	@PostMapping("/pessoa")
	public ResponseEntity<Person> salvar(@RequestBody @Valid Person pessoa) {
		return ResponseEntity.ok(personServices.salvar(pessoa));
	}
	
	@GetMapping("/pessoa")
	public ResponseEntity<List<Person>> listar(){
	     return ResponseEntity.ok(personServices.listar());

	    }
	
	@GetMapping("/pessoa/{id}")
	public ResponseEntity<Person> consultaPorId(@PathVariable Long id) {
		return ResponseEntity.ok(personServices.consultaPorId(id));
	}
	
	/*@GetMapping("/pessoa/nome/{nome}")
	public ResponseEntity<PersonDto> buscaPorNome(@PathVariable String nome){
		PersonDto personDto = null;
		try {
			personDto = personServices.getDepartamentoByNome(nome);
		} catch (NotFoundException e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(personDto);
	}*/
	
	@PutMapping("/pessoa")
	public ResponseEntity<Person> update(@RequestBody @Valid Person person) {
		return ResponseEntity.ok(personServices.update(person));
	}
	
	@DeleteMapping("/pessoa/{id}")
	public ResponseEntity<Person> deletarPorId(@PathVariable Long id) {
		try {
			personServices.deletarPorId(id);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
}
