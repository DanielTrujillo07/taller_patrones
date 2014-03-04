package com.eafit.edu.marcosypatrones.taller.entidades;

import java.math.BigDecimal;

/**
 * Clase encargada de representar una orden de piza
 * @author Daniel danieltrujillo07@gmail.com
 */
public class PizzaOrder {
	
	/** Atributo que indica la cantidad de intems incluye el pedido */
	private Integer amount = BigDecimal.ZERO.intValue();

	/**
	 * Contructor de la la clase PizzaOrder.java
	 * @param amount valor a establecer en el atributo de amount
	 * @author Daniel danieltrujillo07@gmail.com
	 */
	public PizzaOrder(Integer amount) {
		super();
		this.amount = amount;
	}
	
	
	/**
	 * Método encargado de retornar el valor del atributo amount 
	 * @return tretorna el valor de amount
	 */
	public Integer getAmount() {
		return this.amount;
	}
	/**
	 * Método encargado de establecer el parametro de amount
	 * @param amount informacion a establecer
	 */
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
}