package org.opi.sports.pojo;

import org.joda.time.DateTime;

public class EventoCalendarioPOJO {

	private String title;
	private DateTime start;
	private DateTime end;
	private String backgroundColor;
	private String borderColor;
	private int idEvento;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public DateTime getStart() {
		return start;
	}
	public void setStart(DateTime start) {
		this.start = start;
	}
	public DateTime getEnd() {
		return end;
	}
	public void setEnd(DateTime end) {
		this.end = end;
	}
	public String getBackgroundColor() {
		return backgroundColor;
	}
	public void setBackgroundColor(String backgroundColor) {
		this.backgroundColor = backgroundColor;
	}
	public String getBorderColor() {
		return borderColor;
	}
	public void setBorderColor(String borderColor) {
		this.borderColor = borderColor;
	}
	public int getIdEvento() {
		return idEvento;
	}
	public void setIdEvento(int idEvento) {
		this.idEvento = idEvento;
	}
	
	public String toString(){
		String calendario = "title: '" + getTitle() + "'," +
                "start: '" + getStart() + "'," +
                "backgroundColor: '" + getBackgroundColor() + "'," +
                "borderColor: '" + getBorderColor() + "'";
		return calendario;
	}
}
