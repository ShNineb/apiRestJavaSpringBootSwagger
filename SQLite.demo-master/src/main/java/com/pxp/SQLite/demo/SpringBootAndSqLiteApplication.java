package com.pxp.SQLite.demo;


import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.google.common.base.Predicate;

//import io.swagger.v3.oas.annotations.OpenAPIDefinition;
//import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import springfox.documentation.builders.ApiInfoBuilder;
//import io.swagger.v3.oas.annotations.info.Info;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

 
//@OpenAPIDefinition()//info = @Info(title ="Product iiiii", version="2.0",description="product services"))
//@EnableSwagger2
//@Configuration
//@EnableSwagger2
@SpringBootApplication
@EnableJpaRepositories
public class SpringBootAndSqLiteApplication {
 
	/* Application Java 
	 * 
	 * Premier élement qui démarre l'application : Spring
	 * 
	 * */
	
	public static void main(String[] args) {		
		SpringApplication.run(SpringBootAndSqLiteApplication.class, args);
	}

	/*
	@Bean
	public Docket swaggerConfiguration() {
		System.out.println("heree");
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/student/*"))
				.apis(RequestHandlerSelectors.basePackage("com.pxp.SQLite.demo.controller"))
				//.paths(PathSelectors.regex("(?!/error).+")).paths(PathSelectors.regex("(?!/student).+"))
				.build()
				.apiInfo(apiInfo());
	}
	
/*	
	public ApiInfo apiDetails() {
		System.out.println("hereeLA");
		return new ApiInfo(
				"TEsts api swagger",
				"1.0",
				"",
				"",
				new springfox.documentation.service.Contact("Moi", "http:/pourTest.com", "julie@com"),
				"API Licence",
				"http//test",
				Collections.emptyList());
	}*/
/**/
	
	
	/*
	@Bean
	public Docket swaggerConfiguration() {
		System.out.println("heree");
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/student/*"))
				.apis(RequestHandlerSelectors.basePackage("com.pxp.SQLite.demo.controller"))
				//.paths(PathSelectors.regex("(?!/error).+")).paths(PathSelectors.regex("(?!/student).+"))
				//.paths(postPaths())
				.build()
				.apiInfo(apiInfo());
	}
	
	
	
	private Predicate<String> postPaths() {
		return or(regex("/student/*"), regex("/student/*"));
	}

	@SuppressWarnings("deprecation")
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("JavaInUse API")
				.description("etudiants API reference for developers")
				.termsOfServiceUrl("http://javainuse.com")
				.contact("javainuse@gmail.com").license("JavaInUse License")
				.licenseUrl("javainuse@gmail.com").version("1.0").build();
	}

	*/

}
