package main.java.services.model;

import main.java.app.plant.Plant;

public class AreaService {

	public Plant getDefaultArea() throws Exception {
		Plant ha = new Plant();
		ha.setName("MaPlante");
		return ha;
	}
}
