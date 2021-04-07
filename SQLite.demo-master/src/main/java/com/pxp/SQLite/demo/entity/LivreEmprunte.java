/**
 * 
 */
package com.pxp.SQLite.demo.entity;



import java.time.LocalDate;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;


/**
 * Classe permettant de gerer les livres empruntés 
 *
 */
@Entity
@Embeddable
public class LivreEmprunte extends Livre {

	/**
	 * 
	 */
	@Id
	private int id;	
	private static final long serialVersionUID = 1L;
	private Abonne emprunteur;
	private LocalDate dateDebutEmprunt;
	private LocalDate dateFinEmprunt;
	private int nbRelances=0;
 
	// for JPA
	public LivreEmprunte() {}
	

	public LivreEmprunte(Auteur auteur, String titre, Abonne emprunteur) {
		super(auteur, titre);
		this.emprunteur = emprunteur;
	}

	public LivreEmprunte(Livre livreAEmprunte, Abonne emprunteur) {
		super(livreAEmprunte.getAuteur(), livreAEmprunte.getTitre());
		this.emprunteur = emprunteur;
	}

	public Abonne getEmprunteur() {
		return emprunteur;
	}

	public void setEmprunteur(Abonne emprunteur) {
		this.emprunteur = emprunteur;
	}

	public LocalDate getDateDebutEmprunt() {
		return dateDebutEmprunt;
	}

	public void setDateDebutEmprunt(LocalDate dateDebutEmprunt) {
		this.dateDebutEmprunt = dateDebutEmprunt;
	}

	public LocalDate getDateFinEmprunt() {
		return dateFinEmprunt;
	}

	public void setDateFinEmprunt(LocalDate dateFinEmprunt) {
		this.dateFinEmprunt = dateFinEmprunt;
	}

	public int getNbRelances() {
		return nbRelances;
	}
	public int incrementNBRelances() {
		nbRelances++;
		return nbRelances;
	}

	public void setNbRelances(int nbRelance) {
		this.nbRelances = nbRelance;
	}
	
	/**
	 * @return the id
	 */
	public synchronized int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public synchronized void setId(int id) {
		this.id = id;
	}	
	

}
