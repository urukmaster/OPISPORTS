package org.opi.sports.repositories;

import java.util.List;

import org.opi.sports.ejb.Servicio;
import org.springframework.data.repository.CrudRepository;

/**
 * Fecha: 20-07-2015 version 1.0
 * 
 * @author Luis Esteban López Ramírez
 * 
 *Sprint #4 Descripción: Repositorio que se encarga de hacer las consulta a
 *la base de datos.
 */
public interface ServicioRepository extends CrudRepository<Servicio, Integer>{
	
	public List<Servicio> findAll();
	public Servicio findOne(Integer idServicio);
	public <Servicios extends Servicio> Servicios save(Servicios servicio);
	
}
