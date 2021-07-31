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

import com.mx.shopsrus.entity.SalesCheck;
import com.mx.shopsrus.repository.mapper.SalesCheckMapper;
import com.mx.shopsrus.tools.Constants;


public class SalesCheckSP extends StoredProcedure{
	
	private Map<String, Object> inputs = new HashMap<>();

	public SalesCheckSP(JdbcTemplate jdbcTemplate, String sp, int sentinel) {		
		
		super(jdbcTemplate, sp);

		switch (sentinel) {					
			case Constants.FIND_BY_ID:	
				findById();
			break;
			
			
		}
	}
		
		
		@SuppressWarnings("unchecked")
		public List<SalesCheck> findById(Long id) {									
			List<SalesCheck> resp = null;	
			inputs.put("id", id);
			Map<String, Object> rs = super.execute(inputs);
		    resp = (List<SalesCheck>) rs.get(("RS"));
			return resp;
		}
		
		@SuppressWarnings("rawtypes")
		private void findById(){
			RowMapper rowMapper = null;
			rowMapper = new SalesCheckMapper(Constants.FIND_BY_ID);			
			declareParameter(new SqlParameter("id", Types.INTEGER));			
			declareParameter(new SqlReturnResultSet("RS", rowMapper));
			compile();
		}
}

	

