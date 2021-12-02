package academy.it;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.hamcrest.Matchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;

import academy.it.controller.BotigaController;
import academy.it.entity.Botiga;
import academy.it.repository.IbotigaRepository;
import academy.it.service.BotigaService;


@WebMvcTest(BotigaService.class)
public class BotigaControllerTest {
	
	 @Autowired
	 MockMvc mockMvc;
	 
	 @Autowired
	 ObjectMapper mapper;
	 
	 @MockBean
	 BotigaService botigaService;
	 
	 Botiga registre1 = new Botiga ("Botiga una",100);
	 Botiga registre2 = new Botiga ("Botiga dos",110);
	 Botiga registre3 = new Botiga ("Botiga tres",120);
	 Botiga registre4 = new Botiga ("Botiga quatre",130);
	 Botiga registre5 = new Botiga ("Botiga cinc",140);
	 
	 /**
	  * 
	  * getAllRecords() method
	  * 
	  * @throws Exception
	  */
	 @Test
	 public void getAllBotigues_success() throws Exception {
		
		 ArrayList<Botiga> botigues = new ArrayList<Botiga>();
		 botigues.add(registre1);
		 botigues.add(registre2);
		 botigues.add(registre3);
		 botigues.add(registre4);
		 botigues.add(registre5);
	 
		 
		 
		 
	 }
	 
	 
	 
//	 @Test
//	 public void getAllBotigues_success() throws Exception {
//		
//		 ArrayList<Botiga> botigues = new ArrayList<Botiga>();
//		 botigues.add(registre1);
//		 botigues.add(registre2);
//		 botigues.add(registre3);
//		 botigues.add(registre4);
//		 botigues.add(registre5);
//		 
//		 Mockito.when(botigaService.obtenirBotigues()).thenReturn(botigues);
//		 
//		 
//		 mockMvc.perform(MockMvcRequestBuilders
//		            .get("/shops")
//		            .contentType(MediaType.APPLICATION_JSON))
//		            .andExpect(status().isOk())
//		            .andExpect(jsonPath("$", hasSize(5)))
//		            .andExpect(jsonPath("$[2].nom", is("Botiga dos")));	
//	 }

	 
//	/**
//	 * Obtenir botiga id
//	 *
//	 * getBotigaById
//	 * 
//	 * @throws Exception
//	 */
//	 @Test
//	 public void getBotigaById_success() throws Exception {
//	     Mockito.when(botigaRepository.findById(registre1.getId())).thenReturn(java.util.Optional.of(registre1));
//
//	     mockMvc.perform(MockMvcRequestBuilders
//	             .get("/shops/1")
//	             .contentType(MediaType.APPLICATION_JSON))
//	             .andExpect(status().isOk())
//	             .andExpect(jsonPath("$", notNullValue()))
//	             .andExpect(jsonPath("$.name", is("Botiga una")));
//	 }
//
//	 /**
//	  * Afegir nova botiga
//	  * 
//	  * post/shops
//	  * @throws Exception
//	  */
//	 @Test
//	 public void createBotiga_success() throws Exception {
//		 Botiga novaBotiga= new Botiga("Botiga n", 57);
//		 
//	     Mockito.when(botigaRepository.save(novaBotiga)).thenReturn(novaBotiga);
//
//	     MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/shops")
//	             .contentType(MediaType.APPLICATION_JSON)
//	             .accept(MediaType.APPLICATION_JSON)
//	             .content(this.mapper.writeValueAsString(novaBotiga));
//
//	     mockMvc.perform(mockRequest)
//	             .andExpect(status().isOk())
//	             .andExpect(jsonPath("$", notNullValue()))
//	             .andExpect(jsonPath("$.name", is("Botiga n")));
//	     }
//
}
