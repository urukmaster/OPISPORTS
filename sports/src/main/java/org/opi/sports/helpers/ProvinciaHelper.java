package org.opi.sports.helpers;

import java.util.ArrayList;
import java.util.List;

import org.opi.sports.ejb.Canton;
import org.opi.sports.ejb.Distrito;
import org.opi.sports.ejb.Provincia;
import org.opi.sports.pojo.CantonPOJO;
import org.opi.sports.pojo.DistritoPOJO;
import org.opi.sports.pojo.ProvinciaPOJO;
import org.opi.sports.utils.PojoUtils;

public class ProvinciaHelper {
	
	private static ProvinciaHelper instance;

	private ProvinciaHelper() {
	}

	private synchronized static void createInstance() {
		if (instance == null) {
			instance = new ProvinciaHelper();
		}
	}

	public static ProvinciaHelper getInstance() {
		if (instance == null) {
			createInstance();
		}
		return instance;
	}

	public ProvinciaPOJO convertirProvincia(Provincia provincia) {

		ProvinciaPOJO provinciaView = new ProvinciaPOJO();		
		PojoUtils.pojoMappingUtility(provinciaView, provincia);
		
		List<CantonPOJO> listaCantones = new ArrayList<CantonPOJO>();
		
		for(Canton canton : provincia.getCantons()){
			listaCantones.add(convertirCantones(canton));
		}
		
		provinciaView.setListaCantones(listaCantones);
		
		return provinciaView;

	}

	private CantonPOJO convertirCantones(Canton canton) {

		CantonPOJO cantonView = new CantonPOJO();
		PojoUtils.pojoMappingUtility(cantonView, canton);
		
		List<DistritoPOJO> listaDistritos = new ArrayList<DistritoPOJO>();
		
		for(Distrito distrito : canton.getDistritos()){
			listaDistritos.add(convertirDistritos(distrito));
		}
		
		cantonView.setListaDistritos(listaDistritos);
		
		return cantonView;
	}

	private DistritoPOJO convertirDistritos(Distrito distrito) {

		DistritoPOJO distritoView = new DistritoPOJO();
		PojoUtils.pojoMappingUtility(distritoView, distrito);
		
		return distritoView;
	}

}
