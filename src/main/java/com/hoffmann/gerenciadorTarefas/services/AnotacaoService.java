package com.hoffmann.gerenciadorTarefas.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hoffmann.gerenciadorTarefas.domain.Anotacao;
import com.hoffmann.gerenciadorTarefas.repositories.AnotacaoRepository;
import com.hoffmann.gerenciadorTarefas.services.exceptions.ObjectNotFoundException;

@Service
public class AnotacaoService {
	
	@Autowired
	private AnotacaoRepository anotacaoRepository;

	public Anotacao create(Anotacao obj) {
		obj.setId(null);
		return anotacaoRepository.save(obj);
	}
	
	public Anotacao anotacaoById(Integer id) {
		 Optional<Anotacao> obj = anotacaoRepository.findById(id);
		 return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: "+ id + ", Tipo: " + Anotacao.class.getName()));
	}
	
	public Anotacao update(Integer id, Anotacao obj) {
		Anotacao newObj = anotacaoById(id);
		newObj.setAnotacao(obj.getAnotacao());
		return anotacaoRepository.save(newObj);
	} 
}
