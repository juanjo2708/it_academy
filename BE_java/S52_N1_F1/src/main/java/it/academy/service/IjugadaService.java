package it.academy.service;

import java.util.List;

import org.springframework.stereotype.Component;

import it.academy.entity.Jugada;

@Component
public interface IjugadaService {
	
	public List<Jugada> mostrarJugades (Long id);
	
	public void esborrarJugades(Long jugadorId);
	
	
}
