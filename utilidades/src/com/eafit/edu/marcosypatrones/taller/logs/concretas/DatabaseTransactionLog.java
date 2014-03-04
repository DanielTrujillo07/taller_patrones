package com.eafit.edu.marcosypatrones.taller.logs.concretas;

import com.eafit.edu.marcosypatrones.taller.excepcion.UnreachableException;
import com.eafit.edu.marcosypatrones.taller.logs.iterfaces.ITransactionLog;
import com.eafit.edu.marcosypatrones.taller.processors.dto.ChargeResultDTO;

/**
 * Clase concreta1 que extiende de ITransactionLog
 * @author Daniel danieltrujillo07@gmail.com
 */
public class DatabaseTransactionLog extends ITransactionLog{

	/**
	 * Servicio encargado de de registrar un log con el resultado del cobro sobre una tarjeta  
	 * @param result objeto con la informacion del resultado del proceso de cobro
	 * @author Daniel danieltrujillo07@gmail.com
	 */
	public void logChargeResult(ChargeResultDTO result) {
		if(result != null && result.isSuccessful()) {
			super.setSuccessLogged(Boolean.TRUE);
		}
	}
	
	/**
	 * Servicio encargado de registrar la excepcion que se pudiera presentar 
	 * @param e excepcion que se presente
	 * @author Daniel danieltrujillo07@gmail.com
	 */
	public void logConnectException(UnreachableException e) {
		super.setSuccessLogged(Boolean.FALSE);
	}
}