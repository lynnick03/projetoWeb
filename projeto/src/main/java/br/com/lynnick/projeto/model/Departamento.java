package br.com.lynnick.projeto.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Departamento {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	public String nome;
	
	@OneToMany
	private List<Person> person = new ArrayList<Person>();
	
	
	
	
	
	
	public Departamento() {
		
	}
	
	public Departamento(Long id, String nome) {
		this.id = id;
		this.nome = nome;
	}


	public List<Person> getPerson() {
		return person;
	}

	public void setPerson(List<Person> person) {
		this.person = person;
	}


	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	

	
}

