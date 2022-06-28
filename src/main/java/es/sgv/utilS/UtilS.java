package es.sgv.utilS;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UtilS {
	
	public static String leerTeclado(String msg) {
		
		System.out.println(msg);
		
		String entrada = "";
		
		try (BufferedReader bf =  new BufferedReader(new InputStreamReader(System.in))) {
			
			entrada = bf.readLine();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return entrada;
	}

}
