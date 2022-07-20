package es.sgv.FIA.restClients;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import es.sgv.FIA.lecturaDatos.LecturaFormula;
import es.sgv.FIA.model.Escuderia;
import es.sgv.FIA.model.Mundial;
import es.sgv.FIA.model.Piloto;
import es.sgv.FIA.model.Trabajador;
import es.sgv.FIAJSON.FormulaJSON;
import es.sgv.utilS.UtilS;

/*
 * Aplicación de consola que permite realizar las acciones de los microservicios mediante un menu
 */
public class RestClientApp {
	
	/*
	 * Variables estáticas para el correcto funcionamiento de la aplicación y las correctas llamadas a los controladores rest
	 */
	public static final String URL = "http://127.0.0.1:8080/";
	public static final int numOpciones = 9;

	public static void main(String[] args) {
		
		mostrarMenu();
	
	}
	
	/*
	 * Funcion encargada de mostrar el menú y elegir las opciones deseadas
	 */
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
					8. Añadir piloto
					9. Agregar mundial a piloto
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

	/*
	 * Funcion encargada de elegir la opción y dependiendo de la variable llama a un metodo/s u otro
	 */
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
			
		case "8":
			if (annadirPiloto()) {
				System.out.println("Piloto insertado correctamente");
			}
			else {
				System.err.println("Error añadiendo piloto");
			}
			break;
			
		case "9":
			if(agregarMundialAPiloto())
				System.out.println("Mundial insertado en piloto correctamente");
			else
				System.err.println("Error insertando mundial en piloto");
			break;

		default:
			break;
		}
		
	}

	/*
	 * Acude al microservicio de añadir un mundial al piloto que deseemos
	 */
	private static boolean agregarMundialAPiloto() {
		
		
		boolean exito = false;
		
		try {
			String idPiloto = UtilS.leerTeclado("ID PILOTO GANADOR: ");
			
			if(!(obtenerPilotos().stream().anyMatch(e -> e.getId().equals(idPiloto))))
			{
				System.err.println("ID de piloto no valido \t Regresando al menú...");
				throw new IllegalArgumentException();
			}
			
			Mundial mundial = LecturaFormula.leerMundial();
											
			String miURL = URL + "FormulaSpring/pilotos/agregarMundialAPiloto?idPiloto={idPiloto}";
			
			RestTemplate template = new RestTemplate();
			
			Map<String,Object> parametros = new HashMap<String,Object>();
			
			parametros.put("idPiloto", idPiloto);
			
			ResponseEntity<Piloto> response = template.postForEntity(miURL, mundial, Piloto.class, parametros);
			
			//Piloto pilotoInsertado = response.getBody();
			
			//System.out.println(pilotoInsertado);
			
			exito = true;
			
		} catch (Exception e) {
			System.err.println("error restClientApp");
			e.printStackTrace();
		}
		
		return exito;
	}

	/*
	 * Añade un piloto en la base de datos
	 */
	private static boolean annadirPiloto() { //TODO: Manejo de excepciones
		
		boolean exito = false;
		
		try {
			String miURL = URL + "FormulaSpring/pilotos/insertar";
			
			RestTemplate template = new RestTemplate();
			
			Piloto piloto = LecturaFormula.LeerPiloto();
			
			ResponseEntity<Piloto> res = template.postForEntity(miURL, piloto, Piloto.class);
			
			System.out.println(res.getBody());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return exito;		
	}

	/*
	 * Acude al microservicio que devuelve todos los trabajadores de la base de datos y los meustra por pantalla
	 */
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
	
	/*
	 * Hace una llamada al microservicio e inserta un trabajador dentro de una de las escuderías disponibles
	 */
	private static boolean insertarTrabajadorEnEscuderia() {

		boolean exito = false;
		
		try {
			
			Trabajador t = LecturaFormula.leerTrabajador();
			
			System.err.println("LISTA DE ESCUDERIAS DISPONIBLES: ");
			obtenerEscuderias().stream()
			.map(e -> "ID: " + e.getId() + " / NOMBRE: " + e.getNombre())
			.forEach(System.out::println);
								
			String idEscuderia = UtilS.leerTeclado("ID de la escuderia donde se va a insertar el trabajador: ");
			
			if(!(obtenerEscuderias().stream().anyMatch(e -> e.getId().equals(idEscuderia))))
			{
				System.err.println("ID de escuderia no valido \t Regresando al menú...");
				throw new IllegalArgumentException();
			}
			
			String miURL = URL + "FormulaSpring/escuderias/insertarTrabajadorEnEscuderia?idEscuderia={idEscuderia}";
			
			RestTemplate template = new RestTemplate();
			
			Map<String,Object> parametros = new HashMap<String,Object>();
			
			parametros.put("idEscuderia", idEscuderia);
			
			ResponseEntity<Trabajador> response = template.postForEntity(miURL, t, Trabajador.class, parametros);
			
			Trabajador trabajadorInsertado = response.getBody();
			
			System.out.println(trabajadorInsertado);
			
			exito = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return exito;
	}

	/*
	 * Llama al microservicio encargado de cargar los datos iniciales en mi base de datos H2 (posteriormente será diferente ya que se quiere convertir a ddbb mysql)
	 */
	private static void cargarDatos() {
		
		String miURL = URL + "FormulaSpring/escuderias/cargarDatos";

		RestTemplate template = new RestTemplate();
		
		ResponseEntity<String> response = template.getForEntity(miURL, String.class);
		
		System.out.println(response.getBody());
	}

	/*
	 * Llama al microservicio para obtener todas las escuderias y el menú las muestra por pantalla
	 */
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
	
	/*
	 * LLama al microservicio que obtiene todos los pilotos de la base de datos y el menú se encarga de mostrarlos por pantalla
	 */
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
