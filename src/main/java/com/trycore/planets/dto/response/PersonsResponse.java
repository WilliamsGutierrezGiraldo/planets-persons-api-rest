package com.trycore.planets.dto.response;

import java.util.List;

import com.trycore.planets.dto.PersonDTO;

public class PersonsResponse {
	
	private List<PersonDTO> persons = null;

	public List<PersonDTO> getPersons() {
		return persons;
	}

	public void setPersons(List<PersonDTO> persons) {
		this.persons = persons;
	}

}
