package main.java.services.model;

import main.dbconnect.DbHikings;
import main.java.app.hiking.Hikings;

public class AdviceHikingsService {

	public Hikings getDefaultAdviceHikings() throws Exception {
		DbHikings dbHikings = new DbHikings("ThT12");
		Hikings AdvicesHikings = dbHikings.getHikings().adviceHiking();
		return AdvicesHikings;
	}
}
