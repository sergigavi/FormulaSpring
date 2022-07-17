package es.sgv.FIA.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.sgv.FIA.model.Escuderia;
import es.sgv.FIA.model.Piloto;
import es.sgv.FIA.repository.EscuderiaRepository;
import es.sgv.FIA.repository.PilotoRepository;

@Service
public class PilotoServiceImpl implements IPilotoService {
	
	@Autowired private PilotoRepository pilotoDAO;
	@Autowired private EscuderiaRepository escuderiaDAO;

	@Override
	public boolean annadirPiloto(Piloto piloto) {
		
		boolean exito = false;
		
		if(!pilotoDAO.existsById(piloto.getId()))
		{
			try {
				pilotoDAO.save(piloto);
				exito = true;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return exito;
	}
	
	@Override
	public boolean actualizarPiloto(Piloto piloto) {
		
		boolean exito = false;
		
		if(pilotoDAO.existsById(piloto.getId()))
		{
			try {
				pilotoDAO.save(piloto);
				exito = true;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return exito;
	}

	@Override
	public boolean agregarPilotoProbadorEnEscuderia(Piloto piloto, String idEscuderia) {
		
		boolean exito = false;
		
		if(escuderiaDAO.existsById(idEscuderia))
		{
			Escuderia escuderia = escuderiaDAO.findById(idEscuderia).get();
			
			escuderia.getPilotosProbadores().add(piloto);
			escuderiaDAO.save(escuderia);
			
			exito = true;
		}
		
		return exito;		
	}

	@Override
	public boolean annadirPilotoProbadorEnEscuderiaById(String idPiloto, String idEscuderia) {

		boolean exito = false;
		
		if(escuderiaDAO.existsById(idEscuderia) && pilotoDAO.existsById(idPiloto))
		{
			Escuderia escuderia = escuderiaDAO.findById(idEscuderia).get();
			Piloto piloto = pilotoDAO.findById(idPiloto).get();
			
			escuderia.getPilotosProbadores().add(piloto);
			escuderiaDAO.save(escuderia);
			
			exito = true;
		}
		
		return exito;	
	}

	@Override
	public Iterable<Piloto> findAllPilotos() {
		return pilotoDAO.findAll();
	}

	@Override
	public Optional<Piloto> findPilotoById(String idPiloto) {
		return pilotoDAO.findById(idPiloto);
	}

	@Override
	public boolean existsByIdPiloto(String id) {
		return pilotoDAO.existsById(id);
	}

	@Override
	public Piloto deletePilotoById(String id) {
		
		Piloto p = Piloto.builder().id(id).build();
		
		if (pilotoDAO.existsById(id)) {
			p = pilotoDAO.findById(id).get();
			pilotoDAO.deleteById(id);
		}
		
		return p;
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
