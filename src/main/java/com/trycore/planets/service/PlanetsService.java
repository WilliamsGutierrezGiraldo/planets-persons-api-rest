package com.trycore.planets.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.trycore.planets.dto.PlanetDTO;
import com.trycore.planets.dto.response.PlanetsResponse;

public interface PlanetsService {
	
	public ResponseEntity<PlanetsResponse> getAll();
	public HttpStatus incremetVisitsService(Long planetId);
	public int incrementVisitsInRepo(Long planetId);
	public ResponseEntity<PlanetDTO> getById(Long planetId);
	public ResponseEntity<PlanetsResponse> getTop3ByNumberOfVisits();

}
