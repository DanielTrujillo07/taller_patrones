package com.eafit.edu.marcosypatrones.taller.processors.iterfaces;

import java.math.BigDecimal;

import com.eafit.edu.marcosypatrones.taller.entidades.CreditCard;
import com.eafit.edu.marcosypatrones.taller.processors.dto.ChargeResultDTO;

/**
 * Interface con las firmas de los servicios que debe tener las clases que hereden de CreditCardProcesor
 * @author Daniel danieltrujillo07@gmail.com
 * @author Juan Carlos Arbelaez
 * @author Hernan Dario Rincon
 * @author Alejandro Merchan
 */
public abstract class ICreditCardProcessor {
	
	/** Atributo que representa la tarjeta de credito sobre la cual se esta cobrando la orden */
	private CreditCard creditCardLocal = null;
	/** Atributo que indica la cantidad de items cobrados */
	private Integer amountLocal = BigDecimal.ZERO.intValue();
	
	/**
	 * Servicio encargado de realizar un cobro sobre una tarjeta 
	 * @param creditCard tarjeta de credito sobre la cual se va a realizar el cobro
	 * @param amount cantidad de elementos del pedido
	 * @return resultado del proceso de cobro
	 * @author Daniel danieltrujillo07@gmail.com
	 */
	public abstract ChargeResultDTO charge(CreditCard creditCard, Integer amount);
	
	/**
	 * Servicio encargado de retornar la tarjeta sobre la cual se genero el cobro}
	 * @return tarjeta sobre la cual se genero e cobro
	 * @author Daniel danieltrujillo07@gmail.com
	 */
	public CreditCard getCardOfOnlyCharge() {
		return creditCardLocal;
	}
	
	/**
	 * Servicio encargado de retornar la cantidad de items cobrados 
	 * @return cantidad de items cobrados
	 * @author Daniel danieltrujillo07@gmail.com
	 */
	public Integer getAmountOfOnlyCharge() {
		return amountLocal;
	}
	/**
	 * Método encargado de establecer el parametro de creditCardLocal
	 * @param creditCardLocal informacion a establecer
	 */
	public void setCreditCardLocal(CreditCard creditCardLocal) {
		this.creditCardLocal = creditCardLocal;
	}
	/**
	 * Método encargado de establecer el parametro de amountLocal
	 * @param amountLocal informacion a establecer
	 */
	public void setAmountLocal(Integer amountLocal) {
		this.amountLocal = amountLocal;
	}
	
	
}