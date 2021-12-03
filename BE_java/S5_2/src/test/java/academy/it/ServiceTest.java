package academy.it;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import academy.it.controller.BotigaController;
import academy.it.entity.Botiga;
import academy.it.entity.Quadre;
import academy.it.service.BotigaService;

//@TestMethodOrder(OrderAnnotation.class)
@ComponentScan(basePackages ="academy.it.restservices")
@AutoConfigureMockMvc
@ContextConfiguration
@SpringBootTest(classes= {ServiceTest.class})
//@WebMvcTest(controllers = BotigaController.class)
public class ServiceTest {
	
	@Autowired
	private MockMvc mockMvc;

	@Mock
	private BotigaService botigaService;
	
	@InjectMocks
	BotigaController botigaController;
			
	
	
		
		@BeforeEach
		public void setup() {
			mockMvc = MockMvcBuilders.standaloneSetup(botigaController).build();
		}
		
		/**
		 * get /shops
		 * 
		 * @throws Exception
		 */
		@Test
		@Order (1)
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
		 * get /shops/{shop_id}
		 * 
		 * @throws Exception
		 */
		@Test
		@Order (2)
		@DisplayName ("Botiga indicada by Id_botiga   get /shops/id_botiga")
		public void getBotiga_id() throws Exception {
			
			Botiga registre3 = new Botiga ("Botiga tres",120);
			registre3.setId(2);
			
			//botigaService.obtenirBotiga_id(); 
			when(botigaService.obtenirBotigaId(registre3.getId())).thenReturn(registre3);
			this.mockMvc.perform (get ("/shops/{id}", registre3.getId()))
				.andExpect(status().isOk())	
				.andExpect(MockMvcResultMatchers.jsonPath(".id").value(2))
				.andExpect(MockMvcResultMatchers.jsonPath(".nom").value("Botiga tres"))
				.andExpect(MockMvcResultMatchers.jsonPath(".capacitat").value(120))
				.andDo(print());
		}	
	
		/**
		 * post /shops/
		 * 
		 * @throws Exception
		 */
		@Test
		@Order (3)
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
				.andExpect(status().isOk())	
				.andDo(print());
		}		
				
		/**
		 * post /shops/{id}/pictures
		 * 
		 * @throws Exception
		 */
		@Test
		@Order (4)
		@DisplayName ("Afegir un nou quadre a la botiga id      post/{id} /pictures")
		public void postBotigaAddQuadre() throws Exception {
			
			ObjectMapper mapper = new ObjectMapper();
			Botiga registre3 = new Botiga ("Botiga tres",120);
			registre3.setId(2);
			
			Quadre nouQuadre = new Quadre ("Els ciclistes","Pitxot");
			//nouQuadre.setDataEntrada(LocalDate.now());
			nouQuadre.setId(1);
			
			registre3.afegirQuadre(nouQuadre);
			
			
			//botigaService.afegirQuadre(int id_botiga, String nom, String autor); 
			when(botigaService.afegirQuadre(registre3.getId(), nouQuadre.getNom(), nouQuadre.getAutor())).thenReturn(nouQuadre);
			String jsonbody = mapper.writeValueAsString(nouQuadre);
			
			this.mockMvc.perform (post ("/shops/{id}", registre3.getId())
												.content(jsonbody)
												.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())	
				.andDo(print());
		}
		
		
}
