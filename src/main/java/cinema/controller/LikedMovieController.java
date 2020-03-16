//package cinema.controller;
//
//import java.util.Set;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import cinema.persistence.entity.LikedMovies;
//import cinema.persistence.entity.Movie;
//import cinema.persistence.entity.User;
//import cinema.service.ILikedMovieService;
//
//@RestController
//@RequestMapping("/api/likedMovie")
//public class LikedMovieController {
//	
//	@Autowired
//	ILikedMovieService likedMovieService;
//	
//	@CrossOrigin
//	@GetMapping("/numberByIdMovie")
//	@ResponseBody
//	public Integer getNumberLikesByIdMovie(@RequestParam("id") Integer idMovie) {
//		return likedMovieService.getNumberLikesByIdMovie(idMovie); 
//	}
//	
//	@CrossOrigin
//	@GetMapping("/byIdMovie")
//	@ResponseBody
//	public Set<LikedMovies> getUsersByIdMovie(@RequestParam("id") Integer idMovie) {
//		return likedMovieService.getUsersByIdMovie(idMovie); 
//	}
//	
//	@CrossOrigin
//	@GetMapping("/byIdUser")
//	@ResponseBody
//	public Set<LikedMovies> getMoviesByIdUser(@RequestParam("un") String username) {
//		return likedMovieService.getMoviesByIdUser(username); 
//	}
//	
//	@CrossOrigin
//	@GetMapping("/numberByIdUser")
//	@ResponseBody
//	public Integer getNumberMoviesLikedByIdUser(@RequestParam("un") String username) {
//		return likedMovieService.getNumberMoviesLikedByIdUser(username); 
//	}
//	
//	@CrossOrigin
//	@PutMapping("/addMovieToLikedMovies")
//	@ResponseBody
//	public LikedMovies addMovieToLikedMovies(@RequestParam("un") String username, @RequestParam("idM") Integer idMovie) {
//		return likedMovieService.addMovieToLikedMovies(username, idMovie); 
//	}
//
//}
