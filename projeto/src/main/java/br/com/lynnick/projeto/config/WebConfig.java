package br.com.lynnick.projeto.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.lynnick.projeto.model.Departamento;
import br.com.lynnick.projeto.model.Person;
import br.com.lynnick.projeto.model.Project;
import br.com.lynnick.projeto.model.ProjectHistory;
import br.com.lynnick.projeto.model.Task;
import br.com.lynnick.projeto.repository.DepartamentoRepository;
import br.com.lynnick.projeto.repository.PersonRepository;
import br.com.lynnick.projeto.repository.ProjectHistoryRepository;
import br.com.lynnick.projeto.repository.ProjectRepository;
import br.com.lynnick.projeto.repository.TaskRepository;

@Configuration
public class WebConfig implements CommandLineRunner{
	
	@Autowired
	private TaskRepository taskRepository;
	
	@Autowired
	private ProjectRepository projectRepository;
	
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private DepartamentoRepository departamentoRepository;
	
	@Autowired
	private ProjectHistoryRepository projectHistoryRepository;
	
	SimpleDateFormat formataData = new SimpleDateFormat("dd-MM-yyyy");
	
	@Override
	public void run(String... args) throws Exception {
		
		Person pe1 =  new Person(null, "LYNNICK", "SOUZA", "lynnick@gmail.com", "(83)-9999-99999",formataData.parse("26-04-2020"));
		Person pe2 =  new Person(null, "ROSEANE", "AIRES", "roseane@gmail.com", "(83)-9999-99999",formataData.parse("26-04-2019"));
		Person pe3 =  new Person(null, "LEA", "ARISTIDE", "lea@gmail.com", "(83)-9999-99999",formataData.parse("26-04-2018"));
		Person pe4 =  new Person(null, "SAMARA", "THAIS", "samara@gmail.com", "(83)-9999-99999",formataData.parse("26-04-2017"));
		Person pe5 =  new Person(null, "JOAO", "SILVA", "JOAO@gmail.com", "(83)-9999-99999",formataData.parse("26-04-2016"));
		Person pe6 =  new Person(null, "RAFAEL", "AIRES", "RAFAEL@gmail.com", "(83)-9999-99999",formataData.parse("26-04-2015"));
		Person pe7 =  new Person(null, "ROSIMAR", "AIRES", "ROSIMAR@gmail.com", "(83)-9999-99999",formataData.parse("26-04-2014"));
		Person pe8 =  new Person(null, "ALEXANDRE", "MATHEUS", "ALEXANDRE@gmail.com", "(83)-9999-99999",formataData.parse("26-04-2013"));
		Person pe9 =  new Person(null, "ALLAN", "MONTEIRO", "ALLAN@gmail.com", "(83)-9999-99999",formataData.parse("26-04-2012"));
		Person pe10 =  new Person(null, "MARCELO", "ROLIM", "MARCELO@gmail.com", "(83)-9999-99999",formataData.parse("26-04-2011"));
		Person pe11 =  new Person(null, "Gabriel", "ABRANTES", "Gabriel@gmail.com", "(83)-9999-99999",formataData.parse("26-04-2010"));
		Person pe12 =  new Person(null, "BRENO", "BARRETO", "Brenogmail.com", "(83)-9999-99999",formataData.parse("26-04-2009"));
		Person pe13 =  new Person(null, "cleef", "souza", "cleef@gmail.com", "(83)-9999-99999",formataData.parse("26-04-2008"));
		Person pe14 =  new Person(null, "wendeley", "niggas", "wendeley@gmail.com", "(83)-9999-99999",formataData.parse("26-04-2007"));
		Person pe15 =  new Person(null, "Lucas", "Rodrigues", "lucas@gmail.com", "(83)-9999-99999",formataData.parse("26-04-2006"));
		Person pe16 =  new Person(null, "calixto", "souza", "calixto@gmail.com", "(83)-9999-99999",  formataData.parse("26-04-2005"));
		Person pe17 =  new Person(null, "voxtecnologia", "vox", "vox@gmail.com", "(83)-9999-99999", formataData.parse("26-04-2004"));
		Person pe18 =  new Person(null, "teste", "vox", "teste@gmail.com", "(83)-9999-99999",formataData.parse("26-04-2003"));
		personRepository.saveAll(Arrays.asList(pe1,pe2,pe3,pe4,pe5,pe6,pe7,pe8,pe9,pe10,pe11,pe12,pe13,pe14,pe15,pe16,pe17,pe18));
		
		
		Departamento dep1 = new  Departamento(null,"Tecnologia");
		Departamento dep2 = new  Departamento(null,"Administracao");
		Departamento dep3 = new  Departamento(null,"Marketing");
		Departamento dep4 = new  Departamento(null,"Qualidade");
		Departamento dep5 = new  Departamento(null,"RE");

		departamentoRepository.saveAll(Arrays.asList(dep1,dep2,dep3,dep4,dep5));
		
		dep1.getPerson().add(pe1);
		dep1.getPerson().add(pe2);
		dep1.getPerson().add(pe3);
		dep1.getPerson().add(pe4);
		dep2.getPerson().add(pe5);
		dep2.getPerson().add(pe6);
		dep2.getPerson().add(pe7);
		dep3.getPerson().add(pe8);
		dep3.getPerson().add(pe9);
		dep3.getPerson().add(pe10);
		dep3.getPerson().add(pe11);
		dep4.getPerson().add(pe12);
		dep4.getPerson().add(pe13);
		dep4.getPerson().add(pe14);
		dep5.getPerson().add(pe15);
		dep5.getPerson().add(pe16);
		dep5.getPerson().add(pe17);
		dep5.getPerson().add(pe18);
		
		departamentoRepository.saveAll(Arrays.asList(dep1,dep2,dep3,dep4,dep5));
		
		
		Project p1 = new Project(null, "Projeto 1", 1000, 2000, pe1);
		Project p2 = new Project(null, "Projeto 2", 20000, 30000, pe2);
		Project p3 = new Project(null, "Projeto 3", 30000, 40000, pe3);
		Project p4 = new Project(null, "Projeto 4", 500000, 700000, pe4);
		Project p5= new Project(null, "Projeto 5", 500000, 700000, pe5);
		Project p6 = new Project(null, "Projeto 6", 500000, 700000, pe6);
		Project p7 = new Project(null, "Projeto 7", 500000, 700000, pe7);
		Project p8 = new Project(null, "Projeto 8", 500000, 700000, pe8);
		projectRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5,p6,p7,p8));
		
		pe1.getProjeto().add(p1);
		pe2.getProjeto().add(p2);
		pe3.getProjeto().add(p3);
		pe4.getProjeto().add(p4);
		pe5.getProjeto().add(p5);
		pe6.getProjeto().add(p6);
		pe7.getProjeto().add(p7);
		pe8.getProjeto().add(p8);
		personRepository.saveAll(Arrays.asList(pe1,pe2,pe3,pe4,pe5,pe6,pe7,pe8));
		
		Task t1 = new Task(null,"Titulo da tarefa 1","Descricao da tarefa 1",100,formataData.parse("26-04-2020"),null,1);
		Task t2 = new Task(null,"Titulo da tarefa 2","Descricao da tarefa 2",90,formataData.parse("26-04-2020"),formataData.parse("27-04-2020"),2);		
		Task t3 = new Task(null,"Titulo da tarefa 1","Descricao da tarefa 3",80,formataData.parse("26-04-2020"),null,1);
		Task t4 = new Task(null,"Titulo da tarefa 1","Descricao da tarefa 4",70,formataData.parse("26-04-2020"),null,1);
		Task t5 = new Task(null,"Titulo da tarefa 1","Descricao da tarefa 4",60,formataData.parse("26-04-2020"),formataData.parse("27-04-2020"),2);
		Task t6 = new Task(null,"Titulo da tarefa 1","Descricao da tarefa 4",50,formataData.parse("26-04-2020"),null,1);;
		Task t7 = new Task(null,"Titulo da tarefa 1","Descricao da tarefa 4",40,formataData.parse("26-04-2020"),formataData.parse("27-04-2020"),2);
		Task t8 = new Task(null,"Titulo da tarefa 1","Descricao da tarefa 4",30,formataData.parse("26-04-2020"),null,1);
		


		taskRepository.saveAll(Arrays.asList(t1,t2,t3,t4,t5,t6,t7,t8));
		
		
		
		p1.getTask().add(t1);
		p2.getTask().add(t2);
		p3.getTask().add(t3);
		p4.getTask().add(t4);
		p5.getTask().add(t5);
		p6.getTask().add(t6);
		p7.getTask().add(t7);
		p8.getTask().add(t8);
		projectRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5,p6,p7,p8));
		
		
		
		ProjectHistory  pr1 = new ProjectHistory(null, t1.getDataInicial(), t1.getDataFinal(), p1.getPerson(), dep1, p1);
		ProjectHistory  pr2 = new ProjectHistory(null, t2.getDataInicial(), t2.getDataFinal(), p2.getPerson(), dep2, p2);
		ProjectHistory  pr3 = new ProjectHistory(null, t3.getDataInicial(), t3.getDataFinal(), p3.getPerson(), dep3, p3);
		ProjectHistory  pr4 = new ProjectHistory(null, t4.getDataInicial(), t4.getDataFinal(), p4.getPerson(), dep4, p4);
		ProjectHistory  pr5 = new ProjectHistory(null, t5.getDataInicial(), t5.getDataFinal(), p5.getPerson(), dep5, p5);
		ProjectHistory  pr6 = new ProjectHistory(null, t6.getDataInicial(), t6.getDataFinal(), p6.getPerson(), dep1, p6);
		ProjectHistory  pr7 = new ProjectHistory(null, t7.getDataInicial(), t7.getDataFinal(), p7.getPerson(), dep2, p7);
		ProjectHistory  pr8 = new ProjectHistory(null, t8.getDataInicial(), t8.getDataFinal(), p8.getPerson(), dep3, p8);
		projectHistoryRepository.saveAll(Arrays.asList(pr1,pr2,pr3,pr4,pr5,pr6,pr7,pr8));
		
	}
	

}
