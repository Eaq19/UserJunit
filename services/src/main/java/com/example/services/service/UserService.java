package com.example.services.service;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.services.domain.User;
import com.example.services.dto.UserDTO;
import com.example.services.repository.IUserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserService implements IUserService {

	@Autowired
	private IUserRepository userRepository;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public Integer guardar (UserDTO userDTO) {
		log.info("pre guardar - " + userDTO.getName());
		Integer id = null;
		
		if (userRepository.findByName(userDTO.getName()) == null) {
			User user = mapper.map(userDTO, User.class);
			
			id = userRepository.save(user).getId(); 
		} else {
			log.error("El id " + userDTO.getName() + " ya existe en la base de datos.");
		}
		
		log.info("post guardar - " + userDTO.getName());
		return id;
	}
	
	@Override
	public List<UserDTO> consultarTodas (){
		log.info("pre consultarTodas");
		List<UserDTO> usersDTO = null;
		
		List<User> users = (List<User>) userRepository.findAll();
		
		Type targetListType = new TypeToken<List<UserDTO>>() {}.getType();
		usersDTO = mapper.map(users, targetListType);
		
		log.info("post consultarTodas");
		return usersDTO; 
	}
	
	@Override
	public UserDTO consultarPorId (Integer id){
		log.info("pre consultarPorId - " + id);
		UserDTO userDTO = null;
		
		User user = userRepository.findById(id).get();
		
		if(user != null) {
			userDTO = mapper.map(user, UserDTO.class);
		}
		
		log.info("pre consultarPorId - " + id);
		return userDTO;
	}
	
	public void borrar (Integer id){
		log.info("pre borrar - " + id);
		if (userRepository.existsById(id)) {
			userRepository.deleteById(id);
		}
		log.info("post borrar - " + id);
	}
	
}
