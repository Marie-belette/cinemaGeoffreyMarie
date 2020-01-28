package cinema.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import cinema.enumeration.Nationalities;
import cinema.persistence.entity.Person;

public interface IPersonService {

	List<Person> getAllPersons();
	Set<Person>findByNameContainingIgnoreCase(String name);
	Set<Person>findByBirthdateYear(int year);
	Set<Person>findByBirthdateYearBetween(int year, int years);
	Set<Person>findByBithdateYearGreaterThan(int year);
	Set<Person>findByName(String name);
	Set<Person>findByNationalities(Nationalities nationalities);
	Set<Person>findByBiographyContaining(String biography);
//	Set<Person>findByAge(int age);
//	Set<Person>FindByAgeBetween(int age1, int age2);
//	Set<Person>FindByAgeGreaterThan(int age);
	Person postPerson(Person person);
	Optional<Person> postNameBirthdate (Person person);
	Optional<Person> postNationalitiesPerson(Nationalities nationalities, Integer idPerson);
	Optional<Person> postBiographyPerson(String biography, Integer idPerson);
	Optional<Person> deletePerson(int idPerson);
}
