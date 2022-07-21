package com.hoffmann.gerenciadorTarefas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hoffmann.gerenciadorTarefas.domain.ListagemFeira;

@Repository
public interface ListagemFeiraRepository extends JpaRepository<ListagemFeira, Integer> {
	
	@Modifying
	@Query("delete from ListagemFeira")
	void deleteAll();
}
