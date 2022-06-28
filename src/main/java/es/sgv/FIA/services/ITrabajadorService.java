package es.sgv.FIA.services;

import java.util.Optional;

import es.sgv.FIA.model.Trabajador;

public interface ITrabajadorService {

	public boolean annadirTrabajadorEnEscuderia(Trabajador trabajador, String idEscuderia);

	public Iterable<Trabajador> findAllTrabajadores();
	
	public Optional<Trabajador> findTrabajadorById(String idTrabajador);
	
	public boolean existsByIdTrabajador(String id);
	
	public Trabajador deleteTrabajadorById(String id);
	
}
