package cinema.persistence.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import cinema.persistence.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

	Set<Role>findByName(String name);
	Set<Role>findByNameContainingIgnoreCase(String name);
	
}
