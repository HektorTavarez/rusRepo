package com.mx.shopsrus.repository.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mx.shopsrus.entity.Product;
import com.mx.shopsrus.tools.Constants;
import com.mx.shopsrus.tools.Operations;

@SuppressWarnings("rawtypes")
public class ProductMapper implements RowMapper {
		
	private ResultSet resultSet;
	private int sent;

	public ProductMapper(int sent) {
		super();
		this.sent = sent;
	}
	
	
	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		resultSet = rs;
		switch (sent) {		
		case Constants.FIND_BY_SALESCHECK:
			return mapperGetBySalesCheck();	
			
		}
		
		return Constants.NULL;
	}

	
	private Product mapperGetBySalesCheck() throws SQLException {
		
		Product response =  new Product();
		
		response.setId((resultSet.getString("id") == null)?0:Operations.TryParseInt(resultSet.getString("id")));
		response.setNombre((resultSet.getString("producto")== null)?"":resultSet.getString("producto"));
		response.setPrecio((resultSet.getString("precio") == null)?0.0:Operations.TryParseDouble(resultSet.getString("precio")));		
		response.setCategoria((resultSet.getString("categoria") == null)?0:Operations.TryParseInt(resultSet.getString("categoria")));
		return response;
		
	}	
		
	

	
}
