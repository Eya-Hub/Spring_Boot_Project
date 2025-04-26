package com.eya.jeux.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.eya.jeux.dto.JeuDTO;
import com.eya.jeux.entities.Jeu;
import com.eya.jeux.entities.Platforme;
import com.eya.jeux.service.JeuService;

import jakarta.validation.Valid;

@Controller
public class JeuController {
	@Autowired
	JeuService jeuService;
	
	@GetMapping("/accessDenied")
	public String error()
	{
	return "accessDenied";
	}

	@RequestMapping("/ListeJeux")
	public String listeJeux(ModelMap modelMap, 
			@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "3") int size) {
		Page<Jeu> games = jeuService.getAllJeuxParPage(page, size);
		modelMap.addAttribute("jeux", games);
		modelMap.addAttribute("pages", new int[games.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);
		return "listeJeux";
	}

	@RequestMapping("/showCreate")
	public String showCreate(ModelMap modelMap) {
		List<Platforme> plats = jeuService.getAllPlatformes();
		modelMap.addAttribute("jeu", new Jeu());
		modelMap.addAttribute("mode", "new");
		modelMap.addAttribute("platformes", plats);
		return "formJeu";
	}

	@RequestMapping("/saveJeu")
	public String saveJeu(@Valid Jeu jeu, BindingResult bindingResult,
			@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "3") int size) {
		int currentPage;
		boolean isNew = false;
		if (bindingResult.hasErrors()) return "formJeu";
		if (jeu.getIdJeu()==null) //ajout
			isNew=true;
		jeuService.saveJeu(jeu);
		if (isNew) //ajout
		{
		Page<Jeu> games = jeuService.getAllJeuxParPage(page, size);
		currentPage = games.getTotalPages()-1;
		}
		else //modif
		currentPage=page;
		//return "formJeu";
		return ("redirect:/ListeJeux?page="+currentPage+"&size="+size);
	}     

	@RequestMapping("/supprimerJeu")
	public String supprimerJeu(@RequestParam("id") Long id, ModelMap modelMap,
			@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "3") int size) {
		jeuService.deleteJeuById(id);
		Page<Jeu> games = jeuService.getAllJeuxParPage(page, size);
		modelMap.addAttribute("jeux", games);
		modelMap.addAttribute("pages", new int[games.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);
		return "listeJeux";
	}

	@RequestMapping("/modifierJeu")
	public String editerJeu(@RequestParam("id") Long id, ModelMap modelMap,
			@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "3") int size) {
		JeuDTO j = jeuService.getJeu(id);
		List<Platforme> plats = jeuService.getAllPlatformes();
		modelMap.addAttribute("jeu", j);
		modelMap.addAttribute("mode", "edit");
		modelMap.addAttribute("platformes", plats);
		modelMap.addAttribute("page", page);
		modelMap.addAttribute("size", size);
		return "formJeu";
	}

	@RequestMapping("/updateJeu")
	public String updateProduit(@ModelAttribute("jeu") Jeu jeu, @RequestParam("date") String date, ModelMap modelMap)
			throws ParseException {
		// conversion de la date
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateSortieJeu = dateformat.parse(String.valueOf(date));
		jeu.setDateSortieJeu(dateSortieJeu);
		jeuService.updateJeu(jeu);
		List<JeuDTO> games = jeuService.getAllJeux();
		modelMap.addAttribute("jeux", games);
		return "listeJeux";
	}
	
	@GetMapping(value = "/") 
	public String welcome() { 
		return "index";
	}
}
