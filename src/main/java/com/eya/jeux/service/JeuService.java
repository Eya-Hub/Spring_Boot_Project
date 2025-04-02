package com.eya.jeux.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.eya.jeux.entities.Jeu;

public interface JeuService {
	Jeu saveJeu(Jeu j);
	Jeu updateJeu(Jeu j);
	void deleteJeu(Jeu j);
	void deleteJeuById(Long id);
	Jeu getJeu(Long id);
	List<Jeu> getAllJeux();
	
	Page<Jeu> getAllJeuxParPage(int page, int size);
}
