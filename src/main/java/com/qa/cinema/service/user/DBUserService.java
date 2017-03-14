package com.qa.cinema.service.user;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.qa.cinema.persistence.User;
import com.qa.cinema.util.JSONUtil;

/**
 * @author Matt Gordon
 */

@Stateless
@Default
@SuppressWarnings("unchecked")
public class DBUserService implements UserService {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;

	@Override
	public String getAllUsers() {
		Query query = manager.createQuery("Select u FROM User u");
		Collection<User> users = (Collection<User>) query.getResultList();
		return util.getJSONForObject(users);
	}

	@Override
	public String getUserByID(String email) {

		User user = findByID(email);
		if (user == null) {
			return "{\"message\": \"No user found\"}";
		}

		return util.getJSONForObject(user);
	}

	@Override
	public String createUser(String User) {
		User anUser = util.getObjectForJSON(User, User.class);
		manager.persist(anUser);
		return "{\"message\": \"User sucessfully added\"}";
	}

	@Override
	public String updateUser(String email, String user) {
		User updateUser = util.getObjectForJSON(user, User.class);
		User userInDB = findUser(email);
		if (userInDB != null) {
			userInDB = updateUser;
			manager.merge(userInDB);
		}
		return "{\"message\": \"user sucessfully updated\"}";
	}

	@Override
	public String deleteUser(String email) {
		User userInDB = findUser(email);
		if (userInDB != null) {
			manager.remove(userInDB);
		}
		return "{\"message\": \"user sucessfully deleted\"}";
	}

	private User findUser(String email) {
		return manager.find(User.class, email);
	}

	private User findByID(String email) {
		return manager.find(User.class, email);
	}

}
