package com.eafit.edu.marcosypatrones.taller.entidades;

/**
 * Clase que representa una tarjeta de credito
 * @author Daniel danieltrujillo07@gmail.com
 */
public class CreditCard {
	
	/** atributo para indicar el nombre que aparece en la tarjeta*/
	private String nombre = null;
	/** Atributo para indicar el mes de vencimiento que aparece en la tarjeta */
	private Integer mes = null;
	/** atributo para indicar el anio de vencimiento que aparece en la tarjeta */
	private Integer anio = null;
	
	/** Constructor por defecto */
	public CreditCard() {
		super();
	}
	
	/**
	 * Contructor de la la clase CreditCard.java
	 * @param nombre nombre que representa la tarjeta
	 * @param mes mes en la tarjeta
	 * @param anio anio en la tarjeta
	 * @author Daniel danieltrujillo07@gmail.com
	 */
	public CreditCard(String nombre, Integer mes, Integer anio) {
		super();
		this.nombre = nombre;
		this.mes = mes;
		this.anio = anio;
	}
	
	
	/**
	 * Método encargado de retornar el valor del atributo nombre 
	 * @return tretorna el valor de nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * Método encargado de establecer el parametro de nombre
	 * @param nombre informacion a establecer
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * Método encargado de retornar el valor del atributo mes 
	 * @return tretorna el valor de mes
	 */
	public Integer getMes() {
		return mes;
	}
	/**
	 * Método encargado de establecer el parametro de mes
	 * @param mes informacion a establecer
	 */
	public void setMes(Integer mes) {
		this.mes = mes;
	}
	/**
	 * Método encargado de retornar el valor del atributo anio 
	 * @return tretorna el valor de anio
	 */
	public Integer getAnio() {
		return anio;
	}
	/**
	 * Método encargado de establecer el parametro de anio
	 * @param anio informacion a establecer
	 */
	public void setAnio(Integer anio) {
		this.anio = anio;
	}
}