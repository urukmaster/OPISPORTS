package org.opi.sports.pojo;

import java.sql.Time;
import java.util.List;

import org.joda.time.DateTime;

public class ServicioRetoPOJO {
	private int idServicio;
	private byte arbitro;
	private Time horaApertura;
	private Time horaCierre;
	private String precio;
	private String servicio;
	private DateTime horaInicial;	
	private DateTime horaFinal;
	private EstablecimientoDeportivoPOJO establecimientiPojo;
}
