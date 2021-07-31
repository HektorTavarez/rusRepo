package com.mx.shopsrus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mx.shopsrus.dto.ResponseSalesCheckDto;
import com.mx.shopsrus.service.SalesCheckService;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/shoprus")
public class SalesCheckController {

	@Autowired
	SalesCheckService salesCheckService;
	
	
    @GetMapping("/salescheck")
    public ResponseEntity<?> getById(@RequestParam(name="id", required=true) Long id) {
    	   
    	ResponseSalesCheckDto response =  new ResponseSalesCheckDto();
    	 
    	if(null == id) {
    	 		
    	  return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
    	 
    	}else {
    		
    		response = salesCheckService.getById(id);
    		
    		if(null == response) {
    			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    		}
    		
    		return ResponseEntity.ok(response);
    	}    	
    }
	
}
