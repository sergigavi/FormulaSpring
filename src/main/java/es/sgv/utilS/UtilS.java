package es.sgv.utilS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import es.sgv.FIA.model.Trabajador;

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
	
	public static Trabajador leerTrabajador()
	{
		Trabajador t = Trabajador.builder().id("").build();
		
		/*
		try {
			t = Trabajador.builder()
					.id(leerTeclado("ID: "))
					.nombre(leerTeclado("NOMBRE: "))
					.cargo(leerTeclado("CARGO: "))
					.fechaNacimiento(LocalDate.parse(leerTeclado("FECHA NACIMIENTO YYYY/MM/DD: ")))
					//.escuderia(leerTeclado("ESCUDERIA: ")) // Aqui podria sacar el dao y meterle la escuderia por id
					.build();
			
			
		} catch (Exception e) {
			t.setFechaNacimiento(LocalDate.now().minusYears(18));
			e.printStackTrace();
		}*/
		
		try {
			
			t.setId(leerTeclado("ID: "));
			t.setNombre(leerTeclado("NOMBRE: "));
			t.setCargo(leerTeclado("CARGO: "));
			t.setFechaNacimiento(LocalDate.parse(leerTeclado("FECHA NACIMIENTO YYYY-MM-DD: ")));
			//.escuderia(leerTeclado("ESCUDERIA: ")) // Aqui podria sacar el dao y meterle la escuderia por id			
			
		} catch (Exception e) {
			t.setFechaNacimiento(LocalDate.now().minusYears(18));
			e.printStackTrace();
		}
				
		return t;
	}

	
}
