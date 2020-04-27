package br.com.lynnick.projeto.services.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.lynnick.projeto.model.Departamento;

public class DepartamentoDto {

	private Long id;
	private String nome;
	
	public DepartamentoDto(Departamento departamento) {
		
		this.id=departamento.getId();
		this.nome=departamento.getNome();
	}
	
	public Long getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}

	
	public static List<DepartamentoDto> converter(List<Departamento> departamento){
		return departamento.stream().map(DepartamentoDto::new).collect(Collectors.toList());
	}
	
	
}
