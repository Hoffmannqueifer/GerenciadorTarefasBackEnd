package com.hoffmann.gerenciadorTarefas.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.hoffmann.gerenciadorTarefas.services.DBService;

@Configuration
@Profile("test")
public class TestConfig {
	
	@Autowired
	private DBService dbService;
	

	public boolean instancia() {
		this.dbService.instanciaBaseDados();
		return true;
	}
}
