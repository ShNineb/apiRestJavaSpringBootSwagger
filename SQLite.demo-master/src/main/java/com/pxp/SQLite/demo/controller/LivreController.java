package com.pxp.SQLite.demo.controller;

import com.pxp.SQLite.demo.entity.Livre;
import com.pxp.SQLite.demo.service.LivreService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController @Api(value="onlinestore", description="Operations on books") 
public class LivreController {

	
	@Autowired 
	private LivreService livreService;

	@ApiOperation(value = "Create a book", response = Iterable.class)
	@RequestMapping(value = "/livre/createlivre", method = RequestMethod.POST)
	public String createLivre(@RequestBody Livre livre) {
		return livreService.createLivre(livre);
	}
	
	@ApiOperation(value = "View a list of books", response = Iterable.class)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Successfully retrieved list"),
	        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})		
	@RequestMapping(value = "/livre/getlivres", method = RequestMethod.GET) 
	public List<Livre> getLivres() {
		return livreService.getLivres();
	}
	
    @ApiModelProperty(
    	    value = "test de ApiModelProperty",
    	    example = "{nomAuteur: nomAuteur}")
	@ApiOperation(value = "Update a book through a title", response = Iterable.class)  
	@RequestMapping(value = "/livre/getLivreParAuteur/{nomAuteur}", method = RequestMethod.GET) 
	public List<Livre> getLivresParAuteur(@PathVariable("nomAuteur") String nomAuteur) {
		return livreService.getLivresParAuteur(nomAuteur);
	}
    
	@ApiOperation(value = "View a list of books by theme", response = Iterable.class)
	@RequestMapping(value = "/livre/getLivresParTheme/{theme}", method = RequestMethod.GET) 
	public List<Livre> getLivresParTheme(@PathVariable("theme") String theme) {
		return livreService.getLivresParTheme(theme);
	}

	@ApiOperation(value = "Update a book through a title", response = Iterable.class)  
	@RequestMapping(value = "/livre/updatelivre/{titre}", method = RequestMethod.PUT)
	public String updateLivre(@PathVariable("titre") String titre, @RequestBody Livre livre) {		
		return livreService.updateLivre(titre,livre);
	}

	@ApiOperation(value = "Delete a book through a title", response = Iterable.class)  
	@RequestMapping(value = "/livre/deletelivre", method = RequestMethod.DELETE)
	public String deleteLivre( @RequestBody Livre livre) {
		return livreService.deleteLivre(livre);
	}

	
}
