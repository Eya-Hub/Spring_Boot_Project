package com.eya.jeux.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.eya.jeux.entities.Jeu;
import com.eya.jeux.entities.Platforme;

public interface JeuService {
	Jeu saveJeu(Jeu j);
	Jeu updateJeu(Jeu j);
	void deleteJeu(Jeu j);
	void deleteJeuById(Long id);
	Jeu getJeu(Long id);
	List<Jeu> getAllJeux();
	List<Jeu> findByNomJeu(String nom);
	List<Jeu> findByNomJeuContains(String nom);
	List<Jeu> findByNomPrix (String nom, Double prix);
	List<Jeu> findByPlatforme (Platforme platforme);
	List<Jeu> findByPlatformeIdPlat(Long id);
	List<Jeu> findByOrderByNomJeuAsc();
	List<Jeu> trierJeuxNomsPrix();
	
	Page<Jeu> getAllJeuxParPage(int page, int size);
}
