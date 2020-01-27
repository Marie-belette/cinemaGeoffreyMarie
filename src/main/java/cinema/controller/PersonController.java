package cinema.controller;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cinema.persistence.entity.Person;
import cinema.service.IPersonService;

@RestController
@RequestMapping("/api/person")
public class PersonController {
	
	@Autowired
	IPersonService personService;
	
	@GetMapping
	@ResponseBody
	public List<Person> allPersons() {
		return personService.getAllPersons();
	}
	
	@GetMapping("/name")
	@ResponseBody
	public Set<Person> findByName(@RequestParam("n")String name) {
		return personService.findByName(name);
		}
	
	@GetMapping("/nameIgnore")
	@ResponseBody
	public Set<Person> findByNameContainingIgnoreCase(@RequestParam("n") String name) {
		return personService.findByNameContainingIgnoreCase(name);
	}
	
	@GetMapping("/birthdate")
	@ResponseBody
	public Set<Person> findByBirthdateYear(@RequestParam("b") int year) {
		return personService.findByBirthdateYear(year);
	}
	
	@GetMapping("/birthdateBetween")
	@ResponseBody
	public Set<Person> findByBirthdateYearBetween(@RequestParam("b1") int year1, @RequestParam("b2") int year2) {
		return personService.findByBirthdateYearBetween(year1, year2);
	}
	
	@GetMapping ("/birthdateGreaterThan")
	@ResponseBody
	public Set<Person> findByBithdateYearGreaterThan(@RequestParam ("b") int year) {
		return personService.findByBithdateYearGreaterThan(year);
	}
	
	@PostMapping
	public Person addPerson(@RequestBody Person person) {
	return personService.postPerson(person);
	}

	
	@PutMapping("/modify")
	@ResponseBody
	public Optional<Person> modifyPerson (@RequestBody Person person ) {
		return personService.postNameBirthdate(person);

	}
	
	@DeleteMapping("/{id}")
	@ResponseBody
	public Optional<Person> deletePerson(@PathVariable("id") int idPerson) {
		return personService.deletePerson(idPerson);
	}
}
