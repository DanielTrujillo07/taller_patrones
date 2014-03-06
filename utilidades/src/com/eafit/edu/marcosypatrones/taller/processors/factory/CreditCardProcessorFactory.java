package com.eafit.edu.marcosypatrones.taller.processors.factory;

import com.eafit.edu.marcosypatrones.taller.constants.NumerosConstants;
import com.eafit.edu.marcosypatrones.taller.processors.concretas.DebitoCardProcessor;
import com.eafit.edu.marcosypatrones.taller.processors.concretas.DefaultCardProcessor;
import com.eafit.edu.marcosypatrones.taller.processors.concretas.FakeCreditCardProcessor;
import com.eafit.edu.marcosypatrones.taller.processors.concretas.PaypalCreditCardProcessor;
import com.eafit.edu.marcosypatrones.taller.processors.iterfaces.ICreditCardProcessor;

/**
 * Clase Factory encargada de crear la clase concreta de process
 * @author Daniel danieltrujillo07@gmail.com
 * @author Juan Carlos Arbelaez
 * @author Hernan Dario Rincon
 * @author Alejandro Merchan
 */
public class CreditCardProcessorFactory {

	/** Constante para identificar la ruta de la clase extra a cargar */
	private static final String CONSTANTE_RUTA_CLASE_EXTRA = 
			"com.eafit.edu.marcosypatrones.taller.processors.concretas.RuntimeCardProcessor";
	/** Instancia unica del processor */
	private static ICreditCardProcessor instance = null;

	/**
	 * Método encargado de recuperar la clase concreta de processo
	 * @return instancia recuperada
	 * @author Daniel danieltrujillo07@gmail.com
	 */
	public static ICreditCardProcessor getInstance(String tipoClaseConcreta) {
		// las clases a cargar estan configuradas así
		// 1. PayPal
		// 2. FakeCredit
		// 3. Debito
		// 4. Default
		// y en caso de ingresarse una no existente o diferente a estas, se cargara una extra en tiempo de ejecucion
		if(tipoClaseConcreta != null && 
				tipoClaseConcreta.trim().equals(NumerosConstants.CONSTANTE_NRO_UNO)) {
			if(instance == null || !(instance instanceof PaypalCreditCardProcessor)) {
				instance = new PaypalCreditCardProcessor();
			}
		}else {
			if(tipoClaseConcreta != null && 
					tipoClaseConcreta.trim().equals(NumerosConstants.CONSTANTE_NRO_DOS)) {
				if(instance == null || !(instance instanceof FakeCreditCardProcessor)) {
					instance = new FakeCreditCardProcessor();
				}
			}else {
				if(tipoClaseConcreta != null && 
						tipoClaseConcreta.trim().equals(NumerosConstants.CONSTANTE_NRO_TRES)) {
					if(instance == null || !(instance instanceof DebitoCardProcessor)) {
						instance = new DebitoCardProcessor();
					}
				}else {
					if(tipoClaseConcreta != null && 
							tipoClaseConcreta.trim().equals(NumerosConstants.CONSTANTE_NRO_CUATRO)) {
						if(instance == null || !(instance instanceof DefaultCardProcessor)) {
							instance = new DefaultCardProcessor();
						}
					}else {
						// Se carga una clase concreta extra en tiempo de ejecucion
						try {
							@SuppressWarnings("rawtypes")
							Class clasz = Class.forName(CONSTANTE_RUTA_CLASE_EXTRA);
							instance = (ICreditCardProcessor)clasz.newInstance();
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}
					}
				}
			}
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