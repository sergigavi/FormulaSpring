package es.sgv.FIA.services;

import java.util.Optional;

import es.sgv.FIA.model.Piloto;

public class PilotoServiceImpl implements IPilotoService {

	@Override
	public boolean annadirPiloto(Piloto piloto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean agregarPilotoProbadorEnEscuderia(Piloto piloto, String idEscuderia) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean annadirPilotoProbadorEnEscuderiaById(String idPiloto, String idEscuderia) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Piloto> findAllPilotos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Piloto> findPilotoById(String idPiloto) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public boolean existsByIdPiloto(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Piloto deletePilotoById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
