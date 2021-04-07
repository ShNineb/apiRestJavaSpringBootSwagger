package com.pxp.SQLite.demo.SwaggerConfig;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;
import static com.google.common.base.Predicates.or;

@Configuration
@EnableSwagger2
public class SwaggerConfig {


	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.pxp.SQLite.demo.controller"))
				.build()
				.apiInfo(apiInfo());
	}
	
	
	
	private Predicate<String> postPaths() {
		return or(regex("(/student/*)"), regex("/livre/*"));
	}

	@SuppressWarnings("deprecation")
	private ApiInfo apiInfo() {
		
		
		return new ApiInfoBuilder().title("Library catalog in API REST CRUD Java")
				.description("API REST CRUD in Java using SpringBoot, SQLite & Swagger. Managing Books and borrowers.")
				.termsOfServiceUrl("localhost:8070/swagger-ui.html")
				.contact("Sheherazade Nineb & Fabienne Auffret")
				.licenseUrl("sara.nineb@hotmail.fr & fafa@gmail.com").version("1.0").build();
	}
 
}
