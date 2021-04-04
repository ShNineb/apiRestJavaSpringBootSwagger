package com.pxp.SQLite.demo.controller;

import com.pxp.SQLite.demo.entity.Auteur;
import com.pxp.SQLite.demo.service.AuteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuteurController {

	/**/
	@Autowired 
	private AuteurService auteurService;

	@RequestMapping(value = "/auteur/createauteur", method = RequestMethod.POST)
	public String createAuteur(@RequestBody Auteur auteur) {
		return auteurService.createAuteur(auteur);
	}

	@RequestMapping(value = "/auteur/readauteurs", method = RequestMethod.GET) 
	public List<Auteur> readAuteurs() {
		return auteurService.readAuteurs();
	}

	@RequestMapping(value = "/auteur/updateauteur", method = RequestMethod.PUT)
	public String updateLivre(@RequestBody Auteur auteur) {
		return auteurService.updateAuteur(auteur);
	}

	@RequestMapping(value = "/auteur/deleteauteur", method = RequestMethod.DELETE)
	public String deleteAuteur(@RequestBody Auteur auteur) {
		return auteurService.deleteAuteur(auteur);
	}

	/**/
}