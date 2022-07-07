package com.hoffmann.gerenciadorTarefas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hoffmann.gerenciadorTarefas.domain.Anotacao;


@Repository
public interface AnotacaoRepository extends JpaRepository<Anotacao, Integer>{

}
