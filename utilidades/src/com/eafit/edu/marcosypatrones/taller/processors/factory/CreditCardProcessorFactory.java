package com.eafit.edu.marcosypatrones.taller.processors.factory;

import com.eafit.edu.marcosypatrones.taller.processors.concretas.PaypalCreditCardProcessor;
import com.eafit.edu.marcosypatrones.taller.processors.iterfaces.ICreditCardProcessor;

/**
 * Clase Factory encargada de crear la clase concreta de process
 * @author Daniel danieltrujillo07@gmail.com
 */
@Deprecated
public class CreditCardProcessorFactory {

	/** Instancia unica del processor */
	private static ICreditCardProcessor instance = null;

	/**
	 * Método encargado de recuperar la clase concreta de processo
	 * @return instancia recuperada
	 * @author Daniel danieltrujillo07@gmail.com
	 */
	public static ICreditCardProcessor getInstance() {
		if(instance == null) {
			return new PaypalCreditCardProcessor();
		}
		return instance;
	}
	
	/**
	 * Método encargado de  establecer la instancia de la clase concreta
	 * @param creditCardProcessor instancia de la clase concreta
	 * @author Daniel danieltrujillo07@gmail.com
	 */
	public static void setInstance(ICreditCardProcessor creditCardProcessor) {
		instance = creditCardProcessor;
	}

}
// Codigo Origen
//public class CreditCardProcessorFactory {
//
//	private static CreditCardProcessor instance;
//
//	public static void setInstance(CreditCardProcessor creditCardProcessor) {
//		instance = creditCardProcessor;
//	}
//
//	public static CreditCardProcessor getInstance() {
//		if (instance == null) {
//			return new SquareCreditCardProcessor();
//		}
//
//		return instance;
//	}