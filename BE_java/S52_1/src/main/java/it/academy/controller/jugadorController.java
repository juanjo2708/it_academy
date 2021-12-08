package it.academy.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.academy.entity.Jugador;
import it.academy.service.JugadorServiceImpl;

@RestController
@RequestMapping(value = "/jugador")
public class jugadorController {
	
	@Autowired
	JugadorServiceImpl jugadorService;

	
	@GetMapping()
	public ArrayList<Jugador> llistatJugadors() {
		return jugadorService.findAll();
	}


	@GetMapping("/{id}")
	public Jugador jugadorId(@PathVariable ("id") long id) {
		return jugadorService.findByJugadorId(id);
	}
	
	@GetMapping("/nom/{nom}")
	public Jugador jugadorId(@PathVariable ("nom") String nom) {
		return jugadorService.findByJugadorNom(nom);
	}

	
	@PostMapping()
	public Jugador afegirJugador(@RequestBody Jugador jugador) {
		return jugadorService.saveJugador(jugador);
	}

}
