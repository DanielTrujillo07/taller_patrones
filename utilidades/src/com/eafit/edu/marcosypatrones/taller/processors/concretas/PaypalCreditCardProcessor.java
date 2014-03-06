package com.eafit.edu.marcosypatrones.taller.processors.concretas;

import com.eafit.edu.marcosypatrones.taller.entidades.CreditCard;
import com.eafit.edu.marcosypatrones.taller.processors.dto.ChargeResultDTO;
import com.eafit.edu.marcosypatrones.taller.processors.iterfaces.ICreditCardProcessor;

/**
 * Clase concreta1 que extiende de ICreditCardProcessor
 * @author Daniel danieltrujillo07@gmail.com
 * @author Juan Carlos Arbelaez
 * @author Hernan Dario Rincon
 * @author Alejandro Merchan
 */
public class PaypalCreditCardProcessor extends ICreditCardProcessor{

	/**
	 * Servicio encargado de realizar un cobro sobre una tarjeta 
	 * @param creditCard tarjeta de credito sobre la cual se va a realizar el cobro
	 * @param amount cantidad de elementos del pedido
	 * @return resultado del proceso de cobro
	 * @author Daniel danieltrujillo07@gmail.com
	 */
	public ChargeResultDTO charge(CreditCard creditCard,  Integer amount) {
		ChargeResultDTO result = new ChargeResultDTO();
		if(creditCard != null && amount != null) {
			// se verifica que se ingresara la informacion de la tarjeta
			if(creditCard.getNombre() != null && !creditCard.getNombre().trim().isEmpty() && 
					creditCard.getMes() != null && creditCard.getAnio() != null) {
				result.setSuccessful(Boolean.TRUE);
			}else {
				result.setDeclineMessage("No ingreso informacion de la tarjeta. ");
			}
			// se establece la informacion de la tarjeta
			super.setCreditCardLocal(creditCard);
			super.setAmountLocal(amount);
		}
		return result;
	}
}