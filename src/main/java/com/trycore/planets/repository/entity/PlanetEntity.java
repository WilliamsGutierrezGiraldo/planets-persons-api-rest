package com.trycore.planets.repository.entity;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PLANETS")
public class PlanetEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String rotationPeriod;
	private String name;
	private BigDecimal diameter;
	private String weather;
	private String land;
	private Long numberOfVisits;
	@OneToMany(mappedBy = "planet", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<PersonEntity> persons;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getDiameter() {
		return diameter;
	}
	public void setDiameter(BigDecimal diameter) {
		this.diameter = diameter;
	}
	public String getWeather() {
		return weather;
	}
	public void setWeather(String weather) {
		this.weather = weather;
	}
	public String getLand() {
		return land;
	}
	public void setLand(String land) {
		this.land = land;
	}
	public Long getNumberOfVisits() {
		return numberOfVisits;
	}
	public void setNumberOfVisits(Long numberOfVisits) {
		this.numberOfVisits = numberOfVisits;
	}
	public String getRotationPeriod() {
		return rotationPeriod;
	}
	public void setRotationPeriod(String rotationPeriod) {
		this.rotationPeriod = rotationPeriod;
	}
	public List<PersonEntity> getPersons() {
		return persons;
	}
	public void setPersons(List<PersonEntity> persons) {
		this.persons = persons;
	}
	
}
