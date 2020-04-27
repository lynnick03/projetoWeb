package br.com.lynnick.projeto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import br.com.lynnick.projeto.model.Project;
import br.com.lynnick.projeto.repository.ProjectRepository;
import br.com.lynnick.projeto.services.dto.ProjectDto;

@Service
public class ProjectServices {

	
	@Autowired
	private ProjectRepository projectRepository;
	
	
	public ProjectDto getDepartamentoById(Long id) throws NotFoundException {
		Optional<Project> projeto = projectRepository.findById(id);
		
		if(!projeto.isPresent()) {
			throw new NotFoundException();
		}
	
		return new ProjectDto(projeto.get());
	}

	
	public ProjectDto getDepartamentoByNome(String nome) throws NotFoundException{
		
		Optional<Project> projeto = projectRepository.findProjetoByNome(nome);
		
		if(!projeto.isPresent()) {
			throw new NotFoundException();
		}
	
		return new ProjectDto(projeto.get());
	}
	
	public List<Project> listar(){
		return projectRepository.findAll();
	}

	public Project consultaPorId(Long id) {
		return projectRepository.findById(id).get();				
	}
	

	public Project salvar(Project projeto) {
		return projectRepository.save(projeto);
	}
	
	
	public Project update(Project projeto) {
		if(projeto!=null) {
			return projectRepository.save(projeto);
		}
		
			throw new RuntimeException("O ID precisa ser informado");
		}
	
	public void deletarPorId(Long id) {
		projectRepository.deleteById(id);
	}
}
