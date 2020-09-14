package com.example.services.dto.rs;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.example.services.dto.UserDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ConsultUserRs implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@NotNull
	@Valid
	private UserDTO user;

}
