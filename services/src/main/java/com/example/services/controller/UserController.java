package com.example.services.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.services.dto.UserDTO;
import com.example.services.dto.rq.SaveUserRq;
import com.example.services.dto.rs.ConsultUserRs;
import com.example.services.dto.rs.ConsultUsersRs;
import com.example.services.service.IUserService;

import lombok.extern.slf4j.Slf4j;

@RestController()
@RequestMapping("/api")
@Slf4j
public class UserController extends GenericController {

	@Autowired
	private IUserService userService;

	@PostMapping(value = "/user")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> guardar(@RequestBody SaveUserRq userRq) {
		log.info("pre guardar - " + userRq.getUser().getName());
		URI uri = null;
		try {
			userService.guardar(userRq.getUser());
			uri = obtenerURI("/{user}", userRq.getUser().getName());
	
			
		} catch (Exception ex) {;
			throw ex;
		}
	
		log.info("post guardar - " + uri.getPath());
		return ResponseEntity.created(uri).build();
	}

	@GetMapping(value = "/user")
	public ResponseEntity<?> consultarTodas() {
		log.info("pre consultarTodas");
		List<UserDTO> cuentasDTO = userService.consultarTodas();

		ConsultUsersRs cuentas = new ConsultUsersRs(cuentasDTO);
		
		log.info("post consultarTodas");
		return new ResponseEntity<ConsultUsersRs>(cuentas, HttpStatus.OK);
	}

	@GetMapping(value = "/user/{id}")
	public ResponseEntity<?> consultarPorId(Integer id) {
		log.info("pre consultarPorId - " + id);
		UserDTO userDTO = null;

		userDTO = userService.consultarPorId(id);
		
		ConsultUserRs user = new ConsultUserRs(userDTO);

		log.info("post consultarPorId - " + id);
		return new ResponseEntity<ConsultUserRs>(user, HttpStatus.OK);
	}

	@DeleteMapping(value = "/user/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<?> borrar(Integer id) {
		log.info("pre borrar - " + id);
		userService.borrar(id);
		log.info("post borrar - " + id);
		return ResponseEntity.noContent().build();
	}

}