package com.eya.jeux.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.eya.jeux.dto.JeuDTO;
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
	
	@Autowired
	ModelMapper modelMapper;

	@Override
	public JeuDTO saveJeu(JeuDTO j) {
		return convertEntityToDto(jeuRepository.save(convertDtoToEntity(j)));
	}

	@Override
	public JeuDTO updateJeu(JeuDTO j) {
		return convertEntityToDto(jeuRepository.save(convertDtoToEntity(j)));
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
	public JeuDTO getJeu(Long id) {
		return convertEntityToDto(jeuRepository.findById(id).get());
	}

	@Override
	public List<JeuDTO> getAllJeux() {
		return jeuRepository.findAll().stream()
				.map(this::convertEntityToDto) 
				.collect(Collectors.toList());
		
		//OU BIEN
		/*List<Produit> prods = produitRepository.findAll();
		List<ProduitDTO> listprodDto = new ArrayList<>(prods.size());
		for (Produit p : prods)
		listprodDto.add(convertEntityToDto(p));
		return listprodDto;*/
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
	
	
	
	@Override
	public JeuDTO convertEntityToDto(Jeu jeu) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		JeuDTO jeuDTO = modelMapper.map(jeu, JeuDTO.class);
		/*jeuDTO.setIdJeu(jeu.getIdJeu());
		jeuDTO.setNomJeu(jeu.getNomJeu());
		jeuDTO.setPrixJeu(jeu.getPrixJeu());
		jeuDTO.setDateSortieJeu(jeu.getDateSortieJeu());
		jeuDTO.setPlatforme(jeu.getPlatforme());*/
		return jeuDTO;
		
		  	/*return JeuDTO.builder() 
				  .idJeu(jeu.getIdJeu())
				  .nomJeu(jeu.getNomJeu()) 
				  //.prixJeu(jeu.getPrixJeu())
				  .dateSortieJeu(jeu.getDateSortieJeu()) 
				  .nomPlat(jeu.getPlatforme().getNomPlat())
				  //.platforme(jeu.getPlatforme())
				  .build();*/
		 
	}

	@Override
	public Jeu convertDtoToEntity(JeuDTO jeuDto) {
		Jeu jeu = new Jeu();
		jeu = modelMapper.map(jeuDto, Jeu.class);
		/*jeu.setIdJeu(jeuDto.getIdJeu());
		jeu.setNomJeu(jeuDto.getNomJeu());
		jeu.setPrixJeu(jeuDto.getPrixJeu());
		jeu.setDateSortieJeu(jeuDto.getDateSortieJeu());
		jeu.setPlatforme(jeuDto.getPlatforme());*/
		return jeu;
	}

}
