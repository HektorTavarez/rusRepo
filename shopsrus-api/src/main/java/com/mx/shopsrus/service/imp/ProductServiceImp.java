package com.mx.shopsrus.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.shopsrus.entity.Product;
import com.mx.shopsrus.repository.ProductRepository;
import com.mx.shopsrus.service.ProductService;

@Service
public class ProductServiceImp implements ProductService{

	@Autowired
	ProductRepository productRepository;
	
	
	@Override
	public List<Product> getBySalesCheck(Long id) {
		return productRepository.getBySalesCheck(id);	 
	}
	


}
