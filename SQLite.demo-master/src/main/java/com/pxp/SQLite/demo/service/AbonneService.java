/**
 * 
 */
package com.pxp.SQLite.demo.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pxp.SQLite.demo.entity.Abonne;
import com.pxp.SQLite.demo.repository.AbonneRepository;


/**
 * @author U023426
 *
 */
@Service
public class AbonneService {

    @Autowired
    private AbonneRepository abonneRepository;	
    
	/**
	 * methode permettant d'ajouter un abonne
	 * 
	 * @param nomAbonne : le nouvel nomAbonne à ajouter si il n'existe pas 
	 * @return string : état de l'enregistrement nouvel nomAbonne à ajouter si il n'existe pas, sinon rien à faire
	 */   
  
    @Transactional
    public String createAbonne(String nomAbonne){
        try {
        	System.out.println("auteur create 1" + nomAbonne);
            if (!abonneRepository.existsByNom(nomAbonne)){
            	System.out.println("auteur create 2"+nomAbonne);
            	Abonne abonne = new Abonne(); 
            //	abonne.setIdentifiant(null == abonneRepository.findMaxIdentifiant()? 0 : abonneRepository.findMaxIdentifiant() + 1);
            	abonne.setNom(nomAbonne);
            	abonneRepository.save(abonne);
                return "nomAbonne record created successfully.";
            }else {
                return "nomAbonne already exists in the database.";
            }
        }catch (Exception e){
            throw e;
        }
    }	
    
	/**
	 * méthode permettant de lister toutes les abonnes présents dans le catalogue (BD)
	 * de la bibliotheque 
	 * 
	 * @return abonnes : List<Abonne> liste des abonnes
	 */
    public List<Abonne> getAbonnes(){
    	List<Abonne> abonnes = new ArrayList<>();
    	abonneRepository.findAll()
         .forEach(abonnes::add);
         return abonnes;
    }    
	
	
}
