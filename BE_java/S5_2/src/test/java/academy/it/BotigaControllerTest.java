package academy.it;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import academy.it.controller.BotigaController;
import academy.it.entity.Botiga;
import academy.it.entity.Quadre;
import academy.it.exceptions.ResourceNotFoundException;
import academy.it.repository.IbotigaRepository;
import academy.it.service.BotigaService;
import ch.qos.logback.core.net.ObjectWriter;


// Spring injecta automàticament la dependència del servei al controlador
@WebMvcTest(BotigaController.class)
public class BotigaControllerTest {
		
	@Autowired
	private MockMvc mockMvc;
	
		
	// Utilitzem @MockBean per crear i injectar una simulació per a BotigaService 
	//(si no ho fem, el context de l'aplicació no pot iniciar-se) 
	@MockBean
	private BotigaService botigaService;
		
	/**
	 *  get /shops/{id}
	 *  Retorna la  botiga id passada per paràmetre. 
	 *   
	 * @throws Exception
	 */
	@Test
	@DisplayName ("Botiga indicada by Id_botiga   get /shops/id_botiga")
	public void getBotiga_id() throws Exception {
		
		Botiga registre3 = new Botiga ("Botiga tres",120);
		registre3.setId(2);
		
		//Fem un Mock de botigaService.obtenirBotiga_id(); 
		Mockito.when(botigaService.obtenirBotigaId(registre3.getId())).thenReturn(registre3);
		
		this.mockMvc.perform (get ("/shops/{id}",registre3.getId()))
			.andExpect(status().isOk())	
			.andExpect(MockMvcResultMatchers.jsonPath(".id").value(2))
			.andExpect(MockMvcResultMatchers.jsonPath(".nom").value("Botiga tres"))
			.andExpect(MockMvcResultMatchers.jsonPath(".capacitat").value(120))
			.andDo(print());
	}
	
	/**
	 * get /shops
	 * 
	 * @throws Exception
	 */
	@Test
	@DisplayName ("Llista de totes les botigues  get /shops/")
	public void getAllBotigues() throws Exception {
		
		Botiga registre1 = new Botiga ("Botiga una",100);
		registre1.setId(0);
		Botiga registre2 = new Botiga ("Botiga dos",110);
		registre2.setId(1);
		Botiga registre3 = new Botiga ("Botiga tres",120);
		registre3.setId(2);
		Botiga registre4 = new Botiga ("Botiga quatre",130);
		registre4.setId(3);
		Botiga registre5 = new Botiga ("Botiga cinc",140);
		registre5.setId(4);
		ArrayList<Botiga>botigues= new ArrayList<Botiga>();
		botigues.add(registre1);
		botigues.add(registre2);
		botigues.add(registre3);
		botigues.add(registre4);
		botigues.add(registre5);				
								
		//botigaService.obtenirBotigues(); 
		when(botigaService.obtenirBotigues()).thenReturn(botigues);
		this.mockMvc.perform (get ("/shops/"))
			.andExpect(status().isOk())				
			.andExpect(jsonPath("$[2].nom", is("Botiga tres")))
			.andDo(print());
	}
	
