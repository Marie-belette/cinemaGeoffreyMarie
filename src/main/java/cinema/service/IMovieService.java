//ça s'appelle IMovieService parce que c'est une INTERFACE. La classe d'implémentation est celle qui commence par [arobase]service

package cinema.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import cinema.dto.MovieFull;
import cinema.dto.SimpleMovie;
import cinema.enumeration.Classification;
import cinema.enumeration.Color;
import cinema.enumeration.Format;
import cinema.enumeration.Rating;

public interface IMovieService {
	List<SimpleMovie> getAllMovies();
	Optional<MovieFull> getMovieById(int idMovie);
	Set<SimpleMovie> getMovieByPartialTitle(String partialTitle);
	Set<SimpleMovie> getMovieByActorId(int idActor);
	Set<SimpleMovie> getMovieByActorName(String actorName);
	Set<SimpleMovie> getMovieByDirectorId(int idDirector);
	Set<SimpleMovie> getMovieByTitleAndYear(String title, int year);
	Set<SimpleMovie> getMovieByYearBetween( int year1, int year2);
	Set<SimpleMovie> getMovieByDirectorName(String directorName);
	Set<SimpleMovie> getMovieByOriginalTitle(String originalTitle);
	Set<SimpleMovie> getMovieByGenre(String genre);
	Set<SimpleMovie> getMovieByRatingGreaterThan(Rating rating);
	Set<SimpleMovie> getMovieByFormat(Format format);
	Set<SimpleMovie> getMovieByClassificationLessThan(Classification classification);
	Set<SimpleMovie> getMovieByColor(Color color);
	Set<SimpleMovie> getMovieBySynopsis(String synopsis);
	
	Optional<MovieFull> postActorMovie (int idActor, int idMovie);
	Optional<MovieFull> postDirectorMovie (int idDirector, int idMovie);
	Optional<MovieFull> postTitleYearDurationDirector(MovieFull movie) ;
	
	Optional<MovieFull> postGenreMovie(List<String> genre, int idMovie);
	Optional<MovieFull> postRatingMovie(Rating rating, int idMovie);
	Optional<MovieFull> postClassificationMovie(Classification classification, int idMovie);
	Optional<MovieFull> postSynopsisMovie(String synopsis, int idMovie);
	Optional<MovieFull> postColorMovie(Color color, int idMovie);
	Optional<MovieFull> postOriginalTitleMovie(String originalTitle, int idMovie);
	
	MovieFull addMovie(MovieFull movie);
	Optional <MovieFull> deleteMovie (int idMovie);
}
