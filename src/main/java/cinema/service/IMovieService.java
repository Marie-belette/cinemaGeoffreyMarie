//ça s'appelle IMovieService parce que c'est une INTERFACE. La classe d'implémentation est celle qui commence par [arobase]service

package cinema.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import cinema.enumeration.Classification;
import cinema.enumeration.Color;
import cinema.enumeration.Format;
import cinema.enumeration.Rating;
import cinema.persistence.entity.Movie;

public interface IMovieService {
	List<Movie> getAllMovies();
	Optional<Movie> getMovieById(int idMovie);
	Set<Movie> getMovieByPartialTitle(String partialTitle);
	Set<Movie> getMovieByActorId(int idActor);
	Set<Movie> getMovieByActorName(String actorName);
	Set<Movie> getMovieByDirectorId(int idDirector);
	Set<Movie> getMovieByTitleAndYear(String title, int year);
	Set<Movie> getMovieByYearBetween( int year1, int year2);
	Set<Movie> getMovieByDirectorName(String directorName);
	Movie postMovie(Movie movie);
	Optional<Movie> postActorMovie (int idActor, int idMovie);
	Optional<Movie> postDirectorMovie (int idDirector, int idMovie);
	Optional<Movie> postTitleYearDurationDirector(Movie movie) ;
	Optional <Movie> deleteMovie (int idMovie);
	Set<Movie> getMovieByOriginalTitle(String originalTitle);
	Set<Movie> getMovieByGenre(String genre);
	Set<Movie> getMovieByRatingGreaterThan(Rating rating);
	Set<Movie> getMovieByFormat(Format format);
	Set<Movie> getMovieByClassificationLessThan(Classification classification);
	Set<Movie> getMovieByColor(Color color);
	Set<Movie> getMovieBySynopsis(String synopsis);
	Optional<Movie> postGenreMovie(String genre, int idMovie);
	Optional<Movie> postRatingMovie(Rating rating, int idMovie);
	Optional<Movie> postClassificationMovie(Classification classification, int idMovie);
	Optional<Movie> postSynopsisMovie(String synopsis, int idMovie);
	Optional<Movie> postColorMovie(Color color, int idMovie);
	Optional<Movie> postOriginalTitleMovie(String originalTitle, int idMovie);
}
