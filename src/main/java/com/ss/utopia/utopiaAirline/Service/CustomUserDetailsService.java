package com.ss.utopia.utopiaAirline.Service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.ss.utopia.utopiaAirline.DAO.UserDAO;
import com.ss.utopia.utopiaAirline.POJO.CustomUserDetails;
import com.ss.utopia.utopiaAirline.POJO.User;

@Service
public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserDAO userDao;
	
	@Override
	public UserDetails loadUserByUsername (String username) throws UsernameNotFoundException{
		Optional<User> optionalUser = userDao.findByUsername(username);
		
		//throwing exception if DB does not return a value
		optionalUser
					.orElseThrow(() -> new UsernameNotFoundException("Username not found"));
		
		
		//return user details object
		return optionalUser
					.map(CustomUserDetails:: new).get();
		
	}
}
