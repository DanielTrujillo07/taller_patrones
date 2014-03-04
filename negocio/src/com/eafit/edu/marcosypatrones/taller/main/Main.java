package com.eafit.edu.marcosypatrones.taller.main;

import com.eafit.edu.marcosypatrones.taller.ejb.BillingService;
import com.eafit.edu.marcosypatrones.taller.entidades.CreditCard;
import com.eafit.edu.marcosypatrones.taller.entidades.PizzaOrder;
import com.eafit.edu.marcosypatrones.taller.entidades.Receipt;
import com.eafit.edu.marcosypatrones.taller.modulos.BillingModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class Main {
	
	public static void main(String[] args) {
		/** Atributo para representar la orden*/
		final PizzaOrder order = new PizzaOrder(100);
		/** Atributo para representar la tarjeta de credito */
		final CreditCard creditCard = new CreditCard("1234", 11, 2010);
		
	    Injector injector = Guice.createInjector(new BillingModule());
	    BillingService billingService = injector.getInstance(BillingService.class);
	    
	    Receipt receipt = billingService.chargeOrder(order, creditCard);

	    // Se verifica el resultado del proceso
	    System.out.println("hasSuccessfulCharge: "+receipt.hasSuccessfulCharge());
	    System.out.println("getAmountOfCharge: "+receipt.getAmountOfCharge());
	  }
}