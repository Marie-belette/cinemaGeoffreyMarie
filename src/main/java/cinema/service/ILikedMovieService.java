package cinema.service;

import java.util.Set;

import cinema.persistence.entity.LikedMovies;


public interface ILikedMovieService {

Set<LikedMovies> getAllLikedMovies();
Set<LikedMovies> getMovieByIdUser(Integer idUser);
Integer getUsersByIdMovie(Integer idMovie);
}