package br.com.lynnick.projeto.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;



@Entity
public class Project {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private int salarioMinimo;
	private int salarioMaximo;
	
	
	
	@OneToOne
	private Person person;
	
	@ManyToMany
	private List<Task> task = new ArrayList<Task>();
	
	
	
	
	
	
	public Project() {
	}

	public Project(Long id, String nome, int salarioMinimo, int salarioMaximo, Person person) {
		this.id = id;
		this.nome = nome;
		this.salarioMinimo = salarioMinimo;
		this.salarioMaximo = salarioMaximo;
		this.person = person;
	}


	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNomeProjeto() {
		return nome;
	}
	
	public void setNomeProjeto(String nome) {
		this.nome = nome;
	}
	

	public int getSalarioMinimo() {
		return salarioMinimo;
	}
	
	public void setSalarioMinimo(int salarioMinimo) {
		this.salarioMinimo = salarioMinimo;
	}
	
	public int getSalarioMaximo() {
		return salarioMaximo;
	}
	
	public void setSalarioMaximo(int salarioMaximo) {
		this.salarioMaximo = salarioMaximo;
	}

	

	public Person getPerson() {
		return person;
	}

	public List<Task> getTask() {
		return task;
	}

}
