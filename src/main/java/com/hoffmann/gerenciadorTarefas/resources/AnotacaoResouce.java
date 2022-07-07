package com.hoffmann.gerenciadorTarefas.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.hoffmann.gerenciadorTarefas.domain.Anotacao;
import com.hoffmann.gerenciadorTarefas.services.AnotacaoService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/anotacoes")
public class AnotacaoResouce {
	
	@Autowired
	private AnotacaoService anotacaoService;
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Anotacao> findById(@PathVariable Integer id){
		Anotacao obj  = anotacaoService.anotacaoById(id);
		return ResponseEntity.ok().body(obj); 
	}
	
	@PostMapping
	public ResponseEntity<Anotacao> create(@RequestBody Anotacao obj){
		obj = anotacaoService.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Anotacao> update(@PathVariable Integer id, @RequestBody Anotacao obj){
		Anotacao newObj = anotacaoService.update(id, obj);
		return ResponseEntity.ok().body(newObj);
	}

}
