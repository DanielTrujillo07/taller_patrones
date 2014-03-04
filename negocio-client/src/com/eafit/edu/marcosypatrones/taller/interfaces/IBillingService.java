package com.eafit.edu.marcosypatrones.taller.interfaces;

import com.eafit.edu.marcosypatrones.taller.entidades.CreditCard;
import com.eafit.edu.marcosypatrones.taller.entidades.PizzaOrder;
import com.eafit.edu.marcosypatrones.taller.entidades.Receipt;

/**
 * Interfas que contiene las firmas de los servicios a exponer por la clase concetra de BillingService
 * @author Daniel danieltrujillo07@gmail.com
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
	
	
}
//Codigo original
//public interface BillingService {
//
//	  /**
//	   * Attempts to charge the order to the credit card. Both successful and
//	   * failed transactions will be recorded.
//	   *
//	   * @return a receipt of the transaction. If the charge was successful, the
//	   *      receipt will be successful. Otherwise, the receipt will contain a
//	   *      decline note describing why the charge failed.
//	   */
//	  Receipt chargeOrder(PizzaOrder order, CreditCard creditCard);
//	}