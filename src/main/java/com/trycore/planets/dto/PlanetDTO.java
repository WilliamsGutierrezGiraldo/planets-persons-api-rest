package com.trycore.planets.dto;

import java.math.BigDecimal;

public class PlanetDTO {
	
	private Long id;
	private String rotationPeriod;
	private String name;
	private BigDecimal diameter;
	private String weather;
	private String land;
	private Long numberOfVisits;
	private Long population;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRotationPeriod() {
		return rotationPeriod;
	}
	public void setRotationPeriod(String rotationPeriod) {
		this.rotationPeriod = rotationPeriod;
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
	public Long getPopulation() {
		return population;
	}
	public void setPopulation(Long population) {
		this.population = population;
	}
	
}
