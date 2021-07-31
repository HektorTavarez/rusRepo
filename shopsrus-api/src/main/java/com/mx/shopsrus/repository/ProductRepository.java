package com.mx.shopsrus.repository;

import java.util.List;

import com.mx.shopsrus.entity.Product;

public interface ProductRepository {

	public List<Product> getBySalesCheck(Long id);	
	
	
}
