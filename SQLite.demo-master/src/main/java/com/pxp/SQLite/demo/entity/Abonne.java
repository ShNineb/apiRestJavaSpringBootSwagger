/**
 * 
 */
package com.pxp.SQLite.demo.entity;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;

import io.swagger.annotations.ApiModelProperty;

@Entity
//@Embeddable
public class Abonne implements Serializable {

	/**
	 * 
	 */
    @Id
    @ApiModelProperty(notes = "The database generated Livre ID")
	//private long identifiant;
    private int id; 
	private static final long serialVersionUID = 1730766440161300177L;
	private String nom;
	private long identifiant;
	private ArrayList<Amende> amendes;
	
	public Abonne() {}
	

	public Abonne(String nom, long identifiant) {
		this.setNom(nom);
		this.setIdentifiant(identifiant);
		amendes=new ArrayList<Amende>();
	}

	
	public void envoyerAmende(Amende amende) {
		if(amendes.indexOf(amende)==-1) {
			amendes.add(amende);
		}		
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}


	public long getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(long identifiant) {
		this.identifiant = identifiant;
	}


	public ArrayList<Amende> getAmendes() {
		return amendes;
	}


	public void setAmendes(ArrayList<Amende> amendes) {
		this.amendes = amendes;
	}
	
	/**
	 * @return the id
	 */
	/**/
	public synchronized int getId() {
		return id;
	}/**/

	/**
	 * @param id the id to set
	 */
	/**/
	public synchronized void setId(int id) {
		this.id = id;
	}/**/


}
