package cinema.service;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;

import cinema.persistence.entity.Person;

public interface IPersonService {

	List<Person> getAllPersons();
	
	Set<Person>findByNameContainingIgnoreCase(String name);
	
	@Query("select p from Person p where extract(year from birthdate) = ?1")
	Set<Person>findByBirthdateYear(int year);
	
	Set<Person>findByBirthdateYearBetween(int year, int years);
	
	Set<Person>findByBithdateYearGreaterThan(int year);

	Set<Person>findByName(String name);
}
