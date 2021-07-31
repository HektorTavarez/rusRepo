package com.mx.shopsrus.repository.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;

import com.mx.shopsrus.dto.ResponseClientDto;
import com.mx.shopsrus.entity.Address;
import com.mx.shopsrus.entity.Client;
import com.mx.shopsrus.tools.Constants;
import com.mx.shopsrus.tools.Operations;

@SuppressWarnings("rawtypes")
public class ClientMapper implements RowMapper {
	  private static final Logger log = LogManager.getLogger(ClientMapper.class);
	
	
	private ResultSet resultSet;
	private int sent;

	public ClientMapper(int sent) {
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
		case Constants.FIND_BY_NAME:
			return mapperGetAll();	
			
		}
		
		return Constants.NULL;
	}

	
	private Client mapperGetAll() throws SQLException {
		
		Client response =  new Client();
		
		response.setId((resultSet.getString("id") == null)?0:Operations.TryParseInt(resultSet.getString("id")));
		response.setNombres((resultSet.getString("nombres")== null)?"":resultSet.getString("nombres"));
		response.setPaterno((resultSet.getString("paterno") == null)?"":resultSet.getString("paterno"));
		response.setMaterno((resultSet.getString("materno") == null)?"":resultSet.getString("materno"));
		response.setFecha_nacimiento((resultSet.getString("fecha_nacimiento")== null)?"":resultSet.getString("fecha_nacimiento"));
		response.setFecha_antiguedad((resultSet.getString("fecha_creacion") == null)?"":resultSet.getString("fecha_creacion"));
		response.setUsuario((resultSet.getString("usuario") == null)?"":resultSet.getString("usuario"));
		response.setTipo_usuario((resultSet.getString("tipo") == null)?"":resultSet.getString("tipo"));
		
		Address address =  new Address();
		address.setId((resultSet.getString("domicilio") == null)?0:Operations.TryParseInt(resultSet.getString("domicilio")));
		address.setCalle((resultSet.getString("calle")== null)?"":resultSet.getString("calle"));
		address.setColonia((resultSet.getString("colonia") == null)?"":resultSet.getString("colonia"));
		address.setMunicipio((resultSet.getString("municipio") == null)?"":resultSet.getString("municipio"));
		address.setEstado((resultSet.getString("estado") == null)?"":resultSet.getString("estado"));
		address.setNumero((resultSet.getString("numero") == null)?"":resultSet.getString("numero"));
		
		response.setDomicilio(address);
		return response;
		
	}	

	
	private ResponseClientDto mapperSave() throws SQLException {
		
		ResponseClientDto response =  new ResponseClientDto();
		
		response.setCode((resultSet.getString("NumMensaje")== null)?"":resultSet.getString("NumMensaje"));
		response.setMessage((resultSet.getString("Mensaje")== null)?"":resultSet.getString("Mensaje"));
					
		if(response.getCode().equals("01")) {
			log.error((resultSet.getString("MensajeLog")== null)?"":resultSet.getString("MensajeLog"));
		}
		
		
		return response;
		
	}	
	
		
	
}
