package com.eafit.edu.marcosypatrones.taller.logs.iterfaces;

import com.eafit.edu.marcosypatrones.taller.excepcion.UnreachableException;
import com.eafit.edu.marcosypatrones.taller.processors.dto.ChargeResultDTO;

/**
 * Interface con las firmas de los metodos que se deben implementar para el manejo de logs
 * @author Daniel danieltrujillo07@gmail.com
 * @author Juan Carlos Arbelaez
 * @author Hernan Dario Rincon
 * @author Alejandro Merchan
 */
public abstract class ITransactionLog {
	
	/** Atributo para indicar que el proceso de manejo de logs fue exitoso o no*/
	protected Boolean successLogged = Boolean.FALSE;
	
	/**
	 * Servicio encargado de de registrar un log con el resultado del cobro sobre una tarjeta  
	 * @param result objeto con la informacion del resultado del proceso de cobro
	 * @author Daniel danieltrujillo07@gmail.com
	 */
	public abstract void logChargeResult(ChargeResultDTO result);
	
	/**
	 * Servicio encargado de registrar la excepcion que se pudiera presentar 
	 * @param e excepcion que se presente
	 * @author Daniel danieltrujillo07@gmail.com
	 */
	public abstract void logConnectException(UnreachableException e);
	
	/**
	 * Servicio encargado de identificar que el manejo de logs de la transaccion fueron exitosos 
	 * @return true si es exitoso o false en caso contrario
	 * @author Daniel danieltrujillo07@gmail.com
	 */
	public Boolean wasSuccessLogged() {
		return successLogged;
	}
	/**
	 * Método encargado de establecer el parametro de successLogged
	 * @param successLogged informacion a establecer
	 */
	public void setSuccessLogged(Boolean successLogged) {
		this.successLogged = successLogged;
	}

}