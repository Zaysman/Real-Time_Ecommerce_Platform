package com.isaiah.usermicroservice.restcontroller;

import com.isaiah.usermicroservice.object.User;
import com.isaiah.usermicroservice.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("api/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserRestController {
	
	private final String JSON = "application/json";
	private final String LOCALHOST = "http://localhost:3000";
	
	@Autowired
	private UserService userService;
	
	
	//Sign up end point
	//Post new Mapping
	@PostMapping(value = "/signup", produces = JSON, consumes = JSON)
	public User createUser(@RequestBody User user) {
		user = userService.createUser(user);
		return user;
	}
	
	//Login end point
	//Post Mapping
	@PostMapping(value = "/login", produces = JSON, consumes = JSON)
	public User authenticateUser(@RequestBody User user) {
		
		if(userService.authenticateUser(user)) {
			return user;
		} else {
			return null;
		}
		
//		//Check for existing user by username
//		User existingUser = userService.readUserByUsername(user.getUsername());
//		
//		//If no user was found, we'll have to return null
//		if(existingUser == null) {
//			return null;
//		}
//		
//		//Check the sent credentials against the user data retrieved. 
//		if((user.getPassword().compareTo(existingUser.getPassword()) != 0 || user.getUsername().compareTo(existingUser.getUsername()) != 0)) {
//			return null;
//		}
//		
//		//If the credentials sent from the front end equal those retrieved from the database, the user has been properly authenticated as we can return the user credentials.
//		return existingUser;
	}
	
	//Get User by userid
	@GetMapping(value = "/{userid}", produces = JSON)
	public User getUser(@PathVariable long userid) {
		return userService.readUserByUserid(userid);
	}
	
	//Update User endpoint
	@PutMapping(value = "/users/update/{userid}")
	public User UpdateUser(@PathVariable long userid, @RequestBody User user) {
		User existingUser = userService.readUserByUserid(userid);
		
		if(existingUser != null) {
			existingUser.setUsername(user.getUsername());
			existingUser.setPassword(user.getPassword());
			existingUser.setEmail(user.getEmail());
			
			userService.updateUser(existingUser);
			return existingUser;
		} else {
			return null;
		}
	}
	
	
	//Delete a user by id
	@DeleteMapping(value = "/delete/{userid}")
	public void deleteUser(@PathVariable long userid) {
		userService.deleteUserByUserid(userid);
	}

}
