package main.java.restservices.model;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import main.java.app.area.HarvestAreas;
import main.java.services.model.AreasService;

@Path("/areas")
public class AreasRestService {
	

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public HarvestAreas getDefaultAreasInJSON() throws Exception {
		AreasService areasService = new AreasService();
		return areasService.getDefaultAreas();
	}

}