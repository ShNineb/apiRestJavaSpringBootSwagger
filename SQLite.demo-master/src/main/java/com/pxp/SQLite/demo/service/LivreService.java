package com.pxp.SQLite.demo.service;

import com.pxp.SQLite.demo.entity.Auteur;
import com.pxp.SQLite.demo.entity.Livre;
//import com.pxp.SQLite.demo.repository.AuteurRepository;
//import com.pxp.SQLite.demo.entity.Student;
import com.pxp.SQLite.demo.repository.LivreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class LivreService {

    @Autowired
    private LivreRepository livreRepository;
   @Autowired
    private AuteurService auteurService;

    @Transactional
    public String createLivre(Livre livre){
        try {
            if (!livreRepository.existsByTitre(livre.getTitre())){
            	System.out.println("livre create 2"+livre);

            	livre.setId(null == livreRepository.findMaxId()? 0 : livreRepository.findMaxId() + 1);
            	Auteur auteur = livre.getAuteur();
            	auteurService.createAuteur(auteur);
                livreRepository.save(livre);
                return "Book record created successfully.";
            }else {
                return "Book already exists in the database.";
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
    public List<Livre> readLivres(){
    	List<Livre> livres = new ArrayList<>();
    	livreRepository.findAll()
         .forEach(livres::add);
         return livres;
    }

    @Transactional
    public String updateLivre(Livre livre){
        if (livreRepository.existsByTitre(livre.getTitre())){
            try {
                List<Livre> livres = livreRepository.findByTitre(livre.getTitre());
                livres.stream().forEach(s -> {
                	Livre livreToBeUpdate = livreRepository.findById(s.getId()).get();
                	livreToBeUpdate.setAuteur(livre.getAuteur());
                	livreToBeUpdate.setNbTomes(livre.getNbTomes());
                	livreToBeUpdate.setResume(livre.getResume());
                	livreToBeUpdate.setTheme(livre.getTheme());
                	livreToBeUpdate.setAnneePublication(livre.getAnneePublication());
                    
                    
                    livreRepository.save(livreToBeUpdate);
                });
                return "Book record updated.";
            }catch (Exception e){
                throw e;
            }
        }else {
            return "Book does not exists in the database.";
        }
    }

    @Transactional
    public String deleteLivre(Livre livre){
        if (livreRepository.existsByTitre(livre.getTitre())){
            try {
                List<Livre> livres = livreRepository.findByTitre(livre.getTitre());
                livres.stream().forEach(s -> {
                	livreRepository.delete(s);
                });
                return "Book record deleted successfully.";
            }catch (Exception e){
                throw e;
            }

        }else {
            return "Book does not exist";
        }
    }
    
   /* */
}

