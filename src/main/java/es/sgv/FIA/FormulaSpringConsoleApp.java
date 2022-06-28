package es.sgv.FIA;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import es.sgv.FIA.model.Categoria;
import es.sgv.FIA.model.Mundial;
import es.sgv.FIA.model.Piloto;
import es.sgv.FIA.services.IEscuderiaService;
import es.sgv.FIA.services.IPilotoService;
import es.sgv.FIA.services.ITrabajadorService;

@Component //esto no funciona no se por que
public class FormulaSpringConsoleApp implements CommandLineRunner{
	
	@Autowired private IPilotoService pilotoServicio;
	@Autowired private ITrabajadorService trabajadorServicio;
	@Autowired private IEscuderiaService escuderiaServicio;

	public void run(String... args) throws Exception
	{
		System.out.println("estoy en la app 2");
		
		cargarDatos();
		
	}
	
	private void cargarDatos() {
		

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
				.build()
				);
		
		pilotos.add(Piloto.builder()
				.id("LH44")
				.nombre("Lewis Hamilton")
				.dorsal(44)
				.fechaNacimiento(LocalDate.of(1985, 1, 7))
				//TODO
				//dhkjshdkjdshkjhsdjkhkf
				.mundial(Mundial.builder()
						.id("LH44_2008")
						.anno(2008)
						.categoria(Categoria.FORMULA1)
						.build())
				.mundial(Mundial.builder()
						.anno(2014)
						.categoria(Categoria.FORMULA1)
						.build())
				.mundial(Mundial.builder()
						.anno(2015)
						.categoria(Categoria.FORMULA1)
						.build())
				.mundial(Mundial.builder()
						.anno(2017)
						.categoria(Categoria.FORMULA1)
						.build())
				.mundial(Mundial.builder()
						.anno(2018)
						.categoria(Categoria.FORMULA1)
						.build())
				.mundial(Mundial.builder()
						.anno(2019)
						.categoria(Categoria.FORMULA1)
						.build())
				.mundial(Mundial.builder()
						.anno(2020)
						.categoria(Categoria.FORMULA1)
						.build())
				.build()
				);
		
		pilotos.forEach(System.out::println);
		
		//pilotoServicio.addAllPilotos(pilotos);
		
		
		
		
		
	}
}
