package main.java.services.model;

import main.dbconnect.DbHikings;
import main.java.app.area.HarvestAreas;
import main.java.app.hiking.Hikings;

public class AreasService {
	
	public HarvestAreas getDefaultAreas() throws Exception {
		
		DbHikings dbHikings = new DbHikings("ThT12");
		Hikings hikings = dbHikings.getHikings();
		
		HarvestAreas has = new HarvestAreas();
		has.addHarvestAreas(hikings.getHarvestAreas());
		return has;
	}

}
