package com.eya.jeux;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.eya.jeux.entities.Jeu;
import com.eya.jeux.service.JeuService;

@SpringBootApplication
public class JeuxApplication implements CommandLineRunner{
	
	@Autowired
	JeuService jeuService;
	

	public static void main(String[] args) {
		SpringApplication.run(JeuxApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		jeuService.saveJeu(new Jeu("Bioschok", 29.00, new Date()));
		jeuService.saveJeu(new Jeu("Ori", 150.00, new Date()));
		jeuService.saveJeu(new Jeu("Sonic Dash", 163.00, new Date()));
		
	}

}

