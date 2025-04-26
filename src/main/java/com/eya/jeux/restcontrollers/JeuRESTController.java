package com.eya.jeux.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eya.jeux.dto.JeuDTO;
import com.eya.jeux.entities.Jeu;
import com.eya.jeux.service.JeuService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class JeuRESTController {
	
	@Autowired
	JeuService jeuService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<JeuDTO> getAllJeux() {
	return jeuService.getAllJeux();
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public JeuDTO getJeuById(@PathVariable("id") Long id) { 
		return jeuService.getJeu(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public JeuDTO createJeu(@RequestBody JeuDTO jeuDTO) {
	return jeuService.saveJeu(jeuDTO);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public JeuDTO updateJeu(@RequestBody JeuDTO jeuDTO) {
	return jeuService.updateJeu(jeuDTO);
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void deleteJeu(@PathVariable("id") Long id) {
	jeuService.deleteJeuById(id);
	}
	
	@RequestMapping(value="/prodscat/{idPlat}",method = RequestMethod.GET)
	public List<Jeu> getJeuxByPlatId(@PathVariable("idPlat") Long idPlat) {
	return jeuService.findByPlatformeIdPlat(idPlat);
	}
}
