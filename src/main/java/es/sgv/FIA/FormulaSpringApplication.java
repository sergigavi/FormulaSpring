package es.sgv.FIA;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import es.sgv.FIA.model.Categoria;
import es.sgv.FIA.model.Mundial;
import es.sgv.FIA.model.Piloto;
import es.sgv.FIA.services.IEscuderiaService;
import es.sgv.FIA.services.IPilotoService;
import es.sgv.FIA.services.ITrabajadorService;

@SpringBootApplication
public class FormulaSpringApplication {
	
	@Autowired private IPilotoService pilotoServicio;
	@Autowired private ITrabajadorService trabajadorServicio;
	@Autowired private IEscuderiaService escuderiaServicio;

	public static void main(String[] args) {
		SpringApplication.run(FormulaSpringApplication.class, args);
		
		identificarse();
		//cargarDatos();
	}

	private static void cargarDatos() {

		Set<Piloto> pilotos = new HashSet<>();
		
		pilotos.add(Piloto.builder()
				.id("FA14")
				.nombre("Fernando Alonso")
				.dorsal(14)
				.fechaNacimiento(LocalDate.of(1981, 7, 29))
				.mundial(Mundial.builder()
						.anno(2005)
						.categoria(Categoria.FORMULA1)
						.build())
				.mundial(Mundial.builder()
						.anno(2006)
						.categoria(Categoria.FORMULA1)
						.build())
				.build()
				);
		
		
		
	}

	private static void identificarse() {
		System.out.println("estoy en la app 1");
		
	}

}
