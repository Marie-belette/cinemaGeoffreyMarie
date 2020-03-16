package cinema.controller;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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

import cinema.dto.MovieFull;
import cinema.dto.SimpleMovie;
import cinema.enumeration.Classification;
import cinema.enumeration.Color;
import cinema.enumeration.Format;
import cinema.enumeration.Rating;
import cinema.exception.MovieNotFoundException;
import cinema.service.IMovieService;

@RestController
@RequestMapping("/api/movie")
public class MovieController {
	
	@Autowired
	IMovieService movieService;
	
	@CrossOrigin
	@GetMapping
	@ResponseBody
	public List<SimpleMovie> allMovies() {
		return movieService.getAllMovies();
	}
	
	@CrossOrigin
	@GetMapping("/{id}")
	@ResponseBody
	public Optional<MovieFull> movieById(@PathVariable("id")int idMovie) {
		Optional<MovieFull> movieFull = movieService.getMovieById(idMovie);
		if (movieFull.isPresent() ) {
		return movieFull;
		}
		throw new MovieNotFoundException();
	}
	
	@CrossOrigin
	@GetMapping("/byTitle")
	@ResponseBody
	public Set<SimpleMovie> movieByPartialTitle(@RequestParam("t") String partialTitle) {
		return movieService.getMovieByPartialTitle(partialTitle); 
	}
	
	@CrossOrigin
	@GetMapping("/byTitleAndYear")
	@ResponseBody
	public Set<SimpleMovie> movieByTitleAndYear(@RequestParam("t") String title, @RequestParam("y") int year) {
		return movieService.getMovieByTitleAndYear(title, year);
	}
	
	@CrossOrigin
	@GetMapping("/byYearBetween")
	@ResponseBody
	public Set<SimpleMovie> movieByYearBetween(@RequestParam("y1") int year1, @RequestParam("y2") int year2) {
		return movieService.getMovieByYearBetween(year1, year2);
	}
	
	@CrossOrigin
	@GetMapping("/byDirectorName")
	@ResponseBody
	public Set<SimpleMovie> movieByDirectorName(@RequestParam("d") String directorName) {
		return movieService.getMovieByDirectorName(directorName);
	}
	
	@CrossOrigin
	@GetMapping("/byUserLiking")
	@ResponseBody
	public Set<SimpleMovie> movieByUserLiking(@RequestParam("un") String username) {
		return movieService.getMovieByUsersLiking(username);
	}
	
	@CrossOrigin
	@GetMapping("/byDirectorId")
	@ResponseBody
	public Set<SimpleMovie> movieByDirectorId(@RequestParam("d") int idDirector) {
		return movieService.getMovieByDirectorId(idDirector);
	}
	
	@CrossOrigin
	@GetMapping("/byActor")
	@ResponseBody
	public Set<SimpleMovie> movieByActorName(@RequestParam("a") String actorName) {
		return movieService.getMovieByActorName(actorName);
	}
	
	@CrossOrigin
	@GetMapping("/byActorId")
	@ResponseBody
	public Set<SimpleMovie> movieByActorId(@RequestParam("a") int idActor) {
		return movieService.getMovieByActorId(idActor);
	}
	
	@CrossOrigin
	@GetMapping("/byOriginalTitle")
	@ResponseBody
	public Set<SimpleMovie> getMovieByOriginalTitle(@RequestParam("ot") String originalTitle) {
		return movieService.getMovieByOriginalTitle(originalTitle);
	}

	@CrossOrigin
	@GetMapping("/byGenre")
	@ResponseBody
	public Set<SimpleMovie> getMovieByGenre(@RequestParam("g") String genre) {
		return movieService.getMovieByGenre(genre);
	}

	@CrossOrigin
	@GetMapping("/byRating")
	@ResponseBody
	public Set<SimpleMovie> getMovieByRatingGreaterThan(@RequestParam("r") Rating rating) {
		return movieService.getMovieByRatingGreaterThan(rating);
	}

	@CrossOrigin
	@GetMapping ("/byFormat")
	@ResponseBody
	public Set<SimpleMovie> getMovieByFormat(@RequestParam("f")Format format) {
		return movieService.getMovieByFormat(format);
	}

	@CrossOrigin
	@GetMapping("/byClassification")
	@ResponseBody
	public Set<SimpleMovie> getMovieByClassificationLesserThan(@RequestParam("c")Classification classification) {
		return movieService.getMovieByClassificationLessThan(classification);
	}

