package com.heena.rest.Webservice.restfulwebservice.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDAO {

	private static List<User> users = new ArrayList<>();
	private static int usercount = 3;

	public UserDAO()
	{}
	static {
		users.add(new User(1, "Heena", new Date()));
		users.add(new User(2, "Aashi", new Date()));
		users.add(new User(3, "Amita", new Date()));
	}

	public List<User> findall() {
		return users;
	}

	public User save(User user) {
		if (user.getId() == null) {
			user.setId(++usercount);
		}
		users.add(user);
		return user;
	}

	public User findOne(int id) {
		for (User user : users) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}
	
	public User deleteById(int id) {	
		Iterator<User> iterator = users.iterator();
		for (User user : users) {
			if (user.getId() == id) {
				iterator.remove();
				return user;
			}
		}
		return null;
	}
}
