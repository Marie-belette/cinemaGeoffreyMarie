package cinema.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;


import cinema.persistence.entity.Person;
import cinema.persistence.repository.PersonRepository;
import cinema.service.IPersonService;

public class PersonService implements IPersonService {

	@Autowired
	PersonRepository personRepository;
	
	@Override
	public List<Person> getAllPersons() {
	
		return personRepository.findAll() ;
	}

	@Override
	public Set<Person>findByName(String name) { 
		return personRepository.findByName(name);
	}

	@Override
	public Set<Person>findByNameContainingIgnoreCase(String name) {
		
		return personRepository.findByNameContainingIgnoreCase(name);
	}

	@Override
	public Set<Person>findByBirthdateYear(int year) {
		
		return personRepository.findByBirthdateYear(year);
	}

	@Override
	public Set<Person>findByBirthdateYearBetween(int year, int years) {
		
		return personRepository.findByBirthdateYearBetween(year, years);
	}
	
	@Override
	public Set<Person>findByBithdateYearGreaterThan(int year) {
		
		return personRepository.findByBithdateYearGreaterThan(year);
	}

	

}
