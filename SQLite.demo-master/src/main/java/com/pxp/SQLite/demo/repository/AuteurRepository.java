/**
 * 
 */
package com.pxp.SQLite.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.pxp.SQLite.demo.entity.Auteur;


/**
 * 
 *
 */
@Repository
public interface AuteurRepository extends JpaRepository<Auteur, Integer>{
	
	public boolean existsByNom(String nom);
	
	public List<Auteur> findByNom(String nom);
	
	@Query("select s.nom from Auteur s")
	public String findByNom();
	
    @Query("select max(s.id) from Auteur s")
	public Integer findMaxId();
   
}
