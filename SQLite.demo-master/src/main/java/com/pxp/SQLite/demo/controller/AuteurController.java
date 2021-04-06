package com.pxp.SQLite.demo.controller;

import com.pxp.SQLite.demo.entity.Auteur;
import com.pxp.SQLite.demo.service.AuteurService;

import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuteurController {

	
	@Autowired 
	private AuteurService auteurService;

	@ApiOperation(value = "Create an author", response = Iterable.class)
	@RequestMapping(value = "/auteur/createauteur", method = RequestMethod.POST)
	public String createAuteur(@RequestBody Auteur auteur) {
		return auteurService.createAuteur(auteur);
	}

	@ApiOperation(value = "View a list of authors", response = Iterable.class)
	@RequestMapping(value = "/auteur/getauteurs", method = RequestMethod.GET) 
	public List<Auteur> getAuteurs() {
		return auteurService.getAuteurs();
	}

	@ApiOperation(value = "Update an author", response = Iterable.class)  
	@RequestMapping(value = "/auteur/updateauteur", method = RequestMethod.PUT)
	public String updateLivre(@RequestBody Auteur auteur) {
		return auteurService.updateAuteur(auteur);
	}

	@ApiOperation(value = "Delete an author", response = Iterable.class)  
	@RequestMapping(value = "/auteur/deleteauteur", method = RequestMethod.DELETE)
	public String deleteAuteur(@RequestBody Auteur auteur) {
		return auteurService.deleteAuteur(auteur);
	}


}