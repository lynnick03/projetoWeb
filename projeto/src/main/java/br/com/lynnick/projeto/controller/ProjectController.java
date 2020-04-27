package br.com.lynnick.projeto.controller;

import java.util.*;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import br.com.lynnick.projeto.model.Project;
import br.com.lynnick.projeto.service.ProjectServices;
import br.com.lynnick.projeto.services.dto.ProjectDto;


@RestController
@RequestMapping("/api")
public class ProjectController {
	
	@Autowired
	private ProjectServices projectServices;
	
	@PostMapping("/projeto")
	public ResponseEntity<Project> salvar(@RequestBody @Valid Project projeto) {
		return ResponseEntity.ok(projectServices.salvar(projeto));
	}
	
	@GetMapping("/projeto")
	public ResponseEntity<List<Project>> listar(){
	     return ResponseEntity.ok(projectServices.listar());

	    }
	
	@GetMapping("/projeto/{id}")
	public ResponseEntity<Project> consultaPorId(@PathVariable Long id) {
		return ResponseEntity.ok(projectServices.consultaPorId(id));
	}
	
	@GetMapping("/projeto/nome/{nome}")
	public ResponseEntity<ProjectDto> buscaPorNome(@PathVariable String nome){
		ProjectDto projetoDto = null;
		try {
			projetoDto = projectServices.getDepartamentoByNome(nome);
		} catch (NotFoundException e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(projetoDto);
	}
	
	@PutMapping("/projeto")
	public ResponseEntity<Project> update(@RequestBody @Valid Project projeto) {
		return ResponseEntity.ok(projectServices.update(projeto));
	}
	
	@DeleteMapping("/projeto/{id}")
	public ResponseEntity<Project> deletarPorId(@PathVariable Long id) {
		try {
			projectServices.deletarPorId(id);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

}
