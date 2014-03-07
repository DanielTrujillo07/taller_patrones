package com.eafit.edu.marcosypatrones.taller.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.eafit.edu.marcosypatrones.taller.ejb.BillingService;
import com.eafit.edu.marcosypatrones.taller.entidades.CreditCard;
import com.eafit.edu.marcosypatrones.taller.entidades.PizzaOrder;
import com.eafit.edu.marcosypatrones.taller.entidades.Receipt;
import com.eafit.edu.marcosypatrones.taller.modulos.BillingModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Clase encargada de iniciar el aplicativo para solicitar al usuario ingresar una opcion de pago
 * </br> y segun esta inyectar una clase especifica
 * @author Daniel danieltrujillo07@gmail.com
 * @author Juan Carlos Arbelaez
 * @author Hernan Dario Rincon
 * @author Alejandro Merchan
 */
public class Main {

	/** Metodo main del aplicativo */
	public static void main(String[] args) {
		String salir = null;
		do {
			// Variables para mantener la informacion del usuario
			String opcionPago = null;
			String nombre = null;
			String mes = null;
			String anio = null;
			String codigoSeguro = null;
			String pass = null;
			String itemsPedido = null;

			System.out.println("Selecciono la opcion para pagar: ");
			System.out.println("1. PayPal ");
			System.out.println("2. FakeCredit ");
			System.out.println("3. Debito ");
			System.out.println("4. Default ");
			opcionPago = leerTextoConsola(null);
			nombre = leerTextoConsola("Ingrese el nombre como aparece en la tarjeta: ");
			mes = leerTextoConsola("Ingrese el mes que aparece en la tarjeta: ");
			anio = leerTextoConsola("Ingrese el año como aparece en la tarjeta: ");
			codigoSeguro = leerTextoConsola("Ingrese el codigo de seguridad de la tarjeta de ser necesario: ");
			pass = leerTextoConsola("Ingrese la contraseña de la tarjeta si es necesario: ");
			itemsPedido = leerTextoConsola("Ingrese el nro de pizas a pedir: ");

			// Se crea los objetos para realizar el proceso
			/** Atributo para representar la orden*/
			PizzaOrder order = new PizzaOrder(Integer.valueOf(itemsPedido));
			/** Atributo para representar la tarjeta de credito */
			CreditCard creditCard = new CreditCard(nombre, Integer.valueOf(mes), Integer.valueOf(anio));
			if(codigoSeguro != null && !codigoSeguro.trim().isEmpty()) {
				creditCard.setNroSeguridad(Integer.valueOf(codigoSeguro));
			}
			if(pass != null && !pass.trim().isEmpty()) {
				creditCard.setPassTarjeta(pass.trim());
			}

			// Se crea el modulo encargado de inyectar las referencias por medio de Guice
			BillingModule module = new BillingModule();
			module.setCodigoClaseCargar(opcionPago);
			
			Injector injector = Guice.createInjector(module);
			BillingService billingService = injector.getInstance(BillingService.class);
			
			// Se verifica como se proceso la informacion
			System.out.println("Para procesar esta informacion se inyecta la clase: " + billingService.getProcessor().getClass().getName());
			
			// Se ejecuta el proceso
			Receipt receipt = billingService.chargeOrder(order, creditCard);
			// Se verifica el resultado del proceso
			System.out.println("hasSuccessfulCharge: "+receipt.hasSuccessfulCharge());
			System.out.println("Causal de no cobro: "+receipt.getMensajeNoCobro());
			System.out.println("getAmountOfCharge: "+receipt.getAmountOfCharge());
			
			salir = leerTextoConsola("Se desea salir dijite Salir, en caso contrario presione cualquier tecla.");
		}while(salir == null || !salir.equalsIgnoreCase("salir"));
		
		System.out.println("***************************** Terminado.");
	}

	/** 
	 * Método encargado de leer un texto a ingresar por consola
	 * @param object mensaje a mostrar antes de leer
	 * @return cadena ingresada por consola
	 * @author Daniel danieltrujillo07@gmail.com
	 */
	private static String leerTextoConsola(String mensaje) {
		BufferedReader br = null;
		InputStreamReader is = null;
		try {
			if(mensaje != null) {
				System.out.println(mensaje);
			}
			// se lee de la consila
			is = new InputStreamReader(System.in);
			br = new BufferedReader(is);
			return br.readLine();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
}