package es.sgv.FIA.restControllers;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.sgv.FIA.model.Categoria;
import es.sgv.FIA.model.Escuderia;
import es.sgv.FIA.model.Mundial;
import es.sgv.FIA.model.Piloto;
import es.sgv.FIA.model.Trabajador;
import es.sgv.FIA.services.IEscuderiaService;
import es.sgv.FIA.services.IPilotoService;
import es.sgv.FIA.services.ITrabajadorService;

@CrossOrigin	//	Esto permite que se acceda a la API saltandose el CORS (permite el fetch en javascript por ejemplo)	//https://spring.io/guides/gs/rest-service-cors/
@RestController
@RequestMapping("/FormulaSpring/escuderias")
public class EscuderiasRestController {

	@Autowired
	private IEscuderiaService escuderiaServicio;

	@Autowired
	private IPilotoService pilotoServicio;

	@Autowired
	private ITrabajadorService trabajadorServicio;

	@GetMapping("/dametodas")
	public ResponseEntity<Iterable<Escuderia>> obtenerTodasLasEscuderias() {

		ResponseEntity<Iterable<Escuderia>> res = new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		Iterable<Escuderia> allEscuderias = escuderiaServicio.findAllEscuderias();

		res = new ResponseEntity<Iterable<Escuderia>>(allEscuderias, HttpStatus.OK);

		return res;
	}
	
	//TODO: fixear esto
	@GetMapping("/dameporId/{id}")
	public ResponseEntity<Optional<Escuderia>> obtenerEscuderiaById(@PathParam(value = "id") String id) {

		ResponseEntity<Optional<Escuderia>> res = new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		Optional<Escuderia> escuderia = escuderiaServicio.findEscuderiaById(id);

		res = new ResponseEntity<Optional<Escuderia>>(escuderia, HttpStatus.OK);

		return res;
	}

	@GetMapping("/dameTrabajadores")
	public ResponseEntity<Iterable<Trabajador>> obtenerTodosLosTrabajadores() {

		ResponseEntity<Iterable<Trabajador>> res = new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		Iterable<Trabajador> allTrabajadores = trabajadorServicio.findAllTrabajadores();

		res = new ResponseEntity<Iterable<Trabajador>>(allTrabajadores, HttpStatus.OK);

		return res;
	}
	
	//TODO
	@PostMapping("/insertarTrabajadorEnEscuderia")
	public ResponseEntity<Trabajador> insertarTrabajadorEnEscuderia(@RequestBody Trabajador t, @RequestParam String idEscuderia) {

		ResponseEntity<Trabajador> res = new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		trabajadorServicio.annadirTrabajadorEnEscuderia(t, idEscuderia);
		
		res = new ResponseEntity<Trabajador>(t, HttpStatus.OK);

		return res;
	}

