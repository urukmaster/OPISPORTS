package org.opi.sports.contracts;

import java.util.List;

import org.opi.sports.pojo.CentroDistribucionPOJO;

public class CentroDistribucionResponse extends BaseResponse{
	
	private List<CentroDistribucionPOJO> centrosDistribucion;

	public List<CentroDistribucionPOJO> getCentrosDistribucion() {
		return centrosDistribucion;
	}

	public void setCentrosDistribucion(List<CentroDistribucionPOJO> centrosDistribucion) {
		this.centrosDistribucion = centrosDistribucion;
	}
}
