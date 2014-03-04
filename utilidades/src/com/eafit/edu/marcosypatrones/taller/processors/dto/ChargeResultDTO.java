package com.eafit.edu.marcosypatrones.taller.processors.dto;

/**
 * Clase encargada de transportar la informacion del resultado del proceso de cobro del pedido
 * @author Daniel danieltrujillo07@gmail.com
 */
public class ChargeResultDTO {
	
	/** Atributo que indica que el proceso fue exitoso */
	private Boolean successful = Boolean.FALSE;
	/** Atributo para identificar el mensaje de porque la transaccion no fue exitosa */
	private String declineMessage = null;

	
	/**
	 * Método encargado de retornar el valor del atributo successful 
	 * @return tretorna el valor de successful
	 */
	public Boolean isSuccessful() {
		return successful;
	}
	/**
	 * Método encargado de establecer el parametro de successful
	 * @param successful informacion a establecer
	 */
	public void setSuccessful(Boolean successful) {
		this.successful = successful;
	}
	/**
	 * Método encargado de retornar el valor del atributo declineMessage 
	 * @return tretorna el valor de declineMessage
	 */
	public String getDeclineMessage() {
		return declineMessage;
	}
	/**
	 * Método encargado de establecer el parametro de declineMessage
	 * @param declineMessage informacion a establecer
	 */
	public void setDeclineMessage(String declineMessage) {
		this.declineMessage = declineMessage;
	}
	
}