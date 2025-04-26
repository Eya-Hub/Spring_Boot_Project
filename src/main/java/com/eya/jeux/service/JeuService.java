package com.eya.jeux.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.eya.jeux.dto.JeuDTO;
import com.eya.jeux.entities.Jeu;
import com.eya.jeux.entities.Platforme;

public interface JeuService {
	JeuDTO saveJeu(JeuDTO j);
	JeuDTO updateJeu(JeuDTO j);
	void deleteJeu(Jeu j);
	void deleteJeuById(Long id);
	JeuDTO getJeu(Long id);
	List<JeuDTO> getAllJeux();
	List<Jeu> findByNomJeu(String nom);
	List<Jeu> findByNomJeuContains(String nom);
	List<Jeu> findByNomPrix (String nom, Double prix);
	List<Jeu> findByPlatforme (Platforme platforme);
	List<Jeu> findByPlatformeIdPlat(Long id);
	List<Jeu> findByOrderByNomJeuAsc();
	List<Jeu> trierJeuxNomsPrix();
	List<Platforme> getAllPlatformes();
	Page<Jeu> getAllJeuxParPage(int page, int size);
	JeuDTO convertEntityToDto (Jeu jeu);
	Jeu convertDtoToEntity(JeuDTO jeuDto);
}
