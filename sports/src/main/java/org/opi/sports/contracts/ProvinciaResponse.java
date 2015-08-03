package org.opi.sports.contracts;

import java.util.List;

import org.opi.sports.pojo.ProvinciaPOJO;

public class ProvinciaResponse extends BaseResponse {

	private ProvinciaPOJO provincia;
	
	private List<ProvinciaPOJO> provincias;

	public ProvinciaPOJO getProvincia() {
		return provincia;
	}

	public void setProvincia(ProvinciaPOJO provincia) {
		this.provincia = provincia;
	}

	public List<ProvinciaPOJO> getProvincias() {
		return provincias;
	}

	public void setProvincias(List<ProvinciaPOJO> provincias) {
		this.provincias = provincias;
	}
	
}
