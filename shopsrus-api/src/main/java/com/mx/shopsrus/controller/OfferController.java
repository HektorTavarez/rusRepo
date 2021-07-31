package com.mx.shopsrus.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mx.shopsrus.dto.ResponseOfferDto;
import com.mx.shopsrus.entity.Offer;
import com.mx.shopsrus.service.OfferService;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/shoprus")
public class OfferController {

	private static final Logger log = LogManager.getLogger(OfferController.class);

	@Autowired
	OfferService offerService;
	
	
    @GetMapping("/offer")
    public ResponseEntity<?> getAll(@RequestParam(name="id", required=false) Long id) {
    	   
    	ResponseOfferDto response =  new ResponseOfferDto();
    	 
    	if(null == id) {
    	     
    		List<Offer> offers  =  offerService.getAll();
    	     if (offers == null) {
    	            log.info("NO CONTENT");
    	            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    	        }else {
    	        	response.setOffers(offers);
    	        	response.setCode("200");
    	        	response.setMessage("success");
    	        	return ResponseEntity.ok(response);
    	        }    	     
    		
    	}else {
    		Offer offer  =  offerService.getById(id);  
   	     if (offer == null) {
   	            log.info("NO CONTENT");
   	            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
   	        }else {
   	        	response.setOffer(offer);
	        	response.setCode("200");
	        	response.setMessage("success");
   	        	return ResponseEntity.ok(response);
   	        }
    	}    	
    }
    
    
    @PostMapping("/offer")
    public ResponseEntity<?> post(@RequestBody Offer request) {
    	 
    	ResponseOfferDto response =  offerService.save(request);  
    	
    	if(response.getCode().equals("00")) {
    		 return new ResponseEntity<Void>(HttpStatus.CREATED);
    	}
    	
    	
    	return ResponseEntity.ok(response);
    }
	
	
	
}
