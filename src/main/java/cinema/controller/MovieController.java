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

import cinema.enumeration.Classification;
import cinema.enumeration.Color;
import cinema.enumeration.Format;
import cinema.enumeration.Rating;
import cinema.persistence.entity.Movie;
import cinema.service.IMovieService;

@RestController
@RequestMapping("/api/movie")
public class MovieController {
	
	@Autowired
	IMovieService movieService;
	
	@GetMapping
	@ResponseBody
	public List<Movie> allMovies() {
		return movieService.getAllMovies();
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	public Optional<Movie> movieById(@PathVariable("id")int idMovie) {
		return movieService.getMovieById(idMovie);
	}
	
	@GetMapping("/byTitle")
	@ResponseBody
	public Set<Movie> movieByPartialTitle(@RequestParam("t") String partialTitle) {
		return movieService.getMovieByPartialTitle(partialTitle); 
	}
	
	@GetMapping("/byTitleAndYear")
	@ResponseBody
	public Set<Movie> movieByTitleAndYear(@RequestParam("t") String title, @RequestParam("y") int year) {
		return movieService.getMovieByTitleAndYear(title, year);
	}
	
	@GetMapping("/byYearBetween")
	@ResponseBody
	public Set<Movie> movieByYearBetween(@RequestParam("y1") int year1, @RequestParam("y2") int year2) {
		return movieService.getMovieByYearBetween(year1, year2);
	}
	
	@GetMapping("/byDirectorName")
	@ResponseBody
	public Set<Movie> movieByDirectorName(@RequestParam("d") String directorName) {
		return movieService.getMovieByDirectorName(directorName);
	}
	
	@GetMapping("/byDirectorId")
	@ResponseBody
	public Set<Movie> movieByDirectorId(@RequestParam("d") int idDirector) {
		return movieService.getMovieByDirectorId(idDirector);
	}
	
	@GetMapping("/byActor")
	@ResponseBody
	public Set<Movie> movieByActorName(@RequestParam("a") String actorName) {
		return movieService.getMovieByActorName(actorName);
	}
	
	@GetMapping("/byActorId")
	@ResponseBody
	public Set<Movie> movieByActorId(@RequestParam("a") int idActor) {
		return movieService.getMovieByActorId(idActor);
	}
	
	@GetMapping("/byOriginalTitle")
	@ResponseBody
	public Set<Movie> getMovieByOriginalTitle(@RequestParam("ot") String originalTitle) {
		return movieService.getMovieByOriginalTitle(originalTitle);
	}

	@GetMapping("/byGenre")
	@ResponseBody
	public Set<Movie> getMovieByGenre(@RequestParam("g") String genre) {
		return movieService.getMovieByGenre(genre);
	}

	@GetMapping("/byRating")
	@ResponseBody
	public Set<Movie> getMovieByRatingGreaterThan(@RequestParam("r") Rating rating) {
		return movieService.getMovieByRatingGreaterThan(rating);
	}

	@GetMapping ("/byFormat")
	@ResponseBody
	public Set<Movie> getMovieByFormat(@RequestParam("f")Format format) {
		return movieService.getMovieByFormat(format);
	}

	@GetMapping("/byClassification")
	@ResponseBody
	public Set<Movie> getMovieByClassificationLesserThan(@RequestParam("c")Classification classification) {
		return movieService.getMovieByClassificationLessThan(classification);
	}

	@GetMapping("/byColor")
	@ResponseBody
	public Set<Movie> getMovieByColor(@RequestParam("col") Color color) {
		return movieService.getMovieByColor(color);
	}

	@GetMapping("/bySynopsisWords")
	@ResponseBody
	public Set<Movie> getMovieBySynopsis(@RequestParam("sy")String synopsis) {
		return movieService.getMovieBySynopsis(synopsis);
	}
	
	@PostMapping("/addMovie")
	@ResponseBody
	public Movie addMovie(@RequestBody Movie movie) {
		return movieService.postMovie(movie);
	}
	
	@PutMapping("/addActor")
	@ResponseBody
	public Optional<Movie> addActor(@RequestParam("a") int idActor, @RequestParam("m") int idMovie) {		
		return movieService.postActorMovie(idActor, idMovie);

	}
	
	@PutMapping("/setDirector")
	@ResponseBody
	public  Optional<Movie> setDirector(@RequestParam("m") int idMovie, @RequestParam("d") int idDirector) {
		return movieService.postDirectorMovie(idDirector, idMovie);
	}
	
	@PostMapping("/setOriginalTitle")
	@ResponseBody
	public  Optional<Movie> setOriginalTitle(@RequestParam("ot") String originalTitle, @RequestParam("m") int idMovie) {
		return movieService.postOriginalTitleMovie(originalTitle, idMovie);
	}
	
	@PostMapping("/setGenre")
	@ResponseBody
	public Optional<Movie> setGenre(@RequestParam("g") String genre, @RequestParam("m") int idMovie) {		
		return movieService.postGenreMovie(genre, idMovie);
	}
	
	@PostMapping("/setRating")
	@ResponseBody
	public Optional<Movie> setRating(@RequestParam("r")Rating rating, @RequestParam("m") int idMovie) {
		return movieService.postRatingMovie(rating, idMovie);
	}
	
	@PostMapping("/setClassification")
	@ResponseBody
	public Optional<Movie> setClassificationMovie(@RequestParam ("cl")Classification classification, @RequestParam("m") int idMovie) {
		return movieService.postClassificationMovie(classification, idMovie);
	}
	
	@PostMapping("/setSynopsis")
	@ResponseBody
	public Optional<Movie> setSynopsisMovie(@RequestParam ("sy") String synopsis, @RequestParam("m") int idMovie) {
		return movieService.postSynopsisMovie(synopsis, idMovie);
	}
	
	@PostMapping("/setColor")
	@ResponseBody
	public Optional<Movie> setColorMovie(@RequestParam ("co")Color color, @RequestParam("m") int idMovie) {
		return movieService.postColorMovie(color, idMovie);
	}
	
	@PostMapping("/modify")
	@ResponseBody
	public Optional<Movie> modifyMovie(@RequestBody Movie movie) {
		return movieService.postTitleYearDurationDirector(movie);
	}
	
	@DeleteMapping("/{id}")
	@ResponseBody
	public Optional<Movie> deleteMovie(@PathVariable("id") int idMovie) {
		return movieService.deleteMovie(idMovie);
	}
}
