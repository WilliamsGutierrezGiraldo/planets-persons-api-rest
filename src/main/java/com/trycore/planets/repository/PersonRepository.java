package com.trycore.planets.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.trycore.planets.repository.entity.PersonEntity;

@Repository
public interface PersonRepository extends CrudRepository<PersonEntity, Long> {

	@Query(
		value = "SELECT * FROM PERSONS P WHERE P.FK_PLANET = :PLANET_ID",
		nativeQuery = true
	)
	public List<PersonEntity> findByPlanetId(@Param("PLANET_ID") Long planetId);
	
	public List<PersonEntity> findAll(Sort sort);
}
