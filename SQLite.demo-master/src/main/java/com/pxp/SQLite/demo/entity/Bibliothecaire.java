/**
 * 
 */
package com.pxp.SQLite.demo.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author U023426
 *
 */
@Data 
@NoArgsConstructor
@AllArgsConstructor
public class Bibliothecaire {

	private HashMap<Auteur, ArrayList<Livre>> catalogue;
	private List<LivreEmprunte> livresEmpruntes;
	private int NB_JOURS_EMPRUNT_MAX = 30;
	private double MONTANT_AMENDE = 2;

	
	public Bibliothecaire() {}
		
	public Bibliothecaire(HashMap<Auteur, ArrayList<Livre>> catalogue) {
		this.catalogue = catalogue;
		livresEmpruntes = new ArrayList<LivreEmprunte>();
	}
	
	/**
	 * @return the catalogue
	 */
	public HashMap<Auteur, ArrayList<Livre>> getCatalogue() {
		return catalogue;
	}

	/**
	 * @param catalogue the catalogue to set
	 */
	public void setCatalogue(HashMap<Auteur, ArrayList<Livre>> catalogue) {
		this.catalogue = catalogue;
	}	

	
	
	/**
	 * methode permettant d'ajouter un livre au catalogue des livres de la
	 * bibliotheque
	 * 
	 * @param nouveauLivre : le nouveau livre a jouter dans la bibliotheque
	 * @return ArrayList<Livre> :une liste de livres
	 */
	public ArrayList<Livre> ajouterLivre(Livre nouveauLivre) {
		Auteur auteur = nouveauLivre.getAuteur();
		if (Objects.nonNull(getCatalogue().get(auteur))) {
			getCatalogue().get(auteur).add(nouveauLivre);
		} else {
			ArrayList<Livre> livres = new ArrayList<>();
			livres.add(nouveauLivre);
			getCatalogue().put(auteur, livres);
		}
		return getCatalogue().get(auteur);

	}
	
}
