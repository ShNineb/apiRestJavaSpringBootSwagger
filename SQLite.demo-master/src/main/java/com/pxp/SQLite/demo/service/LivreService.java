package com.pxp.SQLite.demo.service;

import com.pxp.SQLite.demo.entity.Auteur;
import com.pxp.SQLite.demo.entity.Livre;
import com.pxp.SQLite.demo.repository.LivreRepository;

import io.swagger.annotations.ApiModelProperty;

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

	/**
	 * methode permettant d'ajouter un livre au catalogue des livres de la
	 * bibliotheque (BD) (méthode équilavelent à "ajouterLivre" de Bibliothecarire)
	 * 
	 * @param livre : le nouveau livre a jouter dans la bibliotheque
	 * @return string : état de l'enregistrement
	 */   
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
    
    
    
	/**
	 * methode permettant d'ajouter un livre au catalogue des livres de la
	 * bibliotheque
	 * 
	 * @param nouveauLivre : le nouveau livre a jouter dans la bibliotheque
	 * @return
	 */
    
    /*
	public ArrayList<Livre> ajouterLivre(Livre nouveauLivre) {
		Auteur auteur = nouveauLivre.getAuteur();
		if (Objects.nonNull(getCatalogue().get(auteur))) {
			getCatalogue().get(auteur).add(nouveauLivre);
		} else {
			ArrayList<Livre> livres = new ArrayList<>();
			livres.add(nouveauLivre);
			getCatalogue().put(auteur, livres);
		}
		return getCatalogue().get(auteur);

	}*/
    
    public List<Livre> readLivres(){
    	List<Livre> livres = new ArrayList<>();
    	livreRepository.findAll()
         .forEach(livres::add);
         return livres;
    }
    
	/**
	 * méthode permettant de lister toutes les oeuvres présentes dans le catalogue (BD)
	 * de la bibliotheque pour un auteur donné (méthode équivalente à "listerOeuvresAuteur")
	 * de Bibliothecarire.
	 * 
	 * @param auteur: l'auteur des oeuvres recherchés
	 * @return livres : List<Livre> liste des oeuvres de l'auteur 
	 */
    @Transactional
    public List<Livre> getLivreParAuteur(String nomAuteur){
    	System.out.println("getLivreParAuteur "+nomAuteur );
         
         if (livreRepository.existsByAuteurNom(nomAuteur)) {
             try {
            	 System.out.println("getLivreParAuteur nomAuteur"+nomAuteur );

            	 List<Livre> livres = livreRepository.findByAuteurNom(nomAuteur) ;
            	 
            	 /* // pour test à enlever ensuite
            	  * 
            	  * livreRepository.findByAuteurNom(nomAuteur)            	 
            	 .forEach(livre -> {
            		 System.out.println("auteur et titre   "+ livre.getAuteur() + livre.getTitre());
            		 System.out.println(livre.getAuteur().getNom());
            		 System.out.println(livre.getTitre());
            	 }); */
            	 
                 return livres;
            	 
             }catch (Exception e){
                 throw e;
             }
         }else {
             return null;
         }
    }
    
    


    @Transactional
    public String updateLivre(String titre, Livre livre){
    	 System.out.println("livre update  ");
        if (livreRepository.existsByTitre(titre)) {
            try {
               
                Livre livreOP = livreRepository.findByTitre(titre);
                
                             
                System.out.println("livre update Titre "+titre );
                
                Livre livreToBeUpdate = livreRepository.findById(livreOP.getId()).get();
                livreToBeUpdate.setTitre(livre.getTitre());
                livreToBeUpdate.setAuteur(livre.getAuteur());
            	livreToBeUpdate.setNbTomes(livre.getNbTomes());
            	livreToBeUpdate.setResume(livre.getResume());
            	livreToBeUpdate.setTheme(livre.getTheme());
            	livreToBeUpdate.setAnneePublication(livre.getAnneePublication());
                
            	
            	Auteur auteur = livre.getAuteur();
            	auteurService.createAuteur(auteur);
              
                livreRepository.save(livreToBeUpdate); 
                
                /* // Dans le cas d'une liste à enlever si non nécessaire plus tard
                
                livres.stream().forEach(s -> {
                	Livre livreToBeUpdate = livreRepository.findById(s.getId()).get();
                	
                	livreToBeUpdate.setAuteur(s.getAuteur());
                	livreToBeUpdate.setNbTomes(s.getNbTomes());
                	livreToBeUpdate.setResume(s.getResume());
                	livreToBeUpdate.setTheme(s.getTheme());
                	livreToBeUpdate.setAnneePublication(s.getAnneePublication());
                    
                	//System.out.println("livre livreToBeUpdate "+livreToBeUpdate);
                	
                    livreRepository.save(livreToBeUpdate);
                }); */
                
                
                return "Book record updated.";
            }catch (Exception e){
                throw e;
            }
        }else {
            return "Book does not exists in the database.";
        }
    }
    
    
    
	/**
	 * Methode permettant de retrouver tous les livres sur un theme donnee
	 * @param theme : le theme cherche
	 * @return: une liste contenant les livres sur ce theme
	 */
    /*
	public ArrayList<Livre> trouverLivresSurUnTheme(String theme) {
		ArrayList<Livre> livresSurUnThemes = new ArrayList<Livre>();
		
		
		
		for (ArrayList<Livre> livresAuteur : catalogue.values()) {
			for (Livre livre : livresAuteur) {
				if (theme.equals(livre.getTheme()))
					livresSurUnThemes.add(livre);
			}
		}

		return livresSurUnThemes;
	}*/
    

	/**
	 * methode permettant d'enlever un livre du catalogue de la bibliotheque
	 * 
	 * @param ancienLivre: le livre a enlever
	 * @return : String: un commentaire de l'état de l'action: livre a bien ete enlevé ou pas
	 *         
	 */    
    @Transactional
    public String deleteLivre(Livre ancienLivre){
    	System.out.println("auteur et titre DELTE  "+ ancienLivre.getAuteur() + ancienLivre.getTitre());
        if (livreRepository.existsByTitre(ancienLivre.getTitre())){
            try {
            	/* // Dans le cas d'une liste à enlever si non nécessaire plus tard
            	 * 
                List<Livre> livres = livreRepository.findByTitre(livre.getTitre());
                livres.stream().forEach(s -> {
                	livreRepository.delete(s);
                });*/
                     
                
                System.out.println("auteur et titre   "+ ancienLivre.getAuteur() + ancienLivre.getTitre());
       		 	System.out.println(ancienLivre.getAuteur().getNom());
       		 	System.out.println(ancienLivre.getTitre());
                
              	livreRepository.deleteByTitre(ancienLivre.getTitre());           	
   
                
                return "Book deleted successfully.";
            }catch (Exception e){
                throw e;
            }

        }else {
            return "Book does not exist";
        }
    }
    

}

