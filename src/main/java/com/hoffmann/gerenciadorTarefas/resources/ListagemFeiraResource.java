package com.hoffmann.gerenciadorTarefas.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.hoffmann.gerenciadorTarefas.domain.GerenciadorTarefas;
import com.hoffmann.gerenciadorTarefas.domain.ListagemFeira;
import com.hoffmann.gerenciadorTarefas.services.ListagemFeiraService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/listagem-feira")
public class ListagemFeiraResource {

	@Autowired
	private ListagemFeiraService listagemFeiraService;
	
	@PostMapping
	public ResponseEntity<ListagemFeira> create(@RequestBody ListagemFeira obj){
		obj = listagemFeiraService.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@GetMapping
	public ResponseEntity<List<ListagemFeira>> listAll (){
		List<ListagemFeira> listFeira = listagemFeiraService.ListAll();
		return ResponseEntity.ok().body(listFeira);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		listagemFeiraService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping()
	public ResponseEntity<Void> deleteAll(){
		listagemFeiraService.deleteAll();
		return ResponseEntity.noContent().build();
	}
}
