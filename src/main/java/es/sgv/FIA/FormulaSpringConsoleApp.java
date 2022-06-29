package es.sgv.FIA;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import es.sgv.FIA.model.Categoria;
import es.sgv.FIA.model.Escuderia;
import es.sgv.FIA.model.Mundial;
import es.sgv.FIA.model.Piloto;
import es.sgv.FIA.model.Trabajador;
import es.sgv.FIA.services.IEscuderiaService;
import es.sgv.FIA.services.IPilotoService;
import es.sgv.FIA.services.ITrabajadorService;
import es.sgv.FIAJSON.FormulaJSON;

@Component //esto no funciona no se por que
public class FormulaSpringConsoleApp implements CommandLineRunner{
	
	@Autowired private IPilotoService pilotoServicio;
	@Autowired private ITrabajadorService trabajadorServicio;
	@Autowired private IEscuderiaService escuderiaServicio;

	public void run(String... args) throws Exception
	{
		
		cargarDatos();
		
		Set<Escuderia> escuderias = new HashSet<Escuderia>();
		
		escuderiaServicio.findAllEscuderias().forEach(e -> escuderias.add(e));
		
		guardarDatosEnJSON(escuderias);
		
	}
	
	private void guardarDatosEnJSON(Set<Escuderia> escuderias) {
		if (FormulaJSON.escribirJSON(escuderias))
		{
			System.out.println("Se ha creado el archivo JSON con las escuderias correctamente");
		}
		else {
			System.err.println("Error creando el json");
		}
	}

