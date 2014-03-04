package com.eafit.edu.marcosypatrones.taller.ejb;

import com.eafit.edu.marcosypatrones.taller.entidades.CreditCard;
import com.eafit.edu.marcosypatrones.taller.entidades.PizzaOrder;
import com.eafit.edu.marcosypatrones.taller.entidades.Receipt;
import com.eafit.edu.marcosypatrones.taller.excepcion.UnreachableException;
import com.eafit.edu.marcosypatrones.taller.interfaces.IBillingService;
import com.eafit.edu.marcosypatrones.taller.logs.iterfaces.ITransactionLog;
import com.eafit.edu.marcosypatrones.taller.processors.dto.ChargeResultDTO;
import com.eafit.edu.marcosypatrones.taller.processors.iterfaces.ICreditCardProcessor;
import com.google.inject.Inject;

/**
 * Clase concreta que implementa los metodos de la interface <code>IBillingService<code>
 * @author Daniel danieltrujillo07@gmail.com
 */
public class BillingService implements IBillingService {
	
	/** Clase que contiene la regferencia de processor */
	private ICreditCardProcessor processor = null;
	/** Clase que contiene la referencia al transactionLog */
	private ITransactionLog transactionLog = null;

	/**
	 * Constructor de la clase 
	 * @param processor instancia a usar del procesor
	 * @param transactionLog instancia a usar del transactionLog
	 * @author Daniel danieltrujillo07@gmail.com
	 */
	@Inject
	public BillingService(ICreditCardProcessor processor, ITransactionLog transactionLog) {
		this.processor = processor;
		this.transactionLog = transactionLog;
	}
	
	/**
	 * Servicio encargado de cobrar la oden a la tarjeta de credito ambos ingresados como parametros,
	 * </br> todas las trasacciones son almacenadas, tanto las exitosas como las fallidas. 
	 * @param order orden a ser cobrada
	 * @param creditCard tarjeta de credito a ser utilizada
	 * @return recepcion de la transaccion, si el cobro es exitoso, la rececion sera exitoso, 
	 * 			</br> en caso contrario tendra un mensaje describiendo por el cobro no fue exitoso
	 * @author Daniel danieltrujillo07@gmail.com
	 */
	public Receipt chargeOrder(PizzaOrder order, CreditCard creditCard) {
		try {
			ChargeResultDTO result = processor.charge(creditCard, order.getAmount());
			transactionLog.logChargeResult(result);
			return result.isSuccessful() ? 
					Receipt.forSuccessfulCharge(order.getAmount()) : Receipt.forDeclinedCharge(result.getDeclineMessage());
		} catch (UnreachableException e) {
			transactionLog.logConnectException(e);
			return Receipt.forSystemFailure(e.getMessage());
		}
	}
	

}
// Codigo origina
//public class RealBillingService implements BillingService {
//	public Receipt chargeOrder(PizzaOrder order, CreditCard creditCard) {
//		CreditCardProcessor processor = new PaypalCreditCardProcessor();
//		TransactionLog transactionLog = new DatabaseTransactionLog();
//
//		try {
//			ChargeResult result = processor.charge(creditCard, order.getAmount());
//			transactionLog.logChargeResult(result);
//
//			return result.wasSuccessful()
//					? Receipt.forSuccessfulCharge(order.getAmount())
//							: Receipt.forDeclinedCharge(result.getDeclineMessage());
//		} catch (UnreachableException e) {
//			transactionLog.logConnectException(e);
//			return Receipt.forSystemFailure(e.getMessage());
//		}
//	}
//}