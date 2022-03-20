package com.api.heroes.initializer;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.api.heroes.model.Heroe;
import com.api.heroes.repository.HeroeRepository;

@Component
public class HeroeInitializer implements CommandLineRunner {

	@Autowired
	HeroeRepository heroeRepository;

	@Override
	public void run(String... args) throws Exception {
	
		List<Heroe> listHeroe = new ArrayList<Heroe>();
		Heroe h = new Heroe();
		h.setNombre("Superman");
		h.setApellido("Marvel");
		h.setEdad(30);
		h.setNacionalidad("Andorra");
		listHeroe.add(h);
		h = new Heroe();
		h.setNombre("Batman");
		h.setApellido("Marvel");
		h.setEdad(40);
		h.setNacionalidad("España");
		listHeroe.add(h);
		h = new Heroe();
		h.setNombre("Robin");
		h.setApellido("Marvel");
		h.setEdad(35);
		h.setNacionalidad("España");
		listHeroe.add(h);
		h = new Heroe();
		h.setNombre("Spiderman");
		h.setApellido("Marvel");
		h.setEdad(38);
		h.setNacionalidad("Alemania");
		listHeroe.add(h);
		h = new Heroe();
		h.setNombre("Superwoman");
		h.setApellido("Marvel");
		h.setEdad(30);
		h.setNacionalidad("Francia");
		listHeroe.add(h);		
		
		for(int i=0; i<listHeroe.size(); i++) {
			Heroe heroe = listHeroe.get(i);
			heroeRepository.save(heroe);
		}		
	}
}
