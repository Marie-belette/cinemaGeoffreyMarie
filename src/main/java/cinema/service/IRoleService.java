package cinema.service;

import java.util.Optional;
import java.util.Set;

import cinema.persistence.entity.Role;

public interface IRoleService {

	Set<Role>findByName(String name);
	Set<Role>findByNameContainingIgnoreCase(String name);
	Role postRole (Role role);
	Optional<Role> postName (Role role);
	Optional<Role> delete (Integer id_Role);
	
	
	
}
