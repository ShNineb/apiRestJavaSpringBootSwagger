/**
 * 
 */
package com.pxp.SQLite.demo.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pxp.SQLite.demo.entity.Abonne;
import com.pxp.SQLite.demo.entity.Livre;
import com.pxp.SQLite.demo.entity.LivreEmprunte;
import com.pxp.SQLite.demo.repository.AbonneRepository;
import com.pxp.SQLite.demo.repository.LivreEmprunteRepository;

/**
 * @author U023426
 *
 */
@Service
public class LivreEmprunteService {
	
	private int NB_JOURS_EMPRUNT_MAX = 30;
	
    @Autowired
    private LivreEmprunteRepository livreEmprunteRepository;

    @Autowired
    private AbonneService abonneService;    
    
    @Autowired
    private AbonneRepository abonneRepository;	
    
	/**
	 * méthode permettant de lister toutes les oeuvres présentes dans le catalogue (BD)
	 * de la bibliotheque 
	 * 
	 * @return livres : List<Livre> liste des oeuvres
	 */    
    public List<LivreEmprunte> getLivresEmpruntes(){
    	List<LivreEmprunte> livresEmpruntes = new ArrayList<>();
    	livreEmprunteRepository.findAll()
         .forEach(livresEmpruntes::add);
         return livresEmpruntes;
    }
    
    
	/**
	 * methode permettant de preter un livre a un abonn�
	 * 
	 * @param livreAEmprunte: le livre a preter
	 * @param emprunteur      : l'abonn� qui va emprunter le livre
	 * @return : le livre emprunte avec la date d'emprunt et la date de retour
	 */
	public LivreEmprunte preterUnLivre(Livre livreAEmprunte, Abonne emprunteur) {
		LivreEmprunte livreEmprunte = new LivreEmprunte(livreAEmprunte, emprunteur);
		List<LivreEmprunte> livresEmpruntes = new ArrayList<LivreEmprunte>();
		livreEmprunte.setDateDebutEmprunt(LocalDate.now());
		livreEmprunte.setDateFinEmprunt(LocalDate.now().plusDays(NB_JOURS_EMPRUNT_MAX));
		livresEmpruntes.add(livreEmprunte);
		return livresEmpruntes.get(livresEmpruntes.size() - 1);
	}
	
	
	/**
	 * methode permettant d'ajouter un livre au catalogue des livres de la
	 * bibliotheque (BD) (méthode équilavelent à "ajouterLivre" de Bibliothecarire)
	 * 
	 * @param livre : le nouveau livre a jouter dans la bibliotheque
	 * @return string : état de l'enregistrement
	 */   
	//TODO: à compléter pour que le retour soit OK => creation d'un classse unique avec les deux élements
	//pour un @RequestBody sur la classe "unique"
    @Transactional
    public String createLivreEmprunte(String nomEmprunteur, Livre livreAEmprunte) { //Abonne emprunteur) { //String nomEmprunteur){
    //  public String createLivreEmprunte(AbonneLivreEmprunte abonneLivreEmprunte) { 	
    	//Livre livreAEmprunte = abonneLivreEmprunte.getLivre();
    	//String nomEmprunteur = abonneLivreEmprunte.getEmprunteur();
    			
     	System.out.println("livreEmprunte create Avant Try  "+ livreAEmprunte.getTitre());
        try {
            if (livreEmprunteRepository.existsByTitre(livreAEmprunte.getTitre())){
            	
            	System.out.println("livreEmprunte create Dans Try  "+ livreAEmprunte.getTitre());
            	
            	//String nomEmprunteur = emprunteur.getNom();
            	
            	// on verifie que l emprunteur existe, sinon on le crée
            	if (!abonneRepository.existsByNom(nomEmprunteur)){
            		String tmp = abonneService.createAbonne(nomEmprunteur);
            	}
            	
            	System.out.println("livreEmprunte create If"+ livreAEmprunte.getTitre());
            	
            	livreAEmprunte.setId(null == livreEmprunteRepository.findMaxId()? 0 : livreEmprunteRepository.findMaxId() + 1);
            	Abonne emprunteur = abonneRepository.findByNom();
            	
            	LivreEmprunte livreEmprunte = preterUnLivre(livreAEmprunte, emprunteur); 
            	livreEmprunteRepository.save(livreEmprunte);
 
                return "Book record created successfully.";
            }else {            		
            		return "createLivreEmprunte already exists in the database.";            	
            }
        }catch (Exception e){
            throw e;
        }
    }	

}
