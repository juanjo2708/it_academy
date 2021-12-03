package academy.it.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import academy.it.service.BotigaService;
import academy.it.entity.Botiga;
import academy.it.entity.Quadre;
import academy.it.exceptions.ResourceNotFoundException;

@RestController
@RequestMapping("/shops")
public class BotigaController {
	
	@Autowired
	BotigaService botigaService;

	/**
	 * Get /shops/
	 * Retorna totes les botigues de la BD.
	 * 
	 * @return	List<Botiga>
	 */
	@GetMapping("")
	public List<Botiga> getAllBotigues() {
		return botigaService.obtenirBotigues();
	}
	
	/**
	 * get /shops/{botiga_id}
	 * 
	 * Retorna la botiga
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public Botiga getlBotigaId(@PathVariable ("id") int id) {
		return botigaService.obtenirBotigaId(id);
	}	
	
	/**
	 * Post /shops/
	 * Crea una nova botiga 
	 * 
	 * @param 	Botiga
	 * @return	Botiga 
	 */
	@PostMapping("")
	public Botiga afegirBotiga(@RequestBody Botiga botiga) {
			
		return botigaService.crearBotiga(botiga.getNom(),botiga.getCapacitat());		
	}
	
	/* afegirQuadre
	 * 
	 * Post /shops/{ID}/pictures
	 * 
	 *  Afegeix un quadre a la botiga id passada com a PathVariable
	 *  @param 	int 	id 		(@PathVariable)
	 *  @param 	Quadre	quadre	(@RequestBody)	 *  
	 */
	@PostMapping("/{ID}/pictures")
	public Quadre afegirQuadre(@PathVariable ("ID") int id, @RequestBody Quadre quadre) {
		return botigaService.afegirQuadre(id, quadre.getNom(),quadre.getAutor());
	}
	
	/**
	 * llistatQuadres
	 * 
	 * Llistat dels quadres de una botiga (id)
	 * 
	 * @param 	int 	id
	 * @return	Set<Quadre>
	 */
	@GetMapping("/{ID}/pictures")
	public Set<Quadre> llitatQuadres(@PathVariable ("ID") int id){
		return botigaService.llistarQuadresBotiga(id);
	}
	
	@DeleteMapping("/{ID}/pictures")
	public ResponseEntity<Botiga> cremarQuadres (@PathVariable ("ID") int id){
		return botigaService.cremarQuadres(id);
	}
	
	
	
	

}
