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

import com.mx.shopsrus.dto.ResponseClientDto;
import com.mx.shopsrus.entity.Client;
import com.mx.shopsrus.service.ClientService;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/shoprus")
public class ClientController {

	private static final Logger log = LogManager.getLogger(ClientController.class);

	@Autowired
	ClientService clientService;
	
	
    @GetMapping("/client")
    public ResponseEntity<?> getAll(@RequestParam(name="id", required=false) Long id, @RequestParam(name="name", required=false) String name) {
    	 
    	ResponseClientDto response =  new ResponseClientDto();
    	 
    	if(null == id && null == name) {
    	     
    		List<Client> clients  =  clientService.getAll();
    	     if (clients == null) {
    	            log.info("NO CONTENT");
    	            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    	        }else {
    	        	response.setClients(clients);
    	        	response.setCode("200");
    	        	response.setMessage("success");
    	        	return ResponseEntity.ok(response);
    	        }    	     
    		
    	}else {
    		if(null != id){
        		Client client  =  clientService.getById(id);  
       	     if (client == null) {
       	            log.info("NO CONTENT");
       	            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
       	        }else {
       	        	response.setClient(client);
    	        	response.setCode("200");
    	        	response.setMessage("success");
       	        	return ResponseEntity.ok(response);
       	        }
        	} else{
        		List<Client> clients  =  clientService.getByName(name.replaceAll(" ", ""));  
          	     if (clients == null) {
          	            log.info("NO CONTENT");
          	            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
          	        }else {
          	        	response.setClients(clients);
       	        	response.setCode("200");
       	        	response.setMessage("success");
          	        	return ResponseEntity.ok(response);
          	        }
           	} 
    	}
    	
    }
    
    
    @PostMapping("/client")
    public ResponseEntity<?> post(@RequestBody Client request) {
    	
    	ResponseClientDto response =  clientService.save(request);  
    	
    	if(response.getCode().equals("00")) {
    	  return new ResponseEntity<Void>(HttpStatus.CREATED);
    	}
    	
    	return ResponseEntity.ok(response);
    }
	
	
	
}
