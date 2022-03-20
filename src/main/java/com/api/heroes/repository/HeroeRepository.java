package com.api.heroes.repository;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import com.api.heroes.model.Heroe;

public interface HeroeRepository extends JpaRepository<Heroe, Long> {
	
	@Transactional
	@Modifying
	@Query("UPDATE Heroe h set h.nombre = ?2, h.apellido = ?3, h.edad = ?4, h.nacionalidad = ?5 where h.id = ?1")
	int updateHeroe(Long id, String nombre, String apellido, Integer edad, String nacionalidad);
	
}


