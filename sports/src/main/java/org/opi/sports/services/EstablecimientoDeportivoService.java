package org.opi.sports.services;

import java.util.List;

import org.opi.sports.contracts.EstablecimientoDeportivoRequest;
import org.opi.sports.ejb.EstablecimientoDeportivo;
import org.opi.sports.repositories.EstablecimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
public class EstablecimientoDeportivoService implements EstablecimientoDeportivoServiceInterface{
	
	@Autowired
	public EstablecimientoRepository establecimientoDeportivoRepository;

	@Override
	@Transactional
	public Page<EstablecimientoDeportivo> findAll(EstablecimientoDeportivoRequest establecimientoRequest) {
	
		PageRequest pageRequest;
		Sort.Direction direction = Sort.Direction.DESC;
		if(establecimientoRequest.getDirection().equals("ASC")){
			direction = Sort.Direction.ASC;
		}
		
		if(establecimientoRequest.getSortBy().size() > 0){
			Sort sort = new Sort(direction,establecimientoRequest.getSortBy());
			pageRequest = new PageRequest(establecimientoRequest.getPageNumber(),
					establecimientoRequest.getPageSize(),sort);
		}else{
			pageRequest = new PageRequest(establecimientoRequest.getPageNumber(),
					establecimientoRequest.getPageSize());
		}
		
		Page<EstablecimientoDeportivo> result = null;
		
		if(establecimientoRequest.getSearchColumn().toLowerCase().equals("all")){
			result = establecimientoDeportivoRepository.findAll(pageRequest);
		}
		return result;
	}

}
