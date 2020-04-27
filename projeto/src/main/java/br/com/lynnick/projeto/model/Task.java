package br.com.lynnick.projeto.model;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private String descricao;
	private int pontosDeTarefa;
	private Date dataInicial;
	private Date dataFinal;
	private int status;
	
	
	public Task() {
	}
	
	
	public Task(Long id, String titulo, String descricao, int pontosDeTarefa, Date dataInicial,
			Date dataFinal, int status) {
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.pontosDeTarefa = pontosDeTarefa;
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
		this.status = status;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public int getPontosDeTarefa() {
		return pontosDeTarefa;
	}
	
	public void setPontosDeTarefa(int pontosDeTarefa) {
		this.pontosDeTarefa = pontosDeTarefa;
	}
	

	public Date getDataInicial() {
		return dataInicial;
	}
	
	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}
	
	public Date getDataFinal() {
		return dataFinal;
	}
	
	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}

	public int getClassificacao() {
		return status;
	}

	public void setClassificacao(int status) {
		this.status = status;
	}

}
