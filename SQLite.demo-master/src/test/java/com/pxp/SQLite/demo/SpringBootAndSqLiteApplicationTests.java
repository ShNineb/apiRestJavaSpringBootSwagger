package com.pxp.SQLite.demo;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.pxp.SQLite.demo.controller.AuteurController;
import com.pxp.SQLite.demo.controller.LivreController;
import com.pxp.SQLite.demo.controller.StudentController;
import com.pxp.SQLite.demo.entity.Auteur;
import com.pxp.SQLite.demo.entity.Livre;
import com.pxp.SQLite.demo.entity.Student;
import com.pxp.SQLite.demo.repository.AuteurRepository;
import com.pxp.SQLite.demo.repository.LivreRepository;
import com.pxp.SQLite.demo.repository.StudentRepository;
import com.pxp.SQLite.demo.service.AuteurService;
import com.pxp.SQLite.demo.service.LivreService;
import com.pxp.SQLite.demo.service.StudentService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.when;


@RunWith(SpringRunner.class)
@SpringBootTest
class SpringBootAndSqLiteApplicationTests {


	@Autowired
	StudentController studentController;
	@Autowired
	AuteurController auteurController;
	@Autowired
	LivreController livreController;
	
	@Autowired
	private StudentService service;
	@Autowired
	private LivreService livreService;
	@Autowired
	private AuteurService auteurService;
	
	@Mock
	private StudentRepository repository;
	@Mock
	private LivreRepository livreRepository;
	@Mock
	private AuteurRepository auteurRepository;
	
	
	
	@Before
	public void init() {
	    MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void getEtudiantsTest() {
		when(repository.findAll()).thenReturn(Stream
				.of(new Student(28, "Carla","carla@gmail.com"), new Student(32, "Eddy","eddy@gmail.com")).collect(Collectors.toList())
				);						
		assertEquals(2, service.readStudents().size());
	}	
	
	
	@Test
	public void getStudentbyAddressTest() {
		
		Student student = new Student();
		student.setName("Cedric");
		student.setEmail("cedric@gmail.com");	
		String address = "Nantes";
		//System.out.println(student);
		when(repository.findByEmail(address))
				.thenReturn(Stream.of(student).collect(Collectors.toList()));		
		//System.out.println(service.updateStudent(student));
		assertTrue("Student does not exists in the database." == service.updateStudent(student));
	}
	

    @Test
    public void getAuteursTest() throws Exception {

        
        Auteur auteur1 = new Auteur();
        auteur1.setNom("Khalil Gibran");
        Auteur auteur2 = new Auteur();
        auteur2.setNom("Céline Proust");
        Auteur auteur3 = new Auteur();
        auteur3.setNom("Victor Hugo");
        
        System.out.println(auteur3);
        
        List<Auteur> auteurList = new ArrayList<Auteur>();
        
        auteurList.add(auteur1);
        auteurList.add(auteur2);
        auteurList.add(auteur3);
     
        when(auteurRepository.findAll()).thenReturn(auteurList);
   	 
        // when
        List<Auteur> result = 	auteurController.getAuteurs();
        //System.out.println("getAuteurs" + result.size() + result.get(0).getNom() + result.get(1).getNom());

        // then
        assertEquals(result.size() ,3);
    }
    
	
	    @Test
	    public void getLivresTest() {
	    	
	        Auteur auteur1 = new Auteur();
	        auteur1.setNom("StExupery");
	        Auteur auteur2 = new Auteur();
	        auteur2.setNom("MarcLevy");	       
	     	System.out.println(auteur1.getNom());
	     	Livre livre1 = new Livre(auteur1, "titre1");
	    	Livre livre2 = new Livre( auteur2,"titre2");       
	        
	    	List<Livre> listLivres = new ArrayList<Livre>();
	    	listLivres.add(livre1);
	    	listLivres.add(livre2);
	    	
	    	when(livreRepository.findAll()).thenReturn(listLivres);
	    	
	        // test
	        List<Livre> result = livreController.getLivres();
	    	
	        assertEquals(2, result.size());  
	    }
	    
	    
	    
	    @Test
	    public void findAllStudentsTest() 
	    {
	        // given
	        
			Student student1 = new Student();
			student1.setName("Eddy");			
			student1.setEmail("eddy@gmail.com");	
			
			
			Student student2 = new Student();
			student2.setName("Julie");
			student2.setEmail("julie@gmail.com");	
			
			List<Student> listStudents = new ArrayList<Student>();
			listStudents.add(student1);
			listStudents.add(student2);
	 
	        when(repository.findAll()).thenReturn(listStudents);
	 
	        // when
	        List<Student> result = 	studentController.readStudents();
	 
	        // then
	        assertTrue(2==result.size());
	    }	    
	    
	    





	 

}

