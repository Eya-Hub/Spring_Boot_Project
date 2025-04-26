package com.eya.jeux;

import java.util.Date;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.eya.jeux.entities.Jeu;
import com.eya.jeux.entities.Role;
import com.eya.jeux.entities.User;
import com.eya.jeux.service.JeuService;
import com.eya.jeux.service.UserService;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class JeuxApplication implements CommandLineRunner {

	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;

	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(JeuxApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// jeuService.saveJeu(new Jeu("Bioschok", 29.00, new Date()));
		//System.out.println("Password Encoded BCRYPT :******************** ");
		//System.out.println(passwordEncoder.encode("123"));
		// repositoryRestConfiguration.exposeIdsFor(Jeu.class);
	}

	/*@PostConstruct
	void init_users() {
		// ajouter les rôles
		userService.addRole(new Role(null, "ADMIN"));
		userService.addRole(new Role(null, "AGENT"));
		userService.addRole(new Role(null, "USER"));
		// ajouter les users
		userService.saveUser(new User(null, "admin", "123", true, null));
		userService.saveUser(new User(null, "eya", "123", true, null));
		userService.saveUser(new User(null, "user1", "123", true, null));
		// ajouter les rôles aux users
		userService.addRoleToUser("admin", "ADMIN");
		userService.addRoleToUser("eya", "USER");
		userService.addRoleToUser("eya", "AGENT");
		userService.addRoleToUser("user1", "USER");
	}*/
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
