package cinema.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cinema.enumeration.Classification;
import cinema.enumeration.Color;
import cinema.enumeration.Format;
import cinema.enumeration.Rating;
import cinema.persistence.entity.Movie;
import cinema.persistence.repository.MovieRepository;
import cinema.persistence.repository.PersonRepository;
import cinema.service.IMovieService;

@Service
@Transactional
public class MovieService implements IMovieService {
	
	@Autowired
	MovieRepository movieRepository;
	
	@Autowired
	PersonRepository personRepository;

	@Override
	public List<Movie> getAllMovies() {
		return movieRepository.findAll();
	}

	@Override
	public Optional<Movie> getMovieById(int idMovie) {
		return movieRepository.findById(idMovie);
	}

	@Override
	public Set<Movie> getMovieByPartialTitle(String partialTitle) {
		return movieRepository.findByTitleContainingIgnoreCase(partialTitle); 
	}

	@Override
	public Set<Movie> getMovieByActorId(int idActor) {
		return movieRepository.findByActorsIdPerson(idActor);
	}

	@Override
	public Set<Movie> getMovieByActorName(String actorName) {
		return movieRepository.findByActorsName(actorName);
	}

	@Override
	public Set<Movie> getMovieByDirectorId(int idDirector) {
		var directorOpt = personRepository.findById(idDirector);
		return directorOpt.map(d -> movieRepository.findByDirector(d))
				.orElseGet(() -> Collections.emptySet());
	}

	@Override
	public Set<Movie> getMovieByTitleAndYear(String title, int year) {
		return movieRepository.findByTitleAndYear(title, year);
	}

	@Override
	public Set<Movie> getMovieByYearBetween(int year1, int year2) {
		return movieRepository.findByYearBetween(year1, year2);
	}

	@Override
	public Set<Movie> getMovieByDirectorName(String directorName) {
		return movieRepository.findByDirectorName(directorName);
	}
	
	@Override
	public Set<Movie> getMovieByOriginalTitle(String originalTitle) {
		return movieRepository.findByOriginalTitleContainingIgnoreCase(originalTitle);
	}

	@Override
	public Set<Movie> getMovieByGenre(String genre) {
		return movieRepository.findByGenreContainingIgnoreCase(genre);
	}

	@Override
	public Set<Movie> getMovieByRatingGreaterThan(Rating rating) {
		return movieRepository.findByRatingGreaterThan(rating);
	}

	@Override
	public Set<Movie> getMovieByFormat(Format format) {
		return movieRepository.findByFormat(format);
	}

	@Override
	public Set<Movie> getMovieByClassificationLessThan(Classification classification) {
		return movieRepository.findByClassificationLessThan(classification);
	}

	@Override
	public Set<Movie> getMovieByColor(Color color) {
		return movieRepository.findByColor(color);
	}

	@Override
	public Set<Movie> getMovieBySynopsis(String synopsis) {
		return movieRepository.findBySynopsisContainingIgnoreCase(synopsis);
	}

	@Override
	public Movie postMovie(Movie movie) {
		Movie movieSaved = movieRepository.save(movie);
		movieRepository.flush();
		return movieSaved;
	}
	
	@Override
	public Optional<Movie> postActorMovie(int idActor, int idMovie) {
		var movieOpt = movieRepository.findById(idMovie);
		var actorOpt = personRepository.findById(idActor);
		if (movieOpt.isPresent() && actorOpt.isPresent()) {
			movieOpt.get().getActors().add(actorOpt.get());
			movieRepository.flush();
		}
		return movieOpt;
	}

	@Override
	public Optional<Movie> postDirectorMovie(int idDirector, int idMovie) {
		var optMovie = movieRepository.findById(idMovie);
		var optDirector = personRepository.findById(idDirector);
		if (optMovie.isPresent() && optDirector.isPresent()) {
			optMovie.get().setDirector(optDirector.get());
		};
		movieRepository.flush();
		return optMovie;
	}

	@Override
	public Optional<Movie> postTitleYearDurationDirector(Movie movie) {
		var optMovie = movieRepository.findById(movie.getIdMovie());
		optMovie.ifPresent(m -> {
			m.setTitle(movie.getTitle());
			m.setYear(movie.getYear());
			m.setDuration(movie.getDuration());
			m.setDirector(movie.getDirector());
		});
		movieRepository.flush();
		return optMovie;
	}
	
	@Override
	public Optional<Movie> postGenreMovie(String genre, int idMovie) {
		var movieOpt = movieRepository.findById(idMovie);
		movieOpt.ifPresent (m -> {
		m.setGenre(genre);
		});
		return movieOpt;
	}
	
	@Override
	public Optional<Movie> postRatingMovie(Rating rating, int idMovie) {
		var movieOpt = movieRepository.findById(idMovie);
		movieOpt.ifPresent (m -> {
		m.setRating(rating);
		});
		return movieOpt;
	}
	
	@Override
	public Optional<Movie> postClassificationMovie(Classification classification, int idMovie) {
		var movieOpt = movieRepository.findById(idMovie);
		movieOpt.ifPresent (m -> {
		m.setClassification(classification);
		});
		return movieOpt;
	}
	
	@Override
	public Optional<Movie> postSynopsisMovie(String synopsis, int idMovie) {
		var movieOpt = movieRepository.findById(idMovie);
		movieOpt.ifPresent (m -> {
		m.setSynopsis(synopsis);
		});
		return movieOpt;
	}
	
	@Override
	public Optional<Movie> postColorMovie(Color color, int idMovie) {
		var movieOpt = movieRepository.findById(idMovie);
		movieOpt.ifPresent (m -> {
		m.setColor(color);
		});
		return movieOpt;
	}

	@Override
	public Optional <Movie> deleteMovie(int idMovie) {
		var movieToDelete = movieRepository.findById(idMovie);
		movieToDelete.ifPresent(m -> { 
			movieRepository.delete(m);
			movieRepository.flush();
		});
		return movieToDelete;
	}

	@Override
	public Optional<Movie> postOriginalTitleMovie(String originalTitle, int idMovie) {
		var movieOpt = movieRepository.findById(idMovie);
		movieOpt.ifPresent (m -> {
		m.setOriginalTitle(originalTitle);
		});
		return movieOpt;
	}
}
