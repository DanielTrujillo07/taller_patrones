package com.eafit.edu.marcosypatrones.taller.entidades;

import java.math.BigDecimal;

/**
 * Clase que representa el recivido de un cobro de un pedido
 * @author Daniel danieltrujillo07@gmail.com
 */
public class Receipt {
	
	/** Atributo que indica que proceso de cobro fue exitoso */
	private Boolean successful = Boolean.FALSE;
	/** Atributo que indica la cantidad de elementos de la orden */
	private Integer amount = BigDecimal.ZERO.intValue();
	/** Atributo para Indicar el mensaje de no cobro */
	private String mensajeNoCobro = null;
	
	/**
	 * Contructor de la la clase Receipt.java
	 * @author Daniel danieltrujillo07@gmail.com
	 */
	public Receipt() {
		super();
	}
	
	/** Metodo encargado de indicar si el proceso fue exitoso o no*/ 
	public Boolean hasSuccessfulCharge() {
		return successful;
	}
	/**
	 * Método encargado de establecer el parametro de successful
	 * @param successful informacion a establecer
	 */
	public void setSuccessful(Boolean successful) {
		this.successful = successful;
	}
	/** Metodo encargado de retornar la cantidad de items cobrados en la orden*/
	public Integer getAmountOfCharge() {
		return amount;
	}
	/**
	 * Método encargado de establecer el parametro de amount
	 * @param amount informacion a establecer
	 */
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	/**
	 * Método encargado de retornar el valor del atributo mensajeNoCobro 
	 * @return tretorna el valor de mensajeNoCobro
	 */
	public String getMensajeNoCobro() {
		return mensajeNoCobro;
	}
	/**
	 * Método encargado de establecer el parametro de mensajeNoCobro
	 * @param mensajeNoCobro informacion a establecer
	 */
	public void setMensajeNoCobro(String mensajeNoCobro) {
		this.mensajeNoCobro = mensajeNoCobro;
	}
	
	
	/**
	 * Método encargado de crear el objeto de resultado exitoso del proceso
	 * @param amount cantidad de items cobrados en la orden
	 * @return objeto con el resultado exitoso
	 * @author Daniel danieltrujillo07@gmail.com
	 */
	public static Receipt forSuccessfulCharge(Integer amount) {
		Receipt obj = new Receipt();
		obj.setSuccessful(Boolean.TRUE);
		obj.setAmount(amount);
		return obj;
	}
	/**
	 * Método encargado de retornar el objeto con el mensaje de fallido
	 * @param mensaje mensaje de causal de no cobro 
	 * @return objeto con el mensaje de no exito
	 * @author Daniel danieltrujillo07@gmail.com
	 */
	public static Receipt forDeclinedCharge(String mensaje) {
		Receipt obj = new Receipt();
		obj.setSuccessful(Boolean.FALSE);
		obj.setAmount(BigDecimal.ZERO.intValue());
		obj.setMensajeNoCobro(mensaje);
		return obj;
	}
	/**
	 * Método encargado de retornar el objeto con el mensaje de fallido
	 * @param mensaje mensaje de causal de no cobro 
	 * @return objeto con el mensaje de no exito
	 * @author Daniel danieltrujillo07@gmail.com
	 */
	public static Receipt forSystemFailure (String mensaje) {
		Receipt obj = new Receipt();
		obj.setSuccessful(Boolean.FALSE);
		obj.setAmount(BigDecimal.ZERO.intValue());
		obj.setMensajeNoCobro(mensaje);
		return obj;
	}	
	
}