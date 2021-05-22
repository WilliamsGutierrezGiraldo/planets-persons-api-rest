package com.trycore.planets.dto.response;

import java.util.List;

import com.trycore.planets.dto.PlanetDTO;

public class PlanetsResponse {
	
	private List<PlanetDTO> planets = null;

	public List<PlanetDTO> getPlanets() {
		return planets;
	}

	public void setPlanets(List<PlanetDTO> planets) {
		this.planets = planets;
	}

}
