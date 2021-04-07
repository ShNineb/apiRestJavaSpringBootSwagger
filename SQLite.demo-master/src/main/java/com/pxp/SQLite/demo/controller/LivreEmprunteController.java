/**
 * 
 */
package com.pxp.SQLite.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pxp.SQLite.demo.entity.Livre;
import com.pxp.SQLite.demo.entity.LivreEmprunte;
import com.pxp.SQLite.demo.service.LivreEmprunteService;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author U023426
 *
 */
@RestController @Api(value="onlinestore", description="Operations on books") 
public class LivreEmprunteController {
	
	@Autowired 
	private LivreEmprunteService livreEmprunteService;
	
	
	@ApiOperation(value = "View a list of borrowed books", response = Iterable.class)
	@RequestMapping(value = "/livreemprunte/getLivresEmpruntes", method = RequestMethod.GET) 
	public List<LivreEmprunte> getLivresEmpruntes() {
		return livreEmprunteService.getLivresEmpruntes();
	}
	
  
    	
	@ApiOperation(value = "Create a borrowed book", response = Iterable.class)
	@RequestMapping(value = "/livreemprunte/createlivreemprunte{emprunteur}", method = RequestMethod.POST)
	public String createLivreEmprunte(@PathVariable("emprunteur") String emprunteur, @RequestBody Livre livre) {
		return createLivreEmprunte(emprunteur,livre);}
	
	/*
	public String createLivreEmprunte(@RequestBody AbonneLivreEmprunte abonneLivreEmprunte) {
		return createLivreEmprunte(abonneLivreEmprunte); }*/
	
	/*
	public String createLivreEmprunte(@RequestBody Livre livre, @RequestBody String nomEmprunteur) {
		return createLivreEmprunte(livre,nomEmprunteur);
	} */   
	
	


/* TODO: créer une classe qui embarque ces deux classes pour permettre à createLivreEmprunte à fonctionner
	public class AbonneLivreEmprunte {
		private String emprunteur;
		private Livre livre;
		
		AbonneLivreEmprunte () {}
		AbonneLivreEmprunte (String emprunteur ,Livre livre ) {
			this.emprunteur = emprunteur;
			this.livre = livre;
		}

		public String getEmprunteur() {
			return emprunteur;
		}

		public void setEmprunteur(String emprunteur) {
			this.emprunteur = emprunteur;
		}
		public Livre getLivre() {
			return livre;
		}
		public void setLivre(Livre livre) {
			this.livre = livre;
		}		
	}
*/
 
}
