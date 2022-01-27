package cat.academy.it.S52_F2_2.service;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import cat.academy.it.S52_F2_2.entity.Jugador;

@Component
public interface IjugadorService {
	
	// emma jugador
	public Jugador saveJugador(Jugador jugador);
	
	// cercar jugador per id 
	public Jugador findByJugadorId(Long jugadorId);
	
	// cercar jugador per nom 
	public Jugador findByJugadorNom(String jugadorNom);
	
	// llistat de tots els jugadors 
	public ArrayList <Jugador> findAll();
	
	// Editar el nom de un jugador id
	public Jugador editNameJugador(Long id, String nouNom);
	
	// Jugador realitza una tirada
	public Jugador ferUnaTirada(Long id);

}
