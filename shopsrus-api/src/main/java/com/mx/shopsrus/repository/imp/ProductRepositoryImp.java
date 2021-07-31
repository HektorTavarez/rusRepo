package com.mx.shopsrus.repository.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mx.shopsrus.entity.Product;
import com.mx.shopsrus.repository.ProductRepository;
import com.mx.shopsrus.repository.sp.ProductSP;
import com.mx.shopsrus.tools.Constants;

@Transactional
@Repository
public class ProductRepositoryImp implements ProductRepository {

	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	

	@Override
	public List<Product>getBySalesCheck(Long id) {
		
		List<Product> response = new ProductSP(jdbcTemplate, "spRusCDetalleFacturaId",Constants.FIND_BY_SALESCHECK).findById(id);
		
		return response;
	}	
	
	
}
