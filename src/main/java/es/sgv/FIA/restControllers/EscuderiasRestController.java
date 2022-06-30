package es.sgv.FIA.restControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.sgv.FIA.model.Escuderia;
import es.sgv.FIA.services.IEscuderiaService;

@RestController
@RequestMapping("/FormulaSpring/escuderias")
public class EscuderiasRestController {
	
@Autowired private IEscuderiaService escuderiaServicio;
	
	@GetMapping("/dametodas")
	public ResponseEntity<Iterable<Escuderia>> obtenerTodasLasEscuderias()
	{
		ResponseEntity<Iterable<Escuderia>> res = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
		Iterable<Escuderia> allEscuderias = escuderiaServicio.findAllEscuderias();
		
		res = new ResponseEntity<Iterable<Escuderia>>(allEscuderias, HttpStatus.OK);
		
		return res;
	}

}
