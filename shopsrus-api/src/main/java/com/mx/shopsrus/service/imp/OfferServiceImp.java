package com.mx.shopsrus.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.mx.shopsrus.dto.ResponseOfferDto;
import com.mx.shopsrus.entity.Offer;
import com.mx.shopsrus.repository.OfferRepository;
import com.mx.shopsrus.service.OfferService;

@Service
public class OfferServiceImp implements OfferService{

	@Autowired
	OfferRepository offerRepository;
	
	@Override
	public List<Offer> getAll() {
		
		List<Offer> respuesta  =  offerRepository.getAll();
			

		return respuesta;
	}

	@Override
	public Offer getById(Long id) {
		return offerRepository.getById(id);	 
	}
	
	@Override
	public ResponseOfferDto save(Offer offer){
		return offerRepository.save(offer);	 
	}
	

}
