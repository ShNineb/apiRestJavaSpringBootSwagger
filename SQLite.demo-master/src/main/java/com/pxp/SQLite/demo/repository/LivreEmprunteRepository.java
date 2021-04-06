/**
 * 
 */
package com.pxp.SQLite.demo.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pxp.SQLite.demo.entity.Abonne;
import com.pxp.SQLite.demo.entity.LivreEmprunte;

/**
 * @author U023426
 *
 */
@Repository
@Transactional
public interface LivreEmprunteRepository extends LivreBaseRepository<LivreEmprunte>, JpaRepository<LivreEmprunte, Integer>{/**/
//@Repository
//public interface LivreEmprunteRepository extends JpaRepository<LivreEmprunte, Integer>{
	/*
    @Query("select max(s.idLivreEmprunte) from LivreEmprunte s")
	public Integer findMaxIdLivreEmprunte();*/	 
}
