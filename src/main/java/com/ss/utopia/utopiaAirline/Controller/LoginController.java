package com.ss.utopia.utopiaAirline.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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

@RequestMapping("/users")
@RestController 
@Produces({"application/xml", "application/json"})
@Consumes({"application/xml", "application/json"})

public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@PreAuthorize("hasAnyAuthority('Clerk')")
	@GetMapping ("") 
	 @ResponseStatus(code = HttpStatus.OK)
		public ResponseEntity<User> readUser(@RequestBody User user) {
		
			boolean unameExists = loginService.ifUserNameExists(user.getUsername());
			User emptyUser = new User();
			
			if(unameExists == true) {
				User userwdata = new User();
				userwdata = loginService.readUserbyUsername(user);
				
				return new ResponseEntity<User>(userwdata, HttpStatus.OK);
			}
			return new ResponseEntity<User>(emptyUser, HttpStatus.NOT_FOUND);
	}

	
	@PreAuthorize("hasAnyAuthority('Clerk')")
	 @PutMapping("")
		public ResponseEntity<User> updateUser(@RequestBody User user) {
			
			boolean unameExists = loginService.ifUserNameExists(user.getUsername());
			User emptyUser = new User();
			
			if(unameExists == true) {
				User userWName = new User();
				userWName = loginService.readUserbyUsername(user);
				user.setUserId(userWName.getUserId());
				loginService.updateUser(user);
				return new ResponseEntity<User>(user, HttpStatus.OK);
			}
				
			return new ResponseEntity<User>(emptyUser, HttpStatus.NOT_FOUND);
		}
	
	@PreAuthorize("hasAnyAuthority('Clerk')")
	 @PostMapping("")
		public ResponseEntity<?> createUser(@RequestBody User user) {
			
		 loginService.createUser(user);
			return new ResponseEntity<User>(user, HttpStatus.CREATED);
		}

	 
	@PreAuthorize("hasAnyAuthority('Clerk')")
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
