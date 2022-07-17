package es.sgv.FIA.services;

import java.util.Optional;

import es.sgv.FIA.model.Piloto;

public interface IPilotoService {
	
	public boolean addAllPilotos(Iterable<Piloto> pilotos);
	
	public boolean annadirPiloto(Piloto piloto);
	
	public boolean agregarPilotoProbadorEnEscuderia(Piloto piloto, String idEscuderia);

	public boolean annadirPilotoProbadorEnEscuderiaById(String idPiloto, String idEscuderia);

	public Iterable<Piloto> findAllPilotos();
	
	public Optional<Piloto> findPilotoById(String idPiloto);
	
	public boolean existsByIdPiloto(String id);
	
	public Piloto deletePilotoById(String id);

	boolean actualizarPiloto(Piloto piloto);
	
}
