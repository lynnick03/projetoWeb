package br.com.lynnick.projeto.services.dto;

import java.util.List;
import java.util.stream.Collectors;
import br.com.lynnick.projeto.model.Project;

public class ProjectDto {
	
	private Long id;
	private String nomeProjeto;
	
	public ProjectDto(Project projeto) {
		
		this.id = projeto.getId();
		this.nomeProjeto = projeto.getNomeProjeto();
	}

	public Long getId() {
		return id;
	}

	public String getNomeProjeto() {
		return nomeProjeto;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNomeProjeto(String nomeProjeto) {
		this.nomeProjeto = nomeProjeto;
	}
	
	
	public static List<ProjectDto> converter(List<Project> projeto){
		return projeto.stream().map(ProjectDto::new).collect(Collectors.toList());
	}
	

}
