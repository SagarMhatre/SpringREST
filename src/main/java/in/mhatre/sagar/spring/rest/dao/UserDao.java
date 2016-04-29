package in.mhatre.sagar.spring.rest.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import in.mhatre.sagar.spring.rest.exceptions.UserDoesNotExistException;
import in.mhatre.sagar.spring.rest.model.User;

public class UserDao {

	private Map<Integer, User> users;

	private UserDao() {
		users = new HashMap<Integer, User>();
		User admin = new User();
		admin.setLoginId("admin");
		admin.setPasswd("a");
		this.addUser(admin);
	}

	private static class SingletonHelper {
		private static final UserDao INSTANCE = new UserDao();
	}

	public static UserDao getInstance() {
		return SingletonHelper.INSTANCE;
	}

	public boolean addUser(User user) {
		user.setId(users.size() + 1);
		users.put(user.getId(), user);
		return true;
	}

	public User editUser(User user) throws UserDoesNotExistException {
		if (users.containsKey(user.getId())) {
			User u = users.put(user.getId(), user);
			return users.get(user.getId());
		} else
			throw new UserDoesNotExistException();
	}

	public Collection<User> getAllUsers() {
		return users.values();
	}

	public User getUserById(int id) throws UserDoesNotExistException {
		if (users.containsKey(id)) {
			return users.get(id);
		} else
			throw new UserDoesNotExistException();
	}

	public User delUserById(int id) throws UserDoesNotExistException {
		if (users.containsKey(id)) {
			return users.remove(id);
		} else
			throw new UserDoesNotExistException();
	}

	public static void main(String[] args) throws UserDoesNotExistException {
		UserDao.getInstance().addUser(new User());
		for (User user : UserDao.getInstance().getAllUsers())
			System.out.println(user);

		System.out.println("1 : " + UserDao.getInstance().getUserById(1));

		User u = new User();
		u.setLoginId("sagar");
		u.setId(1);
		System.out.println(UserDao.getInstance().editUser(u));

		for (User user : UserDao.getInstance().getAllUsers())
			System.out.println(user);

		UserDao.getInstance().delUserById(1);
		for (User user : UserDao.getInstance().getAllUsers())
			System.out.println(user);

	}
}
