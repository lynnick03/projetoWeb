package br.com.lynnick.projeto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import br.com.lynnick.projeto.model.Person;
import br.com.lynnick.projeto.repository.PersonRepository;
import br.com.lynnick.projeto.services.dto.PersonDto;

@Service
public class PersonServices {
	
	
	@Autowired
	private PersonRepository personRepository;
	
	
	public PersonDto getDepartamentoById(Long id) throws NotFoundException {
		Optional<Person> person = personRepository.findById(id);
		
		if(!person.isPresent()) {
			throw new NotFoundException();
		}
	
		return new PersonDto(person.get());
	}

	
	/*public PersonDto getDepartamentoByNome(String nome) throws NotFoundException{
		
		Optional<Person> person = personRepository.findPersonByNome(nome);
		
		if(!person.isPresent()) {
			throw new NotFoundException();
		}
	
		return new PersonDto(person.get());
	}*/
	
	public List<Person> listar(){
		return personRepository.findAll();
	}

	public Person consultaPorId(Long id) {
		return personRepository.findById(id).get();				
	}
	

	public Person salvar(Person pessoa) {
		return personRepository.save(pessoa);
	}
	
	
	public Person update(Person pessoa) {
		if(pessoa!=null) {
			return personRepository.save(pessoa);
		}
		
			throw new RuntimeException("O ID precisa ser informado");
		}
	
	public void deletarPorId(Long id) {
		personRepository.deleteById(id);
	}

}
