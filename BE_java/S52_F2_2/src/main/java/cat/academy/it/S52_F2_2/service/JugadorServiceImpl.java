package cat.academy.it.S52_F2_2.service;

import cat.academy.it.S52_F2_2.exceptions.ResourceNotFoundException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.academy.it.S52_F2_2.entity.DadesJugador;
import cat.academy.it.S52_F2_2.entity.Dau;
import cat.academy.it.S52_F2_2.entity.Jugada;
import cat.academy.it.S52_F2_2.entity.Jugador;
import cat.academy.it.S52_F2_2.repository.IjugadorRepository;

@Service
public class JugadorServiceImpl  implements IjugadorService{

	@Autowired
	IjugadorRepository jugadorRepository;
	
	//@Autowired
	//IjugadaRepository jugadaRepository;
	
// --- Emmagatzemar jugador ----------------------------------------------------------------------------------------------------------	
	@Override
	public Jugador saveJugador(Jugador jugador) {
		// Determinem si és un jugador ANÒNIM, o si existeix
		if(jugador.getNom().equals("ANONIM")){								// Si és anònim el creem i el retornem
			return jugadorRepository.save(jugador);
		}else if (findByJugadorNom(jugador.getNom()) ==null) {	 // Si el jugador no existeix el creem i el retornem
			return jugadorRepository.save(jugador);
		}else {																				// Si el jugador existeix generem una excepció indicant la duplicitat.
			throw  new ResourceNotFoundException("Les dades del Jugador son incorrectes"); 
		}		
	}

// --- Cercar jugador per id --------------------------------------------------------------------------------------------
	@Override
	public Jugador findByJugadorId(Long jugadorId) {
		
		Jugador jugadorTriat = this.jugadorRepository.findById(jugadorId)
				.orElseThrow(() -> new ResourceNotFoundException("El jugador amb id "+jugadorId+" no s'ha trobat"));
		
		return jugadorTriat;
	}

// --- llistat de tots els jugadors ------------------------------
	@Override
	public ArrayList<Jugador> findAll() {
		return (ArrayList<Jugador>) jugadorRepository.findAll();
	}

// --- cercar jugador per nom ----------------------------------------------------------	
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
	
// Canviar el nom de un jugador id ----------------------------------------------------------------------------------------------------
	@Override
	public Jugador editNameJugador(Long id, String nouNom) {
		// Determino si el jugador existeix
		Jugador jugadorTriat = this.jugadorRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Editant un Jugador :   El jugador amb id "+id+" no s'ha trobat"));
		
		jugadorTriat.setNom(nouNom);									 //Canvio el nom del jugador
		return this.jugadorRepository.save(jugadorTriat);		// Actualitzo les dades del repository		
	}

// --- Un jugador realitza una tirada ----------------------------------------------------------------	
	@Override
	public Jugador ferUnaTirada(Long id) {
		Boolean guanyada =false;
		
		// Determino si el jugador existeix
		Jugador jugadorTriat = this.jugadorRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Jugada :   El jugador amb id "+id+" no existeix.  Cal que el registris abans de jugar"));
										
		Dau dau1 = new Dau();											// Llencem els daus i obtenim el valor
		dau1.tirada();							    
		Dau dau2 = new Dau();
		dau2.tirada();
			
		if(dau1.getValor()+dau2.getValor()==7) {			// Determinem i registrem si s'ha guanyat la jugada.
			guanyada=true;
		}																				
		
		Jugada novaJugada = new Jugada(dau1.getValor(), dau2.getValor(), guanyada);						//Creem la Jugada
				
		jugadorTriat.afegirJugada(novaJugada);					// Afegim la jugada a la col.lecció de jugades del jugador id   jugadorTriat.getJugades().add(novaJugada);
		
		return this.jugadorRepository.save(jugadorTriat);			  // Actualitzem la jugada al repository 		
	 
	}

// --- Eliminar les jugades de un Jugador id ----------------------------------------------------------------------------------------------
public  Jugador eliminarJugades(Long id) {
	
	// Determino si el jugador existeix
			Jugador jugadorTriat = this.jugadorRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Eliminar Jugades :   El jugador amb id "+id+" no existeix."));
			
	jugadorTriat.getJugades().clear();								// Netejem l'arrayList de jugades de l'objecte Jugador.
	return this.jugadorRepository.save(jugadorTriat);		// Actualitzem el jugador al repository.			
}	


//--  retorna el llistat de tots  els jugadors del sistema  amb el seu percentatge mig  d’èxits -----------------------------------------------
public ArrayList <DadesJugador> jugadorsPercentatgeExit(){
	
	List<Jugador> jugadors =jugadorRepository.findAll();// jugadorRepository.findAll();		// Recollim els jugadors en una col.lecció
	
	// Si no hi ha jugadors a la llista 
	if(jugadors.size()==0) {
		throw new ResourceNotFoundException("No es pot realitzar el llistat del percentatge d'èxits degut a que no hi han jugadors .");
	}
		return calcularPercentatgesExit(jugadors);	
}

/** ******************************************************************************************************************************************
 * jugadesUnJugador
 * 
 * Retorna les jugades del jugador id
 *  
 * @param id	Long
 * @return		List<Jugada>
 */
public List<Jugada> jugadesUnJugador(Long id){
	// Determino si el jugador existeix
	Jugador jugadorTriat = this.jugadorRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Eliminar Jugades :   El jugador amb id "+id+" no existeix."));
	
	return jugadorTriat.getJugades();
}

/** *******************************************************************************************************************************************
 * rankingPercentatgeMigExits
 * 
 * retorna el ranking  mig de tots els   jugadors del sistema .  És a dir, el  percentatge mig  d’èxits. 
 * 
 * @param jugadors
 * @return
 */
public ArrayList<String> rankingPercentatgeMigExits(){
	// Definició de variables
	int mitjana =  0;
	int jugades =0;
	int guanyades =0;
	
	List<Jugador> jugadors =jugadorRepository.findAll();		// Recollim els jugadors en una col.lecció
	
	// Si no hi ha jugadors a la llista 
	if(jugadors.size()==0) {
		throw new ResourceNotFoundException("No es pot calcular el percentatge mig d'èxits degut a que no hi han jugadors .");
	}
		
	ArrayList<DadesJugador> ranking = calcularPercentatgesExit(jugadors);  		//Obtenim els jugadors i el seu percentatge dèxit
	
	for(int i=0; i<ranking.size();i++) {										// Sumem les mitjanes dels jugadors
		mitjana +=ranking.get(i).getPercentatgeEncert();
		guanyades += ranking.get(i).getEncertades();
		jugades += ranking.get(i).getJugades();
	}
	
	mitjana=mitjana/ranking.size();										// Calculem la mitjana de tots els jugadors
	
	// Afegim els calculs totals a un ArrayList
	ArrayList<String> resultats = new ArrayList<String>();
	resultats.add("RESULTATS TOTALS DE LES JUGADES :");
	resultats.add("Total de jugades : "+jugades);
	resultats.add("Total jugades guanyades : "+guanyades);
	resultats.add("Percentatge mig total de partides guanyades : "+mitjana+" %" );
			
	return resultats;
}

/**
 * rankingJugadorLoser **************************************************************************************************************
 * 
 * Retorna el jugador amb menys partides guanyades.
 * 
 * @return		Jugador
 */
public Optional<Jugador> rankingJugadorLoser() {
	List<Jugador> jugadors =jugadorRepository.findAll();		// Recollim els jugadors en una col.lecció
	
	// Si no hi ha jugadors a la llista 
	if(jugadors.size()==0) {
		throw new ResourceNotFoundException("No es pot cercar el jugador loser degut a que no hi han jugadors .");
	}
		
	ArrayList<DadesJugador> ranking = calcularPercentatgesExit(jugadors);  		//Obtenim els jugadors i el seu percentatge dèxit
	 return jugadorRepository.findById(ranking.get(1).getId_jugador());	
}

/**
 *rankingJugadorWinner *******************************************************************************************************************
 * 
 * Retorna el jugador que més partides ha guanyat
 * 
 * @return 		Jugador
 */
public Optional<Jugador> rankingJugadorWinner() {
	List<Jugador> jugadors =jugadorRepository.findAll();		// Recollim els jugadors en una col.lecció
	
	// Si no hi ha jugadors a la llista 
	if(jugadors.size()==0) {
		throw new ResourceNotFoundException("No es pot cercar el jugador loser degut a que no hi han jugadors .");
	}
		
	ArrayList<DadesJugador> ranking = calcularPercentatgesExit(jugadors);  		//Obtenim els jugadors i el seu percentatge dèxit
	return jugadorRepository.findById(ranking.get(ranking.size()-1).getId_jugador());	
}

/** *********************************************************************************************************************************
 * calcularPercentatgeExit
 * 
 * Calcula el percentatge d'èxit de cada jugador i retorna un ArrayList ordenat amb les dades dels jugadors.
 * 
 * @param	 jugadors		ArrayList<Jugador>
 * @return    llistat 			ArrayList<DadesJugador>
 */
public  ArrayList<DadesJugador> calcularPercentatgesExit(List<Jugador> jugadors) {
		
		// Declaració de variables
		List<Jugada> jugades ;
		ArrayList<DadesJugador >llistat = new ArrayList<DadesJugador>();
		DadesJugador dadesJugador;
		
		int totalJugades=0;
		int exits=0;
		int exitsXcent=0;
		
		for(Jugador jugador : jugadors) {										// Calculem el percentatge d'exit de cada jugador
			jugades = jugador.getJugades();
			totalJugades = jugades.size();

			for(Jugada jugada : jugades) {
				if(jugada.getGuanyada()) {
					exits++;
				}
			}
			
			if (totalJugades ==0) {			// Calculem el percentatge d'èxit i controlem l'error / by zero del jugador
			   exitsXcent =0;	
			   exits =0;
			}else {
				exitsXcent = (exits*100)/totalJugades;
			}
			
			dadesJugador = new DadesJugador(jugador.getId(),jugador.getNom(),totalJugades, exits, exitsXcent);
			llistat.add(dadesJugador);			
		}
		
		Collections.sort(llistat);		//Ordenem el llistat asc per percentatge d'encerts
		return llistat;		
}

}
