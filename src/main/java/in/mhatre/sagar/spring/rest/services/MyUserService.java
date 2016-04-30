package in.mhatre.sagar.spring.rest.services;

import java.util.Collection;

import org.springframework.stereotype.Service;

import in.mhatre.sagar.spring.rest.dao.UserDao;
import in.mhatre.sagar.spring.rest.exceptions.UserDoesNotExistException;
import in.mhatre.sagar.spring.rest.models.User;

@Service
public class MyUserService implements UserService {

	private UserDao userDao = UserDao.getInstance();
	
	@Override
	public boolean addUser(User user) {		
		return userDao.addUser(user);
	}

	@Override
	public User editUser(int id, User user) throws UserDoesNotExistException {		
		return userDao.editUser(id, user);
	}

	@Override
	public Collection<User> getAllUsers() {
		return userDao.getAllUsers();
	}

	@Override
	public User getUserById(int id) throws UserDoesNotExistException {
		return userDao.getUserById(id);
	}

	@Override
	public User delUserById(int id) throws UserDoesNotExistException {
		return  userDao.getUserById(id);
	}

}
