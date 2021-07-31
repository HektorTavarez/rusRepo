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

import com.mx.shopsrus.entity.Product;
import com.mx.shopsrus.repository.mapper.ProductMapper;
import com.mx.shopsrus.tools.Constants;


public class ProductSP extends StoredProcedure{
	
	private Map<String, Object> inputs = new HashMap<>();

	public ProductSP(JdbcTemplate jdbcTemplate, String sp, int sentinel) {		
		
		super(jdbcTemplate, sp);

		switch (sentinel) {					
			case Constants.FIND_BY_SALESCHECK:	
				findById();
			break;	
			
		}
	}		

		@SuppressWarnings("unchecked")
		public List<Product> findById(Long id) {									
			List<Product> resp = null;	
			inputs.put("id", id);
			Map<String, Object> rs = super.execute(inputs);
		    resp = (List<Product>) rs.get(("RS"));
			return resp;
		}
		
		@SuppressWarnings("rawtypes")
		private void findById(){
			RowMapper rowMapper = null;
			rowMapper = new ProductMapper(Constants.FIND_BY_SALESCHECK);			
			declareParameter(new SqlParameter("id", Types.INTEGER));			
			declareParameter(new SqlReturnResultSet("RS", rowMapper));
			compile();
		}
		
		
}

	

