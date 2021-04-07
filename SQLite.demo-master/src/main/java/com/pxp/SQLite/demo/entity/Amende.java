/**
 * 
 */
package com.pxp.SQLite.demo.entity;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author U023426
 *
 */
@Entity
@Embeddable
public class Amende {
	@Id
	private int id;
	private double montantAmende;
	//private LivreEmprunte livreEnRetard; //LivreEmprunte inclus Abonne qui inclut Amende qui lui même inclut LivreEmprunte => on enlève

	public Amende() {}
	
	public Amende(double montantAmende) {
		
		this.montantAmende = montantAmende;
	}	
	 

	public Amende(LivreEmprunte livreEmprunte, double montantAmende) {
	//	this.livreEnRetard = livreEmprunte;
		this.montantAmende = montantAmende;
	}


	/**
	 *
	 */
	@Override	
	public boolean equals(Object amendeIdentique) {
		if (this == amendeIdentique) {
			return true;
		}
		if (amendeIdentique instanceof Amende) {
			return (montantAmende == (((Amende) amendeIdentique).getMontantAmende())
					//&& (livreEnRetard.equals(((Amende) amendeIdentique).getLivreEnRetard()))
					);
		}
		return false;

	}

	/*
	@Override
	public int hashCode() {
		return livreEnRetard.hashCode();
	}*/

	public double getMontantAmende() {
		return montantAmende;
	}


	/**
	 * @param montantAmende
	 */
	public void setMontantAmende(double montantAmende) {
		this.montantAmende = montantAmende;
	}

/*
	public LivreEmprunte getLivreEnRetard() {
		return livreEnRetard;
	}

	public void setLivreEnRetard(LivreEmprunte livreEnRetard) {
		this.livreEnRetard = livreEnRetard;
	}*/

}
