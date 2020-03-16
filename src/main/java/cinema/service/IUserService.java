package cinema.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import cinema.dto.UserDTO;
import cinema.persistence.entity.User;

public interface IUserService {
	
	Set<User> getUserByFirstName(String firstName);
	Set<User> getUserByEMail(String eMail);
	User putUser(Set<User> utilisateur);
	List<User> getAllUsers();
	Optional<User> getUserByUsername(String username);
	Optional <User> getUserById(Integer idUser);
	UserDTO addUser(UserDTO user);
}
