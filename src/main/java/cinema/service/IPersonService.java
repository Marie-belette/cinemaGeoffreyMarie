package cinema.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import cinema.dto.PersonDTO;
import cinema.enumeration.Nationalities;

public interface IPersonService {

	List<PersonDTO> getAllPersons();
	Set<PersonDTO>findByNameContainingIgnoreCase(String name);
	Set<PersonDTO>findByBirthdateYear(int year);
	Set<PersonDTO>findByBirthdateYearBetween(int year, int years);
	Set<PersonDTO>findByBithdateYearGreaterThan(int year);
	Set<PersonDTO>findByName(String name);
	Set<PersonDTO>findByNationalities(Nationalities nationalities);
	Set<PersonDTO>findByBiographyContaining(String biography);
//	Set<PersonDTO>findByAge(int age);
//	Set<PersonDTO>FindByAgeBetween(int age1, int age2);
//	Set<PersonDTO>FindByAgeGreaterThan(int age);
	PersonDTO postPerson(PersonDTO person);
	Optional<PersonDTO> postNameBirthdate (PersonDTO person);
	Optional<PersonDTO> postNationalitiesPerson(Nationalities nationalities, int idPerson);
	Optional<PersonDTO> postBiographyPerson(String biography, int idPerson);
	Optional<PersonDTO> deletePerson(int idPerson);
	Optional<PersonDTO> getMovieDirector(Integer idMovie);
	List<PersonDTO> getMovieActors(Integer idMovie);
}
