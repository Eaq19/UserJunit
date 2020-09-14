package com.example.services.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.cursojava.administracioncuenta.controller"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(apiInfo());
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfo("Microservicio de cuentas REST API",
				"API de administración de cuentas.", "Versión 1.0",
				"https://www.cursojava.com/terminosdeservicio",
				new Contact("Pepito Pérez", "https://www.cursojava.com", "pepitoperez@cursojava.com"),
				"Licencia del API", "https://wwww.cursojava.com/licencia");
	}
}
