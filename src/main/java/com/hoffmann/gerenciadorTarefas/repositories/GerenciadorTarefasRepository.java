package com.hoffmann.gerenciadorTarefas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hoffmann.gerenciadorTarefas.domain.GerenciadorTarefas;

@Repository
public interface GerenciadorTarefasRepository extends JpaRepository<GerenciadorTarefas, Integer>{

	@Query("SELECT obj FROM GerenciadorTarefas obj WHERE obj.finalizado = false ORDER BY obj.dataParaFinalizar")
	List<GerenciadorTarefas> findAllListGTNaoFinalizados();
	
	@Query("SELECT obj FROM GerenciadorTarefas obj WHERE obj.finalizado = true ORDER BY obj.dataParaFinalizar")
	List<GerenciadorTarefas> findAllListGTFinalizados();

}
