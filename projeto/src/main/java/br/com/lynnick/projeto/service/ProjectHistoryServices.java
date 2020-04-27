package br.com.lynnick.projeto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import br.com.lynnick.projeto.model.ProjectHistory;
import br.com.lynnick.projeto.repository.ProjectHistoryRepository;
import br.com.lynnick.projeto.services.dto.ProjectHistoryDto;

@Service
public class ProjectHistoryServices {

	
	
	@Autowired
	private ProjectHistoryRepository phRepository;
	
	
	public ProjectHistoryDto getPhById(Long id) throws NotFoundException {
		Optional<ProjectHistory> ph = phRepository.findById(id);
		
		if(!ph.isPresent()) {
			throw new NotFoundException();
		}
	
		return new ProjectHistoryDto(ph.get());
	}

	
	public List<ProjectHistory> listar(){
		return phRepository.findAll();
	}

	public ProjectHistory consultaPorId(Long id) {
		return phRepository.findById(id).get();				
	}
	

	public ProjectHistory salvar(ProjectHistory ph) {
		return phRepository.save(ph);
	}
	
	
	public ProjectHistory update(ProjectHistory ph) {
		if(ph!=null) {
			return phRepository.save(ph);
		}
		
			throw new RuntimeException("O ID precisa ser informado");
		}
	
	public void deletarPorId(Long id) {
		phRepository.deleteById(id);
	}

}
