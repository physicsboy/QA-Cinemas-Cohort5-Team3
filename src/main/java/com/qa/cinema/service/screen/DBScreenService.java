package com.qa.cinema.service.screen;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.qa.cinema.persistence.Screen;
import com.qa.cinema.util.JSONUtil;

import java.util.Collection;

@Stateless
@Default
@SuppressWarnings("unchecked")
public class DBScreenService implements ScreenService{

	
	@PersistenceContext
	EntityManager em;
	
	@Inject
	private JSONUtil util;
	
	
	
	@Override
	public String getScreens() {
		Query query = em.createQuery("Select s From Screen s");
		Collection<Screen> screens = (Collection<Screen>)query.getResultList();
		return util.getJSONForObject(screens);
	}



	@Override
	public String getScreen(int id) {
		Screen screen = em.find(Screen.class, id);
		return util.getJSONForObject(screen);
	}



	@Override
	public String createScreen(String screen) {
		Screen aScreen = util.getObjectForJSON(screen, Screen.class);
		em.persist(aScreen);
		return "{\"message\": \"movie sucessfully updated\"}";
	}



	@Override
	public String deleteScreen(int id) {
		Screen screen = findScreen(id);
		if (screen != null) {
			em.remove(screen);
		}
		return "{\"message\": \"movie sucessfully deleted\"}";
	}



	@Override
	public String updateScreen(int id, String screen) {
		Screen updatedScreen  = util.getObjectForJSON(screen, Screen.class);
		Screen screenInDB = findScreen(id);
		if (screenInDB != null) {
			screenInDB = updatedScreen;
			em.merge(screenInDB);
		}
		return "{\"message\": \"movie sucessfully updated\"}";
	}

	
	private Screen findScreen(int id) {
		return em.find(Screen.class, id);
	}

}
