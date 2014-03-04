package com.eafit.edu.marcosypatrones.taller.logs.factory;

import com.eafit.edu.marcosypatrones.taller.logs.concretas.DatabaseTransactionLog;
import com.eafit.edu.marcosypatrones.taller.logs.iterfaces.ITransactionLog;

/**
 * Factory para la creacion de la clase concreta encargada de manejar los logs de la transaccion
 * @author Daniel danieltrujillo07@gmail.com
 */
public class TransactionLogFactory {
	
	/** Instancia unica del TransaccionLog */
	private static ITransactionLog instance = null;

	/**
	 * Método encargado de recuperar la clase concreta de manejo de logs
	 * @return instancia recuperada
	 * @author Daniel danieltrujillo07@gmail.com
	 */
	public static ITransactionLog getInstance() {
		if(instance == null) {
			return new DatabaseTransactionLog();
		}
		return instance;
	}
	
	/**
	 * Método encargado de establecer la instancia de la clase concreta
	 * @param transaccionLog instancia de la clase concreta
	 * @author Daniel danieltrujillo07@gmail.com
	 */
	public static void setInstance(ITransactionLog transaccionLog) {
		instance = transaccionLog;
	}

}