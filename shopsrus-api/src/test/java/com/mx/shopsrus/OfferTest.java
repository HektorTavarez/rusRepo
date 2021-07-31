package com.mx.shopsrus;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mx.shopsrus.entity.Offer;
import com.mx.shopsrus.service.OfferService;
import com.mx.shopsrus.tools.Operations;

@SpringBootTest
class OfferTest {

	@Autowired
	OfferService offerService;
	
	@Test
	void testgetAll() {
		int expected  = 6;		
		int actual = offerService.getAll().size();
		
		assertEquals(expected, actual);
		
	}
	
	@Test
	void testfindById() {	
//		 Offer actual = offerService.getById(Operations.TryParseLong("1"));
//		  assertNotNull(actual);
		  
		  Offer actual = offerService.getById(Operations.TryParseLong("10"));		 
		  assertEquals(null, actual);
	}
	
	
	@Test
	void testCreate() {	
		int expected = offerService.getAll().size() + 1;
		
		
		Offer offer =  new Offer();
		offer.setDescripcion("Descuento de 30% para clientes en compra mayos a 3000");
		offer.setAntiguedad(0);
		offer.setAplica(3);
		offer.setCada(3000);
		offer.setCantidad(0);
		offer.setPorcentage(30);
		offer.setRestricciones("1");
		offer.setSuperior(3000.00);
		offer.setTotal(1);
		
		  offerService.save(offer);
		  
		  int actual = offerService.getAll().size();
		  
		  assertEquals(expected, actual);
	}
	
	
}
