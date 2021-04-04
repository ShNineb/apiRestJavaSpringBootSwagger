/**
 * 
 */
package com.pxp.SQLite.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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
    private int id; 
	private static final long serialVersionUID = 1L;
	private Auteur auteur;    
    
	//@ManyToOne 
	//private String auteur;
	private String titre;
	private String resume;
	private int anneePublication;
	private int nbTomes;
	private String theme;

	public Livre() {
    }
	 
	/*
	public Livre(String auteur, String titre) {
		this.auteur = auteur;
		this.titre = titre;
	}*/
	
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

	/*
	public String getAuteur() {
		return auteur;
	}*/

	
	public Auteur getAuteur() {
		return auteur;
	} 	

	/*
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}*/
	
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
	

