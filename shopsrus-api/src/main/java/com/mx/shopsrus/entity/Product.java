package com.mx.shopsrus.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter 
@Setter
public class Product implements Serializable  {
	private static final long serialVersionUID = 1L;
	
	    private int id;
		private String nombre;
		private Double precio;
		private int categoria;
	
}