	/**
	 * post /shops/
	 * 
	 * @throws Exception
	 */
	@Test
	@DisplayName ("Crear una botiga nova      post /shops/")
	public void postBotiga_id() throws Exception {
		
		ObjectMapper mapper = new ObjectMapper();
		Botiga registre3 = new Botiga ("Botiga tres",120);
		registre3.setId(2);
		
		//botigaService.crearBotiga(String nom, int capacitat); 
		when(botigaService.crearBotiga(registre3.getNom(), registre3.getCapacitat())).thenReturn(registre3);
		String jsonbody = mapper.writeValueAsString(registre3);
		
		this.mockMvc.perform (post ("/shops/")
											.content(jsonbody)
											.contentType(MediaType.APPLICATION_JSON))
			.andExpect(MockMvcResultMatchers.jsonPath(".id").value(2))
			.andExpect(MockMvcResultMatchers.jsonPath(".nom").value("Botiga tres"))
			.andExpect(MockMvcResultMatchers.jsonPath(".capacitat").value(120))
			.andExpect(status().isOk())	
			.andDo(print());
	}	
	
	
//	/**
//	 * post /shops/{id}/pictures
//	 * 
//	 * @throws Exception
//	 */
//	@Test
//	@DisplayName ("Afegir un nou quadre a la botiga id      post/{id} /pictures" )
//	public void postBotigaAddQuadre() throws Exception {
//		
//		ObjectMapper mapper = new ObjectMapper();
//		
//		// Creem botiga
//		Botiga registre3 = new Botiga ("Botiga tres",120);
//		registre3.setId(2);
//		
//		// Creem Quadre
//		Quadre nouQuadre = new Quadre ("Els ciclistes","Pitxot");
//		nouQuadre.setId(0);
//		
//		//Afegim el quadre a la botigq
//		registre3.afegirQuadre(nouQuadre);
//		String jsonBody = mapper.writeValueAsString(registre3);
//					
//		// botigaService.afegirQuadre(int id_botiga, String nom, String autor); 
//		Mockito.when(botigaService.afegirQuadre(2,"Els ciclistes", "Pitxot")).thenReturn(registre3);
//		// Comprovem el resultat
//		this.mockMvc.perform (post ("/shops/{id}/pictures", 2 ))
//				.andExpect(status().isOk())	
//				.andExpect(jsonPath("$[0].id", is(2)))
//				.andExpect(jsonPath("$[0].nom", is("Botiga tres")))
//				.andExpect(jsonPath("$[0].quadres.size").isNotEmpty())				
//				.andDo(print());
//	}
//	
	
	/**
	 * post /shops/{id}/pictures
	 * 
	 * @throws Exception
	 */
	@Test
	@DisplayName ("Afegir un nou quadre a la botiga id      post/{id} /pictures" )
	public void postBotigaAddQuadre() throws Exception {
		
		
		// Creem botiga
		Botiga registre3 = new Botiga ("Botiga tres",120);
		registre3.setId(2);
		
		// Creem Quadre
		Quadre nouQuadre = new Quadre ("Els ciclistes","Pitxot");
		nouQuadre.setId(0);
		
		//Afegim el quadre a la botigq
		registre3.afegirQuadre(nouQuadre);
		
		// mapejem l'objecte Quadre a String
		ObjectMapper mapper = new ObjectMapper();
		String stringMapper = mapper.writeValueAsString(nouQuadre);
						
		// botigaService.afegirQuadre(int id_botiga, String nom, String autor); 
		when(botigaService.afegirQuadre(2,"Els ciclistes", "Pitxot")).thenReturn(registre3);		
		
		this.mockMvc.perform( post("/shops/{id}/pictures", 2)
				.content(stringMapper)				
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
	      		.andDo(print())
	      		.andExpect(status().isOk())
	      		.andExpect(MockMvcResultMatchers.jsonPath("$.id").value(2))
	      		.andExpect(MockMvcResultMatchers.jsonPath("$.quadres.length()", is(1)))
	      		.andExpect(MockMvcResultMatchers.jsonPath("$.quadres[*]").isNotEmpty());		
	}
	
	
	/**
	 * botigaLlistarQuadres
	 * 
	 * Retorna un llistat amb els quadres de la botiga id
	 * 
	 * @throws Exception
	 */
	@Test
	@DisplayName ("Llistar els  quadres de la botiga id  -->    get /{ID}/pictures " )
	public void botigaLlistarQuadres() throws Exception {
	
		// Creem botiga
		Botiga registre3 = new Botiga ("Botiga tres",120);
		registre3.setId(2);
		
		// Creem Quadres i els afegim a la botiga
		Quadre nouQuadre = new Quadre ("Els ciclistes","Pitxot");
		nouQuadre.setId(0);
		registre3.afegirQuadre(nouQuadre);
		
		nouQuadre = new Quadre("Collage on road", "Potty Marhs");
		nouQuadre.setId(1);
		registre3.afegirQuadre(nouQuadre);
				
		// botigaService.llistarQuadresBotiga(int id_botiga); 
		Mockito.when(botigaService.llistarQuadresBotiga(2)).thenReturn(registre3);
		
		// Comprovem el resultat
		this.mockMvc.perform (get ("/shops/{ID}/pictures", 2 )
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.id").value(2))				
				.andExpect(MockMvcResultMatchers.jsonPath("$.quadres.length()", is(2)));
	}		
}








