package com.mx.shopsrus.dto;
import java.io.Serializable;
import com.mx.shopsrus.entity.SalesCheck;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter 
@Setter
public class ResponseSalesCheckDto implements Serializable{

	private static final long serialVersionUID = 1L;	
	
	private String message;
	private String code;	
	private SalesCheck salesCheck;
	
	

	
	
	
}

