package com.mx.shopsrus.repository.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mx.shopsrus.dto.ResponseClientDto;
import com.mx.shopsrus.entity.Client;
import com.mx.shopsrus.repository.ClientRepository;
import com.mx.shopsrus.repository.sp.ClientSP;
import com.mx.shopsrus.tools.Constants;

@Transactional
@Repository
public class ClientRepositoryImp implements ClientRepository {

	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Client> getAll() {
		return new ClientSP(jdbcTemplate, "spRusCClientes",Constants.GET_ALL).getAll();
	}

	@Override
	public Client getById(Long id) {
		List<Client> response = new ClientSP(jdbcTemplate, "spRusCClientesId",Constants.FIND_BY_ID).findById(id);
		
		if(response.size() > 0) {
			return response.get(0);
		}else {
			return null;
		}
	}	
	
	@Override
	public ResponseClientDto save(Client client) {
		List<ResponseClientDto> response = new ClientSP(jdbcTemplate, "spRusIClientes",Constants.SAVE).save(client);
		
		if(response.size() > 0) {
			return response.get(0);
		}else {
			return null;
		}		
	 
	}
	
	
	@Override
	public List<Client> getByName(String name) {		
		return new ClientSP(jdbcTemplate, "spRusCClientesName",Constants.FIND_BY_NAME).findByName(name);	
	}
	
	
	
}
