package cinema.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	@Autowired
	IUserService userService;
	
	@Bean
	public PasswordEncoder pwdEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		var utilisateur = userService.getUserByUsername(username);
		
	if(utilisateur.isPresent()) {
		System.out.println("l'user est " + utilisateur.get().getUsername());
		return new User(
				utilisateur.get().getUsername(),
				this.pwdEncoder().encode(utilisateur.get().getPassword()),
				new ArrayList<>());

		} else {
			throw new UsernameNotFoundException("User not found with this username");
		}
	}

}
