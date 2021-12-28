package it.academy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import it.academy.entity.Jugada;
import it.academy.repository.IjugadaRepository;

public class JugadaServiceImpl implements IjugadaService {

	@Autowired
	IjugadaRepository jugadaRepository;
	
	
	
	@Override
	public List<Jugada> mostrarJugades(Long id) {
		return null;
	}

	@Override
	public void esborrarJugades(Long jugadorId) {
		this.jugadaRepository.deleteAllByJugador_id(jugadorId);

	}

}
