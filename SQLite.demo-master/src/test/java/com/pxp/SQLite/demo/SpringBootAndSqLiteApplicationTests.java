package com.pxp.SQLite.demo;
import org.junit.Assert;
import org.junit.Before;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pxp.SQLite.demo.entity.Student;
import com.pxp.SQLite.demo.repository.StudentRepository;
import com.pxp.SQLite.demo.service.StudentService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class SpringBootAndSqLiteApplicationTests {

	
	@Autowired
	private StudentService service;
	
	@MockBean
	private StudentRepository repository;
	
	@Test
	public void getEtudiantsTest() {
		when(repository.findAll()).thenReturn(Stream
				.of(new Student(28, "Carla","carla@gmail.com"), new Student(32, "Eddy","eddy@gmail.com")).collect(Collectors.toList())
				);
						
		assertEquals(2, service.readStudents().size());				
						
				
	}
	
	
	
	@Test
	public void getUserbyAddressTest() {
		
		Student student = new Student();
		student.setName("Sofiane");
		student.setEmail("sobo@gmail.com");	
		String address = "Bangalore";
		System.out.println(student);
		when(repository.findByEmail(address))
				.thenReturn(Stream.of(student).collect(Collectors.toList()));
		System.out.println("testJUNIT");
		System.out.println(service.updateStudent(student));
		assertTrue("Student does not exists in the database." == service.updateStudent(student));
	}
	
	
	private MockMvc mockMvc;
	@Autowired
	private WebApplicationContext context;
	
	//pour transfomer au format json
	// creation d un objectMapper
	ObjectMapper om = new ObjectMapper();
	
	
	// initialisation du MockMvc
	// on pourra l'appeler pour les methodes post/put...
	@Before
	public void setUp(){
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();		
	}
	
	@Test 
	public void addStudentTest() throws Exception{
		Student student = new Student();
		student.setName("Sofiane");
		student.setEmail("sobo@gmail.com");
		System.out.println(student);
		String jsonRequest = om.writeValueAsString(student);
		System.out.println(jsonRequest);
		MvcResult result = mockMvc.perform(post("/student/createstudent").content(jsonRequest)
				.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk())
				.andExpect(content().string("Student record created successfully."))
				.andReturn();
		
//		MvcResult result = mockMvc.perform(post("/EmployeeService/addEmployee").content(jsonRequest)
//				.contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk()).andReturn();
		
		System.out.println(result);
		String resultContent = result.getResponse().getContentAsString();
		System.out.println(resultContent); 
		// dans le cas d un objet etudiant en réponse dela methode
		// il faudra convertir le string en l objet		
		Student etudiant = om.readValue(resultContent, Student.class);		
		assertEquals("Sofiane", etudiant.getName());
		System.out.println(etudiant);
		//Assert.assertTrue(etudiant == "Student record created successfully.");	// pas de sens ici...	
	}

	@Test 
	public void getStudentTest() throws Exception{
//		Student student = new Student();
//		student.setName("Sofiane");
//		student.setEmail("sobo@gmail.com");
//		String jsonRequest = om.writeValueAsString(student);
		MvcResult result = mockMvc.perform(get("/student/readstudents").content(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk()).andReturn();
		String resultContent = result.getResponse().getContentAsString();
		// dans le cas d un objet etudiant en réponse dela methode
		// il faudra convertir le string en l objet
		
		List<Student> etudiantList = (List<Student>) om.readValue(resultContent, Student.class);
		Assert.assertTrue(etudiantList.size() != 0);		
	}



	 

}

