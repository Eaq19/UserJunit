package com.example.services.controller;

import java.net.URI;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Component
public class GenericController {

	protected URI obtenerURI(String path, Object valorPath) {
		return ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{numeroCuenta}")
				.buildAndExpand(valorPath).toUri();
	}
	
}
