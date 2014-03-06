package com.eafit.edu.marcosypatrones.taller.modulos;

import com.eafit.edu.marcosypatrones.taller.ejb.BillingService;
import com.eafit.edu.marcosypatrones.taller.interfaces.IBillingService;
import com.eafit.edu.marcosypatrones.taller.logs.concretas.DatabaseTransactionLog;
import com.eafit.edu.marcosypatrones.taller.logs.iterfaces.ITransactionLog;
import com.eafit.edu.marcosypatrones.taller.processors.factory.CreditCardProcessorFactory;
import com.eafit.edu.marcosypatrones.taller.processors.iterfaces.ICreditCardProcessor;
import com.google.inject.AbstractModule;
/**
 * Clase encargada de implementar la clase AbstractModule de Guice 
 * </br> y así permitir la inyeccion de dependencias
 * @author Daniel danieltrujillo07@gmail.com
 * @author Juan Carlos Arbelaez
 * @author Hernan Dario Rincon
 * @author Alejandro Merchan
 */
public class BillingModule extends AbstractModule{

	/** Atributo para indicar el tipo de clase concreta a inyectar para procesar el cobro */
	private String codigoClaseCargar = null;

	/** Metodo encargado de realizar la configuracion de las clases a inyectar*/
	protected void configure() {
		bind(IBillingService.class).to(BillingService.class);
		bind(ITransactionLog.class).to(DatabaseTransactionLog.class);
		// Se identifica la clase a inyectar para procesar el cobro		
		bind(ICreditCardProcessor.class).to(CreditCardProcessorFactory.getInstance(codigoClaseCargar).getClass());
	}

	/**
	 * Método encargado de retornar el valor del atributo codigoClaseCargar 
	 * @return tretorna el valor de codigoClaseCargar
	 */
	public String getCodigoClaseCargar() {
		return codigoClaseCargar;
	}
	/**
	 * Método encargado de establecer el parametro de codigoClaseCargar
	 * @param codigoClaseCargar informacion a establecer
	 */
	public void setCodigoClaseCargar(String codigoClaseCargar) {
		this.codigoClaseCargar = codigoClaseCargar;
	}

}