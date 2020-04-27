package br.com.lynnick.projeto.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import br.com.lynnick.projeto.model.Task;
import br.com.lynnick.projeto.repository.TaskRepository;
import br.com.lynnick.projeto.services.dto.TaskDto;

@Service
public class TaskServices {

	
	@Autowired
	private TaskRepository taskRepository;
	
	
	public TaskDto getDepartamentoById(Long id) throws NotFoundException {
		Optional<Task> task = taskRepository.findById(id);
		
		if(!task.isPresent()) {
			throw new NotFoundException();
		}
	
		return new TaskDto(task.get());
	}
	

	public TaskDto getDepartamentoByNome(String titulo) throws NotFoundException{
		
		Optional<Task> task = taskRepository.findTaskByTitulo(titulo);
		
		if(!task.isPresent()) {
			throw new NotFoundException();
		}
	
		return new TaskDto(task.get());
	}
	
	public List<Task> listar(){
		return taskRepository.findAll();
	}

	public Task consultaPorId(Long id) {
		return taskRepository.findById(id).get();				
	}
	

	public Task salvar(Task task) {
		return taskRepository.save(task);
	}
	
	
	public Task update(Task task) {
		if(task!=null) {
			return taskRepository.save(task);
		}
		
			throw new RuntimeException("O ID precisa ser informado");
		}
	
	public void deletarPorId(Long id) {
		taskRepository.deleteById(id);
	}

	public List<Task> getTaskEntreDatas(Date dataInicial, Date dataFinal)  {
		 
		List<Task> task = 
				taskRepository.findByDataInicialAndDataFinalBetween(dataInicial, dataFinal);
		return task;
		
	}
	
	public List<Task> getTaskEntreDatasAndStatus(Date dataInicial, Date dataFinal, int status)  {
		 
		List<Task> task = 
				taskRepository.findByDataInicialAndDataFinalAndStatusBetween(dataInicial, dataFinal,status);
		return task;
		
	}
	
	public List<Task> getTaskPontoTarefa(int pontosDeTarefa,int pontosDeTarefa2)  {
		 
		List<Task> task = 
				taskRepository.findBypontosDeTarefaBetween(pontosDeTarefa, pontosDeTarefa2);
		return task;
		
	}

}
