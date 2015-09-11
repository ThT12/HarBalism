package main.java.services.model;

import main.dbconnect.DbHikings;
import main.java.app.hiking.Hikings;

public class HikingsService {

	public Hikings getDefaultHikings() throws Exception {
		DbHikings dbHikings = new DbHikings("ThT12");
		return dbHikings.getHikings();
	}
}
