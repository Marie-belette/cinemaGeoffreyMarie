package cinema.controller;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import cinema.persistence.entity.Role;
import cinema.service.IRoleService;



@RequestMapping("/api/role")
public class RoleController {

	@Autowired
	IRoleService roleService;

	@GetMapping("/name")
	@ResponseBody
	public Set<Role>findByName(@RequestParam ("n") String name){
		return findByName(name);
	}
	
	@GetMapping("/nameContaining")
	@ResponseBody
	public Set<Role>findByNameContainingIgnoreCase(@RequestParam ("n") String name){
		return findByNameContainingIgnoreCase(name);
	}
	
	@PostMapping ("/addRole")
	@ResponseBody
	public Role addRole (@RequestBody Role role) {
	return roleService.postRole(role);
	}
	
	@PutMapping("/modify")
	@ResponseBody
	public Optional<Role> postName(@RequestBody Role role){
		return roleService.postName(role);
	}
	
	@DeleteMapping("/{id}")
	@ResponseBody
	public Optional<Role> delete (Integer id_Role)	{
		return roleService.delete(id_Role);
		
	}
}
