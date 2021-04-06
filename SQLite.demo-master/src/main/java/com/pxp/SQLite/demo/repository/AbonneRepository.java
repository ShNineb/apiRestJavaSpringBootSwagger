/**
 * 
 */
package com.pxp.SQLite.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pxp.SQLite.demo.entity.Abonne;
import com.pxp.SQLite.demo.entity.Auteur;



/**
 * @author U023426
 *
 */
@Repository
public interface AbonneRepository extends JpaRepository<Abonne, Integer>{

	public boolean existsByNom(String nom);
		
	@Query("select s.nom from Abonne s")
	public Abonne findByNom();
	
    @Query("select max(s.id) from Abonne s")
	public Integer findMaxId();
    
/*    @Query("select max(s.identifiant) from Abonne s")
	public Integer findMaxIdentifiant();*/
	
}
