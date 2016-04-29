package in.mhatre.sagar.spring.rest.controllers;

import java.util.Collection;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import in.mhatre.sagar.spring.rest.dao.UserDao;
import in.mhatre.sagar.spring.rest.models.User;

@RestController(value = "/rest/users")
public class UserController {

	private UserDao userDao = UserDao.getInstance();

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<User>> getAllUsers() {
		return new ResponseEntity<Collection<User>>(userDao.getAllUsers(), HttpStatus.OK);
	}
}