	@CrossOrigin
	@GetMapping("/byColor")
	@ResponseBody
	public Set<SimpleMovie> getMovieByColor(@RequestParam("col") Color color) {
		return movieService.getMovieByColor(color);
	}

	@CrossOrigin
	@GetMapping("/bySynopsisWords")
	@ResponseBody
	public Set<SimpleMovie> getMovieBySynopsis(@RequestParam("sy")String synopsis) {
		return movieService.getMovieBySynopsis(synopsis);
	}
	
	@CrossOrigin
	@PostMapping("/addMovie")
	@ResponseBody
	public MovieFull addMovie(@RequestBody MovieFull movie) {
		return movieService.addMovie(movie);
	}
	
	@CrossOrigin
	@PutMapping("/addActor")
	@ResponseBody
	public Optional<MovieFull> addActor(@RequestParam("a") int idActor, @RequestParam("m") int idMovie) {		
		return movieService.postActorMovie(idActor, idMovie);
	}
	
	@CrossOrigin
	@PutMapping("/setDirector")
	@ResponseBody
	public  Optional<MovieFull> setDirector(@RequestParam("m") int idMovie, @RequestParam("d") int idDirector) {
		return movieService.postDirectorMovie(idDirector, idMovie);
	}
	
	@CrossOrigin
	@PutMapping("/setUserLiking")
	@ResponseBody
	public  Optional<MovieFull> setUserLiking(@RequestParam("un") String username, @RequestParam("idM") Integer idMovie) {
		return movieService.putUserLiking(username, idMovie);
	}
	
	@CrossOrigin
	@PutMapping("/eraseUserLiking")
	@ResponseBody
	public  Optional<MovieFull> eraseUserLiking(@RequestParam("un") String username, @RequestParam("idM") Integer idMovie) {
		return movieService.eraseUserLiking(username, idMovie);
	}

	
	@CrossOrigin
	@PostMapping("/setOriginalTitle")
	@ResponseBody
	public  Optional<MovieFull> setOriginalTitle(@RequestParam("ot") String originalTitle, @RequestParam("m") int idMovie) {
		return movieService.postOriginalTitleMovie(originalTitle, idMovie);
	}
	
	@CrossOrigin
	@PostMapping("/setGenre")
	@ResponseBody
	public Optional<MovieFull> setGenre(@RequestParam("g") List<String> genre, @RequestParam("m") int idMovie) {		
		return movieService.postGenreMovie(genre, idMovie);
	}
	
	@CrossOrigin
	@PostMapping("/setRating")
	@ResponseBody
	public Optional<MovieFull> setRating(@RequestParam("r")Rating rating, @RequestParam("m") int idMovie) {
		return movieService.postRatingMovie(rating, idMovie);
	}
	
	@CrossOrigin
	@PostMapping("/setClassification")
	@ResponseBody
	public Optional<MovieFull> setClassificationMovie(@RequestParam ("cl")Classification classification, @RequestParam("m") int idMovie) {
		return movieService.postClassificationMovie(classification, idMovie);
	}
	
	@CrossOrigin
	@PostMapping("/setSynopsis")
	@ResponseBody
	public Optional<MovieFull> setSynopsisMovie(@RequestParam ("sy") String synopsis, @RequestParam("m") int idMovie) {
		return movieService.postSynopsisMovie(synopsis, idMovie);
	}
	
	@CrossOrigin
	@PostMapping("/setColor")
	@ResponseBody
	public Optional<MovieFull> setColorMovie(@RequestParam ("co")Color color, @RequestParam("m") int idMovie) {
		return movieService.postColorMovie(color, idMovie);
	}
	
//	@CrossOrigin
//	@PutMapping("/setLike")
//	@ResponseBody
//	public Optional<MovieFull> setLike(@RequestParam ("id") int idMovie, @RequestParam ("like") int timesLiked) {
//		return movieService.putLike(idMovie, timesLiked);
//	}
	
	@CrossOrigin
	@PostMapping("/modify")
	@ResponseBody
	public Optional<MovieFull> modifyMovie(@RequestBody MovieFull movie) {
		return movieService.postTitleYearDurationDirector(movie);
	}
	
	@CrossOrigin
	@DeleteMapping("/{id}")
	@ResponseBody
	public Optional<MovieFull> deleteMovie(@PathVariable("id") int idMovie) {
		return movieService.deleteMovie(idMovie);
	}
}
