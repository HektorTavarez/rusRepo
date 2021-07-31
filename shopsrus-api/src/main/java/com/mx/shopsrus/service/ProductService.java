package com.mx.shopsrus.service;

import java.util.List;

import com.mx.shopsrus.entity.Product;

public interface ProductService {

	public List<Product> getBySalesCheck(Long id);
	
}
