package com.mx.shopsrus.dto;

import java.io.Serializable;
import java.util.List;

import com.mx.shopsrus.entity.Client;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ResponseClientDto implements Serializable{
	 
	private static final long serialVersionUID = 1L;
	
	private Client client;
	private List<Client> clients;
	private String message;
	private String code;	
}
