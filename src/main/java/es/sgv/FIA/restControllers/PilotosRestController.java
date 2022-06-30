package es.sgv.FIA.restControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
