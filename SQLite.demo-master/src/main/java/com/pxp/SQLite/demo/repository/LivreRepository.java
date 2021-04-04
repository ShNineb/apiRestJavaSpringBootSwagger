/**
 * 
 */
package com.pxp.SQLite.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pxp.SQLite.demo.entity.Livre;


/**
 * 
 *
 */
@Repository
public interface LivreRepository extends JpaRepository<Livre, Integer> {

    public boolean existsByTitre(String titre);

     
    public List<Livre> findByTitre(String titre);


    @Query("select max(s.id) from Livre s")
	public Integer findMaxId();
}
 