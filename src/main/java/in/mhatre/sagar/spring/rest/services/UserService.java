package in.mhatre.sagar.spring.rest.services;

import java.util.Collection;

import in.mhatre.sagar.spring.rest.exceptions.UserDoesNotExistException;
import in.mhatre.sagar.spring.rest.models.User;

public interface UserService {
	
	public boolean addUser(User user);
	public User editUser(int id, User user) throws UserDoesNotExistException;
	public Collection<User> getAllUsers();
	public User getUserById(int id) throws UserDoesNotExistException;
	public User delUserById(int id) throws UserDoesNotExistException;
	
}
