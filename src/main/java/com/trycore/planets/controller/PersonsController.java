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

import com.trycore.planets.dto.response.PersonsResponse;
import com.trycore.planets.service.PersonsService;

@RestController
@RequestMapping(path = "/persons")
@CrossOrigin(origins = "http://localhost:3000")
public class PersonsController {
	
	@Autowired
	private PersonsService service;
	
	@GetMapping(path = "/getAll")
	public ResponseEntity<PersonsResponse> getAll() {
		return service.getAll();
	}
	
	@GetMapping(path = "/findByPlanetId/{planet-id}")
	public ResponseEntity<PersonsResponse> findByPlanetId(@PathVariable("planet-id") Long planetId) {
		return service.findByPlanetId(planetId);
	}
	
	@PatchMapping(path = "/incremetVisits/{person-id}")
	public HttpStatus incremetVisits(@PathVariable("person-id") Long personId) {
		return service.incremetVisitsService(personId);
	}

}
