package com.qa.cinema.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.cinema.service.media.MediaService;

@Path("/media")
public class MediaEndPoint {

	
	@Inject private MediaService service;
	
	@Path("/json/all/{filmId}/{mediaType}")
	@GET
	@Produces({ "application/json" })
	public String getAllMedia(@PathParam("filmId") Long filmID, @PathParam("mediaType") String type) {
		return service.getAllMediaForFilmByType(filmID, type);
	}

	@Path("/json/{filmId}/{mediaType}")
	@GET
	@Produces({ "application/json" })
	public String getSingleMedia(@PathParam("filmId") Long id, @PathParam("mediaType") String type) {
		return service.getSingleMediaForFilmByType(id, type);
	}
	
	
	@Path("/json/{filmId}")
	@POST
	@Produces({ "application/json" })
	public String addMedia(@PathParam("filmId") Long id, String media) {
		return service.createMedia(id, media);
	}

	@Path("/json/{id}")
	@PUT
	@Produces({ "application/json" })
	public String updateMedia(@PathParam("id") Long id, String updated) {
		return service.updateMedia(id, updated);
	}

	@Path("/json/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteMedia(@PathParam("id") Long id) {
		return service.deleteMedia(id);
	}
}
