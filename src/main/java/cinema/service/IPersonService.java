package cinema.service;

import java.util.List;
import java.util.Set;



import cinema.persistence.entity.Person;

public interface IPersonService {

	List<Person> getAllPersons();
	
	Set<Person>findByNameContainingIgnoreCase(String name);
	
	
	Set<Person>findByBirthdateYear(int year);
	
	Set<Person>findByBirthdateYearBetween(int year, int years);
	
	Set<Person>findByBithdateYearGreaterThan(int year);

	Set<Person>findByName(String name);
}
