package cinema.controller;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cinema.dto.LoginDTO;
import cinema.persistence.entity.User;
import cinema.service.IUserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	IUserService userService;
	
	@CrossOrigin
	@GetMapping
	@ResponseBody
	public List<User> allUser() {
		return userService.getAllUsers();
	}
	
	@CrossOrigin
	@GetMapping("/userByFirstName")
	@ResponseBody
	public Set<User> userByFirstName(@RequestParam("fn") String firstName) {
		return userService.getUserByFirstName(firstName);
	}
	
	@CrossOrigin
	@GetMapping("/userByEMail")
	@ResponseBody
	public Set<User> userByEMail(@RequestParam("em") String eMail) {
		return userService.getUserByEMail(eMail);
	}
	
	@CrossOrigin
	@PutMapping("/modify")
	@ResponseBody
	public User modifyUser(@RequestParam("em") String eMail) {
		Set<User> utilisateur = userService.getUserByEMail(eMail);
		return (User) userService.putUser(utilisateur);
	}
	
	@CrossOrigin
	@GetMapping("/userByUsername")
	@ResponseBody
	public Optional<User> userByUsername(@RequestBody LoginDTO loginDTO) {
		var user = userService.getUserByUsername(loginDTO.getUsername());
		if (user.isPresent()) {
			if(user.get().getPassword().equals(loginDTO.getPassword())) {
				return user;
			} else {
				throw new UsernameNotFoundException("password incorrect") ;
			}
		}
		throw new UsernameNotFoundException("username not found");
	}
}

