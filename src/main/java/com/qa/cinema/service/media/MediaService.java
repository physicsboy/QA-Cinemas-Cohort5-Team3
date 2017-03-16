package com.qa.cinema.service.media;

public interface MediaService {
	
	String getAllMediaForFilmByType(Long filmID, String type);
	
	String getSingleMediaForFilmByType(Long filmID, String type);
	
	String getAllMediaByType(String type);
	
	String createMedia(Long filmId, String media);
	
	String updateMedia(Long id, String newMedia);
	
	String deleteMedia(Long id);
}
