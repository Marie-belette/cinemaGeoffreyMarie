package cinema.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cinema.dto.UserDTO;
import cinema.persistence.entity.User;
import cinema.persistence.repository.UserRepository;
import cinema.service.IUserService;

@Service
@Transactional
public class UserService implements IUserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ModelMapper mapper;

	@Override
	public Set<User> getUserByFirstName(String firstName) {
		return userRepository.findByFirstName(firstName);
	}
	
	@Override
	public Optional<User> getUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public Set<User> getUserByEMail(String eMail) {
		return userRepository.findByEMail(eMail);
	}
	
	@Override
	public Optional <User> getUserById(Integer idUser) {
		return userRepository.findById(idUser);
	}

	@Override
	public User putUser(Set<User> user) {
		Set<User> utilisateur = userRepository.findByEMail(((User) user).getEMail());
		((User) utilisateur).setFirstName(((User) user).getFirstName());
		((User) utilisateur).setLastName(((User) user).getLastName());
		((User) utilisateur).setEMail(((User) user).getEMail());
		((User) utilisateur).setPassword(((User) user).getPassword());
		return (User) utilisateur;
	}

	@Override
	public List<User> getAllUsers() {
		List<User> userEntities = userRepository.findAll();
		return userEntities.stream()
		.collect(Collectors.toList());
	}
	
	@Override
	public UserDTO addUser(UserDTO user) {
		User userEntity = mapper.map(user, User.class);
		userRepository.save(userEntity);
		mapper.map(userEntity, user);
		return user;
	}

}
