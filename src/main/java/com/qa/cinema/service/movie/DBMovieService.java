package com.qa.cinema.service.movie;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.qa.cinema.persistence.Movie;
import com.qa.cinema.service.movie.MovieService;
import com.qa.cinema.util.JSONUtil;

@Stateless
@Default
@SuppressWarnings("unchecked")
public class DBMovieService implements MovieService {

	@PersistenceContext(unitName = "primary")
	private EntityManager em;

	@Inject
	private JSONUtil util;

	@Override
	public String listAllMovies() {
		Query query = em.createQuery("SELECT m FROM Movie m");
		Collection<Movie> movies = (Collection<Movie>) query.getResultList();

		return util.getJSONForObject(movies);
	}

	@Override
	public String getMovieById(Long id) {
		return util.getJSONForObject(findMovie(id));
	}

	@Override
	public String listMovieByGenre(String genre) {
		Query query = em.createQuery("SELECT m FROM Movie m WHERE m.genre LIKE " + genre);
		Collection<Movie> movies = (Collection<Movie>) query.getResultList();
		
		return util.getJSONForObject(movies);
	}

	@Override
	public String createNewMovie(String movie) {
		Movie newMovie = util.getObjectForJSON(movie, Movie.class);
		em.persist(newMovie);
		return "{\"message\": \"movie sucessfully added\"}";
	}

	@Override
	public String updateMovie(Long movieId, String movie) {
		Movie updateMovie = util.getObjectForJSON(movie, Movie.class);
		Movie movieInDB = findMovie(new Long(movieId));
		if (movieInDB != null) {
			updateMovie.setID(movieInDB.getId());
			em.merge(updateMovie);
		}
		return "{\"message\": \"movie sucessfully updated\"}";
	}

	@Override
	public String deleteMovie(Long movieId) {
		Movie movieInDB = findMovie(new Long(movieId));
		if (movieInDB != null) {
			em.remove(movieInDB);
		}
		return "{\"message\": \"movie sucessfully deleted\"}";
	}

	private Movie findMovie(Long id) {
		Movie movie =  em.find(Movie.class, id);
		return movie;
	}



}
