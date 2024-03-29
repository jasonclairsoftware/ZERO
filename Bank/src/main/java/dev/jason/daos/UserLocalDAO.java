package dev.jason.daos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dev.jason.enities.User;

public class UserLocalDAO implements UserDAO{

	public final static Map<Integer, User> userstable = new HashMap<Integer, User>();
	private static int idsequencer = 1000;
	
	
	public User createUser(User user) {
		user.setId(++idsequencer);
		userstable.put(idsequencer, user);
		return user;
	}

	public User getUserByUsername(String username) {
		List<User> userlist = new ArrayList<User>(userstable.values());
		for (User user : userlist) {
			if(user.getUsername().equals(username)) {
				return user;
			}
		}
		//System.out.println("That username does not exist.");
		return null;
	}

	public User getUserByID(int id) {
		try {
		User user = userstable.get(id);
		return user;
		} catch (NullPointerException e) {
			//System.out.println("No user exists with that ID.");
			return null;
		}
	}

	public User updateUser(User user) {
		userstable.put(user.getId(), user);
		return user;
	}

	public boolean deleteUser(User user) {
		if (userstable.remove(user.getId()) != null) {
			return true;
		}
		System.out.println("That user does not exist.");
		return false;
	}

}
