package cinema.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;


import cinema.persistence.entity.Person;
import cinema.service.IPersonService;

public class PersonService implements IPersonService {

	@Autowired
	IPersonService personService;
	
	@Override
	public List<Person> getAllPersons() {
		// TODO Auto-generated method stub
		return personService.getAllPersons() ;
	}

	@Override
	public Set<Person>findByName(String name) { 
		return personService.findByName(name);
	}

	@Override
	public Set<Person>findByNameContainingIgnoreCase(String name) {
		// TODO Auto-generated method stub
		return personService.findByNameContainingIgnoreCase(name);
	}

	@Override
	public Set<Person>findByBirthdateYear(int year) {
		// TODO Auto-generated method stub
		return personService.findByBirthdateYear(year);
	}

	@Override
	public Set<Person>findByBirthdateYearBetween(int year, int years) {
		// TODO Auto-generated method stub
		return personService.findByBirthdateYearBetween(year, years);
	}
	
	@Override
	public Set<Person>findByBithdateYearGreaterThan(int year) {
		// TODO Auto-generated method stub
		return personService.findByBithdateYearGreaterThan(year);
	}

	

}
