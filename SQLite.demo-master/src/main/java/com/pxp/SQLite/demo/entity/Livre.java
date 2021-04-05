/**
 * 
 */
package com.pxp.SQLite.demo.entity;

import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author U023426
 *
 */
@Entity
public class Livre  {

	/**
	 * 
	 */
	
    @Id
    @ApiModelProperty(notes = "The database generated Livre ID")
    private int id; 
	private static final long serialVersionUID = 1L;
	//@Embedded
	@ApiModelProperty(notes = " auteur une instance de la classe Auteur")
/*	@ApiModelProperty(
			  value = "auteur une instance de la classe Auteur",
			  name = "auteur",
			  dataType = "Auteur",
			  example = "Vatsal")*/
	private Auteur auteur;    
	@ApiModelProperty(notes = " titre du Livre")
	private String titre;
	@ApiModelProperty(notes = " résumé du Livre")
	private String resume;
	@ApiModelProperty(notes = " année de publication")
	private int anneePublication;
	@ApiModelProperty(notes = " nombre de tomes")
	private int nbTomes;
	@ApiModelProperty(notes = " thèmatique")
	private String theme;	
	private HashMap<Auteur, ArrayList<Integer>> catalogue;
	//@ElementCollection
	private HashMap<Auteur, ArrayList<Livre>> catAuteurLivre;
	
	

	
	
	
	/**
	 * @return the catAuteurLivre
	 */
	public synchronized HashMap<Auteur, ArrayList<Livre>> getCatAuteurLivre() {
		return catAuteurLivre;
	}

	/**
	 * @param catAuteurLivre the catAuteurLivre to set
	 */
	public synchronized void setCatAuteurLivre(HashMap<Auteur, ArrayList<Livre>> catAuteurLivre) {
		this.catAuteurLivre = catAuteurLivre;
	}

	/**
	 * @return the catalogue
	 */
	public HashMap<Auteur, ArrayList<Integer>> getCatalogue() {
		return catalogue;
	}

	/**
	 * @param catalogue the catalogue to set
	 */
	public void setCatalogue(HashMap<Auteur, ArrayList<Integer>> catalogue) {
		this.catalogue = catalogue;
	}

	public Livre() {
    }
	 
	
	public Livre(Auteur auteur, String titre) {
		this.auteur = auteur;
		this.titre = titre;
	}	

	@Override
	public boolean equals(Object livreIdentique) {
		if (this == livreIdentique) {
			return true;
		}
		if (livreIdentique instanceof Livre) {
			return (titre.equals(((Livre) livreIdentique).getTitre())
					&& (auteur.equals(((Livre) livreIdentique).getAuteur())));
		}
		return false;

	}

	@Override
	public int hashCode() {
		return titre.hashCode() + auteur.hashCode();
	}

	
	public Auteur getAuteur() {
		return auteur;
	} 	


	public void setAuteur(Auteur auteur) {
		this.auteur = auteur;
	}

	public int getAnneePublication() {
		return anneePublication;
	}

	public void setAnneePublication(int anneePublication) {
		this.anneePublication = anneePublication;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public int getNbTomes() {
		return nbTomes;
	}

	public void setNbTomes(int nbTomes) {
		this.nbTomes = nbTomes;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}
	

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

}
	

