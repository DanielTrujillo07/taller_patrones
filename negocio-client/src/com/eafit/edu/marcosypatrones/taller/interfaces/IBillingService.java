package com.eafit.edu.marcosypatrones.taller.interfaces;

import com.eafit.edu.marcosypatrones.taller.entidades.CreditCard;
import com.eafit.edu.marcosypatrones.taller.entidades.PizzaOrder;
import com.eafit.edu.marcosypatrones.taller.entidades.Receipt;
import com.eafit.edu.marcosypatrones.taller.processors.iterfaces.ICreditCardProcessor;

/**
 * Interfas que contiene las firmas de los servicios a exponer por la clase concetra de BillingService
 * @author Daniel danieltrujillo07@gmail.com
 * @author Juan Carlos Arbelaez
 * @author Hernan Dario Rincon
 * @author Alejandro Merchan
 */
public interface IBillingService{

	/**
	 * Servicio encargado de cobrar la oden a la tarjeta de credito ambos ingresados como parametros,
	 * </br> todas las trasacciones son almacenadas, tanto las exitosas como las fallidas. 
	 * @param order orden a ser cobrada
	 * @param creditCard tarjeta de credito a ser utilizada
	 * @return recepcion de la transaccion, si el cobro es exitoso, la rececion sera exitoso, 
	 * 			</br> en caso contrario tendra un mensaje describiendo por el cobro no fue exitoso
	 * @author Daniel danieltrujillo07@gmail.com
	 */
	public Receipt chargeOrder(PizzaOrder order, CreditCard creditCard);

	/**
	 * Método encargado de retornar el valor del atributo processor 
	 * @return tretorna el valor de processor
	 */
	public ICreditCardProcessor getProcessor();
	
}