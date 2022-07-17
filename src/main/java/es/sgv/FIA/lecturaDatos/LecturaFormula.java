package es.sgv.FIA.lecturaDatos;

import java.time.LocalDate;

import es.sgv.FIA.model.Categoria;
import es.sgv.FIA.model.Mundial;
import es.sgv.FIA.model.Piloto;
import es.sgv.FIA.model.Trabajador;
import static es.sgv.utilS.UtilS.*;

public class LecturaFormula {


	public static Trabajador leerTrabajador()
	{
		System.out.println("\r\n"
				+ "  _                      _          _      _               _     _   _            _           _         _         \r\n"
				+ " | |___ _  _ ___ _ _  __| |___   __| |__ _| |_ ___ ___  __| |___| | | |_ _ _ __ _| |__  __ _ (_)__ _ __| |___ _ _ \r\n"
				+ " | / -_) || / -_) ' \\/ _` / _ \\ / _` / _` |  _/ _ (_-< / _` / -_) | |  _| '_/ _` | '_ \\/ _` || / _` / _` / _ \\ '_|\r\n"
				+ " |_\\___|\\_, \\___|_||_\\__,_\\___/ \\__,_\\__,_|\\__\\___/__/ \\__,_\\___|_|  \\__|_| \\__,_|_.__/\\__,_|/ \\__,_\\__,_\\___/_|  \r\n"
				+ "        |__/                                                                               |__/                   \r\n"
				+ "");
		
		Trabajador t = Trabajador.builder().id("").build();
		
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
	
	public static Piloto LeerPiloto()
	{
		//TODO: cambiar por piloto
		System.out.println("\r\n"
				+ "  _                      _          _      _               _     _   _            _           _         _         \r\n"
				+ " | |___ _  _ ___ _ _  __| |___   __| |__ _| |_ ___ ___  __| |___| | | |_ _ _ __ _| |__  __ _ (_)__ _ __| |___ _ _ \r\n"
				+ " | / -_) || / -_) ' \\/ _` / _ \\ / _` / _` |  _/ _ (_-< / _` / -_) | |  _| '_/ _` | '_ \\/ _` || / _` / _` / _ \\ '_|\r\n"
				+ " |_\\___|\\_, \\___|_||_\\__,_\\___/ \\__,_\\__,_|\\__\\___/__/ \\__,_\\___|_|  \\__|_| \\__,_|_.__/\\__,_|/ \\__,_\\__,_\\___/_|  \r\n"
				+ "        |__/                                                                               |__/                   \r\n"
				+ "");
		
		Piloto p = Piloto.builder().id("").build();
		
		try {
			
			p.setId(leerTeclado("ID: "));
			p.setNombre(leerTeclado("NOMBRE: "));
			p.setDorsal(Integer.parseInt(leerTeclado("CARGO: ")));
			p.setFechaNacimiento(LocalDate.parse(leerTeclado("FECHA NACIMIENTO YYYY-MM-DD: ")));
			p.setUrlImage(leerTeclado("URL IMAGEN: "));
			//.escuderia(leerTeclado("ESCUDERIA: ")) // Aqui podria sacar el dao y meterle la escuderia por id			
			
		} catch (Exception e) {
			p.setFechaNacimiento(LocalDate.now().minusYears(18));
			e.printStackTrace();
		}
				
		return p;
	}
	
	public static Mundial leerMundial()
	{
		System.out.println("leyendo mundial...");
		Mundial m = Mundial.builder().id("").build();
		
		try {
			
			m.setId(leerTeclado("ID: "));
			m.setAnno(Integer.parseInt(leerTeclado("AÑO: ")));
			m.setCategoria(leerCategoria());
			
		} catch (Exception e) {
			System.err.println("Error leyendo mundial");
			e.printStackTrace();
		}
		return m;
	}

	public static Categoria leerCategoria() {
		
		System.err.println("CATEGORIAS DISPONIBLES: ");
		deArrayASet(Categoria.values()).forEach(System.out::println);
		
		String categoriaString = leerTeclado("Categoria: ");
		
		return parseCategoria(categoriaString);
	}
	
	public static Categoria parseCategoria(String categoriaString) {
		
		Categoria categoria = Categoria.FORMULA1;
		
		switch (categoriaString) {
		case "FORMULA1":
			categoria = Categoria.FORMULA1;
			break;

		case "FORMULA2":
			categoria = Categoria.FORMULA2;
			break;

		case "FORMULA3":
			categoria = Categoria.FORMULA3;
			break;

		case "RESISTENCIA_FIA":
			categoria = Categoria.RESISTENCIA_FIA;
			break;

		case "LEMANS_24H":
			categoria = Categoria.LEMANS_24H;
			break;

		case "DAYTONA_24H":
			categoria = Categoria.DAYTONA_24H;
			break;
		
		}		
		
		return categoria;
	}
	
}
