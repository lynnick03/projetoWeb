package br.com.lynnick.projeto.services.dto;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import br.com.lynnick.projeto.model.Person;

public class PersonDto {

	
	private Long id;
	private String primeiroNome;
	private String ultimoNome;
	private String email;
	private String numeroTelefone;
	private Date dataContratacao;
	
	
	public PersonDto(Person person) {
		this.id = person.getId();
		this.primeiroNome = person.getPrimeiroNome();
		this.ultimoNome = person.getUltimoNome();
		this.email = person.getEmail();
		this.numeroTelefone = person.getNumeroTelefone();
		this.dataContratacao = person.getDataContratacao();
	}
	
	
	

	
	public Long getId() {
		return id;
	}

	public String getPrimeiroNome() {
		return primeiroNome;
	}

	public String getUltimoNome() {
		return ultimoNome;
	}

	public String getEmail() {
		return email;
	}

	public String getNumeroTelefone() {
		return numeroTelefone;
	}

	public Date getDataContratacao() {
		return dataContratacao;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public void setPrimeiroNome(String primeiroNome) {
		this.primeiroNome = primeiroNome;
	}

	public void setUltimoNome(String ultimoNome) {
		this.ultimoNome = ultimoNome;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public void setNumeroTelefone(String numeroTelefone) {
		this.numeroTelefone = numeroTelefone;
	}

	public void setDataContratacao(Date dataContratacao) {
		this.dataContratacao = dataContratacao;
	}

	public static List<PersonDto> converter(List<Person> person){
		return person.stream().map(PersonDto::new).collect(Collectors.toList());
	}
	
	
}
