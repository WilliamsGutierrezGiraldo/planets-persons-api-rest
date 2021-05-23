package com.trycore.planets.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.trycore.planets.dto.PersonDTO;
import com.trycore.planets.dto.response.PersonsResponse;
import com.trycore.planets.repository.PersonRepository;
import com.trycore.planets.repository.entity.PersonEntity;
import com.trycore.planets.service.PersonsService;
import com.trycore.planets.service.PlanetsService;

@Service
public class PersonsServiceImpl implements PersonsService {
	
	@Autowired
	private PersonRepository repository;
	
	@Autowired
	private PlanetsService planetService;

	@Override
	public ResponseEntity<PersonsResponse> getAll() {
		List<PersonEntity> entities = (List<PersonEntity>) repository.
				findAll(Sort.by(Direction.DESC, "numberOfVisits"));
		List<PersonDTO> dtos = new ArrayList<>();
		PersonsResponse responseBody = new PersonsResponse();
		for (PersonEntity entity : entities) {
			dtos.add(entityToDTO(entity));
		}
		responseBody.setPersons(dtos);
		return ResponseEntity.status(HttpStatus.OK).body(responseBody);
	}
	
	@Override
	public ResponseEntity<PersonsResponse> findByPlanetId(Long planetId) {
		List<PersonEntity> entities = (List<PersonEntity>) repository.findByPlanetId(planetId);
		List<PersonDTO> dtos = new ArrayList<>();
		PersonsResponse responseBody = new PersonsResponse();
		for (PersonEntity entity : entities) {
			dtos.add(entityToDTO(entity));
		}
		responseBody.setPersons(dtos);
		return ResponseEntity.status(HttpStatus.OK).body(responseBody);
	}
	
	@Override
	public HttpStatus incremetVisitsService(Long personId) {
		if(incrementVisitsInRepo(personId) == BigDecimal.ONE.intValue()) {
			return HttpStatus.OK;
		}
		return HttpStatus.BAD_REQUEST;
	}
	
	@Override
	public int incrementVisitsInRepo(Long personId) {
		Optional<PersonEntity> op = repository.findById(personId);
		if(op.isPresent()) {
			PersonEntity entity = op.get();
			Long previousValue = entity.getNumberOfVisits();
			Long actualValue = previousValue + 1L;
			entity.setNumberOfVisits(actualValue);
			repository.save(entity);
			// Se debe incrementar en 1 el contador del planeta
			planetService.incrementVisitsInRepo(entity.getPlanet().getId());
			return 1;
		}
		return 0;
	}
	
	@Override
	public ResponseEntity<PersonsResponse> findTop3ByOrderByNumberOfVisitsDesc() {
		List<PersonEntity> entities = (List<PersonEntity>) repository.
				findTop3ByOrderByNumberOfVisitsDesc();
		List<PersonDTO> dtos = new ArrayList<>();
		PersonsResponse responseBody = new PersonsResponse();
		for (PersonEntity entity : entities) {
			dtos.add(entityToDTO(entity));
		}
		responseBody.setPersons(dtos);
		return ResponseEntity.status(HttpStatus.OK).body(responseBody);
	}
	
	@Override
	public ResponseEntity<PersonDTO> findById(Long personId) {
		Optional<PersonEntity> op = repository.findById(personId);
		PersonDTO dto = new PersonDTO();
		if(op.isPresent()) {
			PersonEntity entity = op.get();
			dto = entityToDTO(entity);
		}
		return ResponseEntity.status(HttpStatus.OK).body(dto);
	}
	
	public PersonDTO entityToDTO(PersonEntity entity) {
		PersonDTO dto = new PersonDTO();
		dto.setAge(entity.getAge());
		dto.setDateOfBirth(entity.getDateOfBirth());
		dto.setGender(entity.getGender());
		dto.setHeight(entity.getHeight());
		dto.setId(entity.getId());
		dto.setLastname(entity.getLastname());
		dto.setName(entity.getName());
		dto.setNumberOfVisits(entity.getNumberOfVisits());
		dto.setPlanetId(entity.getPlanet().getId());
		dto.setWeight(entity.getWeight());
		dto.setPlanetName(entity.getPlanet().getName());
		return dto;
	}

}
