package com.example.services.service;

import java.util.List;

import com.example.services.dto.UserDTO;

public interface IUserService {

	Integer guardar (UserDTO userDTO);
	List<UserDTO> consultarTodas ();
	UserDTO consultarPorId (Integer id);
	void borrar (Integer id);
	
}
