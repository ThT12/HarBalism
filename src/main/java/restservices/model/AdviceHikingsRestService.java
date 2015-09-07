package main.java.restservices.model;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import main.java.app.hiking.Hikings;
import main.java.services.model.AdviceHikingsService;


@Path("/advices")
public class AdviceHikingsRestService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Hikings getDefaultAdvicesInJSON() throws Exception {
		AdviceHikingsService adviceHikingsService = new AdviceHikingsService();
		return adviceHikingsService.getDefaultAdviceHikings();
	}
	
}
