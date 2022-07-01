package com.hoffmann.gerenciadorTarefas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hoffmann.gerenciadorTarefas.domain.GerenciadorTarefas;
import com.hoffmann.gerenciadorTarefas.repositories.GerenciadorTarefasRepository;
import com.hoffmann.gerenciadorTarefas.services.exceptions.ObjectNotFoundException;

@Service
public class GerenciadorTarefasService {

	@Autowired
	private GerenciadorTarefasRepository gerenciadorTarefasRepository;
	
	public GerenciadorTarefas GerenciadorTarefasById(Integer id) {
		 Optional<GerenciadorTarefas> obj = gerenciadorTarefasRepository.findById(id);
		 return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontro! Id: "+ id + ", Tipo: " + GerenciadorTarefas.class.getName()));
	}
	
	public List<GerenciadorTarefas> ListGerenciadorTarefasNaoFinalizados() {
		 List<GerenciadorTarefas> listGTNaoFinalizados = gerenciadorTarefasRepository.findAllListGTNaoFinalizados();
		 return listGTNaoFinalizados;
	}
	
	public List<GerenciadorTarefas> ListGerenciadorTarefasFinalizados() {
		 List<GerenciadorTarefas> listGTFinalizados = gerenciadorTarefasRepository.findAllListGTFinalizados();
		 return listGTFinalizados;
	}
	
	public List<GerenciadorTarefas> ListAllGerenciadorTarefas() {
		 List<GerenciadorTarefas> listGT = gerenciadorTarefasRepository.findAll();
		 return listGT;
	}

	public GerenciadorTarefas create(GerenciadorTarefas obj) {
		obj.setId(null);
		return gerenciadorTarefasRepository.save(obj);
	}

	public void delete(Integer id) {
		gerenciadorTarefasRepository.deleteById(id);
		
	}

	public GerenciadorTarefas update(Integer id, GerenciadorTarefas obj) {
		GerenciadorTarefas newObj = GerenciadorTarefasById(id);
		newObj.setTitulo(obj.getTitulo());
		newObj.setDataParaFinalizar(obj.getDataParaFinalizar());
		newObj.setDescricao(obj.getDescricao());
		newObj.setFinalizado(obj.getFinalizado());
		return gerenciadorTarefasRepository.save(newObj);
	} 
}
