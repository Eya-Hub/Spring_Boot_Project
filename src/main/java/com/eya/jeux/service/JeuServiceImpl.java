package com.eya.jeux.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.eya.jeux.entities.Jeu;
import com.eya.jeux.repos.JeuRepository;

@Service
public class JeuServiceImpl implements JeuService{
	
	@Autowired 
	JeuRepository jeuRepository;

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

}
