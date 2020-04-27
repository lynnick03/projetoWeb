package br.com.lynnick.projeto.controller;

import java.util.*;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import br.com.lynnick.projeto.model.Departamento;
import br.com.lynnick.projeto.service.DepartamentoServices;
import br.com.lynnick.projeto.services.dto.DepartamentoDto;


@RestController
@RequestMapping("/api")
public class DepartamentoController {

	@Autowired
	private DepartamentoServices departamentoServices;
	
	@PostMapping("/departamento")
	public ResponseEntity<Departamento> salvar(@RequestBody @Valid Departamento departamento) {
		return ResponseEntity.ok(departamentoServices.salvar(departamento));
	}
	
	@GetMapping("/departamento")
	public ResponseEntity<List<Departamento>> listar(){
	     return ResponseEntity.ok(departamentoServices.listar());

	    }
	
	@GetMapping("/departamento/{id}")
	public ResponseEntity<Departamento> consultaPorId(@PathVariable Long id) {
		return ResponseEntity.ok(departamentoServices.consultaPorId(id));
	}
	
	@GetMapping("/departamento/nome/{nome}")
	public ResponseEntity<DepartamentoDto> buscaPorNome(@PathVariable String nome) throws NotFoundException{
		
		return ResponseEntity.ok(departamentoServices.getDepartamentoByNome(nome));

	}
	
	@PutMapping("/departamento")
	public ResponseEntity<Departamento> update(@RequestBody @Valid Departamento departamento) {
		return ResponseEntity.ok(departamentoServices.update(departamento));
	}
	
	@DeleteMapping("/departamento/{id}")
	public ResponseEntity<Departamento> deletarPorId(@PathVariable Long id) {
		try {
			departamentoServices.deletarPorId(id);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
}
