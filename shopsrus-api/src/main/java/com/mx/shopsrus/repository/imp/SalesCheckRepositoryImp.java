package com.mx.shopsrus.repository.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mx.shopsrus.entity.SalesCheck;
import com.mx.shopsrus.repository.SalesCheckRepository;
import com.mx.shopsrus.repository.sp.SalesCheckSP;
import com.mx.shopsrus.tools.Constants;

@Transactional
@Repository
public class SalesCheckRepositoryImp implements SalesCheckRepository {

	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public SalesCheck getById(Long id) {
		List<SalesCheck> response = new SalesCheckSP(jdbcTemplate, "spRusCfacturaId",Constants.FIND_BY_ID).findById(id);
		
		if(response.size() > 0) {
			return response.get(0);
		}else {
			return null;
		}
	}	
	
}
