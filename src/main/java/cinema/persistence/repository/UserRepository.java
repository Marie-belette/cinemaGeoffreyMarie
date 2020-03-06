package cinema.persistence.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import cinema.persistence.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	Set<User> findByFirstName(String firstName);
	Set<User> findByEMail(String eMail);
}
