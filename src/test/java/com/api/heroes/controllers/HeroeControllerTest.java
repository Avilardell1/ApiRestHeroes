package com.api.heroes.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import com.api.heroes.model.Heroe;
import com.api.heroes.repository.HeroeRepository;

@SpringBootTest
public class HeroeControllerTest {
	
	@InjectMocks
	private HeroeController heroeController;
	
	@Mock
	private HeroeRepository heroeRepository;
	
	@Test
	public void getHeroeByName() {
		List<Heroe> h = new ArrayList<Heroe>();
		Heroe h1 = new Heroe();
		h1.setNombre("Spiderman");
		h1.setApellido("Prova");
		h.add(h1);		
		List<Heroe> heroes = heroeController.getHeroeByName("man");
	    assertEquals(heroes.get(0).getNombre(), "Superman");
	 }
}
