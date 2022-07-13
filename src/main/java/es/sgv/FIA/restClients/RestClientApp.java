package es.sgv.FIA.restClients;

import java.util.HashSet;
import java.util.Set;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import es.sgv.FIA.model.Escuderia;
import es.sgv.FIA.model.Piloto;
import es.sgv.FIA.model.Trabajador;
import es.sgv.FIAJSON.FormulaJSON;
import es.sgv.utilS.UtilS;

public class RestClientApp {
	
	public static final String URL = "http://127.0.0.1:8080/";
	public static final int numOpciones = 7;

	public static void main(String[] args) {
		
		mostrarMenu();
		
	
	}
	
	private static void mostrarMenu() {
		
		String res = "";
		
		do {
			
			System.out.println("""
					1. Salir
					2. Cargar datos
					3. Obtener todas las escuderias
					4. Obtener todos los pilotos
					5. Obtener todos los trabajadores
					6. Guardar Escuderias en fichero JSON
					7. Insertar trabajador en escuderia
					""");
			
			res = UtilS.leerTeclado("Opcion -> ");
			
			elegirOpcion(res);
			
		} while (!res.equals("1"));
		
		System.out.println("\r"
				+ " _   _                       _ _     _             _        _                     _ _                _             \r\n"
				+ "| | | |                     | (_)   | |           | |      | |                   | (_)              (_)            \r\n"
				+ "| |_| | __ _ ___   ___  __ _| |_  __| | ___     __| | ___  | | __ _    __ _ _ __ | |_  ___ __ _  ___ _  ___  _ __  \r\n"
				+ "|  _  |/ _` / __| / __|/ _` | | |/ _` |/ _ \\   / _` |/ _ \\ | |/ _` |  / _` | '_ \\| | |/ __/ _` |/ __| |/ _ \\| '_ \\ \r\n"
				+ "| | | | (_| \\__ \\ \\__ \\ (_| | | | (_| | (_) | | (_| |  __/ | | (_| | | (_| | |_) | | | (_| (_| | (__| | (_) | | | |\r\n"
				+ "\\_| |_/\\__,_|___/ |___/\\__,_|_|_|\\__,_|\\___/   \\__,_|\\___| |_|\\__,_|  \\__,_| .__/|_|_|\\___\\__,_|\\___|_|\\___/|_| |_|\r\n"
				+ "                                                                           | |                                     \r\n"
				+ "                                                                           |_|                                     \r\n"
				+ "");
		
		
	}

	private static void elegirOpcion(String res) {
		
		res = res.trim();
		if(res.equals(""))
			res = "0";
		
		try {
			
			if (Integer.parseInt(res) < 1 || Integer.parseInt(res) > numOpciones)
			{
				System.err.println("Opcion erronea");
			}

			
		} catch (NumberFormatException e) {
			System.err.println("Opcion erronea");
			e.printStackTrace();
		}
		
		
		switch (res) {
		
		case "2":
			cargarDatos();
			break;
			
		case "3":
			obtenerEscuderias().forEach(System.out::println);
			break;
			
		case "4":
			obtenerPilotos().forEach(System.out::println);
			break;
			
		case "5":
			obtenerTrabajadores().forEach(System.out::println);
			break;
			
		case "6":
			if(FormulaJSON.escribirJSON(obtenerEscuderias()))
			{
				System.out.println("Se ha escrito correctamente el fichero JSON");
			}
			else {
				System.err.println("Error escribiendo el archivo");
			}
			break;
			
		case "7":
			if (insertarTrabajadorEnEscuderia()) {
				System.out.println(" insertado correctamente");
				}
			else{
				System.err.println(" no se ha podido insertar.");
			}
			break;

		default:
			break;
		}
		
	}

	private static Set<Trabajador> obtenerTrabajadores() {

		Set<Trabajador> misTrabajadores = new HashSet<Trabajador>();
		
		String miURL = URL + "FormulaSpring/escuderias/dameTrabajadores";
		
		RestTemplate template = new RestTemplate();
		
		ResponseEntity<Trabajador[]> response = template.getForEntity(miURL, Trabajador[].class);
		
		Trabajador[] trabajadores = response.getBody();
		
		for(Trabajador c: trabajadores)
			misTrabajadores.add(c);
		
		return misTrabajadores;
	}
	
	private static boolean insertarTrabajadorEnEscuderia() {

		boolean exito = false;
		
		try {
			
			Trabajador t = UtilS.leerTrabajador();
			String idEscuderia = UtilS.leerTeclado("ID de la escuderia donde se va a insertar el trabajador: ");
			
			String miURL = URL + "FormulaSpring/escuderias/insertarTrabajadorEnEscuderia";
			
			RestTemplate template = new RestTemplate();
			
			ResponseEntity<Trabajador> response = template.getForEntity(miURL, Trabajador.class, t, idEscuderia);
			
			Trabajador trabajadorInsertado = response.getBody();
			
			System.out.println(trabajadorInsertado);
			
			exito = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return exito;
	}

	private static void cargarDatos() {
		
		String miURL = URL + "FormulaSpring/escuderias/cargarDatos";

		RestTemplate template = new RestTemplate();
		
		ResponseEntity<String> response = template.getForEntity(miURL, String.class);
		
		System.out.println(response.getBody());
	}

	private static Set<Escuderia> obtenerEscuderias() {

		Set<Escuderia> misEscuderias = new HashSet<Escuderia>();
		
		String miURL = URL + "FormulaSpring/escuderias/dametodas";
		
		RestTemplate template = new RestTemplate();
		
		ResponseEntity<Escuderia[]> response = template.getForEntity(miURL, Escuderia[].class);
		
		Escuderia[] escuderias = response.getBody();
		
		for(Escuderia c: escuderias)
			misEscuderias.add(c);
		
		return misEscuderias;
	}
	
	private static Set<Piloto> obtenerPilotos() {

		Set<Piloto> misPilotos = new HashSet<Piloto>();
		
		String miURL = URL + "FormulaSpring/pilotos/dametodos";
		
		RestTemplate template = new RestTemplate();
		
		ResponseEntity<Piloto[]> response = template.getForEntity(miURL, Piloto[].class);
		
		Piloto[] pilotos = response.getBody();
		
		for(Piloto c: pilotos)
			misPilotos.add(c);
		
		return misPilotos;
	}

}
