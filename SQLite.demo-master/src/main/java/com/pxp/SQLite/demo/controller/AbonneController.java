/**
 * 
 */
package com.pxp.SQLite.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pxp.SQLite.demo.entity.Abonne;
import com.pxp.SQLite.demo.entity.Auteur;
import com.pxp.SQLite.demo.service.AbonneService;


import io.swagger.annotations.ApiOperation;

/**
 * @author U023426
 *
 */
@RestController
public class AbonneController {

	@Autowired 
	private AbonneService abonneService;


	@ApiOperation(value = "Create an Abonne", response = Iterable.class)
	@RequestMapping(value = "/student/createabonne", method = RequestMethod.POST)
	public String createAbonne(@RequestBody String nomAbonne) {
		return abonneService.createAbonne(nomAbonne);
	}	
	
	//List<Abonne> getAbonne()
	@ApiOperation(value = "View a list of abonnes", response = Iterable.class)
	@RequestMapping(value = "/student/getabonnes", method = RequestMethod.GET) 
	public List<Abonne> getAbonnes() {
		return abonneService.getAbonnes();
	}	
}
