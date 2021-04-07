/**
 * 
 */
package com.pxp.SQLite.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

import com.pxp.SQLite.demo.entity.Livre;

/**
 * Interface générique pour gérer l'héritage, LivreRepository et LivreEmprunteRepository en héritent
 *
 */
@NoRepositoryBean
public interface LivreBaseRepository<T extends Livre> extends JpaRepository<T, Integer> { 
	
	@Query("select u from #{#entityName} as u where u.titre = ?1 ")
    public boolean existsByTitre(String titre);
	
    @Query("select max(s.id) from #{#entityName} s")
	public Integer findMaxId();
}
