/**
 * 
 */
package com.pxp.SQLite.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

import com.pxp.SQLite.demo.entity.Livre;
import com.pxp.SQLite.demo.entity.LivreEmprunte;

/**
 * @author U023426
 *
 */
@NoRepositoryBean
public interface LivreBaseRepository<T extends Livre> extends JpaRepository<T, Integer> { 
	
	@Query("select u from #{#entityName} as u where u.titre = ?1 ")
    public boolean existsByTitre(String titre);
	
    @Query("select max(s.id) from #{#entityName} s")
	public Integer findMaxId();
}
