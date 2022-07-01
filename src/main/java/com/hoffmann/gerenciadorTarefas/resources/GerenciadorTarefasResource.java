package com.hoffmann.gerenciadorTarefas.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.hoffmann.gerenciadorTarefas.domain.GerenciadorTarefas;
import com.hoffmann.gerenciadorTarefas.services.GerenciadorTarefasService;

@RestController
@RequestMapping(value = "/gerenciadortarefas")
public class GerenciadorTarefasResource {
	
	@Autowired
	private GerenciadorTarefasService gerenciadorTarefasService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<GerenciadorTarefas> findById(@PathVariable Integer id){
		GerenciadorTarefas obj  = gerenciadorTarefasService.GerenciadorTarefasById(id);
		return ResponseEntity.ok().body(obj); 
	}
	
	@GetMapping(value = "/listnaofinalizados")
	public ResponseEntity<List<GerenciadorTarefas>> listGerenciadorTarefasNaoFinalizados (){
		List<GerenciadorTarefas> listGTNaoFinalizados = gerenciadorTarefasService.ListGerenciadorTarefasNaoFinalizados();
		return ResponseEntity.ok().body(listGTNaoFinalizados);
	}
	
	@GetMapping(value = "/listfinalizados")
	public ResponseEntity<List<GerenciadorTarefas>> listGerenciadorTarefasFinalizados (){
		List<GerenciadorTarefas> listGTFinalizados = gerenciadorTarefasService.ListGerenciadorTarefasFinalizados();
		return ResponseEntity.ok().body(listGTFinalizados);
	}
	
	@GetMapping(value = "/list")
	public ResponseEntity<List<GerenciadorTarefas>> listAllGerenciadorTarefas (){
		List<GerenciadorTarefas> listGT = gerenciadorTarefasService.ListAllGerenciadorTarefas();
		return ResponseEntity.ok().body(listGT);
	}
	
	@PostMapping
	public ResponseEntity<GerenciadorTarefas> create(@RequestBody GerenciadorTarefas obj){
		obj = gerenciadorTarefasService.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		gerenciadorTarefasService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<GerenciadorTarefas> update(@PathVariable Integer id, @RequestBody GerenciadorTarefas obj){
		GerenciadorTarefas newObj = gerenciadorTarefasService.update(id, obj);
		return ResponseEntity.ok().body(newObj);
	}

}
