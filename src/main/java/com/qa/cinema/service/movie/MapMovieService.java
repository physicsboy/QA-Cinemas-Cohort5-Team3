package com.qa.cinema.service.movie;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;


@ApplicationScoped
@Alternative
public class MapMovieService implements MovieService {

	@Override
	public String listAllMovies() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String getMovieById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String listMovieByGenre(String genre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String createNewMovie(String movie) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateMovie(Long movieId, String movie) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteMovie(Long movieId) {
		// TODO Auto-generated method stub
		return null;
	}

}
