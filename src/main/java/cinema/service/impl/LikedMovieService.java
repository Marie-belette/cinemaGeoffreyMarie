package cinema.service.impl;

import java.util.Optional;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;

import cinema.persistence.entity.LikedMovies;
import cinema.persistence.entity.Movie;
import cinema.persistence.repository.MovieRepository;
import cinema.service.ILikedMovieService;

@Service
@Transactional
public class LikedMovieService implements ILikedMovieService {

	@Autowired
	MovieRepository movieRepository;
	
	
	@Autowired
	ModelMapper mapper;
	
	@CrossOrigin
	@Override
	public Integer getUsersByIdMovie(Integer idMovie) {
		Optional<Movie> movieLiked = movieRepository.findById(idMovie);
		Set<LikedMovies> likedMovies = movieLiked.get().getLikedMovies();
		return likedMovies.size();
	}

	@CrossOrigin
	@Override
	public Set<LikedMovies> getMovieByIdUser(Integer idUser) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@CrossOrigin
	@Override
	public Set<LikedMovies> getAllLikedMovies() {
		// TODO Auto-generated method stub
				return null;
	}

}
