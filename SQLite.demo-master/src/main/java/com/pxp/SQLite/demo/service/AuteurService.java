/**
 * 
 */
package com.pxp.SQLite.demo.service;
import com.pxp.SQLite.demo.entity.Auteur;
//import com.pxp.SQLite.demo.entity.Student;
import com.pxp.SQLite.demo.repository.AuteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuteurService {

    @Autowired
    private AuteurRepository auteurRepository;

    @Transactional
    public String createAuteur(Auteur auteur){
        try {
        	System.out.println("auteur create 1");
            if (!auteurRepository.existsByNom(auteur.getNom())){
            	System.out.println("auteur create 2"+auteur.getNom());
            	auteur.setId(null == auteurRepository.findMaxId()? 0 : auteurRepository.findMaxId() + 1);
            	//livre.setId(null == livreRepository.findByTitre(livre.getTitre())? 0 : livreRepository.findMaxId() + 1);
            	auteurRepository.save(auteur);
                return "Auteur record created successfully.";
            }else {
                return "Auteur already exists in the database.";
            }
        }catch (Exception e){
            throw e;
        }
    }

    /*
    public List<Livre> readLivres(){
        return livreRepository.findAll();
    }*/
    
  /*  public Livre getLivre(String titre){
    	return livreRepository.findByTitre(titre);
         
         //return livreRepository.findOne(titre);
    }
    */
    
    /**/
    public List<Auteur> readAuteurs(){
    	List<Auteur> auteurs = new ArrayList<>();
    	auteurRepository.findAll()
         .forEach(auteurs::add);
         return auteurs;
    }

    @Transactional
    public String updateAuteur(Auteur auteur){
        if (auteurRepository.existsByNom(auteur.getNom())){
            try {
                List<Auteur> auteurs = auteurRepository.findByNom(auteur.getNom());
                auteurs.stream().forEach(s -> {
                	Auteur auteurToBeUpdate = auteurRepository.findById(s.getId()).get();
                	auteurToBeUpdate.setNom(auteur.getNom());  
                    
                	auteurRepository.save(auteurToBeUpdate);
                });
                return "Auteur record updated.";
            }catch (Exception e){
                throw e;
            }
        }else {
            return "Auteur does not exists in the database.";
        }
    }

    @Transactional
    public String deleteAuteur(Auteur auteur){
        if (auteurRepository.existsByNom(auteur.getNom())){
            try {
                List<Auteur> auteurs = auteurRepository.findByNom(auteur.getNom());
                auteurs.stream().forEach(s -> {
                	auteurRepository.delete(s);
                });
                return "Auteur record deleted successfully.";
            }catch (Exception e){
                throw e;
            }

        }else {
            return "Auteur does not exist";
        }
    }
    
   
}


