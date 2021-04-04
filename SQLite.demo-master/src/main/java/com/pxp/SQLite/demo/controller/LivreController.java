package com.pxp.SQLite.demo.controller;

import com.pxp.SQLite.demo.entity.Livre;
import com.pxp.SQLite.demo.service.LivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LivreController {

	/**/
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

	@RequestMapping(value = "/livre/updatelivre", method = RequestMethod.PUT)
	public String updateLivre(@RequestBody Livre livre) {
		return livreService.updateLivre(livre);
	}

	@RequestMapping(value = "/livre/deletelivre", method = RequestMethod.DELETE)
	public String deleteLivre(@RequestBody Livre livre) {
		return livreService.deleteLivre(livre);
	}

	/**/
}
