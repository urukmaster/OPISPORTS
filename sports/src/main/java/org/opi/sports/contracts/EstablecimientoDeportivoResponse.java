package org.opi.sports.contracts;
import org.opi.sports.pojo.EstablecimientoDeportivoPOJO;
import java.util.List;

public class EstablecimientoDeportivoResponse extends BaseResponse {
	
	private List<EstablecimientoDeportivoPOJO> establecimientoDeportivo;
	

	public List<EstablecimientoDeportivoPOJO> getEstablecimientoDeportivo() {
		return establecimientoDeportivo;
	}

	public void setEstablecimientoDeportivo(List<EstablecimientoDeportivoPOJO> establecimientoDeportivo) {
		this.establecimientoDeportivo = establecimientoDeportivo;
	}

}
