package cinema.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cinema.dto.MovieFull;
import cinema.dto.SimpleMovie;
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
	
	@Autowired
	ModelMapper mapper;

	@Override
	public List<SimpleMovie> getAllMovies() {
		 List<Movie> movieEntities = movieRepository.findAll();
		 return movieEntities.stream()
			.map(me -> mapper.map(me, SimpleMovie.class))
			.collect(Collectors.toList());
	}

	@Override
	public Optional<MovieFull> getMovieById(int idMovie) {
		return movieRepository.findById(idMovie)
			.map(me -> mapper.map(me, MovieFull.class));
	}

	@Override
	public Set<SimpleMovie> getMovieByPartialTitle(String partialTitle) {
		Set<Movie> movieEntities = movieRepository.findByTitleContainingIgnoreCase(partialTitle) ;
		return movieEntities.stream()
			.map(me -> mapper.map(me, SimpleMovie.class))
			.collect(Collectors.toSet());
	}

	@Override
	public Set<SimpleMovie> getMovieByActorId(int idActor) {
		Set<Movie> movieEntities = movieRepository.findByActorsIdPerson(idActor);
		return movieEntities.stream()
			.map(me -> mapper.map(me, SimpleMovie.class))
			.collect(Collectors.toSet());
	}

	@Override
	public Set<SimpleMovie> getMovieByActorName(String actorName) {
		Set<Movie> movieEntities = movieRepository.findByActorsName(actorName);
		return movieEntities.stream()
				.map(me -> mapper.map(me, SimpleMovie.class))
				.collect(Collectors.toSet());
	}

	@Override
	public Set<SimpleMovie> getMovieByDirectorId(int idDirector) {
		var directorOpt = personRepository.findById(idDirector);
		Set<Movie> movieEntities = directorOpt.map(d -> movieRepository.findByDirector(d))
		.orElseGet(() -> Collections.emptySet());
		return movieEntities.stream()
				.map(me -> mapper.map(me, SimpleMovie.class))
				.collect(Collectors.toSet());
	}

	@Override
	public Set<SimpleMovie> getMovieByTitleAndYear(String title, int year) {
		Set<Movie> movieEntities = movieRepository.findByTitleAndYear(title, year);
		return movieEntities.stream()
				.map(me -> mapper.map(me, SimpleMovie.class))
				.collect(Collectors.toSet());
	}

	@Override
	public Set<SimpleMovie> getMovieByYearBetween(int year1, int year2) {
		Set<Movie> movieEntities = movieRepository.findByYearBetween(year1, year2);
		return movieEntities.stream()
				.map(me -> mapper.map(me, SimpleMovie.class))
				.collect(Collectors.toSet());
	}

	@Override
	public Set<SimpleMovie> getMovieByDirectorName(String directorName) {
		Set<Movie> movieEntities =  movieRepository.findByDirectorName(directorName);
		return movieEntities.stream()
				.map(me -> mapper.map(me, SimpleMovie.class))
				.collect(Collectors.toSet());
	}

	@Override
	public Set<SimpleMovie> getMovieByOriginalTitle(String originalTitle) {
		Set<Movie> movieEntities = movieRepository.findByOriginalTitleContainingIgnoreCase(originalTitle);
		return movieEntities.stream()
				.map(me -> mapper.map(me, SimpleMovie.class))
				.collect(Collectors.toSet());
	}

	@Override
	public Set<SimpleMovie> getMovieByGenre(String genre) {
		Set<Movie> movieEntities = movieRepository.findByGenreContainingIgnoreCase(genre);
		return movieEntities.stream()
				.map(me -> mapper.map(me, SimpleMovie.class))
				.collect(Collectors.toSet());
	}

	@Override
	public Set<SimpleMovie> getMovieByRatingGreaterThan(Rating rating) {
		Set<Movie> movieEntities = movieRepository.findByRatingGreaterThan(rating);
		return movieEntities.stream()
				.map(me -> mapper.map(me, SimpleMovie.class))
				.collect(Collectors.toSet());
	}

	@Override
	public Set<SimpleMovie> getMovieByFormat(Format format) {
		Set<Movie> movieEntities = movieRepository.findByFormat(format);
		return movieEntities.stream()
				.map(me -> mapper.map(me, SimpleMovie.class))
				.collect(Collectors.toSet());
	}

	@Override
	public Set<SimpleMovie> getMovieByClassificationLessThan(Classification classification) {
		Set<Movie> movieEntities = movieRepository.findByClassificationLessThan(classification);
		return movieEntities.stream()
				.map(me -> mapper.map(me, SimpleMovie.class))
				.collect(Collectors.toSet());
	}

	@Override
	public Set<SimpleMovie> getMovieByColor(Color color) {
		Set<Movie> movieEntities = movieRepository.findByColor(color);
		return movieEntities.stream()
				.map(me -> mapper.map(me, SimpleMovie.class))
				.collect(Collectors.toSet());
	}

	@Override
	public Set<SimpleMovie> getMovieBySynopsis(String synopsis) {
		Set<Movie> movieEntities = movieRepository.findBySynopsisContainingIgnoreCase(synopsis);
		return movieEntities.stream()
				.map(me -> mapper.map(me, SimpleMovie.class))
				.collect(Collectors.toSet());
	}

	@Override
	public Optional<MovieFull> postActorMovie(int idActor, int idMovie) {
		var movieOpt = movieRepository.findById(idMovie);
		var actorOpt = personRepository.findById(idActor);
		if (movieOpt.isPresent() && actorOpt.isPresent()) {
				movieOpt.get().getActors().add(actorOpt.get());
				movieRepository.flush();
		}
		return movieOpt
				.map(me -> mapper.map(me, MovieFull.class));
	}

	@Override
	public Optional<MovieFull> postDirectorMovie(int idDirector, int idMovie) {
		var optMovie = movieRepository.findById(idMovie);
		var optDirector = personRepository.findById(idDirector);
		if (optMovie.isPresent() && optDirector.isPresent()) {
			optMovie.get().setDirector(optDirector.get());
		};
		movieRepository.flush();
		return optMovie
				.map(me -> mapper.map(me, MovieFull.class));
	}

	@Override
	public Optional<MovieFull> postTitleYearDurationDirector(MovieFull movie) {
		var optMovie = movieRepository.findById(movie.getIdMovie());
		optMovie.ifPresent(m -> {
			m.setTitle(movie.getTitle());
			m.setYear(movie.getYear());
			m.setDuration(movie.getDuration());
			m.setDirector(movie.getDirector());
		});
		movieRepository.flush();
		return optMovie
				.map(me -> mapper.map(me, MovieFull.class));
	}

	@Override
	public Optional<MovieFull> postGenreMovie(String genre, int idMovie) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<MovieFull> postRatingMovie(Rating rating, int idMovie) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<MovieFull> postClassificationMovie(Classification classification, int idMovie) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<MovieFull> postSynopsisMovie(String synopsis, int idMovie) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<MovieFull> postColorMovie(Color color, int idMovie) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<MovieFull> postOriginalTitleMovie(String originalTitle, int idMovie) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MovieFull addMovie(MovieFull movie) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<MovieFull> deleteMovie(int idMovie) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public MovieFull addMovie(MovieFull movie) {
//		Movie movieSaved = movieRepository.save(movie);
//		movieRepository.flush();
//		return movieSaved;
//	}

//	@Override
//	public Optional<MovieFull> postGenreMovie(String genre, int idMovie) {
//		var movieOpt = movieRepository.findById(idMovie);
//		movieOpt.ifPresent (m -> {
//		m.setGenre(genre);
//		});
//		return movieOpt;
//	}
//	
//	@Override
//	public Optional<MovieFull> postRatingMovie(Rating rating, int idMovie) {
//		var movieOpt = movieRepository.findById(idMovie);
//		movieOpt.ifPresent (m -> {
//		m.setRating(rating);
//		});
//		return movieOpt;
//	}
//	
//	@Override
//	public Optional<MovieFull> postClassificationMovie(Classification classification, int idMovie) {
//		var movieOpt = movieRepository.findById(idMovie);
//		movieOpt.ifPresent (m -> {
//		m.setClassification(classification);
//		});
//		return movieOpt;
//	}
//	
//	@Override
//	public Optional<MovieFull> postSynopsisMovie(String synopsis, int idMovie) {
//		var movieOpt = movieRepository.findById(idMovie);
//		movieOpt.ifPresent (m -> {
//		m.setSynopsis(synopsis);
//		});
//		return movieOpt;
//	}
//	
//	@Override
//	public Optional<MovieFull> postColorMovie(Color color, int idMovie) {
//		var movieOpt = movieRepository.findById(idMovie);
//		movieOpt.ifPresent (m -> {
//		m.setColor(color);
//		});
//		return movieOpt;
//	}
//
//	@Override
//	public Optional<MovieFull> deleteMovie(int idMovie) {
//		var movieToDelete = movieRepository.findById(idMovie);
//		movieToDelete.ifPresent(m -> { 
//			movieRepository.delete(m);
//			movieRepository.flush();
//		});
//		return movieToDelete;
//	}
//
//	@Override
//	public Optional<MovieFull> postOriginalTitleMovie(String originalTitle, int idMovie) {
//		var movieOpt = movieRepository.findById(idMovie);
//		movieOpt.ifPresent (m -> {
//		m.setOriginalTitle(originalTitle);
//		});
//		return movieOpt;
//	}
}
