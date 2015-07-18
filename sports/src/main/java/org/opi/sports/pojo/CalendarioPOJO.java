package org.opi.sports.pojo;

import java.util.Date;

import org.joda.time.DateTime;

public class CalendarioPOJO {

	private String title;
	private DateTime start;
	private DateTime end;
	private String backgroundColor;
	private String borderColor;
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
	
	public String toString(){
		String calendario = "title: '" + getTitle() + "'," +
                "start: '" + getStart() + "'," +
                "backgroundColor: '" + getBackgroundColor() + "'," +
                "borderColor: '" + getBorderColor() + "'";
		return calendario;
	}
}
