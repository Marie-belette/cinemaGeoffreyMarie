package cinema.persistence.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cinema.enumeration.Nationalities;
import cinema.persistence.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {

	Set<Person>findByName(String name);
	Set<Person>findByNameContainingIgnoreCase(String name);

	@Query("select p from Person p where extract(year from p.birthdate) = ?1")
	Set<Person>findByBirthdateYear(int year);
	
	@Query("select p from Person p where extract(year from p.birthdate) between ?1 and ?2")
	Set<Person>findByBirthdateYearBetween(int year1, int year2);
	
	@Query("select p from Person p where extract(year from p.birthdate) > ?1")
	Set<Person>findByBithdateYearGreaterThan(int year);
	
	Set<Person>findByNationalities(Nationalities nationalities);
	
	Set<Person>findByBiographyContaining(String biography);
	
//	Set<Person>findByAge(int age);
//	
//	Set<Person>FindByAgeBetween(int age1, int age2);
	
//	Set<Person>FindByAgeGreaterThan(int age);
	
}