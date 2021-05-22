package com.trycore.planets.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.trycore.planets.repository.entity.PlanetEntity;

@Repository
public interface PlanetRepository extends CrudRepository<PlanetEntity, Long> {
	
	public List<PlanetEntity> findAll(Sort sort);
	public List<PlanetEntity> findTop3ByOrderByNumberOfVisitsDesc();

}
