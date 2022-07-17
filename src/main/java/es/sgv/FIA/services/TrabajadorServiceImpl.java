package es.sgv.FIA.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.sgv.FIA.model.Escuderia;
import es.sgv.FIA.model.Trabajador;
import es.sgv.FIA.repository.EscuderiaRepository;
import es.sgv.FIA.repository.TrabajadorRepository;

@Service
public class TrabajadorServiceImpl implements ITrabajadorService {
	
	@Autowired
	private TrabajadorRepository trabajadorDAO;
	
	@Autowired
	private EscuderiaRepository escuderiaDAO;

	@Override
	public boolean annadirTrabajadorEnEscuderia(Trabajador trabajador, String idEscuderia) {

		boolean exito = false;
		
		if(escuderiaDAO.findById(idEscuderia).isPresent())
		{
			try {
				
				trabajador.setEscuderia(escuderiaDAO.findById(idEscuderia).get());
				
				Escuderia e = escuderiaDAO.findById(idEscuderia).get();
				e.getTrabajadores().add(trabajador);
				
				escuderiaDAO.save(e);
				
				exito = true;
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
				
		return exito;
	}

	@Override
	public Iterable<Trabajador> findAllTrabajadores() {
		return trabajadorDAO.findAll();
	}

	@Override
	public Optional<Trabajador> findTrabajadorById(String idTrabajador) {
		return trabajadorDAO.findById(idTrabajador);
	}

	@Override
	public boolean existsByIdTrabajador(String id) {
		return trabajadorDAO.existsById(id);
	}

	@Override
	public Trabajador deleteTrabajadorById(String id) {
		
		Trabajador t = Trabajador.builder().id(id).build();
		
		if(trabajadorDAO.existsById(id))
		{
			t = trabajadorDAO.findById(id).get();
			trabajadorDAO.deleteById(id);
		}
		
		return t;
	}

}
