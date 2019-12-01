package com.ss.utopia.utopiaAirline.Service;

import java.util.Optional;
import org.springframework.stereotype.Component;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.ss.utopia.utopiaAirline.DAO.RoleDAO;
import com.ss.utopia.utopiaAirline.DAO.UserDAO;
import com.ss.utopia.utopiaAirline.POJO.User;

@Component
public class LoginService {
	
	@Autowired //it lets you access DAO without creating instance
	 UserDAO userDao;
	 
	 @Autowired
	 RoleDAO roleDao;
	 
	 @Autowired
		private BCryptPasswordEncoder passwordEncoder;
	 
	 //get user info
	 public Optional<User> readUserbyId(Integer userId) {
		 return userDao.findById(userId);
	 }
	 
	 //delete user info
	 public void deleteUserbyId(Integer userId) {
		 userDao.deleteById(userId);
		}
	 
	 //create new user
	 public User createUser(User user) {
		 String pwd = user.getPassword();
		 String encryptPwd = passwordEncoder.encode(pwd);
		 user.setPassword(encryptPwd);
		 return userDao.save(user);
	 }
	 
	 //update user info
	 public User updateUser(User user) {
		 String pwd = user.getPassword();
		 String encryptPwd = passwordEncoder.encode(pwd);
		 user.setPassword(encryptPwd);
		 return userDao.save(user);
	 }
	 
	//check if user already exists
		public boolean ifUserExists(Integer userId) {
			List<User> list = userDao.findAll();
			
			boolean exists = list.stream()
					.anyMatch(id -> id.getUserId().equals(userId));
		
			return exists;
		}
}

