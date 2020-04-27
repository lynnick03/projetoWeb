package br.com.lynnick.projeto.repository;


import java.util.*;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.lynnick.projeto.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

	Optional<Task> findTaskByTitulo(String titulo);
	Optional<Task> findTaskById(Long id);
	
	/*@Query(value = "select t from Task t where t.dataInicial,t.dataFinal BETWEEN :dataInicial AND :dataFinal")
	List<Task> findByDataInicialAndDataFinalBetween(@Param("dataInicial")Date dataInicial,@Param("dataFinal")Date dataFinal);*/
	
	
	
	@Query("select a from Task a where a.dataInicial <= :dataInicial and a.dataFinal <=:dataFinal")
    List<Task> findByDataInicialAndDataFinalBetween
    		(@Param("dataInicial")Date dataInicial,@Param("dataFinal")Date dataFinal);
	
	
	@Query("select a from Task a where a.dataInicial <= :dataInicial and a.dataFinal <=:dataFinal and a.status <=:status")
    List<Task> findByDataInicialAndDataFinalAndStatusBetween
    		(@Param("dataInicial")Date dataInicial,@Param("dataFinal")Date dataFinal,@Param("status")int status);
	
	
	List<Task> findBypontosDeTarefaBetween(int pontosDeTarefa, int pontosDeTarefa1);
	
}
