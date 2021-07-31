package com.mx.shopsrus.repository.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mx.shopsrus.entity.Client;
import com.mx.shopsrus.entity.SalesCheck;
import com.mx.shopsrus.entity.Store;
import com.mx.shopsrus.tools.Constants;
import com.mx.shopsrus.tools.Operations;

@SuppressWarnings("rawtypes")
public class SalesCheckMapper implements RowMapper {
	
	private ResultSet resultSet;
	private int sent;

	public SalesCheckMapper(int sent) {
		super();
		this.sent = sent;
	}
	
	
	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		resultSet = rs;
		switch (sent) {		
		case Constants.FIND_BY_ID:
			return mapperFindById();				
		}
		
		return Constants.NULL;
	}

	
	private SalesCheck mapperFindById() throws SQLException {
		
		SalesCheck response =  new SalesCheck();	
		response.setId((resultSet.getString("id") == null)?0:Operations.TryParseInt(resultSet.getString("id")));
		 		
		Client cliente = new Client();
		cliente.setId((resultSet.getString("cliente") == null)?0:Operations.TryParseInt(resultSet.getString("cliente")));

		Store store = new Store();
		store.setId((resultSet.getString("tienda") == null)?0:Operations.TryParseInt(resultSet.getString("tienda")));
		store.setNombre((resultSet.getString("nombre_tienda") == null)?"":resultSet.getString("nombre_tienda"));
		
		
		response.setCliente(cliente);
		response.setTienda(store);
		
		return response;
		
	}	

	
	

	
	
	
}
