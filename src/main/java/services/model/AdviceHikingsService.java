package main.java.services.model;

import main.java.app.hiking.Hikings;

public class AdviceHikingsService {

	public Hikings getDefaultAdviceHikings() throws Exception {
		Hikings hikings = new Hikings("Example");
		Hikings AdvicesHikings = hikings.adviceHiking();
		return AdvicesHikings;
	}
}
