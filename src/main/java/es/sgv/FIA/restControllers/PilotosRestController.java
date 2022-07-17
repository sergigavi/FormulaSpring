package es.sgv.FIA.restControllers;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.sgv.FIA.lecturaDatos.*;

import es.sgv.FIA.model.Mundial;
import es.sgv.FIA.model.Piloto;
import es.sgv.FIA.services.IPilotoService;

@RestController
@RequestMapping("/FormulaSpring/pilotos")
public class PilotosRestController {

	@Autowired private IPilotoService pilotoServicio;
	
	@GetMapping("/dametodos")
	public ResponseEntity<Iterable<Piloto>> obtenerTodosLosPilotos()
	{
		ResponseEntity<Iterable<Piloto>> res = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
		Iterable<Piloto> allPilotos = pilotoServicio.findAllPilotos();
		
		res = new ResponseEntity<Iterable<Piloto>>(allPilotos, HttpStatus.OK);
		
		return res;
	}
	
	@PostMapping("/insertarPorParametro")
	public ResponseEntity<String> insertarPilotoPorParametros(@RequestParam String id, @RequestParam String nombre, @RequestParam int dorsal, @RequestParam String fechaNac, @RequestParam String imgUrl)
	{
		ResponseEntity<String> res = new ResponseEntity<String>("Error insertando piloto nuevo", HttpStatus.INTERNAL_SERVER_ERROR);
		
		try {
			Piloto p = Piloto.builder()
					.id(id)
					.nombre(nombre)
					.dorsal(dorsal)
					.fechaNacimiento(LocalDate.parse(fechaNac))
					.urlImage(imgUrl)
					.build();
			
			pilotoServicio.annadirPiloto(p);
			
			res = new ResponseEntity<String>("Piloto insertado correctamente: " + p.toString(), HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return res;
	}
	
	@PostMapping("/insertar")
	public ResponseEntity<String> insertarPiloto(@RequestBody Piloto piloto)
	{
		ResponseEntity<String> res = new ResponseEntity<String>("Error insertando piloto nuevo", HttpStatus.INTERNAL_SERVER_ERROR);
		
		try {
			
			pilotoServicio.annadirPiloto(piloto);
			
			res = new ResponseEntity<String>("Piloto insertado correctamente: " + piloto.toString(), HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return res;
	}
	
	@PostMapping("/agregarMundialAPiloto")
	public ResponseEntity<String> agregarMundialAPiloto(@RequestParam String idPiloto, @RequestBody Mundial mundial)
	{
		ResponseEntity<String> res = new ResponseEntity<String>("Error insertando mundial en piloto", HttpStatus.INTERNAL_SERVER_ERROR);
		
		try {
			
			if(pilotoServicio.existsByIdPiloto(idPiloto))
			{
				Piloto p = pilotoServicio.findPilotoById(idPiloto).get();
				p.getMundiales().add(mundial);
				pilotoServicio.actualizarPiloto(p);
				res = new ResponseEntity<String>("Mundial "/* + mundial + " agregado correctamente en el piloto: \n" + p.toString()*/, HttpStatus.OK);
			}
			
		} catch (Exception e) {
			System.err.println("error pilotoRestController");
			e.printStackTrace();
		}
		
		return res;
	}
	
	@PutMapping("/agregarMundialAPilotoParametros")
	public ResponseEntity<String> agregarMundialAPilotoParametros(@RequestParam String idPiloto, @RequestParam String idMundial, @RequestParam int anno, @RequestParam String categoria)
	{
		Mundial mundial = Mundial.builder().id("").build();

		ResponseEntity<String> res = new ResponseEntity<String>("Error insertando mundial en piloto", HttpStatus.INTERNAL_SERVER_ERROR);
		
		try {
			
			mundial = Mundial.builder().id(idMundial).anno(anno).categoria(LecturaFormula.parseCategoria(categoria)).build();
			
			if(pilotoServicio.existsByIdPiloto(idPiloto))
			{
				Piloto p = pilotoServicio.findPilotoById(idPiloto).get();
				p.getMundiales().add(mundial);
				pilotoServicio.actualizarPiloto(p);
				res = new ResponseEntity<String>("Mundial " + mundial + " agregado correctamente en el piloto: \n" + p.toString(), HttpStatus.OK);
			}
			
		} catch (Exception e) {
			System.err.println("error pilotoRestController");
			e.printStackTrace();
		}
		
		return res;
	}
	
}
