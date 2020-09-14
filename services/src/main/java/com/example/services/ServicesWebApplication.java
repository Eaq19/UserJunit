package com.example.services;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ServicesWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicesWebApplication.class, args);
	}
	
	/**
	 * Bean que expone el objeto Mapper injectable (@Autowired) que permite tranformar las estructuras de datos.
	 * @return
	 */
	@Bean("modelMapper")
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}

}
