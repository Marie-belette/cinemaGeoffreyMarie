package cinema.service.impl;

import java.util.List;
import java.util.Optional;
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
	public Optional<Person> deletePerson(int idPerson) {
		var personToDelete = personRepository.findById(idPerson);
		personToDelete.ifPresent(p -> { 
			personRepository.delete(p);
			personRepository.flush();
		});
		return personToDelete;
	}
}