	private void cargarDatos() {
		
		// añado los pilotos
		
		//creo una lista y posteriormente los añado todos a la base de datos

		Set<Piloto> pilotos = new HashSet<>();
		
		pilotos.add(Piloto.builder()
				.id("FA14")
				.nombre("Fernando Alonso")
				.dorsal(14)
				.fechaNacimiento(LocalDate.of(1981, 7, 29))
				.mundial(Mundial.builder()
						.id("FA14_2005")
						.anno(2005)
						.categoria(Categoria.FORMULA1)
						.build())
				.mundial(Mundial.builder()
						.id("FA14_2006")
						.anno(2006)
						.categoria(Categoria.FORMULA1)
						.build())
				.urlImage("https://phantom-marca.unidadeditorial.es/5d3131b97c57cbd81a0f3c2612f17124/resize/1320/f/jpg/assets/multimedia/imagenes/2022/04/08/16494033688026.jpg")
				.build()
				);
		
		pilotos.add(Piloto.builder()
				.id("LH44")
				.nombre("Lewis Hamilton")
				.dorsal(44)
				.fechaNacimiento(LocalDate.of(1985, 1, 7))
				.mundial(Mundial.builder()
						.id("LH44_2008")
						.anno(2008)
						.categoria(Categoria.FORMULA1)
						.build())
				.mundial(Mundial.builder()
						.id("LH44_2014")
						.anno(2014)
						.categoria(Categoria.FORMULA1)
						.build())
				.mundial(Mundial.builder()
						.id("LH44_2015")
						.anno(2015)
						.categoria(Categoria.FORMULA1)
						.build())
				.mundial(Mundial.builder()
						.id("LH44_2017")
						.anno(2017)
						.categoria(Categoria.FORMULA1)
						.build())
				.mundial(Mundial.builder()
						.id("LH44_2018")
						.anno(2018)
						.categoria(Categoria.FORMULA1)
						.build())
				.mundial(Mundial.builder()
						.id("LH44_2019")
						.anno(2019)
						.categoria(Categoria.FORMULA1)
						.build())
				.mundial(Mundial.builder()
						.id("LH44_2020")
						.anno(2020)
						.categoria(Categoria.FORMULA1)
						.build())
				.urlImage("https://citas.in/media/authors/lewis-hamilton.jpeg")
				.build()
				);
		
		pilotos.add(Piloto.builder()
				.id("CS55")
				.nombre("Carlos Sainz")
				.dorsal(55)
				.fechaNacimiento(LocalDate.of(1994,9 , 1))
				.urlImage("https://upload.wikimedia.org/wikipedia/commons/thumb/a/aa/Formel12021-SchlossGabelhofen%2815%29.jpg/1200px-Formel12021-SchlossGabelhofen%2815%29.jpg")
				.build()
				);
		
		pilotos.add(Piloto.builder()
				.id("CL16")
				.nombre("Charles Leclerc")
				.dorsal(16)
				.fechaNacimiento(LocalDate.of(1997, 10 , 16))
				.urlImage("https://upload.wikimedia.org/wikipedia/commons/thumb/0/08/Charles-Leclerc.jpg/640px-Charles-Leclerc.jpg")
				.build()
				);
		
		pilotos.add(Piloto.builder()
				.id("MS47")
				.nombre("Mick Schumacher")
				.dorsal(47)
				.fechaNacimiento(LocalDate.of(1999, 3 , 22))
				.urlImage("https://static.motor.es/f1/fichas/contenido/mick-schumacher/mick-schumacher2021_1617622323.jpg")
				.build()
				);
		
		pilotos.add(Piloto.builder()
				.id("AG99")
				.nombre("Antonio Giovinazzi")
				.dorsal(99)
				.fechaNacimiento(LocalDate.of(1993, 12 , 14))
				.urlImage("https://soymotor.com/sites/default/files/styles/small/public/imagenes/piloto/antonio-giovinazzi-2021-soymotor.png")
				.build()
				);
		
		/*
		pilotos.add(Piloto.builder()
				.id("")
				.nombre("")
				.dorsal()
				.fechaNacimiento(LocalDate.of(, , ))
				
				.mundial(Mundial.builder()
						.id("ID_year")
						.anno()
						.categoria(Categoria.FORMULA1)
						.build())
				.urlImage("")
				.build()
				);
		*/
		
		
		pilotoServicio.addAllPilotos(pilotos);
				
		//pilotoServicio.findAllPilotos().forEach(System.out::println);
		
		// creo las escuderias con sus trabajadores dentro y posteriormente le añado a cada una sus pilotos
		
		Set<Escuderia> escuderias = new HashSet<>();
		
		escuderias.add(Escuderia.builder()
				.id("SF_F1")
				.nombre("Scuderia Ferrari")
				.categoria(Categoria.FORMULA1)
				.pilotoOficial(pilotos.stream().filter(p -> p.getNombre().equals("Charles Leclerc")).findFirst().get())
				.pilotoSecundario(pilotos.stream().filter(p -> p.getNombre().equals("Carlos Sainz")).findFirst().get())
				.pilotoProbador(pilotos.stream().filter(p -> p.getNombre().equals("Mick Schumacher")).findFirst().get())
				.pilotoProbador(pilotos.stream().filter(p -> p.getId().equals("AG99")).findFirst().get())
				.trabajador(Trabajador.builder()
						.id("t1_SF_F1")
						.nombre("Juanito Derrapes")
						.cargo("Mecanico ruedas")
						.fechaNacimiento(LocalDate.of(1985, 12, 3))
						.build())
				.build());
		
		//con esto le añado a mis trabajadores la escuderia en la que están (seguro que hay una forma mejor de hacerlo con el this o algo)
		escuderias.stream().filter(s -> s.getId().equals("SF_F1")).findFirst().get()
		.getTrabajadores().stream().filter(t -> t.getId().equals("t1_SF_F1")).findFirst().get().setEscuderia(
				escuderias.stream().filter(s -> s.getId().equals("SF_F1")).findFirst().get());
		
		escuderiaServicio.saveAllEscuderias(escuderias);
		
		escuderiaServicio.findAllEscuderias().forEach(System.out::println);
		
		
		//TODO: Continuar metiendo datos, creando pilotos y escuderias, ademas de incluir más trabajadores
		
		
		
	}
}
