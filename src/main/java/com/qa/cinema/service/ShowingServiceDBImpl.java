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
public class ShowingServiceDBImpl implements ShowingService {
	
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	
	@Inject 
	private JSONUtil util;

	@Override
	public String getAllShowings() {
		Query query = manager.createQuery("SELECT s FROM Showing s");
		Collection<Showing> showing = (Collection<Showing>) query.getResultList();
		return util.getJSONForObject(showing);
	}
	
	private Showing findShowing(Long id){
		return manager.find(Showing.class, id);
	}

}
