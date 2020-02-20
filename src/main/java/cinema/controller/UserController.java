//package cinema.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import cinema.persistence.entity.User;
//import cinema.service.IUserService;
//
//public class UserController {
//	
//	@Autowired
//	IUserService userService;
//	
//	@GetMapping("/userByFirstName")
//	@ResponseBody
//	public User userByFirstName(@RequestParam("fn") String firstName) {
//		return userService.getUserByFirstName(firstName);
//	}
//		
//	@GetMapping("/userByFirstName")
//	@ResponseBody
//	public User userByEMail(@RequestParam("em") String eMailAdress) {
//		return userService.getUserByEMail(eMailAdress);
//	}
//	
//	@PostMapping("/modify")
//	@ResponseBody
//	public User modifyUser(@RequestParam("em") String eMailAdress) {
//		return userService.postUser(eMailAdress);
//	}
//
//}
