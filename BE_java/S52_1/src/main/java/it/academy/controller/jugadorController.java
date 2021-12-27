package it.academy.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.academy.entity.DadesJugador;
import it.academy.entity.Jugada;
import it.academy.entity.Jugador;
import it.academy.service.JugadorServiceImpl;

@RestController
@RequestMapping(value = "/players")
public class jugadorController {
	
	@Autowired
	JugadorServiceImpl jugadorService;

	
	/**  ***********************************************************************************************
	 * llistatJugadors
	 * 
	 * Retorna el llistat de tots els jugadors
	 * 
	 * @return	ArrayList<Jugador>
	 */
	@GetMapping("/list")
	public ArrayList<Jugador> llistatJugadors() {
		return jugadorService.findAll();
	}

	
	/** ***********************************************************************************************
	 * jugadorId
	 * 
	 *  Retorna el Jugador Id
	 *  
	 *  @param		id		Long
	 *  @return				Jugador
	 */
	@GetMapping("/{id}")
	public Jugador jugadorId(@PathVariable ("id") long id) {
		return jugadorService.findByJugadorId(id);
	}
	
	// ***********************************************************************************************
	@GetMapping("/nom/{nom}")
	public Jugador jugadorId(@PathVariable ("nom") String nom) {
		return jugadorService.findByJugadorNom(nom);
	}

	/** ***********************************************************************************************
	 * post /players/
	 * 
	 * Afegir un nou jugador
	 * @param jugador
	 * @return
	 */
	@PostMapping()
	public Jugador afegirJugador(@RequestBody Jugador jugador) {
		return jugadorService.saveJugador(jugador);
	}
	
	/** *********************************************************************************************
	 * Put /players/{id}
	 *  
	 *  Modifica el nom del jugador id
	 *  
	 * @param id					int
	 * @param nouNom			String
	 * 
	 * @return						Jugador
	 */		
	@PutMapping("/{id}")
	public Jugador editarJugador(@PathVariable ("id") long id, @RequestBody String nouNom) {
		return jugadorService.editNameJugador(id, nouNom);		
	}
	
	/** *******************************************************************************************************
	 * Post /{id}/games
	 * 
	 * El jugador id realitza una tirada de daus
	 * 
	 * @param id		Long
	 * @return			Jugador
	 */
	@PostMapping("/{id}/games")
	public Jugador jugadorIdJuga(@PathVariable ("id") long id) {
		return jugadorService.ferUnaTirada(id);
	}
	
	/** ************************************************************************************************************
	 * Delete {id}/games
	 * 
	 * Esborra totes les jugades del jugador id
	 * 
	 * @param id		Long
	 * @return			Jugador
	 */
	@DeleteMapping("/{id}/games")
	public Jugador jugadorIdEsborraJugades(@PathVariable ("id") long id) {
		return jugadorService.eliminarJugades(id);
	}
	
	/** **************************************************************************************************************
	 * get/players/
	 * 
	 * Retorna els jugadors amb el seu percentatge d'encerts
	 * @return
	 */
	@GetMapping()
	public ArrayList<DadesJugador> LlistatJugadorsPercentExit(){
		return jugadorService.jugadorsPercentatgeExit();
	}
		
	/** ****************************************************************************************************************
	 * GET /players/{id}/games
	 * 
	 * retorna el llistat de jugades per un jugador.  	
	 * 
	 * @param id	Long
	 * @return		List<Jugada>
	 */
	@GetMapping ("/{id}/games")
	public List<Jugada> jugadesUnJugador(@PathVariable ("id") Long id){
		return jugadorService.jugadesUnJugador(id);
	}
		  
	/** ********************************************************************************************************************
	 * GET /players/ranking
	 * 
	 * retorna el ranking  mig de tots els   jugadors del sistema,  percentatge mig  d’èxits. 
	 * 
	 * @return	ArrayList<String>
	 */
	@GetMapping ("/ranking")
	public ArrayList<String> rankingMigExits(){
		return jugadorService.rankingPercentatgeMigExits();
	}
	
	/** ************************************************************************************************************************
	 * 	GET /players/ranking/loser
	 * 
	 *  retorna el jugador  amb pitjor percentatge d’èxit  
	 * 
	 * @return	Jugador
	 */
	@GetMapping("/ranking/loser")
	public Optional<Jugador> jugadorLoser() {
		return jugadorService.rankingJugadorLoser();
	}
	
	/** ***************************************************************************************************************************
	 * GET /players/ranking/winner
	 * 
	 *     retorna el  jugador amb  millor percentatge   d’èxit
	 * 
	 * @return		Jugador
	 */
	@GetMapping("/ranking/winner")
	public Optional<Jugador> jugadorWinner() {
		return jugadorService.rankingJugadorWinner();
	}
	
	
}
