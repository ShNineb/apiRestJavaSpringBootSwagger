package com.pxp.SQLite.demo.controller;

import com.pxp.SQLite.demo.entity.Livre;
import com.pxp.SQLite.demo.service.LivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LivreController {

	
	@Autowired 
	private LivreService livreService;

	@RequestMapping(value = "/livre/createlivre", method = RequestMethod.POST)
	public String createLivre(@RequestBody Livre livre) {
		return livreService.createLivre(livre);
	}

	@RequestMapping(value = "/livre/readlivres", method = RequestMethod.GET) 
	public List<Livre> readLivres() {
		return livreService.readLivres();
	}
	

	@RequestMapping(value = "/livre/getLivreParAuteur/{nomAuteur}", method = RequestMethod.GET) 
	public List<Livre> getLivreParAuteur(@PathVariable("nomAuteur") String nomAuteur) {
		return livreService.getLivreParAuteur(nomAuteur);
	}

	@RequestMapping(value = "/livre/updatelivre/{titre}", method = RequestMethod.PUT)
	public String updateLivre(@PathVariable("titre") String titre, @RequestBody Livre livre) {
		System.out.println("livre update 22 "+ titre );
		return livreService.updateLivre(titre,livre);
	}

	@RequestMapping(value = "/livre/deletelivre", method = RequestMethod.DELETE)
	public String deleteLivre(@RequestBody Livre livre) {
		return livreService.deleteLivre(livre);
	}

	
}
