package com.qa.cinema.service;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.qa.cinema.persistence.Showing;
import com.qa.cinema.util.JSONUtil;


@Stateless
@Default
public class DBShowingService implements ShowingService {
	
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	
	@Inject 
	private JSONUtil util;

	@Override
	public String getAllShowings() {
		Query query = manager.createQuery("SELECT s FROM Showing s");
		@SuppressWarnings("unchecked")
		Collection<Showing> showing = (Collection<Showing>) query.getResultList();
		return util.getJSONForObject(showing);
	}
	
	@Override
	public String getShowingByDate(Long id, Long dateShowing) {
		Query query = manager.createQuery("SELECT s FROM Showing s WHERE dateShowing >=" + dateShowing + " AND s.movie.id = " + id);
		@SuppressWarnings("unchecked")
		Collection<Showing> showing = (Collection<Showing>) query.getResultList();
		return util.getJSONForObject(showing);
	}
	
	@Override
	public String getShowingById(Long showingId){
		Query query = manager.createQuery("SELECT s FROM Showing s WHERE id =" + showingId);
		Showing showing = (Showing) query.getSingleResult();
		return util.getJSONForObject(showing);
	}
	
	@Override
	public String getShowingByMovie(Long movieID){
		Query query = manager.createQuery("SELECT s FROM Showing s WHERE movie_Id =" + movieID);
		@SuppressWarnings("unchecked")
		Collection<Showing> showing = (Collection<Showing>) query.getResultList();
		return util.getJSONForObject(showing);
	}
	
	@Override
	public String addShowing(String showing){
		Showing newShowing = util.getObjectForJSON(showing, Showing.class);
		manager.persist(newShowing);
		return  "{\"message\": \"showing sucessfully added\"}";
	}
	
	@Override
	public String deleteShowing(Long id){
		Showing showingToBeDeleted = findShowing(id);
		if (showingToBeDeleted != null){
			manager.remove(showingToBeDeleted);
		}
		
		return "{\"message\": \"showing sucessfully deleted\"}";
	}
	
	@Override
	public String updateShowing(Long showingId, String showing){
		Showing updatedShowing = util.getObjectForJSON(showing, Showing.class);
		Showing showingInDB = findShowing(showingId);
		if (showingInDB != null) {
			showingInDB = updatedShowing;
			manager.merge(showingInDB);
			}
		return "{\"message\": \"showing sucessfully updated\"}";
	}
	
	private Showing findShowing(Long id) {
		return manager.find(Showing.class, id);
	}


	
}
