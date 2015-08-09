package org.opi.sports.helpers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.opi.sports.contracts.EstablecimientoDeportivoRequest;
import org.opi.sports.contracts.ServicioRequest;
import org.opi.sports.ejb.Distrito;
import org.opi.sports.ejb.EstablecimientoDeportivo;
import org.opi.sports.ejb.Reservaciones;
import org.opi.sports.ejb.Reto;
import org.opi.sports.ejb.Review;
import org.opi.sports.ejb.Servicio;
import org.opi.sports.ejb.Usuario;
import org.opi.sports.pojo.EstablecimientoDeportivoPOJO;
import org.opi.sports.pojo.ReservacionesPOJO;
import org.opi.sports.pojo.RetosPOJO;
import org.opi.sports.pojo.ReviewsPOJO;
import org.opi.sports.pojo.ServicioPOJO;
import org.opi.sports.services.EstablecimientoDeportivoServiceInterface;
import org.opi.sports.services.ServicioServiceInterface;
import org.opi.sports.utils.PojoUtils;

/**
 * Fecha: 17-07-2015 version 1.0
 * @author Mauricio Araica Hernández
 *Sprint 02 Descripción: Helper de establecimientos deportivos
 *
 */
public class EstablecimientoDeportivoHelper {
	
	private static EstablecimientoDeportivoHelper instance;

	private EstablecimientoDeportivoHelper() {
	}

	private synchronized static void createInstance() {
		if (instance == null) {
			instance = new EstablecimientoDeportivoHelper();
		}
	}

	public static EstablecimientoDeportivoHelper getInstance() {
		if (instance == null) {
			createInstance();
		}
		return instance;
	}

	public EstablecimientoDeportivoPOJO convertirEstablecimiento(
			EstablecimientoDeportivo establecimiento) {

		EstablecimientoDeportivoPOJO establecimientoView = new EstablecimientoDeportivoPOJO();
		
		PojoUtils.pojoMappingUtility(establecimientoView, establecimiento);
		
		List<ServicioPOJO> servicios = new ArrayList<ServicioPOJO>();
		List<ReviewsPOJO> reviews =  new ArrayList<ReviewsPOJO>();
		
		for(Servicio servicio: establecimiento.getServicios()){
			if(servicio.getActive() == 1){
			servicios.add(convertirServicios(servicio));
			}
		}		
		reviews = obtenerReviews(establecimiento);
		
		establecimientoView.setReviews(reviews);
		establecimientoView.setServicios(servicios);
		establecimientoView.setCalendario();
		establecimientoView.setPendientes();
		return establecimientoView;
	}

	private List<ReviewsPOJO> obtenerReviews(EstablecimientoDeportivo establecimiento) {
		List<ReviewsPOJO> reviews =  new ArrayList<ReviewsPOJO>();
		for(Review review : establecimiento.getReviews()){
			reviews.add(convertirReview(review));
		}
		return reviews;
	}

	private ReviewsPOJO convertirReview(Review preview) {
		ReviewsPOJO reviewpojo = new ReviewsPOJO();
		reviewpojo.setIdComentario(preview.getIdComentario());
		reviewpojo.setCalificacion(preview.getCalificacion());
		reviewpojo.setReview(preview.getReview());
		reviewpojo.setIdEstablecimientoDeportivo(preview.getEstablecimientoDeportivo().getIdEstablecimientoDeportivo());
		reviewpojo.setNombreUsuario(preview.getUsuario().getNombre());
		reviewpojo.setIdUsuario(preview.getUsuario().getIdUsuario());
		reviewpojo.setActive(preview.getActive());
		
	return reviewpojo;
	
	}

	private ServicioPOJO convertirServicios(Servicio servicio) {

		ServicioPOJO servicioView = new ServicioPOJO();
		PojoUtils.pojoMappingUtility(servicioView, servicio);
		
		List<ReservacionesPOJO> reservaciones = new ArrayList<ReservacionesPOJO>();
		
		for(Reservaciones reservacion : servicio.getReservaciones()){
			if(reservacion.getActive() == (byte) 1){
			reservaciones.add(convertirReservaciones(reservacion));
			}
		}
		
		servicioView.setReservaciones(reservaciones);

		servicioView.setHoraInicial(new DateTime(servicio.getHoraApertura()));
		servicioView.setHoraFinal(new DateTime(servicio.getHoraCierre()));
		
		return servicioView;
	}

	private ReservacionesPOJO convertirReservaciones(Reservaciones reservacion) {
		
		ReservacionesPOJO reservacionesPOJO = new ReservacionesPOJO();
		PojoUtils.pojoMappingUtility(reservacionesPOJO, reservacion);
		
		return reservacionesPOJO;
	}
	/**
	 * Metodo encargado de registrar el establecimiento deportivo
	 * 
	 */
	public EstablecimientoDeportivoPOJO saveEstablecimiento(EstablecimientoDeportivoRequest establecimientoRequest,
			EstablecimientoDeportivoServiceInterface establecimientoService) {
		
 		EstablecimientoDeportivo establecimientoEJB = new EstablecimientoDeportivo();

		if(establecimientoRequest.getAccion().equals("Modificar")){
			establecimientoEJB.setIdEstablecimientoDeportivo(establecimientoRequest.getIdEstablecimientoDeportivo());
		}
		
		establecimientoEJB.setNombre(establecimientoRequest.getNombre());
		establecimientoEJB.setDireccion(establecimientoRequest.getDireccion());
		establecimientoEJB.setTelefono(establecimientoRequest.getTelefono());
		establecimientoEJB.setPaginaWeb(establecimientoRequest.getPaginaWeb());
		
		Distrito distrito = new Distrito();
		distrito.setIdDistrito(establecimientoRequest.getIdDistrito());
		establecimientoEJB.setDistrito(distrito);
		
		Usuario usuario = new Usuario();
		usuario.setIdUsuario(establecimientoRequest.getIdUsuario());
		establecimientoEJB.setUsuario(usuario);
		
		establecimientoEJB.setActive((byte)1);
		
		EstablecimientoDeportivoPOJO establecimientoPOJO = new EstablecimientoDeportivoPOJO();

		PojoUtils.pojoMappingUtility(establecimientoPOJO,
				establecimientoService.save(establecimientoEJB));
		
		return establecimientoPOJO;
	}

}
