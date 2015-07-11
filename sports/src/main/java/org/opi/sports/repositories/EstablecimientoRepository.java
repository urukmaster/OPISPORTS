package org.opi.sports.repositories;

import java.util.List;

import org.opi.sports.ejb.EstablecimientoDeportivo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;



public interface EstablecimientoRepository extends CrudRepository<EstablecimientoDeportivo, Integer>{
	
public static final int PAGE_SIZE = 5;
	
	
	Page<EstablecimientoDeportivo> findAll(Pageable pageable);


}