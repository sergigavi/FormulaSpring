package es.sgv.FIA.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.sgv.FIA.model.Piloto;
import es.sgv.FIA.repository.PilotoRepository;

@Service
public class PilotoServiceImpl implements IPilotoService {
	
	@Autowired private PilotoRepository pilotoDAO;

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

	@Override
	public boolean addAllPilotos(Iterable<Piloto> pilotos) {
		
		boolean exito = false;
		
		try {
			
			pilotoDAO.saveAll(pilotos);
			exito = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return exito;
	}

}
