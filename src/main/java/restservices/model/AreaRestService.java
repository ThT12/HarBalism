package main.java.restservices.model;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import main.java.app.area.HarvestArea;
import main.java.services.model.AreaService;

@Path("/area")
public class AreaRestService {
	

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public HarvestArea getDefaultAreaInJSON() throws Exception {
		AreaService areaService = new AreaService();
		return areaService.getDefaultArea();
	}

}
