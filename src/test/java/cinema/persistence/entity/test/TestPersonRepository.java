package cinema.persistence.entity.test;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import cinema.enumeration.Nationalities;
import cinema.persistence.entity.Person;
import cinema.persistence.repository.PersonRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class TestPersonRepository {

		@Autowired
		PersonRepository repoPerson;
		
		@Autowired
		EntityManager entityManager;

		@Test
		void testSave() {
			//given
			Person person = new Person("Clint Eastwood", LocalDate.of(1930, 5, 31));
			//when
			repoPerson.save(person);
			//then
			System.out.println(person);
		}
	
		
		@Rollback(false)
		@Test
		void testSaveData() {
			var joaq = new Person("Joaquin Phoenix", LocalDate.of(1974, 10, 28), 46, Nationalities.ETATS_UNIEN);
			var gege = new Person ("Gérard Darmon", LocalDate.of(1948,  2, 29),71, Nationalities.FRANCAIS);
			var todd = new Person ("Todd Phillips", LocalDate.of(1970, 12, 20),29,Nationalities.ETATS_UNIEN);
			var clint = new Person("Clint Eastwood", LocalDate.of(1930, 5, 31),89,Nationalities.ETATS_UNIEN);
			var brad = new Person("Bradley Cooper", LocalDate.of(1975, 1, 5),45,Nationalities.ETATS_UNIEN);
			var bong = new Person ("Bong Joon-Ho", LocalDate.of(1969, 9, 14),50,Nationalities.CORÉEN);
			var nolan = new Person ("Christopher Nolan", LocalDate.of(1970, 7, 30),49,Nationalities.ANGLAIS);
			var gene = new Person ("Gene Hackman", LocalDate.of(1930, 1, 30),89,Nationalities.ETATS_UNIEN);
			var morgan = new Person ("Morgan Freeman", LocalDate.of(1937,6,1),83,Nationalities.ETATS_UNIEN);
			var persons = List.of(joaq, gege, todd, clint, brad, bong, nolan, gene, morgan);
			persons.forEach(repoPerson::save);	
		}
		
		@Test
		void scenario06SelectPersonByYear() {
			var data = repoPerson.findByBirthdateYear(1930);
			System.out.println(data);
		}
		@Test
		void SelectPersonByAge() {
			
			var data = repoPerson.findByAge(89);
			System.out.println("les acteurs sont  : " + data);
		}
		
//		@Test
//		void SelectPersonByNationlities() {
//			
//			var data = repoPerson.findByNationalities(francais);
//			System.out.println("les acteurs sont  : " + data);
//		}
}

