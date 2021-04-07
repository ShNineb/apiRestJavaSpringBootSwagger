/**
 * 
 */
package com.pxp.SQLite.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pxp.SQLite.demo.entity.Amende;

@Repository
public interface AmendeRepository extends JpaRepository<Amende, Integer>{

}
