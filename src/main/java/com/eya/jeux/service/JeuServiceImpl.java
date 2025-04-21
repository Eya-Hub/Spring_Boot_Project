package com.eya.jeux.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.eya.jeux.entities.Jeu;
import com.eya.jeux.entities.Platforme;
import com.eya.jeux.repos.JeuRepository;
import com.eya.jeux.repos.PlatformeRepository;

@Service
public class JeuServiceImpl implements JeuService{
	
	@Autowired 
	JeuRepository jeuRepository;
	
	@Autowired
	PlatformeRepository platformeRepository;

	@Override
	public Jeu saveJeu(Jeu j) {
		return jeuRepository.save(j);
	}

	@Override
	public Jeu updateJeu(Jeu j) {
		return jeuRepository.save(j);
	}

	@Override
	public void deleteJeu(Jeu j) {
		jeuRepository.delete(j);
		
	}

	@Override
	public void deleteJeuById(Long id) {
		jeuRepository.deleteById(id);
		
	}

	@Override
	public Jeu getJeu(Long id) {
		return jeuRepository.findById(id).get();
	}

	@Override
	public List<Jeu> getAllJeux() {
		return jeuRepository.findAll();
	}

	@Override
	public Page<Jeu> getAllJeuxParPage(int page, int size) {
		return jeuRepository.findAll(PageRequest.of(page, size));
	}

	@Override
	public List<Jeu> findByNomJeu(String nom) {
		return jeuRepository.findByNomJeu(nom);
	}

	@Override
	public List<Jeu> findByNomJeuContains(String nom) {
		return jeuRepository.findByNomJeuContains(nom);
	}

	@Override
	public List<Jeu> findByNomPrix(String nom, Double prix) {
		return jeuRepository.findByNomPrix(nom, prix);
	}

	@Override
	public List<Jeu> findByPlatforme(Platforme platforme) {
		return jeuRepository.findByPlatforme(platforme);
	}

	@Override
	public List<Jeu> findByPlatformeIdPlat(Long id) {
		return jeuRepository.findByPlatformeIdPlat(id);
	}

	@Override
	public List<Jeu> findByOrderByNomJeuAsc() {
		return jeuRepository.findByOrderByNomJeuAsc();
	}

	@Override
	public List<Jeu> trierJeuxNomsPrix() {
		return jeuRepository.trierJeuxNomsPrix();
	}
	
	@Override
	public List<Platforme> getAllPlatformes() {
	return platformeRepository.findAll();
	}

}
