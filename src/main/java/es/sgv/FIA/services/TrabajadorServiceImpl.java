package es.sgv.FIA.services;

import java.util.Optional;

import es.sgv.FIA.model.Trabajador;

public class TrabajadorServiceImpl implements ITrabajadorService {

	@Override
	public boolean annadirTrabajadorEnEscuderia(Trabajador trabajador, String idEscuderia) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Trabajador> findAllTrabajadores() {
		// TODO Auto-generated method stub
		return null;
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
