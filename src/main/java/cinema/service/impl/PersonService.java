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
	public Set<Person> getfindByName(String name) { 
		return personService.getfindByName(name);
	}

	@Override
	public Set<Person> getfindByNameContainingIgnoreCase(String name) {
		// TODO Auto-generated method stub
		return personService.getfindByNameContainingIgnoreCase(name);
	}

	@Override
	public Set<Person> getfindByBirthdateYear(int year) {
		// TODO Auto-generated method stub
		return personService.getfindByBirthdateYear(year);
	}

	@Override
	public Set<Person> getfindByBirthdateYearBetween(int year, int years) {
		// TODO Auto-generated method stub
		return personService.getfindByBirthdateYearBetween(year, years);
	}
	
	@Override
	public Set<Person> getfindByBithdateYearGreaterThan(int year) {
		// TODO Auto-generated method stub
		return personService.getfindByBithdateYearGreaterThan(year);
	}

	

}
