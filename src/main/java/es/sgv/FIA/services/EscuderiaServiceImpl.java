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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Escuderia> findAllEscuderias() {
		return escuderiaDAO.findAll();
	}

	@Override
	public Optional<Escuderia> findEscuderiaById(String idEscuderia) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public boolean existsByIdEscuderia(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Escuderia deleteEscuderiaById(String id) {
		// TODO Auto-generated method stub
		return null;
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
