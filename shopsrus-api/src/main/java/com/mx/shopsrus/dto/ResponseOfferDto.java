package com.mx.shopsrus.dto;

import java.io.Serializable;
import java.util.List;

import com.mx.shopsrus.entity.Offer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter 
@Setter
public class ResponseOfferDto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Offer offer;
	private List<Offer> offers;
	private String message;
	private String code;
	
}
