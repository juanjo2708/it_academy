package academy.it.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import academy.it.entity.Botiga;
import academy.it.entity.Quadre;
import academy.it.exceptions.BotigaException;
import academy.it.exceptions.ResourceNotFoundException;
import academy.it.repository.IbotigaRepository;

@Service
public class BotigaService {
	
	@Autowired
	IbotigaRepository botigaRepositori;
	
	
	/**
	 * crearBotiga
	 * Crea una botiga nova
	 * 
	 * @param String 	nom
	 * @return	Botiga
	 */
	public Botiga crearBotiga(String nom, int capacitat) {
		
		// Determinem si els paràmetres passats son correctes
		if(nom==null || nom.equals("")){
			throw new BotigaException("el nom de la botiga és null o està buit");
		}else if (capacitat<=0) {
			throw new BotigaException("La capacitat de la botiga té un valor negatiu o zero.");
		}
		
		//Retornem la botiga creada.
		return botigaRepositori.save(new Botiga(nom, capacitat));
	}	
	
	/**
	 * obtenirBotigues
	 * Retorna totes les botigues del repository
	 * 
	 * @return List<Botiga>
	 */
	public List<Botiga> obtenirBotigues(){
		return botigaRepositori.findAll();
	}
	
	/**
	 * afegirQuadre
	 * 
	 * Afegeix un quadre a l'entitat bancària idBotiga
	 * 
	 * @param 	idBotiga	int
	 * @param 	nom			String
	 * @param 	autor		String
	 * @return	Quadre		
	 */
	public Quadre afegirQuadre(int idBotiga, String nom, String autor) {
								
		// Determino is existeix la botiga, Envio missatge d'error si no existeix.		
		Botiga botigaId = this.botigaRepositori.findById(idBotiga)
				.orElseThrow(() -> new ResourceNotFoundException("La botiga amb id "+idBotiga+" no s'ha trobat"));
		
		// Creo el quadre.
		Quadre nouQuadre = new Quadre (nom, autor);	
		
		// Afegim el quadre i actualitzem la botiga amb el quadre afegit
		botigaId.afegirQuadre(nouQuadre);
		this.botigaRepositori.save(botigaId);
			
		//this.botigaRepositori.findById(idBotiga).get().afegirQuadre(nouQuadre);
		//this.botigaRepositori.save(this.botigaRepositori.findById(idBotiga).get());
		
		return nouQuadre;				
	}
	
	/**
	 * llistarQuadresBotiga
	 * 
	 * Retorna un Set amb tots els quadres de la botiga idBotiga.
	 * 
	 * @param 	int 		idBotiga
	 * @return	Set<Quadre>	
	 */
	public Set<Quadre> llistarQuadresBotiga(int idBotiga){
		
		// Determino is existeix la botiga, Envio missatge d'error si no existeix.
		Botiga botigaId =this.botigaRepositori.findById(idBotiga)
				.orElseThrow(() -> new ResourceNotFoundException("La botiga amb id "+idBotiga+" no s'ha trobat"));
		
		//Retorno el Set de quadres de la botiga idBotiga
		return botigaId.getQuadres();
		
		//return this.botigaRepositori.findById(idBotiga).get().getQuadres();
	}
	
	public ResponseEntity <Botiga> cremarQuadres(int idBotiga){
		
		// Determino is existeix la botiga, Envio missatge d'error si no existeix.
		Botiga botigaId =this.botigaRepositori.findById(idBotiga)
				.orElseThrow(() -> new ResourceNotFoundException("La botiga amb id "+idBotiga+" no s'ha trobat"));
		
		// Esborrem els quadres de la botiha
		botigaId.getQuadres().clear();
		botigaRepositori.save(botigaId);
		
		return ResponseEntity.ok().body(botigaId);
	}	
	
}