	@GetMapping("/cargarDatos")
	public ResponseEntity<String> cargar_Datos() {
		ResponseEntity<String> res = new ResponseEntity<>("Error insertando los datos", HttpStatus.BAD_REQUEST);

		try {

			cargarDatos();

			res = new ResponseEntity<String>("Datos insertados correctamente", HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return res;
	}

	private void cargarDatos() {

		// añado los pilotos

		// creo una lista y posteriormente los añado todos a la base de datos

		Set<Piloto> pilotos = new HashSet<>();

		pilotos.add(Piloto.builder().id("FA14").nombre("Fernando Alonso").dorsal(14)
				.fechaNacimiento(LocalDate.of(1981, 7, 29))
				.mundial(Mundial.builder().id("FA14_2005").anno(2005).categoria(Categoria.FORMULA1).build())
				.mundial(Mundial.builder().id("FA14_2006").anno(2006).categoria(Categoria.FORMULA1).build())
				.urlImage(
						"https://phantom-marca.unidadeditorial.es/5d3131b97c57cbd81a0f3c2612f17124/resize/1320/f/jpg/assets/multimedia/imagenes/2022/04/08/16494033688026.jpg")
				.build());

		pilotos.add(Piloto.builder().id("LH44").nombre("Lewis Hamilton").dorsal(44)
				.fechaNacimiento(LocalDate.of(1985, 1, 7))
				.mundial(Mundial.builder().id("LH44_2008").anno(2008).categoria(Categoria.FORMULA1).build())
				.mundial(Mundial.builder().id("LH44_2014").anno(2014).categoria(Categoria.FORMULA1).build())
				.mundial(Mundial.builder().id("LH44_2015").anno(2015).categoria(Categoria.FORMULA1).build())
				.mundial(Mundial.builder().id("LH44_2017").anno(2017).categoria(Categoria.FORMULA1).build())
				.mundial(Mundial.builder().id("LH44_2018").anno(2018).categoria(Categoria.FORMULA1).build())
				.mundial(Mundial.builder().id("LH44_2019").anno(2019).categoria(Categoria.FORMULA1).build())
				.mundial(Mundial.builder().id("LH44_2020").anno(2020).categoria(Categoria.FORMULA1).build())
				.urlImage("https://citas.in/media/authors/lewis-hamilton.jpeg").build());

		pilotos.add(Piloto.builder().id("CS55").nombre("Carlos Sainz").dorsal(55)
				.fechaNacimiento(LocalDate.of(1994, 9, 1))
				.urlImage(
						"https://upload.wikimedia.org/wikipedia/commons/thumb/a/aa/Formel12021-SchlossGabelhofen%2815%29.jpg/1200px-Formel12021-SchlossGabelhofen%2815%29.jpg")
				.build());

		pilotos.add(Piloto.builder().id("CL16").nombre("Charles Leclerc").dorsal(16)
				.fechaNacimiento(LocalDate.of(1997, 10, 16))
				.urlImage(
						"https://upload.wikimedia.org/wikipedia/commons/thumb/0/08/Charles-Leclerc.jpg/640px-Charles-Leclerc.jpg")
				.build());

		pilotos.add(Piloto.builder().id("MS47").nombre("Mick Schumacher").dorsal(47)
				.fechaNacimiento(LocalDate.of(1999, 3, 22))
				.urlImage(
						"https://static.motor.es/f1/fichas/contenido/mick-schumacher/mick-schumacher2021_1617622323.jpg")
				.build());

		pilotos.add(Piloto.builder().id("AG99").nombre("Antonio Giovinazzi").dorsal(99)
				.fechaNacimiento(LocalDate.of(1993, 12, 14))
				.urlImage(
						"https://soymotor.com/sites/default/files/styles/small/public/imagenes/piloto/antonio-giovinazzi-2021-soymotor.png")
				.build());

		pilotos.add(Piloto.builder().id("SV05").nombre("Sebastian Vettel").dorsal(5)
				.fechaNacimiento(LocalDate.of(1987, 7, 3))

				.mundial(Mundial.builder().id("SV05_2010").anno(2010).categoria(Categoria.FORMULA1).build())
				.mundial(Mundial.builder().id("SV05_2011").anno(2011).categoria(Categoria.FORMULA1).build())
				.mundial(Mundial.builder().id("SV05_2012").anno(2012).categoria(Categoria.FORMULA1).build())
				.mundial(Mundial.builder().id("SV05_2013").anno(2013).categoria(Categoria.FORMULA1).build())
				.urlImage("https://cdn-1.motorsport.com/images/mgl/2jXZrAb6/s8/sebastian-vettel-aston-martin-1.jpg")
				.build());

		pilotos.add(Piloto.builder().id("EO33").nombre("Esteban Ocon").dorsal(33)
				.fechaNacimiento(LocalDate.of(1996, 10, 17))
				.urlImage("https://cdn-2.motorsport.com/images/mgl/6zQ7ev7Y/s8/esteban-ocon-alpine-1.jpg").build());

		pilotos.add(Piloto.builder().id("MV01").nombre("Max Verstappen").dorsal(1)
				.fechaNacimiento(LocalDate.of(1997, 9, 30))
				.mundial(Mundial.builder().id("MV01_2021").anno(2021).categoria(Categoria.FORMULA1).build())
				.urlImage(
						"https://img.redbull.com/images/c_limit,w_1500,h_1000,f_auto,q_auto/redbullcom/2022/5/5/esxtfazwc5k0xntwv20i/max-verstappen-profile-pic")
				.build());

		pilotos.add(Piloto.builder().id("SP11").nombre("Sergio Perez").dorsal(11)
				.fechaNacimiento(LocalDate.of(1990, 1, 26))
				.urlImage(
						"https://img.redbull.com/images/c_limit,w_1500,h_1000,f_auto,q_auto/redbullcom/2022/5/10/hop9yksneuaqtv4coxri/sergio-perez-portrait-imola-gp-f1-2022")
				.build());

		pilotos.add(Piloto.builder().id("AA23").nombre("Alex Albon").dorsal(23)
				.fechaNacimiento(LocalDate.of(1996, 3, 23))
				.urlImage(
						"https://www.formula1.com/content/fom-website/en/drivers/alexander-albon/_jcr_content/image.img.320.medium.jpg")
				.build());

		pilotos.add(Piloto.builder().id("GR63").nombre("George Russell").dorsal(63)
				.fechaNacimiento(LocalDate.of(1998, 2, 15))
				.urlImage(
						"https://static.motor.es/fotos-noticias/2021/07/george-russell-piloto-mercedes-f1-2022-202179569-1626110071_4.jpg")
				.build());
		
		pilotos.add(Piloto.builder().id("VB77").nombre("Valtteri Bottas").dorsal(77)
				 .fechaNacimiento(LocalDate.of(1989, 8 , 28)) .urlImage("https://phantom-marca.unidadeditorial.es/e182f3bb06b02e9767447638bb1d65ed/resize/1320/f/jpg/assets/multimedia/imagenes/2022/03/02/16462181912388.jpg")
				 .build() );

		/*
		 * pilotos.add(Piloto.builder() .id("") .nombre("") .dorsal()
		 * .fechaNacimiento(LocalDate.of(, , )) .mundial(Mundial.builder()
		 * .id("ID_year") .anno() .categoria(Categoria.FORMULA1) .build()) .urlImage("")
		 * .build() );
		 */

		pilotoServicio.addAllPilotos(pilotos);

		// creo las escuderias con sus trabajadores dentro y posteriormente le añado a
		// cada una sus pilotos

		Set<Escuderia> escuderias = new HashSet<>();

		escuderias.add(Escuderia.builder().id("SF_F1").nombre("Scuderia Ferrari").categoria(Categoria.FORMULA1)
				.pilotoOficial(pilotos.stream().filter(p -> p.getNombre().equals("Charles Leclerc")).findFirst().get())
				.pilotoSecundario(pilotos.stream().filter(p -> p.getNombre().equals("Carlos Sainz")).findFirst().get())
				.pilotoProbador(pilotos.stream().filter(p -> p.getNombre().equals("Mick Schumacher")).findFirst().get())
				.pilotoProbador(pilotos.stream().filter(p -> p.getId().equals("AG99")).findFirst().get())
				.trabajador(Trabajador.builder().id("t1_SF_F1").nombre("Juanito Derrapes").cargo("Mecanico ruedas")
						.fechaNacimiento(LocalDate.of(1985, 12, 3)).build())
				.build());

		escuderias
				.add(Escuderia.builder().id("RB_F1").nombre("Oracle Red Bull Racing").categoria(Categoria.FORMULA1)
						.pilotoOficial(pilotos.stream().filter(p -> p.getId().equals("MV01")).findFirst().get())
						.pilotoSecundario(pilotos.stream().filter(p -> p.getId().equals("SP11")).findFirst().get())
						.pilotoProbador(pilotos.stream().filter(p -> p.getId().equals("AA23")).findFirst().get())
						.trabajador(Trabajador.builder().id("t1_RB_F1").nombre("Manolito Trompos")
								.cargo("Ingeniero aerodinamico").fechaNacimiento(LocalDate.of(1983, 10, 3)).build())
						.build());

		escuderias.add(Escuderia.builder().id("MP_F1").nombre("Mercedes AMG Petronas").categoria(Categoria.FORMULA1)
				.pilotoOficial(pilotos.stream().filter(p -> p.getId().equals("LH44")).findFirst().get())
				.pilotoSecundario(pilotos.stream().filter(p -> p.getId().equals("GR63")).findFirst().get())
				.trabajador(Trabajador.builder().id("t1_MP_F1").nombre("Toto Wolff").cargo("Director ejecutivo")
						.fechaNacimiento(LocalDate.of(1972, 1, 12)).build())
				.build());

		annadirSuEscuderiaACadaTrabajador(escuderias);

		escuderiaServicio.saveAllEscuderias(escuderias);
		
		escuderiaServicio.findAllEscuderias().forEach(System.out::println);

		// TODO: Continuar metiendo datos, creando pilotos y escuderias, ademas de
		// incluir más trabajadores 

	}

	private void annadirSuEscuderiaACadaTrabajador(Set<Escuderia> escuderias) {

		// con esto le añado los trabajadores de cada escuderia la escuderia en la que
		// están, ya que es bidireccional (seguro que hay una forma mejor de hacerlo con
		// el this o algo)
		// las escuderias guardan a los trabajadores y los trabajadores guardan su
		// escuderia

		escuderias.stream().filter(s -> s.getId().equals("SF_F1")).findFirst().get().getTrabajadores().stream().forEach(
				t -> t.setEscuderia(escuderias.stream().filter(s -> s.getId().equals("SF_F1")).findFirst().get()));

		escuderias.stream().filter(s -> s.getId().equals("RB_F1")).findFirst().get().getTrabajadores().stream().forEach(
				t -> t.setEscuderia(escuderias.stream().filter(s -> s.getId().equals("RB_F1")).findFirst().get()));

		escuderias.stream().filter(s -> s.getId().equals("MP_F1")).findFirst().get().getTrabajadores().stream().forEach(
				t -> t.setEscuderia(escuderias.stream().filter(s -> s.getId().equals("MP_F1")).findFirst().get()));

	}

}
