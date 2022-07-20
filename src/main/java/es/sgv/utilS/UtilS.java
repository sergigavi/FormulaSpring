package es.sgv.utilS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/*
 * Clase de utilidades de Sergigavi
 */

public class UtilS {
	
	/*
	 * Funcion que recibe un parametro que mostrará por pantalla para indicar aquello que se va a leer por teclado (puede ser un "" en el caso de que no queramos mostrar mensaje).
	 * Permite leer por teclado en consola un String (posteriormente puede ser parseado) y lo devuelve a la ejecucion desde la cual hayamos llamado a esta funcion.
	 */
	public static String leerTeclado(String msg) {
		
		System.out.println(msg);
		
		String entrada = "";
		
		try {
			
			BufferedReader bf =  new BufferedReader(new InputStreamReader(System.in));
			
			entrada = bf.readLine();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return entrada;
	}

	/*
	 * Permite universalizar el paso de un array estandar de java a un Set<>
	 */
	public static Set<Object> deArrayASet(Object[] array)
	{
		Set<Object> miSet = new HashSet<>();
		
		for (int i = 0; i < array.length; i++) {
			miSet.add(array[i]);
		}
		
		return miSet;
	}

	
}
