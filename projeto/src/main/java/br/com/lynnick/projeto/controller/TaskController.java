package br.com.lynnick.projeto.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import br.com.lynnick.projeto.model.Task;
import br.com.lynnick.projeto.service.TaskServices;
import br.com.lynnick.projeto.services.dto.TaskDto;


@RestController
@RequestMapping("/api")
public class TaskController {
	
	@Autowired
	private TaskServices taskServices;
	
	SimpleDateFormat formataData = new SimpleDateFormat("dd-MM-yyyy");

	
	@PostMapping("/task")
	public ResponseEntity<Task> salvar(@RequestBody @Valid Task task) {
		return ResponseEntity.ok(taskServices.salvar(task));
	}
	
	@GetMapping("/task/busca/{dataInicial}/{dataFinal}")
	public ResponseEntity<List<Task>> buscaTaskEntreDatas(@PathVariable String dataInicial, @PathVariable String dataFinal) throws ParseException{
	
		return ResponseEntity.ok(taskServices.getTaskEntreDatas(formataData.parse(dataInicial), formataData.parse(dataFinal)));
	}
	
	@GetMapping("/task/busca/{dataInicial}/{dataFinal}/{status}")
	public ResponseEntity<List<Task>> getTaskEntreDatasAndStatusAberta(@PathVariable String dataInicial, @PathVariable String dataFinal,@PathVariable int status) throws ParseException{
		
		return ResponseEntity.ok(taskServices.getTaskEntreDatasAndStatus(formataData.parse(dataInicial), formataData.parse(dataFinal),status));
	}
	
	@GetMapping("/task/pontotask/{pontosDeTarefa}/{pontosDeTarefa2}")
	public ResponseEntity<List<Task>> getPontDeTask(@PathVariable int pontosDeTarefa, @PathVariable int pontosDeTarefa2) throws ParseException{
		
		return ResponseEntity.ok(taskServices.getTaskPontoTarefa(pontosDeTarefa,pontosDeTarefa2));
	}
	
	@GetMapping("/task")
	public ResponseEntity<List<Task>> listar(){
	     return ResponseEntity.ok(taskServices.listar());

	    }
	
	@GetMapping("/task/{id}")
	public ResponseEntity<Task> consultaPorId(@PathVariable Long id) {
		return ResponseEntity.ok(taskServices.consultaPorId(id));
	}
	
	@GetMapping("/task/nome/{nome}")
	public ResponseEntity<TaskDto> buscaPorNome(@PathVariable String nome){
		TaskDto taskDto = null;
		try {
			taskDto = taskServices.getDepartamentoByNome(nome);
		} catch (NotFoundException e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(taskDto);
	}
	
	@PutMapping("/task")
	public ResponseEntity<Task> update(@RequestBody @Valid Task task) {
		return ResponseEntity.ok(taskServices.update(task));
	}
	
	@DeleteMapping("/task/{id}")
	public ResponseEntity<Task> deletarPorId(@PathVariable Long id) {
		try {
			taskServices.deletarPorId(id);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

}
