package com.trycore.planets.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.trycore.planets.dto.response.PersonsResponse;

public interface PersonsService {
	
	public ResponseEntity<PersonsResponse> getAll();
	public ResponseEntity<PersonsResponse> findByPlanetId(Long planetId);
	public HttpStatus incremetVisitsService(Long personId);
	public int incrementVisitsInRepo(Long personId);
	public ResponseEntity<PersonsResponse> findTop3ByOrderByNumberOfVisitsDesc();

}
