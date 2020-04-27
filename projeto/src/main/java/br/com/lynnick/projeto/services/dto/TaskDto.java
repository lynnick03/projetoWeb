package br.com.lynnick.projeto.services.dto;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.lynnick.projeto.model.Task;

public class TaskDto {

	private int id;
	private String titulo;
	private String descricao;
	private int pontosDeTarefa;
	private int status; 
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date dataInicial;
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date dataFinal;
	




	public TaskDto(int id, String titulo, String descricao, int pontosDeTarefa, int status, Date dataInicial,
			Date dataFinal) {
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.pontosDeTarefa = pontosDeTarefa;
		this.status = status;
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
	}

	public TaskDto(Task task) {
	}

	public int getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public int getPontosDeTarefa() {
		return pontosDeTarefa;
	}

	public int getStatus() {
		return status;
	}

	public Date getDataInicial() {
		return dataInicial;
	}

	public Date getDataFinal() {
		return dataFinal;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setPontosDeTarefa(int pontosDeTarefa) {
		this.pontosDeTarefa = pontosDeTarefa;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}

	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}
	
	
	public static List<TaskDto> converter(List<Task> task){
		return task.stream().map(TaskDto::new).collect(Collectors.toList());
	}
	
}
