package cinema.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cinema.enumeration.Nationalities;
import cinema.persistence.entity.Person;
import cinema.persistence.repository.PersonRepository;
import cinema.service.IPersonService;

@Service
@Transactional
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
	public Set<Person>findByBirthdateYearBetween(int year1, int year2) {
		return personRepository.findByBirthdateYearBetween(year1, year2);
	}
	
	@Override
	public Set<Person>findByBithdateYearGreaterThan(int year) {
		return personRepository.findByBithdateYearGreaterThan(year);
	}
	
	@Override
	public Set<Person> findByNationalities(Nationalities nationalities) {
		
		return personRepository.findByNationalities(nationalities);
	}
	
	@Override
	public Set<Person> findByBiographyContaining(String biography) {
	
		return personRepository.findByBiographyContaining(biography);
	}
//	@Override
//	public Set<Person> findByAge(int age) {
//		return personRepository.findByAge(age);
//	}

//	@Override
//	public Set<Person> FindByAgeBetween(int age1, int age2) {
//		return personRepository.FindByAgeBetween(age1, age2);
//	}

//	@Override
//	public Set<Person> FindByAgeGreaterThan(int age) {
//		return personRepository.FindByAgeGreaterThan(age);
//	}
//	
	@Override
	public Person postPerson(Person person) {
		Person personSaved = personRepository.save(person);
		personRepository.flush();
		return personSaved;
	}
	

	@Override
	public Optional<Person> postNameBirthdate(Person person) {
		var optPerson = personRepository.findById(person.getIdPerson());
			optPerson.ifPresent(p -> {
			p.setName(person.getName());
			p.setBirthdate(person.getBirthdate());
		
			});
			personRepository.flush();
			return optPerson;
	}
	
	@Override
	public Optional<Person> postNationalitiesPerson(Nationalities nationalities, Integer idPerson){
		var optPerson = personRepository.findById(idPerson);
			optPerson.ifPresent(p -> {
			p.setNationalities(nationalities);
			});
			personRepository.flush();
			return optPerson;
	}
	@Override
	public Optional<Person> postBiographyPerson(String biography, Integer idPerson){
		var optPerson = personRepository.findById(idPerson);
			optPerson.ifPresent(p -> {
			p.setBiography(biography);;
			});
			personRepository.flush();
			return optPerson;
	}
	
	@Override
	public Optional<Person> deletePerson(int idPerson) {
		var personToDelete = personRepository.findById(idPerson);
		personToDelete.ifPresent(p -> { 
			personRepository.delete(p);
			personRepository.flush();
		});
		return personToDelete;
	}

	
	

}
