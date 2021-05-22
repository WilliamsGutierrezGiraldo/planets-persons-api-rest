package com.trycore.planets.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.trycore.planets.dto.PlanetDTO;
import com.trycore.planets.dto.response.PlanetsResponse;
import com.trycore.planets.repository.PlanetRepository;
import com.trycore.planets.repository.entity.PlanetEntity;
import com.trycore.planets.service.PlanetsService;

@Service
public class PlanetsServiceImpl implements PlanetsService {
	
	@Autowired
	private PlanetRepository repository;

	@Override
	public ResponseEntity<PlanetsResponse> getAll() {
		List<PlanetEntity> entities = (List<PlanetEntity>) repository.
				findAll(Sort.by(Sort.Direction.DESC, "numberOfVisits"));
		List<PlanetDTO> dtos = new ArrayList<>();
		PlanetsResponse responseBody = new PlanetsResponse();
		for (PlanetEntity entity : entities) {
			dtos.add(entityToDTO(entity));
		}
		responseBody.setPlanets(dtos);
		return ResponseEntity.status(HttpStatus.OK).body(responseBody);
	}
	

	@Override
	public HttpStatus incremetVisitsService(Long planetId) {
		if(incrementVisitsInRepo(planetId) == BigDecimal.ONE.intValue()) {
			return HttpStatus.OK;
		}
		return HttpStatus.BAD_REQUEST;
	}

	@Override
	public int incrementVisitsInRepo(Long planetId) {
		Optional<PlanetEntity> op = repository.findById(planetId);
		if(op.isPresent()) {
			PlanetEntity entity = op.get();
			Long previousValue = entity.getNumberOfVisits();
			Long actualValue = previousValue + 1L;
			entity.setNumberOfVisits(actualValue);
			repository.save(entity);
			return 1;
		}
		return 0;
	}

	@Override
	public ResponseEntity<PlanetDTO> getById(Long planetId) {
		PlanetDTO dto = new PlanetDTO();
		Optional<PlanetEntity> op = repository.findById(planetId);
		if(op.isPresent()) {
			PlanetEntity entity = op.get();
			dto = entityToDTO(entity);
		}
		return ResponseEntity.status(HttpStatus.OK).body(dto);
	}

	public PlanetDTO entityToDTO(PlanetEntity entity) {
		PlanetDTO dto = new PlanetDTO();
		dto.setId(entity.getId());
		dto.setDiameter(entity.getDiameter());
		dto.setLand(entity.getLand());
		dto.setName(entity.getName());
		dto.setNumberOfVisits(entity.getNumberOfVisits());
		dto.setRotationPeriod(entity.getRotationPeriod());
		dto.setWeather(entity.getWeather());
		dto.setPopulation(Long.valueOf(entity.getPersons().size()));
		return dto;
	}
	
}
