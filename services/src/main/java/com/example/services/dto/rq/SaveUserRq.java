package com.example.services.dto.rq;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.example.services.dto.UserDTO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaveUserRq implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(notes = "User a guardar", required = true)
	@NotNull
	private UserDTO user;

}
