/**
 * 
 */
package com.pxp.SQLite.demo.service;
import com.pxp.SQLite.demo.entity.Auteur;
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

	/**
	 * methode permettant d'ajouter un auteur
	 * 
	 * @param auteur : le nouvel auteur à ajouter si il n'existe pas 
	 * @return string : état de l'enregistrement nouvel auteur à ajouter si il n'existe pas, sinon rien à faire
	 */       
    @Transactional
    public String createAuteur(Auteur auteur){
        try {
        	System.out.println("auteur create 1");
            if (!auteurRepository.existsByNom(auteur.getNom())){
            	System.out.println("auteur create 2"+auteur.getNom());
            	auteur.setId(null == auteurRepository.findMaxId()? 0 : auteurRepository.findMaxId() + 1);
            	auteurRepository.save(auteur);
                return "Auteur record created successfully.";
            }else {
                return "Auteur already exists in the database.";
            }
        }catch (Exception e){
            throw e;
        }
    }

	/**
	 * méthode permettant de lister toutes les auteurs présents dans le catalogue (BD)
	 * de la bibliotheque 
	 * 
	 * @return auteurs : List<Auteur> liste des auteurs
	 */     
    public List<Auteur> getAuteurs(){
    	List<Auteur> auteurs = new ArrayList<>();
    	auteurRepository.findAll()
         .forEach(auteurs::add);
         return auteurs;
    }

	/**
	 * méthode permettant de mettre à jour un auteur à partir de son nom
	 * 
	 * @param auteur: auteur de l'auteur recherché
	 * @return string : commentaire décrivant l'état de la mise à jour: possible ou pas (si l'auteur n'existe pas) 
	 */
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
 
	/**
	 * methode permettant d'enlever un auteur du catalogue de la bibliotheque
	 * 
	 * @param auteur: auteur a enlever
	 * @return : String: un commentaire de l'état de l'action: auteur a bien été enlevé ou pas
	 *         
	 */       
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


