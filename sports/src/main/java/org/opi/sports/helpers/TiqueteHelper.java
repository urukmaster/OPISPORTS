package org.opi.sports.helpers;

import org.opi.sports.contracts.TiqueteRequest;
import org.opi.sports.ejb.Evento;
import org.opi.sports.ejb.Inscripcion;
import org.opi.sports.ejb.Tiquete;
import org.opi.sports.ejb.Usuario;
import org.opi.sports.pojo.InscripcionPOJO;
import org.opi.sports.pojo.TiquetePOJO;
import org.opi.sports.services.InscripcionServiceInterface;
import org.opi.sports.services.TiqueteServiceInterface;
import org.opi.sports.utils.PojoUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Fecha: 26-07-2015 version 1.0
 * 
 * @author Mauricio Fernández Mora.
 *
 *         Sprint 03 Descripción:Esta clase sirve de apoyo a la clase de
 *         TiquetesController y contiene la lógica necesaria para
 *         serializar los tiquetes y poder mostrarlas en el front end Esta
 *         clase se implementa como "Singleton" para asegurarnos que sea
 *         instanciada una sola vez.
 */


public class TiqueteHelper {

	private static TiqueteHelper instance;

	private TiqueteHelper() {
	}

	private synchronized static void createInstance() {
		if (instance == null) {
			instance = new TiqueteHelper();
		}
	}

	public static TiqueteHelper getInstance() {
		if (instance == null) {
			createInstance();
		}
		return instance;
	}
	
	@Autowired
	InscripcionServiceInterface inscripcionService;

	/**
	 *Este método convierte las instancias de tiquetesEJB en tiquetesPOJO
	 */	
	public TiquetePOJO convertirTiquete(Tiquete tiquete) {

		TiquetePOJO tiqueteView = new TiquetePOJO();
		
		Inscripcion inscripcion = new Inscripcion();
		
		inscripcion = tiquete.getInscripcion();
		
		PojoUtils.pojoMappingUtility(tiqueteView, tiquete);
		
		tiqueteView.setIdInscripcion(convertirInscripcion(inscripcion));
		
		return tiqueteView;

	}
	
	/**
	 *Este método convierte las instancias de InscripcionEJB en InscripcionPOJO
	 */	
	public InscripcionPOJO convertirInscripcion(Inscripcion inscripcion) {

		InscripcionPOJO inscripcionView = new InscripcionPOJO();		
		PojoUtils.pojoMappingUtility(inscripcionView, inscripcion);
		
		return inscripcionView;

	}
	
	/**
	 *Este método hace el registro de una inscripcion en la base de datos
	 */	
	public TiquetePOJO save(TiqueteRequest tiqueteRequest, TiqueteServiceInterface tiqueteService,
			Usuario usuario, Evento evento, Inscripcion inscripcion) {
		
		inscripcion.setUsuario(usuario);
		
		Tiquete tiquete = new Tiquete();
		
		if(tiqueteRequest.getAccion().equals("Modificar")){
			tiquete.setIdTiquete(tiqueteRequest.getIdTiquete());
		}
		
		long current = System.currentTimeMillis();
		
		tiquete.setActive(tiqueteRequest.getActive());
		tiquete.setEstado(tiqueteRequest.getEstado());
		tiquete.setEvento(evento);
		tiquete.setFechaCaducidad(tiqueteRequest.getFechaCaducidad());
		tiquete.setInscripcion(inscripcion);
		tiquete.setPrecio(tiqueteRequest.getPrecio());
		tiquete.setNombreEvento(tiqueteRequest.getNombreEvento());
		tiquete.setCodigo(tiqueteRequest.getCodigo() + current);

		TiquetePOJO tiquetePOJO = new TiquetePOJO();

		PojoUtils.pojoMappingUtility(tiquetePOJO,
				tiqueteService.save(tiquete));

		return tiquetePOJO;
		
	}

}
