package cinema.persistence.entity.test;

import java.time.LocalDate;
//import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import cinema.persistence.entity.Movie;
import cinema.persistence.entity.Person;
import cinema.persistence.repository.MovieRepository;
import cinema.persistence.repository.PersonRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class TestSixDegreesOfKevinBacon {
	
	@Autowired
	PersonRepository repoPersons;
	
	@Autowired
	MovieRepository repoMovies;

	@Rollback(false)
	@Test
	void testSaveData() {
		var joaq = new Person("Joaquin Phoenix", LocalDate.of(1974, 10, 28));
		var todd = new Person ("Todd Phillips", LocalDate.of(1970, 12, 20));
		var clint = new Person("Clint Eastwood", LocalDate.of(1930, 5, 31));
		var brad = new Person("Bradley Cooper", LocalDate.of(1975, 1, 5));
		var bong = new Person ("Bong Joon-Ho", LocalDate.of(1969, 9, 14));
		var scarlett = new Person ("Scarlett Johansson", LocalDate.of(1984, 11, 22));
		var mark = new Person ("Mark Ruffalo", LocalDate.of(1967, 11, 22));
		var jake = new Person ("Jake Gyllenhaal", LocalDate.of(1980, 12, 19));
		var persons = List.of(joaq, todd, clint, brad, bong, scarlett, mark, jake);
			persons.forEach(repoPersons::save);	
			
		var joker = new Movie ("Joker", 2019, 165, todd);
		var parasite = new Movie ("Parasite", 2019, 132, bong);
		var americanSniper = new Movie ("American Sniper", 2014, 133, clint);
		var veryBadTrip = new Movie ("Very Bad Trip", 2009, 100, todd);
		var avengers = new Movie ("Avengers", 2012, 143);
		var her = new Movie("Her", 2014, 126);
		var zodiac = new Movie ("Zodiac", 2007, 156);
		var movies = List.of(joker, parasite, americanSniper, veryBadTrip, avengers, her, zodiac);
			movies.forEach(repoMovies::save);
	}
	
	@Rollback(false)
	@Test
	void addActorsAmericanSniper() {
		var americanSniper = repoMovies.findByTitle("American Sniper").stream().findFirst().get();
		var brad = repoPersons.findByName("Bradley Cooper").stream().findFirst().get();
		americanSniper.setActors(List.of(brad));
		repoMovies.flush();
	}
	
	@Rollback(false)
	@Test
	void addActorsVeryBadTrip() {
		var veryBadTrip = repoMovies.findByTitle("Very Bad Trip").stream().findFirst().get();
		var brad = repoPersons.findByName("Bradley Cooper").stream().findFirst().get();
		veryBadTrip.setActors(List.of(brad));
		repoMovies.flush();
	}


	@Rollback(false)
	@Test
	void addActorsJoker() {
		var joker = repoMovies.findByTitle("Joker").stream().findFirst().get();
		var joaq = repoPersons.findByName("Joaquin Phoenix").stream().findFirst().get();
		joker.setActors(List.of(joaq));
		repoMovies.flush();
	}

	@Rollback(false)
	@Test
	void addActorsHer() {
		var her = repoMovies.findByTitle("Her").stream().findFirst().get();
		var scarlett = repoPersons.findByName("Scarlett Johansson").stream().findFirst().get();
		var joaq = repoPersons.findByName("Joaquin Phoenix").stream().findFirst().get();
		her.setActors(List.of(scarlett, joaq));
		repoMovies.flush();
	}

	@Rollback(false)
	@Test
	void addAvengers() {
		var avengers = repoMovies.findByTitle("Avengers").stream().findFirst().get();
		var scarlett = repoPersons.findByName("Scarlett Johansson").stream().findFirst().get();
		var mark = repoPersons.findByName("Mark Ruffalo").stream().findFirst().get();
		avengers.setActors(List.of(scarlett, mark));
		repoMovies.flush();
	}
	
	@Rollback(false)
	@Test
	void addActorsZodiac() {
		var zodiac = repoMovies.findByTitle("Zodiac").stream().findFirst().get();
		var mark = repoPersons.findByName("Mark Ruffalo").stream().findFirst().get();
		var jake = repoPersons.findByName("Jake Gyllenhaal").stream().findFirst().get();
		zodiac.setActors(List.of(jake, mark));
		repoMovies.flush();
	}
	
//	@Test
//	void essaiMarieListCoworkers() {
//		Person clint = repoPersons.findByName("Clint Eastwood").stream().findFirst().get();
//		Person joaq = repoPersons.findByName("Joaquin Phoenix").stream().findFirst().get();
//		var filmsClint = repoMovies.findByDirector(clint);
//		ArrayList<Person> clintCoworkers = new ArrayList<Person>();
//        filmsClint.stream() 
//        		.map(m -> m.getActors())
//                .forEach(clintCoworkers::add); 
//        clintCoworkers.stream()
//        .equals(joaq);
//		}

	
}
