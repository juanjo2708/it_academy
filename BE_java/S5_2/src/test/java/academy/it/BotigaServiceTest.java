package academy.it;

// https://youtu.be/zO7nO8PB9Pw
// https://www.youtube.com/watch?v=SJ2hwfdFMxY
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import academy.it.entity.Botiga;
import academy.it.exceptions.ResourceNotFoundException;
import academy.it.repository.IbotigaRepository;
import academy.it.service.BotigaService;
import antlr.collections.List;

class BotigaServiceTest {
	Botiga botigaEntt;
	
	 
	@InjectMocks
	BotigaService botigaService;
	
	// Mockejem el repository de les botiges
	@Mock
	private IbotigaRepository botigaRepository;
	

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
		
		botigaEntt = new Botiga("La Tafanera", 145);
		botigaEntt.setId(0);
	}
	
// ------------------------------------------------------------------------------------------------
	@Test
	final void testCrearBotiga() {
		when(botigaRepository.save(any())).thenReturn(botigaEntt);
		
		Botiga botigaResult = botigaService.crearBotiga(botigaEntt.getNom(),botigaEntt.getCapacitat());
		
		assertNotNull(botigaResult, "La botiga emmagatzemada no pot ser null" );
		assertEquals(0, botigaResult.getId(), "El Id de botiga ha de coincidir");
		verify(botigaRepository, times(1)).save(any());
	}
// ------------------------------------------------------------------------------------------------
	@Test
	final void testObtenirBotigues() {
		Botiga botiga1 =new Botiga("Botiga 1", 100); 
		botiga1.setId(1);
		Botiga botiga2 =new Botiga("Botiga 2", 200);
		botiga2.setId(2);
		Botiga botiga3 =new Botiga("Botiga 3", 300);
		botiga3.setId(3);
		Botiga botiga4 =new Botiga("Botiga 4", 400);
		botiga4.setId(4);
		Botiga botiga5 =new Botiga("Botiga 5", 500);
		botiga5.setId(5);
		ArrayList<Botiga> botigues = new ArrayList<Botiga>();		
		botigues.add(botiga1);
		botigues.add(botiga2);
		botigues.add(botiga3);
		botigues.add(botiga4);
		botigues.add(botiga5);
		
		when(botigaRepository.findAll()).thenReturn(botigues);
		
		ArrayList<Botiga> botiguesObt = (ArrayList<Botiga>) botigaService.obtenirBotigues();
		assertEquals(5, botiguesObt.size());
		verify(botigaRepository, times(1)).findAll();
	}
// ------------------------------------------------------------------------------------------------	
	@Test
	final void testObtenirBotigaId() {
		
		when (botigaRepository.findById(0)).thenReturn(Optional.of(botigaEntt));
				
		Botiga botigaDto = botigaService.obtenirBotigaId(botigaEntt.getId());
		
		assertNotNull(botigaDto);
		assertEquals(botigaEntt.getId(), botigaDto.getId());
		assertEquals(botigaEntt.getNom(), botigaDto.getNom());
		assertEquals(botigaEntt.getCapacitat(), botigaDto.getCapacitat());
	}
	
	@Test
	final void testObtenirBotigaIdNotFound() {
		
		when (botigaRepository.findById(0)).thenReturn(Optional.empty());
		
		// Assertions.assertThrows(NullPointerException.class, ()-> {codeThatThrowsNPE;})
		Exception exception =assertThrows(
				ResourceNotFoundException.class,
				()-> botigaService.obtenirBotigaId(0));
				
		assertEquals("La botiga amb id 0 no s'ha trobat", exception.getMessage());		
	}
// ------------------------------------------------------------------------------------------------	
	
	@Test
	final void testAfegirQuadre() {
		fail("Not yet implemented");
	}

	@Test
	final void testLlistarQuadresBotiga() {
		fail("Not yet implemented");
	}

	@Test
	final void testCremarQuadres() {
		fail("Not yet implemented");
	}

}
