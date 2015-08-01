package org.opi.sports.contracts;

import java.util.List;

import org.joda.time.DateTime;
import org.opi.sports.pojo.RetosPOJO;

public class RetoResponse {
	private List<RetosPOJO> retospojo;

	public List<RetosPOJO> getRetospojo() {
		return retospojo;
	}

	public void setRetospojo(List<RetosPOJO> retospojo) {
		this.retospojo = retospojo;
	}
}
