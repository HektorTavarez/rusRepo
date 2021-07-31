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
public class Offer implements Serializable  {
	
	private static final long serialVersionUID = 1L;
	
	 private int id;
	 private String descripcion;
	 private int aplica;
	 private int porcentage;
	 private int cantidad;
	 private String restricciones;	
	 private int antiguedad;
	 private Double superior;
	 private int cada;
	 private int total;
}
