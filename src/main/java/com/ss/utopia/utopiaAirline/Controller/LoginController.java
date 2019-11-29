package com.ss.utopia.utopiaAirline.Controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import com.ss.utopia.utopiaAirline.POJO.User;
import com.ss.utopia.utopiaAirline.Service.*;
import org.springframework.web.bind.annotation.ResponseStatus;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;

@RestController 
@RequestMapping("/users")
@Produces({"application/xml", "application/json"})
@Consumes({"application/xml", "application/json"})
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	
	 @GetMapping ("/{userId}") 
	 @ResponseStatus(code = HttpStatus.OK)
		public Optional<User> readUser(@PathVariable Integer userId) {
		 System.out.println("this is user test" + userId);
			 return loginService.readUserbyId(userId);
		 }
	 
	 @PostMapping("")
		public ResponseEntity<?> createUser(@RequestBody User user) {
			
		 loginService.createUser(user);
			return new ResponseEntity<User>(user, HttpStatus.CREATED);
		}
	 
	 @PutMapping("/{userId}")
		public ResponseEntity<?> updateUser(@PathVariable Integer userId, @RequestBody User user) {
			
			boolean checkId = loginService.ifUserExists(userId);
			
			if(checkId == true) {
				user.setUserId(userId);
				loginService.updateUser(user);
				return new ResponseEntity<User>(user, HttpStatus.OK);
			}
				
			return new ResponseEntity<String>("Invalid ID.", HttpStatus.NOT_FOUND);
		}
	 
	 @DeleteMapping("/{userId}")
		public ResponseEntity<?> deleteUserbyId(@PathVariable Integer userId) {
			
			boolean checkId = loginService.ifUserExists(userId);
			
			if(checkId == true) {
				loginService.deleteUserbyId(userId);
				return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
			}
				
			return new ResponseEntity<String>("Invalid ID.", HttpStatus.NOT_FOUND);
		}
}
