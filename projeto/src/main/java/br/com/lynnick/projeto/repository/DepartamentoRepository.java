package br.com.lynnick.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import br.com.lynnick.projeto.model.Departamento;

@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {

	
	Optional<Departamento> findDepartamentoByNome(String nome);
	Optional<Departamento> findDepartamentoById(Long id);

	
}
