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

import cinema.enumeration.Nationalities;
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
	
	@GetMapping("/biography")
	@ResponseBody
	public Set<Person> findByBiographyContaining(@RequestParam("bio") String biography) {
		return personService.findByBiographyContaining(biography);
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
	
	@GetMapping("/nationalities")
	@ResponseBody
	public Set<Person> findByNationalities(@RequestParam("nat") Nationalities nationalities) {
		return personService.findByNationalities(nationalities);
	}
	
//	@GetMapping("/age")
//	@ResponseBody
//	public Set<Person>FindByAge(@RequestParam ("a") int age){
//		return personService.findByAge(age);
//	}
	
//	@GetMapping("/ageBetween")
//	@ResponseBody
//	public Set<Person>FindByAgeBetween(@RequestParam ("a1") int age1, @RequestParam("a2") int age2){
//		return personService.FindByAgeBetween(age1, age2);
//	}

//	@GetMapping("/ageGreaterThan")
//	@ResponseBody
//	public Set<Person>FindByAgeGreaterThan(@RequestParam ("a") int age){
//		return personService.FindByAgeGreaterThan(age);
//	}
//	
	@PostMapping ("/addPerson")
	@ResponseBody
	public Person addPerson(@RequestBody Person person) {
	return personService.postPerson(person);
	}

	@PostMapping("/setNationalities")
	@ResponseBody
	public Optional<Person> setNationalities(@RequestParam("n") Nationalities nationalities, @RequestParam("p") int idPerson) {
		return personService.postNationalitiesPerson(nationalities, idPerson);
	}
	
	@PostMapping("/setBiography")
	@ResponseBody
	public Optional<Person> setBiography(@RequestParam("b") String biography, @RequestParam("p") int idPerson ) {
		return personService.postBiographyPerson(biography, idPerson);
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
