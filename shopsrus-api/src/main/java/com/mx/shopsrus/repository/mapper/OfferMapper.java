package com.mx.shopsrus.repository.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;

import com.mx.shopsrus.dto.ResponseOfferDto;
import com.mx.shopsrus.entity.Offer;
import com.mx.shopsrus.tools.Constants;
import com.mx.shopsrus.tools.Operations;

@SuppressWarnings("rawtypes")
public class OfferMapper implements RowMapper {
	  private static final Logger log = LogManager.getLogger(OfferMapper.class);
	
	
	private ResultSet resultSet;
	private int sent;

	public OfferMapper(int sent) {
		super();
		this.sent = sent;
	}
	
	
	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		resultSet = rs;
		switch (sent) {		
		case Constants.GET_ALL:
			return mapperGetAll();
		case Constants.FIND_BY_ID:
			return mapperGetAll();	
		case Constants.SAVE:
			return mapperSave();
		case Constants.FIND_BY_USER:
			return mapperGetAll();
		}
		
		return Constants.NULL;
	}

	
	private Offer mapperGetAll() throws SQLException {
		
		Offer response =  new Offer();
		response.setId((resultSet.getString("id") == null)?0:Operations.TryParseInt(resultSet.getString("id")));
		response.setDescripcion((resultSet.getString("descripcion")== null)?"":resultSet.getString("descripcion"));
		response.setAplica((resultSet.getString("aplica") == null)?0:Operations.TryParseInt(resultSet.getString("aplica")));
		response.setPorcentage((resultSet.getString("porcentage") == null)?0:Operations.TryParseInt(resultSet.getString("porcentage")));
		response.setCantidad((resultSet.getString("cantidad") == null)?0:Operations.TryParseInt(resultSet.getString("cantidad")));		
		response.setRestricciones((resultSet.getString("restricciones")== null)?"":resultSet.getString("restricciones"));
		response.setAntiguedad((resultSet.getString("antiguedad") == null)?0:Operations.TryParseInt(resultSet.getString("antiguedad")));
		response.setSuperior((resultSet.getString("superior") == null)?0:Operations.TryParseDouble(resultSet.getString("superior")));		
		response.setCada((resultSet.getString("cada") == null)?0:Operations.TryParseInt(resultSet.getString("cada")));		
		response.setTotal((resultSet.getString("total") == null)?0:Operations.TryParseInt(resultSet.getString("total")));
		
		
		return response;
		
	}	

	
	private ResponseOfferDto mapperSave() throws SQLException {
		
		ResponseOfferDto response =  new ResponseOfferDto();
		
		response.setCode((resultSet.getString("NumMensaje")== null)?"":resultSet.getString("NumMensaje"));
		response.setMessage((resultSet.getString("Mensaje")== null)?"":resultSet.getString("Mensaje"));
		
			
		if(response.getCode().equals("01")) {
			log.error((resultSet.getString("MensajeLog")== null)?"":resultSet.getString("MensajeLog"));
		}
		
		
		return response;
		
	}	
	

	
}
