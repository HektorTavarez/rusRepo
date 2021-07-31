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
public class Client implements Serializable  {
	
	private static final long serialVersionUID = 1L;
	
	 private int id;
	 private String nombres;
	 private String paterno;
	 private String materno;
	 private String fecha_nacimiento;
	 private String fecha_antiguedad;	
	 private String tipo_usuario;
	 private String usuario;
	 private Address domicilio;
	 
}
