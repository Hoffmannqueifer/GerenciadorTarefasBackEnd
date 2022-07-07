package com.hoffmann.gerenciadorTarefas.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.hoffmann.gerenciadorTarefas.domain.GerenciadorTarefas;
import com.hoffmann.gerenciadorTarefas.repositories.GerenciadorTarefasRepository;

@Service
public class DBService {

	@Autowired
	private GerenciadorTarefasRepository gerenciadorTarefasRepository;

	@Bean
	public void instanciaBaseDados() throws ParseException {
		//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyy HH:mm");
		//SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		//GerenciadorTarefas gt1 = new GerenciadorTarefas(null, "fazer a feira hoje lá no queiroz", "angular", sdf.parse("09/06/2022"), true);
		//GerenciadorTarefas gt2 = new GerenciadorTarefas(null, "estudar", "java", sdf.parse("10/06/2022"), true);
		//GerenciadorTarefas gt3 = new GerenciadorTarefas(null, "estudar", ".net", sdf.parse("11/06/2022"), false);
		//GerenciadorTarefas gt4 = new GerenciadorTarefas(null, "estudar", "docker", sdf.parse("12/06/2022"), false);
		//gerenciadorTarefasRepository.saveAll(Arrays.asList(gt1, gt2, gt3, gt4));
	}

}
