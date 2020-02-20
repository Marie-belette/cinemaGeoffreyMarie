//package cinema.service.impl;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import cinema.persistence.entity.User;
//import cinema.persistence.repository.UserRepository;
//import cinema.service.IUserService;
//
//@Service
//@Transactional
//public class UserService implements IUserService {
//	
//	@Autowired
//	UserRepository userRepository;
//
//	@Override
//	public User getUserByFirstName(String firstName) {
//		return userRepository.findByFirstName(firstName);
//	}
//
//	@Override
//	public User getUserByEMail(String eMailAdress) {
//		return userRepository.findByEMail(eMailAdress);
//	}
//
//	@Override
//	public User postUser(String eMailAdress) {
//		User utilisateur = userRepository.findByEMail(eMailAdress);
//		utilisateur.setFirstName(utilisateur.getFirstName());
//		utilisateur.setLastName(utilisateur.getLastName());
//		utilisateur.seteMail(utilisateur.geteMail());
//		utilisateur.setPassword(utilisateur.getPassword());
//		utilisateur.setRole(utilisateur.getRole());
//		return utilisateur;
//	}
//
//}
