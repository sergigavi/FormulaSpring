package es.sgv.utilS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class UtilS {
	
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

	public static Set<Object> deArrayASet(Object[] array)
	{
		Set<Object> miSet = new HashSet<>();
		
		for (int i = 0; i < array.length; i++) {
			miSet.add(array[i]);
		}
		
		return miSet;
	}

	
}
