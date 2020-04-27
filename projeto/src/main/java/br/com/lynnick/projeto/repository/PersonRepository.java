package br.com.lynnick.projeto.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.lynnick.projeto.model.Person;


@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

	

}
