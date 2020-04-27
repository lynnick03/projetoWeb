package br.com.lynnick.projeto.controller;

import java.util.*;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import br.com.lynnick.projeto.model.ProjectHistory;
import br.com.lynnick.projeto.service.ProjectHistoryServices;


@RestController
@RequestMapping("/api")
public class ProjectHistoryController {

	
	
	@Autowired
	private ProjectHistoryServices projectHistoryServices;
	
	@PostMapping("/projetohistory")
	public ResponseEntity<ProjectHistory> salvar(@RequestBody @Valid ProjectHistory ph) {
		return ResponseEntity.ok(projectHistoryServices.salvar(ph));
	}
	
	@GetMapping("/projetohistory")
	public ResponseEntity<List<ProjectHistory>> listar(){
	     return ResponseEntity.ok(projectHistoryServices.listar());

	    }
	
	@GetMapping("/projetohistory/{id}")
	public ResponseEntity<ProjectHistory> consultaPorId(@PathVariable Long id) {
		return ResponseEntity.ok(projectHistoryServices.consultaPorId(id));
	}
	
	
	@PutMapping("/projetohistory")
	public ResponseEntity<ProjectHistory> update(@RequestBody @Valid ProjectHistory ph) {
		return ResponseEntity.ok(projectHistoryServices.update(ph));
	}
	
	@DeleteMapping("/projetohistory/{id}")
	public ResponseEntity<ProjectHistory> deletarPorId(@PathVariable Long id) {
		try {
			projectHistoryServices.deletarPorId(id);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
}
