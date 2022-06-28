package es.sgv.FIA.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import es.sgv.FIA.model.Escuderia;

@Service
public class EscuderiaServiceImpl implements IEscuderiaService {

	@Override
	public boolean annadirEscuderia(Escuderia escuderia) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Escuderia> findAllEscuderias() {
		// TODO Auto-generated method stub
		return null;
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

}
