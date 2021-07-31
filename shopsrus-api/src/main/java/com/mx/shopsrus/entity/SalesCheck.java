package com.mx.shopsrus.entity;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter 
@Setter
public class SalesCheck implements Serializable{

	private static final long serialVersionUID = 1L;
	
	 private int id;
	 private Client cliente;
	 private Store tienda;
	 private List<Product> productos;
	 private Double importe_total;
	 private Double descuento;
	 private Double importe_con_descuento;
	 
	 
}
