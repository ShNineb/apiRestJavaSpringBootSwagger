/**
 * 
 */
package com.pxp.SQLite.demo.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pxp.SQLite.demo.entity.Auteur;
import com.pxp.SQLite.demo.entity.Livre;


/**
 * 
 *
 */
@Repository
@Transactional
public interface LivreRepository extends JpaRepository<Livre, Integer> {


    public boolean existsByTitre(String titre);
    public boolean existsByTheme(String theme);
    public boolean existsByAuteurNom(String nomAuteur);
         

    public Livre findByTitre(String titre);
    public List<Livre> findByTheme(String theme);    
    public List<Livre> findByAuteur(Auteur auteur);

    public void deleteByTitre(String titre);
    List<Livre> findByAuteurNom(String nom);  
    
        
    @Query("select max(s.id) from Livre s")
	public Integer findMaxId();
        
}
 