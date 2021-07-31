package com.mx.shopsrus.repository.sp;

import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.SqlReturnResultSet;
import org.springframework.jdbc.object.StoredProcedure;

import com.mx.shopsrus.dto.ResponseClientDto;
import com.mx.shopsrus.entity.Client;
import com.mx.shopsrus.repository.mapper.ClientMapper;
import com.mx.shopsrus.tools.Constants;


public class ClientSP extends StoredProcedure{
	
	private Map<String, Object> inputs = new HashMap<>();

	public ClientSP(JdbcTemplate jdbcTemplate, String sp, int sentinel) {		
		
		super(jdbcTemplate, sp);

		switch (sentinel) {		
			case Constants.GET_ALL:
				getAllClients();
			break;	
			case Constants.FIND_BY_ID:	
				findById();
			break;
			case Constants.SAVE:	
				save();
			break;
			case Constants.FIND_BY_NAME:	
				findByName();
			break;
			
			
		}
	}
		
		@SuppressWarnings("unchecked")
		public List<Client> getAll() {									
			List<Client> resp = null;						
			Map<String, Object> rs = super.execute(inputs);
		    resp = (List<Client>) rs.get(("RS"));
			return resp;
		}
		
		@SuppressWarnings("rawtypes")
		private void getAllClients(){
			RowMapper rowMapper = null;
			rowMapper = new ClientMapper(Constants.GET_ALL);
			declareParameter(new SqlReturnResultSet("RS", rowMapper));
			compile();
		}
		
		@SuppressWarnings("unchecked")
		public List<Client> findById(Long id) {									
			List<Client> resp = null;	
			inputs.put("id", id);
			Map<String, Object> rs = super.execute(inputs);
		    resp = (List<Client>) rs.get(("RS"));
			return resp;
		}
		
		@SuppressWarnings("rawtypes")
		private void findById(){
			RowMapper rowMapper = null;
			rowMapper = new ClientMapper(Constants.FIND_BY_ID);			
			declareParameter(new SqlParameter("id", Types.INTEGER));			
			declareParameter(new SqlReturnResultSet("RS", rowMapper));
			compile();
		}
		
		@SuppressWarnings("unchecked")
		public List<Client> findByName(String name) {									
			List<Client> resp = null;	
			inputs.put("name", name);
			Map<String, Object> rs = super.execute(inputs);
		    resp = (List<Client>) rs.get(("RS"));
			return resp;
		}
		
		@SuppressWarnings("rawtypes")
		private void findByName(){
			RowMapper rowMapper = null;
			rowMapper = new ClientMapper(Constants.FIND_BY_NAME);			
			declareParameter(new SqlParameter("name", Types.VARCHAR));			
			declareParameter(new SqlReturnResultSet("RS", rowMapper));
			compile();
		}
		
		
		@SuppressWarnings("unchecked")
		public List<ResponseClientDto> save(Client client) {									
			List<ResponseClientDto> resp = null;	
			inputs.put("nombres", client.getNombres());
			inputs.put("paterno", client.getPaterno());
			inputs.put("materno", client.getMaterno());
			inputs.put("tipo_usuario", client.getUsuario());
			inputs.put("fecha_nacimiento", client.getFecha_nacimiento());
			inputs.put("calle", client.getDomicilio().getCalle());
			inputs.put("colonia", client.getDomicilio().getColonia());
			inputs.put("municipio", client.getDomicilio().getMunicipio());
			inputs.put("estado", client.getDomicilio().getEstado());
			inputs.put("numero", client.getDomicilio().getNumero());
			
			Map<String, Object> rs = super.execute(inputs);
		    resp = (List<ResponseClientDto>) rs.get(("RS"));
			return resp;
		}
		
		@SuppressWarnings("rawtypes")
		private void save(){
			RowMapper rowMapper = null;
			rowMapper = new ClientMapper(Constants.SAVE);			
			declareParameter(new SqlParameter("nombres", Types.VARCHAR));
			declareParameter(new SqlParameter("paterno", Types.VARCHAR));	
			declareParameter(new SqlParameter("materno", Types.VARCHAR));	
			declareParameter(new SqlParameter("tipo_usuario", Types.INTEGER));	
			declareParameter(new SqlParameter("fecha_nacimiento", Types.VARCHAR));	
			declareParameter(new SqlParameter("calle", Types.VARCHAR));
			declareParameter(new SqlParameter("colonia", Types.VARCHAR));	
			declareParameter(new SqlParameter("municipio", Types.VARCHAR));	
			declareParameter(new SqlParameter("estado", Types.VARCHAR));	
			declareParameter(new SqlParameter("numero", Types.VARCHAR));
			declareParameter(new SqlReturnResultSet("RS", rowMapper));
			compile();
		}
		
		
		
		
}

	

