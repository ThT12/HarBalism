package main.java.restservices.model;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import main.java.app.hiking.Hikings;
import main.java.services.model.HikingsService;

@Path("/hikings")
public class HikingsRestService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Hikings getDefaultAreasInJSON() throws Exception {
		HikingsService hikingsService = new HikingsService();
		return hikingsService.getDefaultHikings();
	}

}
