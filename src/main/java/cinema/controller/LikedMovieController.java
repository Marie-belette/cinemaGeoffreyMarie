package cinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cinema.service.ILikedMovieService;

@RestController
@RequestMapping("/api/likedMovie")
public class LikedMovieController {
	
	@Autowired
	ILikedMovieService likedMovieService;
	
	@CrossOrigin
	@GetMapping("/byIdMovie")
	@ResponseBody
	public Integer getUsersByIdMovie(@RequestParam("id") Integer idMovie) {
		return likedMovieService.getUsersByIdMovie(idMovie); 
	}

}
