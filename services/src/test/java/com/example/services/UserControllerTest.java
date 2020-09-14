package com.example.services;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.services.controller.UserController;
import com.example.services.dto.UserDTO;
import com.example.services.dto.rq.SaveUserRq;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UserControllerTest extends ServicesWebApplicationTests {

	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void testUser() throws Exception {
		mockMvc.perform(get("/user")).andExpect(status().isOk())
		.andExpect(content().contentType("application/json;charset=UTF-8"));
	}
	
	@Test
	public void testCreateUser() throws Exception {
		SaveUserRq save = new SaveUserRq();
		UserDTO user = new UserDTO();
		user.setName("Andres");
		user.setAge(22);
		save.setUser(user);
		mockMvc.perform(post("/user")
			      .content(asJsonString(save))
			      .contentType(MediaType.APPLICATION_JSON)
			      .accept(MediaType.APPLICATION_JSON))
			      .andExpect(status().isCreated());
	}
	
	public static String asJsonString(final Object obj) {
	    try {
	        return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}

}
