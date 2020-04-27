package br.com.lynnick.projeto.services.dto;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import br.com.lynnick.projeto.model.ProjectHistory;

public class ProjectHistoryDto {

	
	private Long id;
	private Date dataInicio;
	private Date dataFinal;
	
	public ProjectHistoryDto(ProjectHistory projetoHistoria) {
		
		this.id=projetoHistoria.getId();
		this.dataInicio=projetoHistoria.getDataInicio();
		this.dataFinal=projetoHistoria.getDataFinal();

	}

	public Long getId() {
		return id;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public Date getDataFinal() {
		return dataFinal;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}
	
	public static List<ProjectHistoryDto> converter(List<ProjectHistory> projetoHistoria){
		return projetoHistoria.stream().map(ProjectHistoryDto::new).collect(Collectors.toList());
	}
}
