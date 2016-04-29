package in.mhatre.sagar.spring.rest.controllers;

import java.util.Collection;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import in.mhatre.sagar.spring.rest.dao.UserDao;
import in.mhatre.sagar.spring.rest.exceptions.UserDoesNotExistException;
import in.mhatre.sagar.spring.rest.models.User;

@RestController
public class UserController {

	private UserDao userDao = UserDao.getInstance();

	@RequestMapping(value = "rest/users", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<User>> getAllUsers() {
		return new ResponseEntity<Collection<User>>(userDao.getAllUsers(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "rest/users/{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> getUserById(@PathVariable("userId") int id) {
		User user;
		try {
			user = userDao.getUserById(id);
			return new ResponseEntity<User>(user, HttpStatus.OK);
		} catch (UserDoesNotExistException e) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		} 
		
	}
}
