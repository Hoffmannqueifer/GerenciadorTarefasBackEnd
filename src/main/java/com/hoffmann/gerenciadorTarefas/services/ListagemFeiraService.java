package com.hoffmann.gerenciadorTarefas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hoffmann.gerenciadorTarefas.domain.GerenciadorTarefas;
import com.hoffmann.gerenciadorTarefas.domain.ListagemFeira;
import com.hoffmann.gerenciadorTarefas.repositories.ListagemFeiraRepository;

@Service
public class ListagemFeiraService {

	@Autowired
	private ListagemFeiraRepository listagemFeiraRepository;
	
	public ListagemFeira create(ListagemFeira obj) {
		obj.setId(null);
		return listagemFeiraRepository.save(obj);
	}
	
	public List<ListagemFeira> ListAll() {
		 List<ListagemFeira> listFeira = listagemFeiraRepository.findAll();
		 return listFeira;
	}

	public void delete(Integer id) {
		listagemFeiraRepository.deleteById(id);
	}
	
	public void deleteAll() {
		listagemFeiraRepository.deleteAll();
	}
}
