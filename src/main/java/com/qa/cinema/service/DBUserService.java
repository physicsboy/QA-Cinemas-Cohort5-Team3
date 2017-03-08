package com.qa.cinema.service;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.qa.cinema.persistence.User;
import com.qa.cinema.util.JSONUtil;


@Stateless
@Default
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
	public String createUser(String User) {
		User anUser = util.getObjectForJSON(User, User.class);
		manager.persist(anUser);
		return "{\"message\": \"User sucessfully added\"}";
	}

}
