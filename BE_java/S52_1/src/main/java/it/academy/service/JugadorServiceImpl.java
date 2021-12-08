package it.academy.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.academy.entity.Jugador;
import it.academy.repository.IjugadorRepository;

@Service
public class JugadorServiceImpl  implements IjugadorService{

	@Autowired
	IjugadorRepository jugadorRepository;
	
// --- Emmagatzemar jugador ---------------------	
	@Override
	public Jugador saveJugador(Jugador jugador) {
	    return jugadorRepository.save(jugador);
	}

// --- Cercar jugador per id ---------------------------
	@Override
	public Jugador findByJugadorId(Long jugadorId) {
		
		return jugadorRepository.getById(jugadorId);
	}

// --- llistat de tots els jugadors ------------------------------
	@Override
	public ArrayList<Jugador> findAll() {
		return (ArrayList<Jugador>) jugadorRepository.findAll();
	}

	// --- cercar jugador per nom --------------------------------	
	@Override
	public Jugador findByJugadorNom(String jugadorNom) {
		ArrayList<Jugador> jugadors = (ArrayList<Jugador>) jugadorRepository.findAll();
		
		for(Jugador jugador : jugadors) {
			if(jugador.getNom().equals(jugadorNom)) {
				return jugador;
			}			
		}
		return null;
	}
	

}
