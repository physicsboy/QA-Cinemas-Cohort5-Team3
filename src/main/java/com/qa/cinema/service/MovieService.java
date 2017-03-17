package com.qa.cinema.service;

public interface MovieService {

	String listAllMovies();
	
	String getMovieById(Long id);
	
	String listMovieByGenre(String genre);

	String createNewMovie(String movie);

	String updateMovie(Long movieId, String movie);

	String deleteMovie(Long movieId);
}
