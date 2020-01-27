package cinema.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cinema.persistence.entity.Person;
import cinema.service.IPersonService;

public class PersonController {
	
	@Autowired
	IPersonService personService;
	
	@GetMapping
	@ResponseBody
	List<Person>  getAllPersons() {
		return personService.getAllPersons();
	}
	
	@GetMapping("/name")
	@ResponseBody
	public Set<Person> getfindByName(@RequestParam("n")String name) {

		return personService.findByName(name);
		}
	
	@GetMapping("/nameIgnore")
	@ResponseBody
	public Set<Person> getfindByNameContainingIgnoreCase(@RequestParam("n") String name) {
		// TODO Auto-generated method stub
		return personService.findByNameContainingIgnoreCase(name);
	}
	
	@GetMapping("/birthdate")
	@ResponseBody
	public Set<Person> getfindByBirthdateYear(int year) {
		// TODO Auto-generated method stub
		return personService.findByBirthdateYear(year);
	}
	
	@GetMapping("/birthdateBetween")
	@ResponseBody
	public Set<Person> getfindByBirthdateYearBetween(int year, int years) {
		// TODO Auto-generated method stub
		return personService.findByBirthdateYearBetween(year, years);
	}
	
	@GetMapping ("/birthdateGreaterThan")
	@ResponseBody
	public Set<Person> getfindByBithdateYearGreaterThan(int year) {
		// TODO Auto-generated method stub
		return personService.findByBithdateYearGreaterThan(year);
	}
	
	@PostMapping
	Person addPerson(Person person) {
	// TODO
	return person;
	}

	
	@PutMapping("/modify")
	@ResponseBody
	public Person modifyPerson (@RequestBody Person person ) {
		
		return person;

	}
}
