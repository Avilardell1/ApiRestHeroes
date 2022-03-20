package com.api.heroes.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.api.heroes.model.Heroe;
import com.api.heroes.repository.HeroeRepository;

@RestController
@RequestMapping("/api/heroes")
public class HeroeController {

	@Autowired
	HeroeRepository heroeRepository;
	
	@GetMapping(path="/", produces = "application/json")
    public List<Heroe> getAllHeroes()    {
        return heroeRepository.findAll();
    }
	
	@GetMapping(path="/{id}", produces = "application/json")
    public ResponseEntity<Heroe> getHeroeById(@PathVariable Long id) {	
        Optional<Heroe> heroe = heroeRepository.findById(id);
        return ResponseEntity.of(heroe);
    }
	
	@GetMapping(path="/heroe/{name}", produces = "application/json")
    public List<Heroe> getHeroeByName(@PathVariable String name) {	
        List<Heroe> listHeroe = heroeRepository.findAll();
        List<Heroe> listHeroeFinal = new ArrayList<Heroe>();
        for(Heroe h : listHeroe) {
        	if(h.getNombre().contains(name)) {
        		listHeroeFinal.add(h);
        	}     	
        }
        return listHeroeFinal;
    }
	
	@DeleteMapping(path="/delete", produces = "application/json")
    public void getHeroe(@PathVariable Long id) {	
		heroeRepository.deleteById(id);		
    }
	
	@PutMapping(path="/update", produces = "application/json")
    public String updateHeroe(@RequestBody Heroe heroe) {	
		int resultado = heroeRepository.updateHeroe(heroe.getId(), heroe.getNombre(), heroe.getApellido(), heroe.getEdad(), heroe.getNacionalidad());		
		if (resultado == 1) {
			return "Se ha actualizado el heroe correctamente";
		} else {
			return "No se ha podido actualizar el heroe";
		}
	}	
}
