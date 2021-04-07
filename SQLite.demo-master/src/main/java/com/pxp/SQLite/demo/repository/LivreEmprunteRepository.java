/**
 * 
 */
package com.pxp.SQLite.demo.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.pxp.SQLite.demo.entity.LivreEmprunte;

/**
 * LivreEmprunteRepository héritant de LivreBaseRepository 
 *
 */
@Repository
@Transactional
public interface LivreEmprunteRepository extends LivreBaseRepository<LivreEmprunte>, JpaRepository<LivreEmprunte, Integer>{

}
