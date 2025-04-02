package com.eya.jeux;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.eya.jeux.entities.Jeu;
import com.eya.jeux.repos.JeuRepository;
import com.eya.jeux.service.JeuService;

@SpringBootTest
class JeuxApplicationTests {

	@Autowired
	private JeuRepository jeuRepository;
	
	@Autowired
	private JeuService jeuService;

	@Test
	public void testCreateJeu() {
		Jeu game = new Jeu("Resident Evil Village", 139.99, new Date());
		jeuRepository.save(game);
	}

	@Test
	public void testFindJeu() {
		Jeu j = jeuRepository.findById(1L).get();
		System.out.println(j);
	}

	@Test
	public void testUpdateJeu() {
		Jeu j = jeuRepository.findById(1L).get();
		j.setPrixJeu(1000.0);
		jeuRepository.save(j);
	}

	@Test
	public void testDeleteJeu() {
		jeuRepository.deleteById(2L);
	}

	@Test
	public void testFindAllJeux() {
		List<Jeu> games = jeuRepository.findAll();
		for (Jeu j : games) {
			System.out.println(j);
		}
	}
	
	@Test
	public void testFindByNomProduitContains() {
		Page<Jeu> games = jeuService.getAllJeuxParPage(0, 2);
		System.out.println(games.getSize());
		System.out.println(games.getTotalElements());
		System.out.println(games.getTotalPages());
		games.getContent().forEach(j -> {
			System.out.println(j.toString());
		});
		/*
		 * ou bien for (Jeu j : games) { System.out.println(j); }
		 */
	}

}
