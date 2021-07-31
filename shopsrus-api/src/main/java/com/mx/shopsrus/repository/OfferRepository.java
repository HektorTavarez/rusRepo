package com.mx.shopsrus.repository;

import java.util.List;

import com.mx.shopsrus.dto.ResponseOfferDto;
import com.mx.shopsrus.entity.Offer;

public interface OfferRepository {

	public List<Offer> getAll();
	
	public Offer getById(Long id);	
	
	public ResponseOfferDto save(Offer offer);
	
	public List<Offer> getByUser(Long id, Double monto, int antiguedad);
	
}
