package com.qa.cinema.service.media;

import java.util.Collection;
import java.util.Random;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.Query;

import org.hibernate.QueryException;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import com.qa.cinema.persistence.Media;
import com.qa.cinema.persistence.Movie;
import com.qa.cinema.util.JSONUtil;

@Stateless
@Default
public class DBMediaService implements MediaService {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	JSONUtil util;

	@Override
	public String getAllMediaForFilmByType(Long filmID, String type) {
		Collection<Media> media = getAllMediaForFilm(filmID, type);

		return util.getJSONForObject(media);
	}

	@Override
	public String getSingleMediaForFilmByType(Long filmID, String type) {
		Collection<Media> media = getAllMediaForFilm(filmID, type);
		
		Random random = new Random();
		int index = random.nextInt(media.size());
		
		Media mediaObj = (Media) media.toArray()[index];
		return util.getJSONForObject(mediaObj);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public String getAllMediaByType(String type) {
		try{
			Query query = manager.createQuery("Select m from Media m where m.type = " + "com.qa.cinema.persistence.MediaType." + type.toUpperCase()); 
			Collection<Media> media = (Collection<Media>) query.getResultList();
			return util.getJSONForObject(media);
		}catch(IllegalArgumentException iae){
			return "{\"message\": \"No Such Media Type\"}";
		}
	}

	@Override
	public String createMedia(Long filmId, String media) {
		Media mediaObj = util.getObjectForJSON(media, Media.class);
		Movie movie = manager.find(Movie.class, filmId);
		movie.addMedia(mediaObj);
		manager.persist(mediaObj);
		
		return "{\"message\": \"Media added sucessfully\"}";
	}

	@Override
	public String updateMedia(Long id, String newMedia) {
		Media mediaToUpdate = findByID(id);
		
		if(mediaToUpdate == null){
			return "{\"message\": \"No media found\"}";
		}
		
		Media updatedMedia = util.getObjectForJSON(newMedia, Media.class);
		updatedMedia.setId(mediaToUpdate.getId());
		manager.merge(updatedMedia);
		
		return "{\"message\": \"Media updated sucessfully\"}";
	}

	@Override
	public String deleteMedia(Long id) {
		Media mediaToDelete = findByID(id);
		
		if(mediaToDelete == null){
			return "{\"message\": \"No Media found\"}";
		}
		
		manager.remove(mediaToDelete);
		return "{\"message\": \"Media deleted sucessfully\"}";
	}

	
	
	@SuppressWarnings("unchecked")
	private Collection<Media> getAllMediaForFilm(Long filmID, String mediaType){
		Query query = manager.createQuery("Select m from Media m where m.movieID = " + filmID +
				" AND m.type = " + "com.qa.cinema.persistence.MediaType." + mediaType.toUpperCase()); 
		return (Collection<Media>) query.getResultList();
	}
	
	private Media findByID(Long id){
		return manager.find(Media.class, id);
	}

}