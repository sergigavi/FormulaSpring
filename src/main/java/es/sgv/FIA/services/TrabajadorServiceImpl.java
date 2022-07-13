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
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public boolean existsByIdTrabajador(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Trabajador deleteTrabajadorById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
