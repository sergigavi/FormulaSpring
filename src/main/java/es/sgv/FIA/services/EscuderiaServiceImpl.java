package es.sgv.FIA.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.sgv.FIA.model.Escuderia;
import es.sgv.FIA.repository.EscuderiaRepository;

@Service
public class EscuderiaServiceImpl implements IEscuderiaService {
	
	@Autowired private EscuderiaRepository escuderiaDAO;

	@Override
	public boolean annadirEscuderia(Escuderia escuderia) {
		
		boolean exito = false;
		
		try {
			escuderiaDAO.save(escuderia);
			exito = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return exito;
	}

	@Override
	public Iterable<Escuderia> findAllEscuderias() {
		return escuderiaDAO.findAll();
	}

	@Override
	public Optional<Escuderia> findEscuderiaById(String idEscuderia) {
		return escuderiaDAO.findById(idEscuderia);
	}

	@Override
	public boolean existsByIdEscuderia(String id) {
		return escuderiaDAO.existsById(id);
	}

	@Override
	public Escuderia deleteEscuderiaById(String id) {
		
		Escuderia e = Escuderia.builder().id(id).build();
		
		if(escuderiaDAO.existsById(id))
		{
			e = escuderiaDAO.findById(id).get();
			escuderiaDAO.deleteById(id);
		}
		
		return e;
	}

	@Override
	public boolean saveAllEscuderias(Iterable<Escuderia> escuderias) {
		
		boolean exito = false;
		
		if (escuderiaDAO.saveAll(escuderias) != null)
		{
			exito = true;
		}
		
		return exito;
	}

}
