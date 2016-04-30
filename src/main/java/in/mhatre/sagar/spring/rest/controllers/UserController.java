package in.mhatre.sagar.spring.rest.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import in.mhatre.sagar.spring.rest.exceptions.UserDoesNotExistException;
import in.mhatre.sagar.spring.rest.models.User;
import in.mhatre.sagar.spring.rest.services.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/rest/users", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<User>> getAllUsers() {
		return new ResponseEntity<Collection<User>>(userService.getAllUsers(), HttpStatus.OK);
	}

	@RequestMapping(value = "/rest/users/{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> getUserById(@PathVariable("userId") int id) {
		User user;
		try {
			user = userService.getUserById(id);
			return new ResponseEntity<User>(user, HttpStatus.OK);
		} catch (UserDoesNotExistException e) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}

	}

	@RequestMapping(value = "/rest/users", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> createUser(@RequestBody User user) {
		userService.addUser(user);
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/rest/users/{userId}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> updateUser(@PathVariable("userId") int id, @RequestBody User user) {
		try {
			userService.editUser(id, user);
			return new ResponseEntity<User>(user, HttpStatus.OK);
		} catch (UserDoesNotExistException e) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}		
	}
	
	@RequestMapping(value = "/rest/users/{userId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> updateUser(@PathVariable("userId") int id) {
		try {
			User user = userService.getUserById(id);
			userService.delUserById(id);
			return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
		} catch (UserDoesNotExistException e) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}		
	}
}
