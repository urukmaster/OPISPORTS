package org.opi.sports.repositories;
import java.util.List;

import org.opi.sports.ejb.Reservaciones;
import org.opi.sports.ejb.Reto;
import org.springframework.data.repository.CrudRepository;

public interface RetoRepository extends CrudRepository<Reto,Integer>{
	
	public List<Reto> findAll();
	
	public <S extends Reto> S save(S reto);
}
