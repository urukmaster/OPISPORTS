package org.opi.sports.contracts;

import java.util.List;

import org.opi.sports.pojo.CalendarioPOJO;
import org.opi.sports.pojo.EventoPOJO;

/**
 * Fecha: 14-07-2015 version 1.0
 * 
 * @author Mauricio Fernández Mora.
 *
 *Sprint 02 Descripción:Esta clase simula un httpservlet, 
 *simula las respuestas al front end.
 */

public class EventoResponse extends BaseResponse{

	private List<EventoPOJO> evento;
	private List<CalendarioPOJO> JSONCalendar;

	public List<EventoPOJO> getEvento() {
		return evento;
	}

	public void setEvento(List<EventoPOJO> evento) {
		this.evento = evento;
	}

	public List<CalendarioPOJO> getJSONCalendar() {
		return JSONCalendar;
	}

	public void setJSONCalendar(List<CalendarioPOJO> jSONCalendar) {
		JSONCalendar = jSONCalendar;
	}
}
