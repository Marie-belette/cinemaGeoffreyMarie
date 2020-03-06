package cinema.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
	
	@GetMapping("/userByFirstName")
	@ResponseBody
	public Set<User> userByFirstName(@RequestParam("fn") String firstName) {
		return userService.getUserByFirstName(firstName);
	}
		
	@GetMapping("/userByEMail")
	@ResponseBody
	public Set<User> userByEMail(@RequestParam("em") String eMail) {
		return userService.getUserByEMail(eMail);
	}
	
	@PutMapping("/modify")
	@ResponseBody
	public User modifyUser(@RequestParam("em") String eMail) {
		Set<User> utilisateur = userService.getUserByEMail(eMail);
		return (User) userService.putUser(utilisateur);
	}

}
