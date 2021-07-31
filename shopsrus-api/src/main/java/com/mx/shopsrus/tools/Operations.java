package com.mx.shopsrus.tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.Calendar.*;
import com.mx.shopsrus.entity.Offer;
import com.mx.shopsrus.entity.Product;

public class Operations {

	public static int TryParseInt(String cadena){
		int respuesta;
		
		try{
			respuesta = Integer.parseInt(cadena.trim());
		}catch(Exception e) {
			respuesta = 0;
		}
		
		return respuesta;
		
	}
	
	public static Long TryParseLong(String cadena){
		long respuesta;
		
		try{
			respuesta = Long.parseLong(cadena.trim());
		}catch(Exception e) {
			respuesta = 0;
		}
		
		return respuesta;
		
	}
	
	
	
	public static double TryParseDouble(String cadena){
		double respuesta;
		
		try{
			respuesta = Double.parseDouble(cadena.trim());
		}catch(Exception e) {
			respuesta = 0.0;
		}
		
		return respuesta;
		
	}
	
	
	public static Double calculaDescuento(List<Offer> ofertas,List<Product> productos) {
		Double respuesta = 0.0;
		
		long contadorRestriccion = 0;
		double total = productos.stream().mapToDouble(Product::getPrecio).sum();	
		double totalTemp = total;
		List<String> categorias =  Operations.obtieneCategorias(productos);
					  		
		for(Offer offer : ofertas) {
			
			
			List<String> restricciones = Arrays.asList((offer.getRestricciones()).split(";"));			
			
			
			for(String restriccion: restricciones) {				
				contadorRestriccion += (categorias.contains(restriccion)==true?1:0);
			}

			if(contadorRestriccion == 0) { // aplica el descuento 				
				Double descuento = Operations.calculaMontoOferta(totalTemp,offer);	
				totalTemp = totalTemp - descuento;					
				respuesta += descuento;		
				System.out.println("descuento-> "+descuento);
			}					
		}
		
		return respuesta;
	}
			
	public static double calculaMontoOferta(Double total, Offer oferta) {
		Double respuesta = 0.0;
		
		if(oferta.getPorcentage() > 0 && 1 == oferta.getTotal()) {			
			respuesta = (oferta.getPorcentage() * total) / 100;			
		}else if(oferta.getCantidad() > 0 && oferta.getTotal() == 1){				
			respuesta = total - oferta.getCantidad();		
		} else {
			respuesta = Math.floor((total / oferta.getCada())) * oferta.getCantidad();
		}
		
		return respuesta;		
	}
		
	public static List<String> obtieneCategorias(List<Product> productos) {
		List<String> respuesta = new ArrayList<String>();
		
		 Collection<Product> list = productos;
		 
	        List<Product> filtroCategorias = list.stream()
	                    .filter( distinctByKey(p -> p.getCategoria()) )
	                    .collect( Collectors.toList());
		
	        for(Product producto:filtroCategorias) {
	        	respuesta.add(producto.getCategoria()+"");
	        }
	    return respuesta; 
	}
	
	
   public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) 
   {
       Map<Object, Boolean> map = new ConcurrentHashMap<>();
       return t -> map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
   }
   
   public static int calculaAntiguedad(String fecha) {
	   int respuesta = 0 ;	   	     
	   try {
		   
		   String fechaRegistro = fecha.substring(0,10);
		   
		Date fechaInicial = new SimpleDateFormat("yyyy-MM-dd").parse(fechaRegistro);
		
		Date fechactual =  new Date();
		
		    Calendar a = getCalendar(fechaInicial);
		    Calendar b = getCalendar(fechactual);
		    
		     respuesta = b.get(YEAR) - a.get(YEAR);
		     
		    if (a.get(MONTH) > b.get(MONTH) || 
		        (a.get(MONTH) == b.get(MONTH) && a.get(DATE) > b.get(DATE))) {
		    	respuesta--;
		    } 
		  
		} catch (ParseException e) {
		
		}  
	   
	   return respuesta;
   }
   
   
	public static Calendar getCalendar(Date date) {
	    Calendar cal = Calendar.getInstance(Locale.US);
	    cal.setTime(date);
	    return cal;
	}
   
   
	
}
