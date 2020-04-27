package br.com.lynnick.projeto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;
import br.com.lynnick.projeto.model.Departamento;

import br.com.lynnick.projeto.repository.DepartamentoRepository;
import br.com.lynnick.projeto.services.dto.DepartamentoDto;

@Service
public class DepartamentoServices {

	@Autowired
	private DepartamentoRepository departamentoRepository;
	
	
	public DepartamentoDto getDepartamentoById(Long id) throws NotFoundException {
		Optional<Departamento> departamento = departamentoRepository.findById(id);
		
		if(!departamento.isPresent()) {
			throw new NotFoundException();
		}
	
		return new DepartamentoDto(departamento.get());
	}

	
	public DepartamentoDto getDepartamentoByNome(String nome) throws NotFoundException{
		
		Optional<Departamento> departamento = departamentoRepository.findDepartamentoByNome(nome);
		
		if(!departamento.isPresent()) {
			throw new NotFoundException();
		}
	
		return new DepartamentoDto(departamento.get());
	}
	
	public List<Departamento> listar(){
		return departamentoRepository.findAll();
	}

	public Departamento consultaPorId(Long id) {
		return departamentoRepository.findById(id).get();				
	}
	

	public Departamento salvar(Departamento departamento) {
		return departamentoRepository.save(departamento);
	}
	
	
	public Departamento update(Departamento departamento) {
		if(departamento!=null) {
			return departamentoRepository.save(departamento);
		}
		
			throw new RuntimeException("O ID precisa ser informado");
		}
	
	public void deletarPorId(Long id) {
		departamentoRepository.deleteById(id);
	}
	
	
	
}
