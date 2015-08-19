package org.opi.sports.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.opi.sports.config.OpiSportsApplication;
import org.opi.sports.contracts.TiqueteRequest;
import org.opi.sports.contracts.TiqueteResponse;
import org.opi.sports.ejb.Evento;
import org.opi.sports.ejb.Inscripcion;
import org.opi.sports.ejb.Tiquete;
import org.opi.sports.ejb.Usuario;
import org.opi.sports.helpers.TiqueteHelper;
import org.opi.sports.pojo.TiquetePOJO;
import org.opi.sports.services.EventoServiceInterface;
import org.opi.sports.services.InscripcionServiceInterface;
import org.opi.sports.services.TiqueteServiceInterface;
import org.opi.sports.services.UsuarioServiceInterface;
import org.opi.sports.utils.PojoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



/**
 * Fecha: 25-07-2015 version 1.0
 * 
 * @author Mauricio Fernández Mora.
 *
 *Sprint 03 Descripción:Esta clase es la que contendrá cada uno de los servicios que
 *serán necesarios para procesar la información de los tiquetes de eventos de la aplicación
 */
//Se especifica con que correrá el JUNIT
@RunWith(SpringJUnit4ClassRunner.class)
//Se debe cargar la configuración del servidor
@SpringApplicationConfiguration(classes = OpiSportsApplication.class)
@WebAppConfiguration
public class TiqueteTest {
	
	@Autowired
	TiqueteServiceInterface tiqueteServices;
	
	@Autowired
	EventoServiceInterface eventoServices;
	
	@Autowired
	UsuarioServiceInterface usuarioServices;
	
	@Autowired
	InscripcionServiceInterface inscripcionServices;
	

	/**
	 *Este método obtiene cada una de las instancias de tiquetes
	 *registrados en la base de datos
	 */	
	@Test
	public void getAll(){	
		
		TiqueteResponse tiqueteResponse = new TiqueteResponse();
		
		List<Tiquete> tiqueteList = tiqueteServices.getAllTiquetes();
	    List<TiquetePOJO> tiqueteViewList = new ArrayList<TiquetePOJO>();
		
		for(Tiquete tiquete : tiqueteList){
			
			if(tiquete.getActive() == 1){
				tiqueteViewList.add(TiqueteHelper.getInstance().convertirTiquete(tiquete));
			}
		}
		
		tiqueteResponse.setTiquetes(tiqueteViewList);
		
		assertNotNull(tiqueteViewList);
		
	}

	/**
	 *Este método obtiene un tiquete a un evento
	 *registrado en la base de datos por medio de su id
	 */	
	@Test
	public void getTiquete(){
		
		TiqueteResponse tiqueteResponse = new TiqueteResponse();
		
		Tiquete tiquete = tiqueteServices.findOne(1);
		
		TiquetePOJO tiqueteView = new TiquetePOJO();
		PojoUtils.pojoMappingUtility(tiqueteView, tiquete);
		
		tiqueteResponse.setTiquete(tiqueteView);
		
		assertNotNull(tiqueteView);
		assertNotNull(tiqueteView.getIdTiquete());
		
	}
		
	/**
	 * Metodo de registrar una inscripcion
	 * 
	 */
	@Test
	public void save(){

		TiqueteRequest tiqueteRequest = new TiqueteRequest();
		
		tiqueteRequest.setAccion("Registrar");
		tiqueteRequest.setActive((byte)1);
		tiqueteRequest.setCantidad(5);
		tiqueteRequest.setCodigo("Codigo");
		tiqueteRequest.setEstado("Pendiente");
		tiqueteRequest.setFechaCaducidad(new Date());
		tiqueteRequest.setInscripcion(1);
		tiqueteRequest.setNombreEvento("Evento");
		tiqueteRequest.setPrecio("10000");
		tiqueteRequest.setUsuario(1);
		tiqueteRequest.setEvento(1);
		
		TiqueteResponse tiqueteResponse = new TiqueteResponse();
		
		Usuario usuario = usuarioServices.findOne(tiqueteRequest.getUsuario());
		
		Evento evento = eventoServices.findOne(tiqueteRequest.getEvento());
		
		Inscripcion inscripcion = new Inscripcion();
		
		inscripcion = inscripcionServices.save(inscripcion);
		
		for(int i = 0; i < tiqueteRequest.getCantidad(); i++){

			TiquetePOJO tiqueteView = TiqueteHelper.getInstance().save(tiqueteRequest, tiqueteServices,
					usuario, evento, inscripcion);
			
			if(tiqueteServices.exists(tiqueteView.getIdTiquete())){
				List<TiquetePOJO> tiquetes = new ArrayList<TiquetePOJO>();
				tiquetes.add(tiqueteView);
				tiqueteResponse.setTiquetes(tiquetes);
				tiqueteResponse.setCode(200);
				tiqueteResponse.setCodeMessage("La inscripción se registro correctamente");
			}else{
				tiqueteResponse.setCode(401);
				tiqueteResponse.setCodeMessage("La inscripción no se registro");
			}
			
		}
		
		assertNotNull(tiqueteResponse.getTiquete());
	}

	/**
	 * Metodo de canelar un tiquete
	 * 
	 */
	@Test
	public void delete() {
		
		Tiquete tiquete = tiqueteServices.findOne(1);
		tiquete.setActive((byte) 0);
		
		TiquetePOJO tiquetePOJO = new TiquetePOJO();

		tiqueteServices.save(tiquete);
		
		PojoUtils.pojoMappingUtility(tiquetePOJO, tiquete);
		
		assertNotNull(tiquetePOJO);

	}

}
