//package cinema.service.impl;
//
//import java.util.Optional;
//import java.util.Set;
//
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.web.bind.annotation.CrossOrigin;
//
//import cinema.persistence.entity.LikedMovies;
//import cinema.persistence.entity.Movie;
//import cinema.persistence.entity.User;
//import cinema.persistence.repository.MovieRepository;
//import cinema.persistence.repository.UserRepository;
//import cinema.service.ILikedMovieService;
//
//@Service
//@Transactional
//public class LikedMovieService implements ILikedMovieService {
//
//	@Autowired
//	MovieRepository movieRepository;
//	
//	
//	@Autowired
//	UserRepository userRepository;
//	
//	
//	@Autowired
//	ModelMapper mapper;
//	
//	@CrossOrigin
//	@Override
//	public Integer getNumberLikesByIdMovie(Integer idMovie) {
//		Optional<Movie> movieLiked = movieRepository.findById(idMovie);
//		Set<LikedMovies> likedMovies = movieLiked.get().getLikedMovies();
//		return likedMovies.size();
//	}
//
//	@Override
//	public Set<LikedMovies> getUsersByIdMovie(Integer idMovie) {
//		Optional<Movie> movieLiked = movieRepository.findById(idMovie);
//		Set<LikedMovies> likedMovies = movieLiked.get().getLikedMovies();
//		return likedMovies;
//	}
//	
//	@CrossOrigin
//	@Override
//	public Set<LikedMovies> getMoviesByIdUser(String username) {
//		Optional<User> userLiking = userRepository.findByUsername(username);
//		Set<LikedMovies> likedMovies = userLiking.get().getLikedMovies();
//		return likedMovies;
//	}
//
//	@CrossOrigin
//	@Override
//	public Integer getNumberMoviesLikedByIdUser(String username) {
//		Optional<User> userLiking = userRepository.findByUsername(username);
//		Set<LikedMovies> likedMovies = userLiking.get().getLikedMovies();
//		return likedMovies.size();
//	}
//
//	@Override
//	public LikedMovies addMovieToLikedMovies(String username, Integer idMovie) {
//		Optional<User> userLiking = userRepository.findByUsername(username);
//		Optional<Movie> movieLiked = movieRepository.findById(idMovie);
//		
//		LikedMovies newLike = new LikedMovies();
//		
//		newLike.setMovie(movieLiked.get());
//		newLike.setUser(userLiking.get());
//		
//		Set<LikedMovies> setLikesUser = userLiking.get().likedMovies;
//		setLikesUser.add(newLike);
//		userLiking.get().setLikedMovies(setLikesUser);
//		
//		Set<LikedMovies> setLikesMovie = movieLiked.get().likedMovies;
//		setLikesMovie.add(newLike);
//		movieLiked.get().setLikedMovies(setLikesMovie);
//		
//		
//		return newLike;
//	}
//
//}
