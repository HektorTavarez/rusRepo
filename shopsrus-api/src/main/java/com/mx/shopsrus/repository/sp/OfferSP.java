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

import com.mx.shopsrus.dto.ResponseOfferDto;
import com.mx.shopsrus.entity.Offer;
import com.mx.shopsrus.repository.mapper.OfferMapper;
import com.mx.shopsrus.tools.Constants;


public class OfferSP extends StoredProcedure{
	
	private Map<String, Object> inputs = new HashMap<>();

	public OfferSP(JdbcTemplate jdbcTemplate, String sp, int sentinel) {		
		
		super(jdbcTemplate, sp);

		switch (sentinel) {		
			case Constants.GET_ALL:
				getAllOffers();
			break;	
			case Constants.FIND_BY_ID:	
				findById();
			break;
			case Constants.SAVE:	
				save();
			break;
			case Constants.FIND_BY_USER:	
				findByUser();
			break;
			
			
		}
	}
		
		@SuppressWarnings("unchecked")
		public List<Offer> getAll() {									
			List<Offer> resp = null;						
			Map<String, Object> rs = super.execute(inputs);
		    resp = (List<Offer>) rs.get(("RS"));
			return resp;
		}
		
		@SuppressWarnings("rawtypes")
		private void getAllOffers(){
			RowMapper rowMapper = null;
			rowMapper = new OfferMapper(Constants.GET_ALL);
			declareParameter(new SqlReturnResultSet("RS", rowMapper));
			compile();
		}
		
		@SuppressWarnings("unchecked")
		public List<Offer> findById(Long id) {									
			List<Offer> resp = null;	
			inputs.put("id", id);
			Map<String, Object> rs = super.execute(inputs);
		    resp = (List<Offer>) rs.get(("RS"));
			return resp;
		}
		
		@SuppressWarnings("rawtypes")
		private void findById(){
			RowMapper rowMapper = null;
			rowMapper = new OfferMapper(Constants.FIND_BY_ID);			
			declareParameter(new SqlParameter("id", Types.INTEGER));			
			declareParameter(new SqlReturnResultSet("RS", rowMapper));
			compile();
		}
		
		
		@SuppressWarnings("unchecked")
		public List<ResponseOfferDto> save(Offer offer) {									
			List<ResponseOfferDto> resp = null;	
			inputs.put("descripcion", offer.getDescripcion());
			inputs.put("aplica", offer.getAplica());
			inputs.put("porcentage", offer.getPorcentage());
			inputs.put("cantidad", offer.getCantidad());
			inputs.put("restricciones", offer.getRestricciones());
			inputs.put("antiguedad", offer.getAntiguedad());
			inputs.put("superior", offer.getSuperior());
			inputs.put("cada", offer.getCada());
			inputs.put("total", offer.getTotal());
			Map<String, Object> rs = super.execute(inputs);
		    resp = (List<ResponseOfferDto>) rs.get(("RS"));
			return resp;
		}
		
		@SuppressWarnings("rawtypes")
		private void save(){
			RowMapper rowMapper = null;
			rowMapper = new OfferMapper(Constants.SAVE);			
			declareParameter(new SqlParameter("descripcion", Types.VARCHAR));
			declareParameter(new SqlParameter("aplica", Types.INTEGER));	
			declareParameter(new SqlParameter("porcentage", Types.INTEGER));	
			declareParameter(new SqlParameter("cantidad", Types.INTEGER));	
			declareParameter(new SqlParameter("restricciones", Types.VARCHAR));	
			declareParameter(new SqlParameter("antiguedad", Types.INTEGER));	
			declareParameter(new SqlParameter("superior", Types.INTEGER));	
			declareParameter(new SqlParameter("cada", Types.INTEGER));	
			declareParameter(new SqlParameter("total", Types.INTEGER));	
			declareParameter(new SqlReturnResultSet("RS", rowMapper));
			compile();
		}
		
		
		
		@SuppressWarnings("unchecked")
		public List<Offer> findByUser(Long id,Double monto, int antiguedad) {									
			List<Offer> resp = null;	
			inputs.put("id", id);
			inputs.put("monto", monto);
			inputs.put("antiguedad", antiguedad);
			Map<String, Object> rs = super.execute(inputs);
		    resp = (List<Offer>) rs.get(("RS"));
			return resp;
		}
		
		@SuppressWarnings("rawtypes")
		private void findByUser(){
			RowMapper rowMapper = null;
			rowMapper = new OfferMapper(Constants.FIND_BY_USER);			
			declareParameter(new SqlParameter("id", Types.INTEGER));
			declareParameter(new SqlParameter("monto", Types.DECIMAL));
			declareParameter(new SqlParameter("antiguedad", Types.INTEGER));
			declareParameter(new SqlReturnResultSet("RS", rowMapper));
			compile();
		}
}

	

