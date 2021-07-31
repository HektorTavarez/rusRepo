package com.mx.shopsrus.service;

import java.util.List;

import com.mx.shopsrus.dto.ResponseOfferDto;
import com.mx.shopsrus.entity.Offer;

public interface OfferService {

	public List<Offer> getAll();
	
	public Offer getById(Long id);
	
	public ResponseOfferDto save(Offer offer);
	
}
