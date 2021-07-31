package com.mx.shopsrus.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.shopsrus.dto.ResponseClientDto;
import com.mx.shopsrus.entity.Client;
import com.mx.shopsrus.repository.ClientRepository;
import com.mx.shopsrus.service.ClientService;

@Service
public class ClientServiceImp implements ClientService{

	@Autowired
	ClientRepository clientRepository;
	
	@Override
	public List<Client> getAll() {
		return clientRepository.getAll();
	}

	@Override
	public Client getById(Long id) {
		return clientRepository.getById(id);	 
	}
	
	@Override
	public ResponseClientDto save(Client offer){
		return clientRepository.save(offer);	 
	}
	
	@Override
	public List<Client> getByName(String name) {
		return clientRepository.getByName(name);	 
	}
	

}
