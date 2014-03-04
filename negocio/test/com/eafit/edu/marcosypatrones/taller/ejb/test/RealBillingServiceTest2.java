package com.eafit.edu.marcosypatrones.taller.ejb.test;

import junit.framework.TestCase;

import org.junit.Test;

import com.eafit.edu.marcosypatrones.taller.ejb.BillingService;
import com.eafit.edu.marcosypatrones.taller.entidades.CreditCard;
import com.eafit.edu.marcosypatrones.taller.entidades.PizzaOrder;
import com.eafit.edu.marcosypatrones.taller.entidades.Receipt;
import com.eafit.edu.marcosypatrones.taller.logs.concretas.InMemoryTransactionLog;
import com.eafit.edu.marcosypatrones.taller.processors.concretas.FakeCreditCardProcessor;

/**
 * Clase encargada de ejecutar una pruebas unitarias sobre <code>BillingService<code>
 * @author Daniel danieltrujillo07@gmail.com
 */
public class RealBillingServiceTest2 extends TestCase {
	
	/** Atributo para representar la orden*/
	private final PizzaOrder order = new PizzaOrder(100);
	/** Atributo para representar la tarjeta de credito */
	private final CreditCard creditCard = new CreditCard("1234", 11, 2010);
	/** Clase concreta para manejar los logs */
	private final InMemoryTransactionLog transactionLog = new InMemoryTransactionLog();
	/** Clase concreta para ejecutar el cobro de la orden a la tarjeta de credito */
	private final FakeCreditCardProcessor creditCardProcessor = new FakeCreditCardProcessor();


	/** Metodo encargado de ejecutar la logica de cobro*/
	@Test
	public void testSuccessfulCharge() {
		BillingService billingService = new BillingService(creditCardProcessor, transactionLog);
		Receipt receipt = billingService.chargeOrder(order, creditCard);
		
		// Se verifica el resultado del proceso
		assertTrue(receipt.hasSuccessfulCharge());
		assertEquals(Integer.valueOf(100), receipt.getAmountOfCharge());
		assertEquals(creditCard, creditCardProcessor.getCardOfOnlyCharge());
		assertEquals(Integer.valueOf(100), creditCardProcessor.getAmountOfOnlyCharge());
		assertTrue(transactionLog.wasSuccessLogged());
	}
}
