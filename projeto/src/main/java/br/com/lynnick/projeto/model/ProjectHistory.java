package br.com.lynnick.projeto.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class ProjectHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date dataInicio;
	private Date dataFinal;
	
	@OneToOne
	private Person manager;
	
	@OneToOne
	private Departamento departamento;
	
	@OneToOne
	private Project projeto;
	
	
	
	
	public ProjectHistory() {
	}
	
	public ProjectHistory(Long id, Date dataInicio, Date dataFinal, Person manager, Departamento departamento,
			Project projeto) {
		this.id = id;
		this.dataInicio = dataInicio;
		this.dataFinal = dataFinal;
		this.manager = manager;
		this.departamento = departamento;
		this.projeto = projeto;
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

	public Person getManager() {
		return manager;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public Project getProjeto() {
		return projeto;
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

	public void setManager(Person manager) {
		this.manager = manager;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public void setProjeto(Project projeto) {
		this.projeto = projeto;
	}


	
	
	
}
