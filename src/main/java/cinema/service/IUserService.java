package cinema.service;

import java.util.List;
import java.util.Set;

import cinema.persistence.entity.User;

public interface IUserService {
	
	Set<User> getUserByFirstName(String firstName);
	Set<User> getUserByEMail(String eMail);
	User putUser(Set<User> utilisateur);
	List<User> getAllUsers();

}
