package br.com.lynnick.projeto.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.lynnick.projeto.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

	Optional<Project> findProjetoByNome(String nome);
	Optional<Project> findProjetoById(Long id);
}
