package org.opi.sports.contracts;

import java.util.List;

import org.joda.time.DateTime;
import org.opi.sports.ejb.Evento;
import org.opi.sports.pojo.CalendarioPOJO;
import org.opi.sports.pojo.EventoCalendarioPOJO;
import org.opi.sports.pojo.EventoPOJO;

/**
 * Fecha: 14-07-2015 version 1.0
 * 
 * @author Mauricio Fernández Mora.
 *
 *Sprint 02 Descripción:Esta clase simula un httpservlet, 
 *simula las respuestas al front end.
 */

public class TorneoResponse extends BaseResponse{

	private List<EventoPOJO> eventos;
	private List<EventoCalendarioPOJO> JSONCalendar;
	private EventoPOJO evento;
	
	private DateTime fecha;
	private DateTime hora;
	
	public List<EventoPOJO> getEventos() {
		return eventos;
	}
	public void setEventos(List<EventoPOJO> eventos) {
		this.eventos = eventos;
	}
	public List<EventoCalendarioPOJO> getJSONCalendar() {
		return JSONCalendar;
	}
	public void setJSONCalendar(List<EventoCalendarioPOJO> jSONCalendar) {
		JSONCalendar = jSONCalendar;
	}
	public EventoPOJO getEvento() {
		return evento;
	}
	public void setEvento(EventoPOJO evento) {
		this.evento = evento;
	}
	public DateTime getFecha() {
		return fecha;
	}
	public void setFecha() {
		DateTime fechaEvento = new DateTime(evento.getFecha());
		this.fecha = fechaEvento;
	}
	public DateTime getHora() {
		return hora;
	}
	public void setHora() {
		DateTime horaEvento = new DateTime(evento.getHora());
		this.hora = horaEvento;
	}
}