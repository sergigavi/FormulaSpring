package es.sgv.FIA.services;

import java.util.Optional;

import es.sgv.FIA.model.Escuderia;

public interface IEscuderiaService {

	public boolean annadirEscuderia (Escuderia escuderia);

	public Iterable<Escuderia> findAllEscuderias();
	
	public Optional<Escuderia> findEscuderiaById(String idEscuderia);
	
	public boolean existsByIdEscuderia(String id);
	
	public Escuderia deleteEscuderiaById(String id);
	
}

