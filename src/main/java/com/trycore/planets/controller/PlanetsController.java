package com.trycore.planets.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trycore.planets.dto.PlanetDTO;
import com.trycore.planets.dto.response.PlanetsResponse;
import com.trycore.planets.service.PlanetsService;

@RestController
@RequestMapping(path = "/planets")
@CrossOrigin(origins = "http://localhost:3000")
public class PlanetsController {
	
	@Autowired
	private PlanetsService service;
	
	@GetMapping(path = "getAll")
	public ResponseEntity<PlanetsResponse> getAll(){
		return service.getAll();
	}
	
	@PatchMapping(path = "/incremetVisits/{planet-id}")
	public HttpStatus incremetVisits(@PathVariable("planet-id") Long planetId) {
		return service.incremetVisitsService(planetId);
	}
	
	@GetMapping(path = "getById/{planet-id}")
	public ResponseEntity<PlanetDTO> getById(@PathVariable("planet-id") Long planetId){
		return service.getById(planetId);
	}

}
