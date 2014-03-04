package com.eafit.edu.marcosypatrones.taller.modulos;

import com.eafit.edu.marcosypatrones.taller.ejb.BillingService;
import com.eafit.edu.marcosypatrones.taller.interfaces.IBillingService;
import com.eafit.edu.marcosypatrones.taller.logs.concretas.DatabaseTransactionLog;
import com.eafit.edu.marcosypatrones.taller.logs.iterfaces.ITransactionLog;
import com.eafit.edu.marcosypatrones.taller.processors.concretas.PaypalCreditCardProcessor;
import com.eafit.edu.marcosypatrones.taller.processors.iterfaces.ICreditCardProcessor;
import com.google.inject.AbstractModule;
/**
 * Clase encargada de implementar la clase AbstractModule de Guice 
 * </br> y así permitir la inyeccion de dependencias
 * @author Daniel danieltrujillo07@gmail.com
 */
public class BillingModule extends AbstractModule{
	
	/** Metodo encargado de realizar la configuracion de las clases a inyectar*/
	protected void configure() {
	    bind(ITransactionLog.class).to(DatabaseTransactionLog.class);
	    bind(ICreditCardProcessor.class).to(PaypalCreditCardProcessor.class);
	    bind(IBillingService.class).to(BillingService.class);
	  }

}