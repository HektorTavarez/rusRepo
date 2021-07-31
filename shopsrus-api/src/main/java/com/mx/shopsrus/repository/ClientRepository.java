package com.mx.shopsrus.repository;

import java.util.List;

import com.mx.shopsrus.dto.ResponseClientDto;
import com.mx.shopsrus.entity.Client;

public interface ClientRepository {

	public List<Client> getAll();
	
	public Client getById(Long id);	
	
	public ResponseClientDto save(Client client);
	
	public List<Client> getByName(String name);	
	
}
